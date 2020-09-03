
/**
 * @program: leetcode
 * @description: ArrayList
 * @author: HuRan
 * @create: 2020-06-21 16:08
 */
public class MyArrayList {
    /**
     * 元素的数量
     */
    private int size;

    /**
     * 所有元素
     */
    private int[] elements;

    private static final int DEFAULT_CAPACICY = 10;

    public MyArrayList(int capaticy) {
        capaticy = (capaticy < DEFAULT_CAPACICY) ? DEFAULT_CAPACICY : capaticy;
        elements = new int[capaticy];
    }

    public MyArrayList() {
        this(DEFAULT_CAPACICY);
    }

    public void clear() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(int element) {
        return indexOf(element) != -1;
    }

    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) return i;
        }
        return -1;
    }

    public int set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
        int old = elements[index];
        elements[index] = element;
        return old;
    }

    public int get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    public int remove(int index) {
        rangeCheck(index);
        int old = elements[index];
        for (int i = index + 1; i < size - 1; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        return old;
    }

    public void add(int index, int element) {
        rangeCheckAdd(index);
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    public void add(int element) {
        add(size, element);
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
    }

    private void rangeCheckAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
    }

    @Override
    public String toString() {
        // size=3, [99, 88, 77]
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(elements[i]);

//			if (i != size - 1) {
//				string.append(", ");
//			}
        }
        string.append("]");
        return string.toString();
    }
}