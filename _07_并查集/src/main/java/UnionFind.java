/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-01-02 18:10
 */
public abstract class UnionFind {
    protected int[] parents;

    public UnionFind(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity  myst be >=1");
        }
        parents = new int[capacity];
        //初始化 每一个元素都是一个单独的集合
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    protected abstract void union(int v1, int v2);

    protected abstract boolean isSame(int v1, int v2);

    protected void rangeCheck(int v) {
        if (v < 0 || v >= parents.length) {
            throw new IllegalArgumentException();
        }
    }



}