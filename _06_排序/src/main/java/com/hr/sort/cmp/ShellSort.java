package com.hr.sort.cmp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.hr.sort.Sort;

/**
 * <p>
 * 希尔排序  分步长，发现逆序对的数量在减少
 * 底层用插入排序实现
 * </p>
 *
 * @param <T>
 */
@SuppressWarnings("unused")
public class ShellSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        List<Integer> stepSequence = sedgewickStepSequence();
        for (Integer step : stepSequence) { //步长
            sort(step);  //分成多少列进行排序
        }
    }


    /**
     * 分成step列进行排序
     * 1.假设元素在col列，第row行，步长是step
     * 那么这个元素在数据中的索引是col+row*step
     */
    private void sort(int step) {
        // col : 第几列，column的简称
        //按照列进行排序 从0列开始
        for (int col = 0; col < step; col++) { // 对第col列进行排序
            // col、col+step、col+2*step、col+3*step
            //begin = col + step 从第二个索引元素开始排序 为什么 插入排序没必要从第一个元素开始，因为第一个元素前面没有元素了 没必要
			//begin += step 下一个元素的索引
            for (int begin = col + step; begin < array.length; begin += step) {
                int cur = begin;
				// 说明：cmp(cur, cur - step) 拿到一个元素 跟前面的元素进行比较
                while (cur > col && cmp(cur, cur - step) < 0) {
                    swap(cur, cur - step);
                    cur -= step;
                }
            }
        }
    }

    /**
     * 希尔规定的：
     *
     * @return
     */
    private List<Integer> shellStepSequence() {
        List<Integer> stepSequence = new ArrayList<>();
        int step = array.length; //步长序列跟你的数据规模有关系
        //右移一位除以二
        while ((step = (step >> 1)) > 0) {
            stepSequence.add(step);
        }
        return stepSequence;
    }

    private List<Integer> sedgewickStepSequence() {
        List<Integer> stepSequence = new LinkedList<>();
        int k = 0, step = 0;
        while (true) {
            if (k % 2 == 0) {
                int pow = (int) Math.pow(2, k >> 1);
                step = 1 + 9 * (pow * pow - pow);
            } else {
                int pow1 = (int) Math.pow(2, (k - 1) >> 1);
                int pow2 = (int) Math.pow(2, (k + 1) >> 1);
                step = 1 + 8 * pow1 * pow2 - 6 * pow2;
            }
            if (step >= array.length) break;
            stepSequence.add(0, step);
            k++;
        }
        return stepSequence;
    }
}
