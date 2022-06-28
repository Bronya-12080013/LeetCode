package 刷题.leetcode.T86分隔链表;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
/*
选择不新建节点的话 记得在结尾阻断
 */

//100.00% && 65.71%
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode l = new ListNode(0);
        ListNode r = new ListNode(0);
        ListNode lt =l;
        ListNode rt =r;
        while (head!=null)
        {
            if(head.val<x)
            {
                lt.next = head;
                lt = lt.next;
            }else {
                rt.next = head;
                rt = rt.next;
            }
            head = head.next;
        }
        lt.next=r.next;
        rt.next=null;  //记得阻断
        return l.next;
    }
}


/*  看错题目了  题目真难看懂
这里我把x看成是下标了(虽然链表没下标就是了)
前面我因为题目理解和示例对不上 而理解错了
class Solution {
    public static void main(String[] args) {
       // ListNode root = new ListNode(1);
       // root.next = new ListNode(4);
       // root.next.next=new ListNode(3);
       // root.next.next.next = new ListNode(2);
       // root.next.next.next.next =  new ListNode(5);
       // root.next.next.next.next.next = new ListNode(2);
        ListNode root = new ListNode(2);
        root.next = new ListNode(1);
        partition(root,2);
    }
    static public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        int val = Integer.MAX_VALUE;
        Deque<ListNode> queue = new ArrayDeque<>();
        while (head!=null)
        {
            x--;
            if(x==0) val=head.val;
            queue.add(head);
            head=head.next;
        }
        int len = queue.size();
        for(int i =0;i<len;i++)
        {
            ListNode node = queue.poll();
            if(node.val<val) {
                temp.next=node;
                temp=temp.next;
            }else {
                queue.add(node);
            }
        }
        len = queue.size();
        for(int i=0;i<len;i++)
        {
            temp.next=queue.poll();
            temp=temp.next;
        }
        temp.next=null;  //这里记得截断
        return res.next;
    }
}


 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}