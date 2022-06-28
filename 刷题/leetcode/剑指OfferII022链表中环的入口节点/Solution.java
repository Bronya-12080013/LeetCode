/*
链接：https://leetcode-cn.com/problems/c32eOV/solution/jian-zhi-offer-ii-022-lian-biao-zhong-hu-8f1m/
这个推导太漂亮了
 */
package 刷题.leetcode.剑指OfferII022链表中环的入口节点;
import java.util.List;
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(true)
        {
            if(fast==null||fast.next==null) return null;
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) break;
        }
        fast=head;
        while (slow!=fast)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

/*  11/16 不行了   越写越觉得我写得是什么玩意
package 刷题.leetcode.剑指OfferII022链表中环的入口节点;
import java.util.List;
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h = new ListNode(2);
        head.next=h;
       // h.next=head;
        detectCycle(head);
    }
    static ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode node = new ListNode(0);
        node.next=head;
        ListNode p1 = node;
        if(head.next==null) return null;
        ListNode p2 = head.next;
        while (true)
        {
            if(p2.next==null) return null;
            p1=p1.next;
            p2=p2.next;
            if(p2.next==null) return null;
            p2=p2.next;
            if(p2.next==null) return null;
            if(p1==p2) break;
        }
        return p1.next;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
 */