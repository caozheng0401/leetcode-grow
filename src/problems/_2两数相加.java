import java.util.ArrayList;
import java.util.List;

/**
 * @author cz
 * @create 2021/4/20 21:38
 */

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 00，比如 987 + 23 = 987 + 023 = 1010
 * 每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值
 * 如果两个链表全部遍历完毕后，进位值为 11，则在新链表最前方添加节点 11
 * 小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。
 * 使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
 */
public class _2两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        List<Integer> a = new ArrayList<>();
//        List<Integer> b = new ArrayList<>();
//        StringBuilder f = new StringBuilder();
//        StringBuilder g = new StringBuilder();
//        int c = 0,d= 0;
//        while(l1.next!=null){
//            a.add(l1.val);
//        }
//        while(l2.next!=null){
//            b.add(l2.val);
//        }
//        for (int i = a.size() - 1; i >= 0 ; i--) {
//            f.append(a.get(i));
//        }
//        for (int i = b.size() - 1; i >= 0; i--) {
//            g.append(b.get(i));
//        }
//        Integer integer = Integer.valueOf(String.valueOf(f));
//        Integer integer1 = Integer.valueOf(String.valueOf(g));
//        Integer sout = integer + integer1;
//        String s = String.valueOf(sout);
//        int[] p = new int[s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            p[i] = s.charAt(i);
//        }
//        ListNode ln=new ListNode();
//        ln.val=p[0];
//        ListNode m=ln;
//        for(int i=1;i<p.length;i++){
//            //建立一个暂存节点信息的节点
//            ListNode tem=new ListNode();
//            tem.val=p[i];
//            m.next=tem;
//            m=(ListNode) m.next;
//        }
//        return ln;
        ListNode pre = new ListNode(0);      //定义一个空指针，使它指向真正的第一个指针
        ListNode cur = pre;
        int carry = 0;                    //进不进位
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;    //判断有没有，如果没有当做0相加
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;           //相加结果

            carry = sum / 10;                //求进不进位
            sum = sum % 10;                 //个位数
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);         //当完成时候进不进最后那位
        }
        return pre.next;
    }
    }



}
