/**
 * @program: leetcode
 * @description: Quick Union  开发中建议使用此方法
 * <p>
 * 思路：左边的根节点==右边的根节点（注意：是根节点 不是父节点，Quick Find是父节点）
 * 基于高度的优化
 * </p>
 * @author: HuRan
 * @create: 2021-01-02 18:19
 */
public class UnionFine_QU_RANK extends UnionFine_QU {
    int[] ranks;

    public UnionFine_QU_RANK(int capacity) {
        super(capacity);
        ranks = new int[capacity];
        for (int i = 0; i < ranks.length; i++) {
            ranks[i] = 1; //开始默认高度是1
        }
    }

    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) {
            return;
        }
        if (ranks[p1] < ranks[p2]) {
            parents[p1] = p2; //整个树嫁接过去 整体高度没有变化
        } else if (ranks[p1] > ranks[p2]) {
            parents[p2] = p1;
        } else {
            //高度一样的话
            parents[p1] = p2;
            //次数高度发生了变化
            ranks[p2] += 1;
        }
    }
}