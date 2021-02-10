/**
 * @program: leetcode
 * @description: Quick Union  开发中建议使用此方法
 * <p>
 * 思路：左边的根节点==右边的根节点（注意：是根节点 不是父节点，Quick Find是父节点）
 * </p>
 * @author: HuRan
 * @create: 2021-01-02 18:19
 */
public class UnionFine_QU extends UnionFind {
    public UnionFine_QU(int capacity) {
        super(capacity);
    }

    /**
     * 查找v所属的集合也就是根节点
     * 通过parents链表不断向上找，直到找到根节点
     * O(log(n))
     * @param v
     * @return
     */
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]) {
            v = parents[v];
        }
        return v;
    }

    /**
     * 检查v1 v2是否属于同一个集合
     *
     * @param v1
     * @param v2
     * @return
     */
    @Override
    public boolean isSame(int v1, int v2) {
        return find(v1) == find(v2);
    }

    /**
     * 将v1的根节点嫁接到v2的根节点上
     * @param v1
     * @param v2
     */
    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) {
            return;
        }
        //只修改根几点的值，Quick Find是全部替换掉
        parents[p1] = p2;
    }
    void testTimeUnionFine_QU() {
        System.out.println(getClass().getSimpleName());
        int count = 100000;
        UnionFind uf = new UnionFine_QU(count);
        for (int i = 0; i < count; i++) {
            uf.union((int) Math.random() * count, (int) Math.random() * count);
        }
        for (int i = 0; i < count; i++) {
            System.out.println(uf.isSame((int) Math.random() * count, (int) Math.random() * count));

        }
    }
}