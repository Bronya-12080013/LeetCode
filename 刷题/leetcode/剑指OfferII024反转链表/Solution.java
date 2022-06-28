/*
经典老题 写了几次了 每次都以不同的名义出现
这几天都在写难题 快来点简单题放松大脑   2021.12.7--19：41
================================================
过了 简单
100.00% 22.94%
这次用了上次学官方的递归法
 */
package 刷题.leetcode.剑指OfferII024反转链表;

import java.util.List;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        reverseList(head);
    }
    static ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;     //注意这里不是retrun null;
        ListNode p = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return p;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
