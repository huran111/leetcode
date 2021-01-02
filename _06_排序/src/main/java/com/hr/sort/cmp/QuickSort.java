package com.hr.sort.cmp;

import com.hr.sort.Sort;

/**
 * 快速排序 不稳定排序
 * <p>
 * 1.序列中选取一个轴点元素
 * 小于轴点的放在左边，
 * 大于轴点的放在右边
 * 等于轴点的放哪都可以
 * 对子序列进行上述操作
 * <p>
 * 快速排序的本质：
 * 主键将每个一元素变为轴点元素
 *
 * <p>
 * <en>
 * 1.轴点构造 左闭右开[ )
 * 左边第一个元素开始作为轴点（备份一个）
 * 从右边开始扫描元素如果大于轴点元素，end--
 * 如果比轴点元素小 直接覆盖(之前轴点元素已经备份过) begin++
 * </en>
 * <en>
 * 1.如果抽点左右元素数量极度不均匀，最坏情况，
 *    T(n)=T(n-1)+O(n)=O(n^2)
 * 2.解决 随机采取轴点元素
 * </en>
 *
 * <en>
 *     细节：与轴点相等的元素
 *     1.好处依然能够平均分割
 *     如果(cmp(pivot, array[end]) <= 0)或者(cmp(pivot, array[end]) >= 0)
 *     轴点元素切割出来的元素比较不均匀
 * </en>
 * </p>
 *
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        sort(0, array.length);
    }

    /**
     * 对 [begin, end) 范围的元素进行快速排序
     *
     * @param begin 开始位置  [
     * @param end   结束位置   ）
     */
    private void sort(int begin, int end) { //T(n)=2*T(n/2)+O(n)=nlog(n)
        //如果元素小于2个直接返回
        if (end - begin < 2) {
            return;
        }
        // 确定轴点位置 O(n)
        int mid = pivotIndex2(begin, end);
        // 对子序列进行快速排序
        sort(begin, mid);      //T(n/2)
        sort(mid + 1, end);    //T(n/2)
    }


    /**
     * 构造出 [begin, end) 范围的轴点元素
     *
     * @return 轴点元素的最终位置
     */
    private int pivotIndex(int begin, int end) {
        // 随机选择一个元素跟begin位置进行交换
        swap(begin, begin + (int) (Math.random() * (end - begin)));

        // 备份begin位置的元素
        T pivot = array[begin];
        // end指向最后一个元素
        end--;

        while (begin < end) {
            while (begin < end) {
                if (cmp(pivot, array[end]) < 0) { // 右边元素 > 轴点元素
                    end--;
                } else { // 右边元素 <= 轴点元素
                    array[begin++] = array[end];
                    break;
                }
            }
            while (begin < end) {
                if (cmp(pivot, array[begin]) > 0) { // 左边元素 < 轴点元素
                    begin++;
                } else { // 左边元素 >= 轴点元素
                    array[end--] = array[begin];
                    break;
                }
            }
        }

        // 将轴点元素放入最终的位置
        array[begin] = pivot;
        // 返回轴点元素的位置
        return begin;
    }


    private int pivotIndex2(int begin, int end) {
        T pivot = array[begin];//备份begin位置的元素
        end--;//end指向最后一个元素
        while (begin < end) {
            while (begin < end) {
                //从右往左扫描：右边比较大的时候
                if (cmp(pivot, array[end]) < 0) {
                    end--;
                } else {  //等于轴点元素  换方向扫描
                    //end位置的元素是不大于轴点的  小于等于轴点覆盖begin位置的元素 begin在++
                    array[begin] = array[end];
                    begin++;
                    break; //跳出while循环，开始从左往右扫描
                }
            }
            while (begin < end) {
                //从左往右 扫描方向发生改变
                if (cmp(pivot, array[begin]) > 0) {//此时begin元素如果小于抽点元素，不用动 直接begin++
                    begin++;
                } else {//扫描方向发生改变，等于轴点元素  换方向扫描
                    //从左往右扫描的时候begin大于轴点元素，那么直接覆盖end的值 end--
                    array[end] = array[begin];
                    end--;
                    break; //跳出while循环 开始从右往左扫描
                }
            }
        }
        //将轴点元素放入最终的位置
        array[begin] = pivot;
        return begin;
    }

}
