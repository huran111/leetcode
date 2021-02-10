/**
 * @program: leetcode
 * @description: Quick Union  开发中建议使用此方法
 * <p>
 * <p>
 * 基于Rank的优化+路径分裂
 * </p>
 * @author: HuRan
 * @create: 2021-01-02 18:19
 */
public class UnionFine_QU_RANK_PS extends UnionFine_QU_RANK {

    public UnionFine_QU_RANK_PS(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]) {
            int p = parents[v]; //保留v父节点让它也执行同样操作
            parents[v] = parents[parents[v]];//找到v的祖父节点
            v = p;
        }
        return v;
    }
}