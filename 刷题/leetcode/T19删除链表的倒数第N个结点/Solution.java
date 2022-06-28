/*
过了，中等题就这？   100% && 39.80%
但还是要注意。
=========================================
关键是//2： 用
while (n!=0&&temp.next!=null)
和
 if(n!=0) return head.next;     即如果长度不足n的情况
 这是要判断 节点不足n个的情况 如[1,2,3] 3
 当小于n个节点时程序舒展不开
 当大于n就没问题了

 //1 和 //3 都是基于这的判断  没必要了
==============================================================
 ohhhhhhhhhhhhhhhhhh
 前言
在对链表进行操作时，一种常用的技巧是添加一个哑节点（dummy node），它的 \textit{next}next 指针指向链表的头节点。
这样一来，我们就不需要对头节点进行特殊的判断了。
例如，在本题中，如果我们要删除节点 yy，我们需要知道节点 yy 的前驱节点 xx，并将 xx 的指针指向 yy 的后继节点。
但由于头节点不存在前驱节点，因此我们需要在删除头节点时进行特殊判断。
但如果我们添加了哑节点，那么头节点的前驱节点就是哑节点本身，此时我们就只需要考虑通用的情况即可。

看，下面的节点就有构造方法
ListNode(int val, ListNode next)
可以  ListNode dummy = new ListNode(0, head);

就用双指针法
===================================================================
还有天秀的递归法:
class Time {
    int cur = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;                //步入虚无后返回
        head.next = removeNthFromEnd(head.next, n);   //一直沉直到底部
        return ++cur == n ? head.next : head;         //从倒数第一就开始计数 返回的是 head 直到倒数第n个 返回的是 head.next
    }
}

作者：downupzi
链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/di-gui-yyds-by-downupzi-t2ho/

 */

package 刷题.leetcode.T19删除链表的倒数第N个结点;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        removeNthFromEnd(head,2);
    }
    static ListNode removeNthFromEnd(ListNode head, int n) {
        // if(head.next==null) return null;    //1
        ListNode listNode =head;
        ListNode temp=head;
        while (n!=0&&temp.next!=null)            //2
        {
            n--;
            temp=temp.next;
        }
        if(n!=0) return head.next;                 //2
        while (temp.next!=null)
        {
            temp=temp.next;
            listNode=listNode.next;
        }
       // listNode.next=(listNode.next.next==null)?null:listNode.next.next;  //3
        listNode.next=listNode.next.next;
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