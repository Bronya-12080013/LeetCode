package 刷题.leetcode.剑指Offer25合并两个排序的链表;/*
用复制法（遍历两链表，填到一个新链表上）过了，初版还有很大的压缩空间,我就不简化了，去看看大佬直接把两个链表拼接吧   45.30% && 75.13%
======================================================================
等等等等
大佬的也是复制法
分析一下他与我的差别
1.用 ListNode dum = new ListNode(0) 来当新的头，而return dum.next;
这样就省去了像我的麻烦的判断。
2.用的是while(l1 != null && l2 != null)循环，（   而我的是 while (l11!=null||l22!=null)   ）
而后面剩下的直接拼上去，不必再循环了： cur.next = l1 != null ? l1 : l2;
 */


/*
复制法：
package 刷题.leetcode.剑指Offer25合并两个排序的链表;

import java.util.List;

class RangeFreqQuery {
    public static void main(String[] args) {
      //  ListNode l1=new ListNode(1);
      //  l1.next =new ListNode(2);
      //  l1.next.next=new ListNode(4);
      //  ListNode l2 =new ListNode(1);
      //  l2.next=new ListNode(3);
      //  l2.next.next=new ListNode(4);
        ListNode l1=new ListNode(2);
    }
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null)
            return null;
        if(l1==null&&l2!=null)
        {
            return l2;
        }
        if(l1!=null&&l2==null)
        {
            return l1;
        }
        ListNode l11= l1;
        ListNode l22= l2;
        ListNode newnode;
        if(l11.val<=l22.val){
            newnode=new ListNode(l1.val);
            l11=l11.next;
        }else {
            newnode=new ListNode(l2.val);
            l22=l22.next;
        }
        ListNode node = newnode;
        while (l11!=null||l22!=null)
        {
            if(l11!=null&&l22==null)
            {
                node.next = new ListNode(l11.val);
                l11=l11.next;
            }
            else if(l11==null&&l22!=null)
            {
                node.next = new ListNode(l22.val);
                l22=l22.next;
            }
            else if(l11.val==l22.val)
            {
                node.next = new ListNode(l11.val);
                node=node.next;
                node.next = new ListNode(l22.val);
                l11=l11.next;
                l22=l22.next;
            }
            else if(l11.val<l22.val){
                node.next = new ListNode(l11.val);
                l11=l11.next;
            }else {
                node.next = new ListNode(l22.val);
                l22=l22.next;
            }
            node=node.next;
        }
        return newnode;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 */

//大佬的
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}