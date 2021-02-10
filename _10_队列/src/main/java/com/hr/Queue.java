package com.hr;


import com.hr.list.LinkedList;
import com.hr.list.List;
//双向链表实现队列
public class Queue<E> {
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
	//入队添加到尾部
	public void enQueue(E element) {
		list.add(element);
	}
	//队头的元素出队
	public E deQueue() {
		return list.remove(0);
	}

	//获取头部元素
	public E front() {
		return list.get(0);
	}
}
