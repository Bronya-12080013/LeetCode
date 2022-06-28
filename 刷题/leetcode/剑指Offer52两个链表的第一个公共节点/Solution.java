package 刷题.leetcode.剑指Offer52两个链表的第一个公共节点;


//OK,粗暴的遍历法过了    5.03% && 44.60%

class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode h1 = headA;
            ListNode h2;
            while (h1!=null)
            {
                h2=headB;
                while (h2!=null)
                {
                    if(h1.equals(h2))
                        return h1;
                    h2=h2.next;
                }
                h1=h1.next;
            }
            return null;
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

/*

//嘤嘤嘤嘤    5.14%  && 16.35%
反而比第一个还低
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class RangeFreqQuery {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode h1=headA;
       ListNode h2=headB;
        Set<ListNode> set =new HashSet<>();
        while (h1!=null||h2!=null)
        {
            if(h1!=null&&set.contains(h1))
                return h1;
            if(h1!=null)
            {
                set.add(h1);
                h1=h1.next;
            }
            if(h2!=null&&set.contains(h2))
                return h2;
            if (h2!=null)
            {
                set.add(h2);
                h2=h2.next;
            }
        }
        return null;
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

//大佬的的思路太强了
/*
public class RangeFreqQuery {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}

 */