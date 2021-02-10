package 链表;


/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-06 14:28
 */
public class _206_反转链表 {
    public static void main(String[] args) {

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 5 4 3 2 1  给你一个链表头 ，返回一个新的链表头
    public ListNode reverseList(ListNode hand) {
        if (hand == null || hand.next == null) {
            return hand;
        }
        ListNode newHead = reverseList(hand.next);
        hand.next.next = hand;
        hand.next = null;
        return newHead;
    }

    public ListNode reverseList2(ListNode hand) {
        if (hand == null || hand.next == null) {
            return hand;
        }
        ListNode newHead = null;
        while (hand != null) {//注意 这个hand不是虚拟头节点
            final ListNode temp = hand.next;
            hand.next = newHead;
            newHead = hand;
            hand = temp;

        }
        return newHead;
    }
}