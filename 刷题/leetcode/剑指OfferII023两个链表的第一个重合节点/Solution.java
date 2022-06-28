package 刷题.leetcode.剑指OfferII023两个链表的第一个重合节点;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*  方法一 哈希表过了
class Solution {
    public static void main(String[] args) {
        ListNode ha = new ListNode(4);
        ha.next = new ListNode(1);
        ListNode hb = new ListNode(5);
        hb.next = new ListNode(0);
        hb.next.next = new ListNode(1);
        ListNode hc = new ListNode(8);
        hc.next = new ListNode(4);
        hc.next.next = new ListNode(5);
        ha.next.next = hc;
        hb.next.next.next = hc;
        getIntersectionNode(ha,hb);
    }
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {     //又写成结束条件了
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
}
 */

/*  方法二  特殊暴力法 主要是因为有无交点情况 我经过反复测试才搞出了 19891 的数字少一次都不行
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA;
        ListNode hb = headB;
        int count = 0;
        while (ha!=hb)
        {
            ha=ha.next;
            hb=hb.next;
            if(ha==null) ha=headB;
            if(hb==null) hb=headA;
            if(++count==19891) return null;
        }
        return ha;
    }
}
 */

//改进 方法三: 当两个链表无相交且长度不等 则当ha hb 各自都逛了一遍两个链表后 同时为null
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {  //本题不要求
            return null;
        }
        ListNode ha = headA;
        ListNode hb = headB;
        while (ha!=hb)
        {
            ha=ha.next;
            hb=hb.next;
            if(ha==null&&hb==null) return null;
            if(ha==null) ha=headB;
            if(hb==null) hb=headA;
        }
        return ha;
    }
}
/*
方法三的官方版:
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;   //注意当pA为末端时，仍是执行pA=pA.next pA会保持null到下一次（而不是直接变了） 这样就当两者都为null时达成pA==pB 出局
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }