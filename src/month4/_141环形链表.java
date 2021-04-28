package 链表;

/**
 * url:https://leetcode-cn.com/problems/linked-list-cycle/
 * 思路：快慢指针：设置一个快的，一个慢的。要是有环他们必定相遇。
 */
public class _141环形链表 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next!=null){
            if (fast == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
