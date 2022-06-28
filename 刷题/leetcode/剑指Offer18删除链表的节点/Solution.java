/*
成功了，不愧是我   100% && 82.26%
 */

package 刷题.leetcode.剑指Offer18删除链表的节点;

class Solution {
    public static void main(String[] args) {
       // ListNode node =new ListNode(4);
       // node.next=new ListNode(5);
       // node.next.next=new ListNode(1);
       // node.next.next.next=new ListNode(9);
       // ListNode n =deleteNode(node,1);
    }
    static ListNode deleteNode(ListNode head, int val) {
        ListNode node = head;    //这个node是个指针，也就是个“替身”;
        if(head.val==val)
            head=head.next;
        else
        while (node.next!=null)
        {
            if(node.next.val==val)
            {
                node.next=node.next.next;
                break;
            }
            node=node.next;
        }
        return head;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }