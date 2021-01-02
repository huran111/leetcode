import java.util.Comparator;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-11-15 18:57
 */
public abstract class AbstractHeap<E> implements Heap<E> {
    protected  int size;
    protected Comparator<E> comparator;
    public AbstractHeap(Comparator comparator){
        this.comparator=comparator;
    }
    public AbstractHeap(){
        this(null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    protected int compare(E e1, E e2) {
        if(null!=comparator){
           return comparator.compare(e1, e2);
        }else {
            return ((Comparable<E>) e1).compareTo(e2);
        }
    }
}
