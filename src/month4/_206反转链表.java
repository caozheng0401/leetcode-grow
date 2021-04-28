package 链表;

/**
 * url:https://leetcode-cn.com/problems/reverse-linked-list/
 * 思路：1.递归：reverseList含义就是反转，当把next传进去，head就变成了1->2->3->4->null,这时只要把5加进去就可以，head这时还指向5，5的next就是
 * 4，而4的next是null，则把next的next等于head，再把null连上就好了
 *      2.不递归：头插法，
 */
public class _206反转链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode reverseList(ListNode head) {

        if(head == null) return null;
        if (head.next == null) return head;
//        ListNode newhead =reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
        ListNode newhead = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = newhead;
            newhead = head;
            head = tmp;
        }
        return newhead;
    }
}