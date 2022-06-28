/*
3分钟一遍过的送分题（是我之前看过书了）
设两个指针，一个先走k-1步，然后两个一起走，当前面的到尾部时，后面那个就在k-1的位置上了
 */

package 刷题.leetcode.剑指Offer22链表中倒数第k个节点;

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode lead =head;
        ListNode curr =head;
        for(int i=1;i<=k-1;i++)
        {
            lead=lead.next;
        }
        while (lead.next!=null)
        {
            lead=lead.next;
            curr=curr.next;
        }
        return curr;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
