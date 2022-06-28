/*
经典回归
这可是我早期(指两个月前 现在12.3 之前9.24)刷的题啊 之前是剑指offer的
平角裤平角裤  100% && 59.19%
==============================================
官方迭代  感觉没我的好用哎 每次都要建一个新的指针
class TopVotedCandidate {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
=====================================================
官方递归 效率没迭代好 看着还脑壳痛
class TopVotedCandidate {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}


 */
package 刷题.leetcode.T206反转链表;

public class Solution {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        node.next.next.next.next=new ListNode(5);
        reverseList(node);
    }
    static ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ListNode pre=null;
        ListNode tie=head.next;
        while (tie!=null)
        {
            head.next=pre;
            pre=head;
            head=tie;
            tie=tie.next;
        }
        head.next=pre;             //注意这里
        return head;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }