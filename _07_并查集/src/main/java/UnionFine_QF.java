/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-01-02 18:19
 */
public class UnionFine_QF extends UnionFind {
    public UnionFine_QF(int capacity) {
        super(capacity);
    }

    /**
     * 查找v所属的集合也就是根节点
     *
     * @param v
     * @return
     */
    public int find(int v) {
        rangeCheck(v);
        return parents[v];//返回集合根节点
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
     *  左边的值得父节点 改成右边值得父节点的值
     *  将v1所有的集合所有元素都嫁接到v2元素的父节点上
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
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == p1) {
                parents[i] = p2;
            }
        }
    }
    void testTimeUnionFine_QF() {
        System.out.println(getClass().getSimpleName());
        int count = 100000;
        UnionFind uf = new UnionFine_QF(count);
        for (int i = 0; i < count; i++) {
            uf.union((int) Math.random() * count, (int) Math.random() * count);
        }
        for (int i = 0; i < count; i++) {
            uf.isSame((int) Math.random() * count, (int) Math.random() * count);
        }
    }
}