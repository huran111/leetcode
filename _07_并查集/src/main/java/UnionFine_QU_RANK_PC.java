/**
 * @program: leetcode
 * @description: Quick Union  开发中建议使用此方法
 * <p>
 * <p>
 * 基于Rank的优化+路径压缩
 * </p>
 * @author: HuRan
 * @create: 2021-01-02 18:19
 */
public class UnionFine_QU_RANK_PC extends UnionFine_QU_RANK {

    public UnionFine_QU_RANK_PC(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        if (v != parents[v]) {
            //拿到v的父节点
            int parent_data = parents[v];
            //这一步在修改v的父节点为根节点
            parents[v] = find(parent_data);//递归调用 向上查找 路径压缩
        }
        return parents[v];
    }
}