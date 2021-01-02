import org.junit.Test;
import printer.BinaryTrees;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-11-15 17:00
 */
public class Main {
    public static void main(String[] args) {
//        BinaryHeap<Integer> heap = new BinaryHeap<>();
//        heap.add(68);
//        heap.add(72);
//        heap.add(43);
//        heap.add(50);
//        heap.add(38);
//        BinaryTrees.println(heap);
//        heap.replace(1);
//        System.out.println("===========================");
//        BinaryTrees.println(heap);
        System.out.println("===========================");
        createHeap02();
    }

    //笨方法
    private static void createHeap01() {
        Integer[] data = {23, 43, 5, 7, 8, 34, 23, 23, 2, 23, 232, 62, 2, 92, 32, 7, 23, 85, 44, 6, 56, 5};
        BinaryHeap heap = new BinaryHeap(data);
        for (int i = 0; i < data.length; i++) {
            heap.add(data[i]);
        }
        BinaryTrees.println(heap);
    }

    //自上而下的上滤
    private static void createHeap02() {
        Integer[] data = {23, 43, 5, 7, 8, 34, 23, 23, 2, 23, 232, 62, 2, 92, 32, 7, 23, 85, 44, 6, 56, 5};
        BinaryHeap heap = new BinaryHeap<>(data);
        //外部修改对内部没有影响
        data[0] = 10;
        data[1] = 123;
        BinaryTrees.println(heap);
    }
    //最大堆
    @Test
    public   void maxHeap() {
        Integer[] data = {23, 43, 5, 7, 8, 34, 23, 23, 2, 23, 232, 62, 2, 92, 32, 7, 23, 85, 44, 6, 56, 5};
        BinaryHeap heap = new BinaryHeap<>(data, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        //外部修改对内部没有影响
        data[0] = 10;
        data[1] = 123;
        BinaryTrees.println(heap);
    }
    //最小堆
    @Test
    public   void minHeap() {
        Integer[] data = {23, 43, 5, 7, 8, 34, 23, 23, 2, 23, 232, 62, 2, 92, 32, 7, 23, 85, 44, 6, 56, 5, 44, 6, 56, 5, 44, 6, 56, 5, 44, 6, 56, 5, 44, 6, 56, 5, 44, 6, 56, 5, 44, 6, 56, 5, 44, 6, 56, 5};
        BinaryHeap heap = new BinaryHeap<>(data, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1 ;
            }
        });
        //外部修改对内部没有影响
        data[0] = 10;
        data[1] = 123;
        BinaryTrees.println(heap);
    }
    //tok k 问题
    @Test
    public void test4(){

        BinaryHeap<Integer> heap = new BinaryHeap<>( new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1 ;
            }
        });
        Integer[] data = {23, 43, 5, 7, 8, 34, 23, 23, 2, 23, 232, 62, 2, 92, 32, 7, 23, 85, 44, 6, 56, 5, 44, 6, 56, 5, 44, 6, 56, 5, 44, 6, 56, 5, 44, 6, 56, 5, 44, 6, 56, 5, 44, 6, 56, 5, 44, 6, 56, 5};
        int k=5;
        for (int i = 0; i < data.length; i++) {
            if(heap.size()<k){
                heap.add(data[i]);
            }else if(data[i]>heap.get()) {
                heap.replace(data[i]);
            }
        }
        BinaryTrees.println(heap);

    }
}