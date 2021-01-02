package com.hr.sort.cmp;

import com.hr.sort.Sort;
//归并排序  nlog(n)
@SuppressWarnings("unchecked")
public class MergeSort<T extends Comparable<T>> extends Sort<T> {
	private T[] leftArray;

	@Override
	protected void sort() {
		/**
		 * [0,array.length]
		 * [0,mid] 左边==>[0,array.length>>1]
		 * [mid,array.length]  右边
		 */
		//备份左边那一半的数据
		leftArray = (T[]) new Comparable[array.length >> 1];
		sort(0, array.length);
	}
	
	// T(n) = T(n/2) + T(n/2) + O(n)
	
	/**
	 * 对 [begin, end) 范围的数据进行归并排序
	 */
	private void sort(int begin, int end) {
		//知道剩余一个
		if (end - begin < 2) return;
		
		int mid = (begin + end) >> 1;
		sort(begin, mid);
		sort(mid, end);
		merge(begin, mid, end);
	}
	
	/**
	 * 将 [begin, mid) 和 [mid, end) 范围的序列合并成一个有序序列
	 */
	private void merge(int begin, int mid, int end) {
		int li = 0, le = mid - begin;
		int ri = mid, re = end;
		int ai = begin; //是从begin开始的
		
		// 备份左边数组
		for (int i = li; i < le; i++) {
			leftArray[i] = array[begin + i];
		}
		
		// 如果左边还没有结束
		while (li < le) { 
			if (ri < re && cmp(array[ri], leftArray[li]) < 0) {
				array[ai++] = array[ri++];
			} else {
				array[ai++] = leftArray[li++];
			}
		}
	}
}
