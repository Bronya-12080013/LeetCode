//过了  100% && 30.76%

/*
官方有有趣的解法:
用两个指针 slow 与 fast 一起遍历链表。slow 一次走一步，fast 一次走两步。那么当 fast 到达链表的末尾时，slow 必然位于中间。

class Time {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
 */
package 刷题.leetcode.T876链表的中间结点;

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode listNode = head;
        int num=1;
        while (listNode.next!=null)
        {
            num++;
            listNode=listNode.next;
        }
        num=num/2;
        //if(num%2==0) num--;      别给自己加戏
        while (num!=0)
        {
            num--;
            head=head.next;
        }
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
