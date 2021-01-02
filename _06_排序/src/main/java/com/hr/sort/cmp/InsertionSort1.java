package com.hr.sort.cmp;

import com.hr.sort.Sort;

public class InsertionSort1<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        /**
         * 1.begin就是你抓的那张牌，你要插到合适的位置去
         * 2.想象前面已经有序了， 拿到一张牌 不断地往左走，一直进行比较"cmp(cur, cur - 1)"如果是小于0 标识begin比左边的小，那么就进行交换。交换完成后，索引要减去1.
         * 3.begin需要保留，用cur做一个副本，不然找不到下一张(begin+1)的牌，begin也可能减为0，那么cur
         * 应该大于0
         * 4.插入算法是稳定的：cmp(cur, cur - 1) < 0)稳定
         * cmp(cur, cur - 1) <= 0)：<=是不稳定的
         */
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            while (cur > 0 && cmp(cur, cur - 1) < 0) {
                swap(cur, cur - 1);
                cur--;
            }
        }
    }

}
