import printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * @program: leetcode
 * @description: 二叉堆 最大堆
 * @author: HuRan
 * @create: 2020-11-15 16:32
 */
public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {
    public E[] elements;
    private static final int DEFAULT_SIZE = 10;

    public BinaryHeap(E[] elements, Comparator<E> comparator) {
        super(comparator);
        if (elements == null || elements.length == 0) {
            this.elements = (E[]) new Object[DEFAULT_SIZE];
        } else {
            size = elements.length;
            int capacity = Math.max(elements.length, DEFAULT_SIZE);
            this.elements = (E[]) new Object[capacity];
            //深拷贝
            for (int i = 0; i < elements.length; i++) {
                this.elements[i] = elements[i];
            }
            heapify();
        }

    }

    //批量建堆
    private void heapify() {
        //自上而下的上滤
//        for (int i = 1; i < size; i++) {
//            siftUp_V2(i);
//        }
        //自下而上的下滤
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    public BinaryHeap(E[] elements) {
        this(elements, null);
    }

    public BinaryHeap(Comparator<E> comparator) {
        this(null, comparator);
    }

    public BinaryHeap() {
        this(null, null);
    }


    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(E element) {
        this.elementNotNullCheck(element);
        this.ensureCapacity(size + 1);
        elements[size++] = element;
        this.siftUp_V2(size - 1);
    }

    /**
     * 上滤
     *
     * @param index index元素的位置上滤
     * @return
     */
    public void siftUp(int index) {
        E e = this.elements[index];
        while (index > 0) { //父节点
            int pindex = (index - 1) >> 1;
            E p = this.elements[pindex];
            if (compare(e, p) <= 0) {
                return;
            }
            //交换内容
            E tmp = this.elements[index];
            elements[index] = elements[pindex];
            elements[pindex] = tmp;
            //重新赋值
            index = pindex;
        }
    }

    /**
     * 上滤-优化思路 确定最终位置才摆放上去
     *
     * @param index index元素的位置上滤
     * @return
     */
    public void siftUp_V2(int index) {
        E e = this.elements[index];
        while (index > 0) { //父节点
            int pindex = (index - 1) >> 1;
            E p = this.elements[pindex];
            if (compare(e, p) <= 0) {
                break;
            }
            //将父元素存储在index位置
            this.elements[index] = p;
            index = pindex;//重新赋值
        }
        this.elements[index] = e;
    }


    /**
     * 下滤
     *
     * @param index 位置
     */
    public void siftDown(int index) {
        int half = size >> 1;
        E element = elements[index];
        //必须保证index位置是非叶子节点  如果是叶子节点 就没必要下滤了
        while (index < half) {
            // index节点有2种情况 1.只有左子节点，2 同时有左右子节点  去除最大子节点
            //默认为左子节点
            int childIndex = (index << 1) + 1;
            E child = elements[childIndex];
            int rightIndex = childIndex + 1;
            //选出左右子节点最大的那个
            if (rightIndex < size && compare(elements[rightIndex], child) > 0) {  //算出来的索引是在正常返回内得，那就是存在
                childIndex = rightIndex;
                child = elements[rightIndex];
            }
            if (compare(element, child) >= 0) {
                break;
            }
            //将子节点存放到index位置
            elements[index] = child;
            index = childIndex;
        }
        elements[index] = element;
    }

    @Override
    public E get() {
        this.emptyCheck();
        return this.elements[0];
    }

    /**
     * 删除堆顶元素
     *
     * @return
     */
    @Override
    public E remove() {
        this.emptyCheck();
        int lastSize = --size;
        E root = elements[0];
        elements[0] = elements[lastSize];
        elements[lastSize] = null;
        this.siftDown(0);
        return root;
    }

    //v1
//    @Override
//    public E replace(E element) {
//        final E root = remove();//log(n)
//        add(element);//log(n)
//        return root;
//    }
    //v2
    @Override
    public E replace(E element) {
        this.elementNotNullCheck(element);
        E root = elements[0];
        if (size == 0) {
            //空堆
            this.elements[0] = element;
            size++;
        } else {
            //替换堆顶元素
            this.elements[0] = element;
            //下滤
            this.siftDown(0);//log(n)
        }
        return root;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    private void emptyCheck() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Heap is Empty");
        }
    }


    @Override
    public Object root() {
        return 0;
    }

    @Override
    public Object left(Object node) {
        Integer index = (int) node;
        index = (index << 1) + 1;
        return index >= size ? null : index;
    }

    @Override
    public Object right(Object node) {
        Integer index = (int) node;
        index = (index << 1) + 2;
        return index >= size ? null : index;
    }

    @Override
    public Object string(Object node) {
        Integer index = (int) node;
        return elements[index];
    }
}