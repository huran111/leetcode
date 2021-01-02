package com.hr.sort.cmp;

import com.hr.sort.Sort;

public class InsertionSort2<T extends Comparable<T>> extends Sort<T> {

    /**
     * <p>
     * 1.逆序对越多，插入排序复杂度越高
     * 2.将交换转为挪动
	 * 3.该算法改进 逆序对越多 算法优势越大
     * </P>
     */
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            //将元素备份一份，拿着备份的元素跟其他元素比较，如果cur-1位置的元素比我大，那么将cur-1后移动到cur位置。
            //
            T v = array[cur];
            while (cur > 0 && cmp(v, array[cur - 1]) < 0) {
                array[cur] = array[cur - 1];
                cur--; //cur是变化的
            }
            //cur最终的值 就是你带插入元素要放的地方
            array[cur] = v;
        }
    }

}
