package com.hr.单项链表;


/**
 * @program: leetcode
 * @description: 单链表 该单链表没有虚拟头节点
 * @author: HuRan
 * @create: 2020-09-03 22:55
 */
public class LinkedList<E> extends AbstractList<E> {
    private Node<E> first;


    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +

                    '}';
        }
    }



    /**
     * 设置元素的值
     *
     * @param index   位置
     * @param element 元素
     * @return 旧值
     */
    @Override
    public E set(int index, E element) {
        //找到要插入元素的下标
        Node<E> node = node(index);
        //旧的值
        E old = node.element;
        //设置新的值
        node.element = element;
        //返回旧的值
        return old;
    }

    /**
     * 添加节点
     *
     * @param index   下标
     * @param element 元素
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //如果下标为0
        if (index == 0) {
            first = new Node<>(element, first);
        } else {
            //找到要插入元素的前一个节点
            final Node<E> prev = node(index - 1);
            //创建新的节点  新创建的节点的下一个元素为prev.next
            Node<E> newNode = new Node<>(element, prev.next);
            //指向新的节点
            prev.next = newNode;
        }
        //大小添加1
        size++;
    }

    /**
     * 删除元素
     *
     * @param index 位置
     * @return 旧值
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        //默认为first节点
        Node<E> node = first;
        //删除0位置
        if (index == 0) {
            first = first.next;
        } else {
            //获取删除元素位置的前一个节点
            final Node<E> prev = node(index - 1);
            //获取被删除的元素节点 并返回
            node = prev.next;
            prev.next = prev.next.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return 0;
    }

    /**
     * 清空元素
     */
    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    /**
     * 获取index位置对应的节点对象
     *
     * @param index 下标
     * @return node
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(node);

            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}