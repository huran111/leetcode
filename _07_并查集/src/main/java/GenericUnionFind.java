import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-01-02 19:30
 */
public class GenericUnionFind<V> {
    private Map<V, Node<V>> nodes = new HashMap();

    //初始化集合
    public void makeSet(V v) {
        nodes.put(v, new Node<V>(v));
    }

    public void union(V v1, V v2) {
        Node<V> p1 = findNode(v1);
        Node<V> p2 = findNode(v2);
        if (p1 == null || p2 == null) {
            return;
        }
        if (Objects.equals(p1.value, p2.value)) {
            return;
        }
        if (p1.rank < p2.rank) {
            p1.parent = p2;
        } else if (p1.rank > p2.rank) {
            p2.parent = p1;
        } else {
            p1.parent = p2;
            p2.rank += 1;
        }
    }

    /**
     * 找出V的根节点
     *
     * @param v
     * @return
     */
    private Node<V> findNode(V v) {
        Node<V> node = nodes.get(v);
        if (node == null) {
            return null;
        }
        while (!Objects.equals(node.value, node.parent.value)) {
            node.parent = node.parent.parent;
            node = node.parent;
        }
        return node;

    }

    //返回根节点
    public V find(V v) {
        Node<V> node = findNode(v);
        return node == null ? null : node.value;
    }

    public boolean isSame(V v1, V v2) {
        return Objects.equals(find(v1), find(v2));
    }


    private static class Node<V> {
        V value;
        Node<V> parent = this;
        int rank = 1;

        public Node(V v) {
            this.value = v;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "jack");
        Student s2 = new Student(2, "B");
        Student s3 = new Student(3, "C");
        Student s4 = new Student(4, "D");
        GenericUnionFind uf = new GenericUnionFind();
        uf.makeSet(s1);
        uf.makeSet(s2);
        uf.makeSet(s3);
        uf.makeSet(s4);
        uf.union(s1, s2);
        uf.union(s3, s4);
        uf.union(s1, s4);
        System.out.println(uf.isSame(s2, s3));
    }
}