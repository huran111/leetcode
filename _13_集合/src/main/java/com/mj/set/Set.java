package com.mj.set;

public interface Set<E> {
    /**
     * 集合大小
     * @return
     */
	int size();

    /**
     * 集合是否为空
     * @return
     */
	boolean isEmpty();

    /**
     * 清空集合
     */
	void clear();

    /**
     * 是否包含该元素
     * @param element
     * @return
     */
	boolean contains(E element);

    /**
     * 添加元素
     * @param element
     */
	void add(E element);

    /**
     * 删除元素
     * @param element
     */
	void remove(E element);

    /**
     * 打印集合元素
     * @param visitor
     */
	void traversal(Visitor<E> visitor);
	
	public static abstract class Visitor<E> {
		boolean stop;
		public abstract boolean visit(E element);
	}
}
