package com.hr.sort.cmp;

import com.hr.sort.Sort;

public class InsertionSort3<T extends Comparable<T>> extends Sort<T> {


    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            //从左边有序数组里面找到插入元素合适的位置，你就默认它有序 从index=0-1开始 拿 index[1]和index[0]开始比较
            //问题：为什么要传索引值,包含前面排好序的元素有多少个，比如是5:[0,5),index的元素是待插入的
            int insertIndex = search(begin);
            //insertIndex 找到插入位置的索引
            insert(begin, insertIndex);
        }
    }

    /**
     * 将source位置的元素插入到dest位置
     *
     * @param source
     * @param dest
     */
    private void insert(int source, int dest) {
        T v = array[source];
        //通通往右边移动(大的值开始)i > dest 大于插入位置
        for (int i = source; i > dest; i--) {
            array[i] = array[i - 1];
        }
        array[dest] = v;
    }

    /**
     * 利用二分搜索找到 index 位置元素的待插入位置
     * 已经排好序数组的区间范围是 [0, index)
     *
     * @param index
     * @return
     */
    private int search(int index) {
        int begin = 0; //在0到index有序数组里面找出插入位置
        int end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (cmp(array[index], array[mid]) < 0) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }
}
