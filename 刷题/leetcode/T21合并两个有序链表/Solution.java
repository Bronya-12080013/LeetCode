/*
又是写过的题 还不会写了呜呜呜呜呜 我想直接拼接来着
直接遍历复制！！！！！
============================================
成功了 100.00% && 73.37% 嘿嘿嘿复制我的超人
回去看了一下之前的 我也是用复制法 但还是费了很大功夫
现在我虽不能直接拼接 但写复制法还是很容易的 也算是进步了？
=============================================
好家伙
官方和大佬也不直接拼接啊 我在搞什么 想大道至简吗
有   递归法 和 迭代法（复制法）
=============================================
递归法（真棒，好好看看）
class TopVotedCandidate {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null)
        {
            return list1;
        }
        if(list1.val<list2.val)
        {
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }
    }
}
======================================================
迭代法  思想和我一样 但简明多了
class TopVotedCandidate {
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
 */
/*  又是写过的题 写不了！！！！！！
package 刷题.leetcode.合并两个有序链表21;
public class TopVotedCandidate {
    public static void main(String[] args) {
      //  ListNode list1=new ListNode(5);
        ListNode list1=new ListNode(1);
        list1.next=new ListNode(2);
        list1.next.next=new ListNode(4);
       ListNode list2 =new ListNode(1);
       list2.next=new ListNode(3);
       list2.next.next=new ListNode(4);
        mergeTwoLists(list1,list2);
    }
    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null&&list2==null) return null;
        else if(list1!=null&&list2==null) return list1;
        else if(list1==null&&list2!=null) return list2;
        ListNode head=list1.val<=list2.val?list1:list2;
        while (list1!=null&&list2!=null)       //又写终止条件了
        {
            if(list1.val<=list2.val)
            {
                if(list1.next!=null)
                while (list1.next.val< list2.val)
                {
                    list1=list1.next;
                    if(list1.next==null) break;
                }
                ListNode node = list1.next;
                list1.next=list2;
                list1=node;
            }else {
                if (list2.next!=null)
                while (list2.next.val< list1.val)
                {
                    list2=list2.next;
                    if(list2.next==null) break;
                }
                ListNode node = list2.next;
                list2.next=list1;
                list2=node;
            }
        }
        return head;
    }
}
 */

//果然直接复制方便多了
package 刷题.leetcode.T21合并两个有序链表;
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        while (list1!=null||list2!=null){
            if(list1!=null&&list2!=null)
            {
                if(list1.val<= list2.val)
                {
                    head.next=new ListNode(list1.val);
                    head=head.next;
                    list1=list1.next;
                }else {
                    head.next=new ListNode(list2.val);
                    head=head.next;
                    list2=list2.next;
                }
            }
            else if(list1!=null&&list2==null){
                head.next=list1;
                break;
            }else if(list1==null&&list2!=null)
            {
                head.next=list2;
                break;
            }
        }
        return listNode.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }