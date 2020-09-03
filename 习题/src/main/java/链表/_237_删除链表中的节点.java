package 链表;

/**
 * @program: leetcode
 * @description: leetcode
 * @author: HuRan
 * @create: 2020-09-03 23:46
 */
public class _237_删除链表中的节点 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //覆盖 将该节点的后一个节点的值覆要删除的节点的值，然后
    //将改节点指向下下一个节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}