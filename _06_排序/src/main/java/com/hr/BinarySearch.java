package com.hr;

public class BinarySearch {

    /**
     * 查找v在有序数组array中的位置
     * 二分法
     * <p>
     * 1.
     * </p>
     */
    public static int indexOf(int[] array, int v) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (v < array[mid]) { //左边搜索
                end = mid;
            } else if (v > array[mid]) { //右边搜索
                begin = mid + 1;
            } else {
                return mid; //等于 返回
            }
        }
        return -1; //找不到返回-1
    }

    /**
     * 查找v在有序数组array中待插入位置
     * <p>
     * 1.要求二分搜索返回的插入位置，第1个大于V的元素位置
     *
     * </p>
     */
    public static int search(int[] array, int v) {
        if (array == null || array.length == 0) {
			return -1;
		}
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (v < array[mid]) {//如果插入元素小于中间元素
                end = mid;//赋值给end
            } else {
                //大于 右边那一半去找，新的范围是mid+1到end,修改begin的值
                begin = mid + 1;
            }
        }
        //一旦while循环退出的话，begin是等于end的
        return begin;
    }
}
