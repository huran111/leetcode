/**
 * @program: leetcode
 * @description: Quick Union  开发中建议使用此方法
 * <p>
 * <p>
 * 基于Rank的优化+路径减半
 * </p>
 * @author: HuRan
 * @create: 2021-01-02 18:19
 */
public class UnionFine_QU_RANK_PH extends UnionFine_QU_RANK {

    public UnionFine_QU_RANK_PH(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]) {
            parents[v] = parents[parents[v]];
            v = parents[v];
        }
        return v;
    }
}