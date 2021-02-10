package com.hr;


import com.hr.list.LinkedList;
import com.hr.list.List;

/**
 * 双端队列
 * @param <E>
 */
public class Deque<E> {
    private List<E> list = new LinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

	/**
	 * 从队尾入队
	 * @param element
	 */
	public void enQueueRear(E element) {
        list.add(element);
    }

    public E deQueueFront() {
        return list.remove(0);
    }

    public void enQueueFront(E element) {
        list.add(0, element);
    }

	/**
	 * 尾部出队
	 * @return
	 */
	public E deQueueRear() {
        return list.remove(list.size() - 1);
    }

	/**
	 * 获取头部元素
	 * @return
	 */
	public E front() {
        return list.get(0);
    }

	/**
	 * 获取尾部元素
	 * @return
	 */
	public E rear() {
        return list.get(list.size() - 1);
    }
}
