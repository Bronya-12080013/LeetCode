/*
初写杀（我被杀了）
=========================
静下心看了下答案 很容易
看来太久不写了脑子都秀逗了
连先建个空节点都忘了 这个可以解决很多问题的
空点啊空点
如果在写题时发生了空指针异常 编程生涯就结束了吧
对了,那就就建立很强的空节点掩盖过去吧
listnode~listnode~listnode~listnode~listnode~
==============================================
我开始是把前指针放在要删的位置了 应该是放在前一个位置
前指针距离后指针n+1位 当后指针==null 前指针就在要删除节点的前一个节点

当然 前指针距离后指针n位也行 我的第一想法是的 当后指针到头 也就是 后指针.next==null 时 前指针就在要删除节点的前一个节点

写成
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0,head);
        ListNode cur = node;
        while (--n!=0) head=head.next;   //修改1
        //直接移动 等出来在删 不急着在里面删
        while (head.next!=null)          //修改2
        {
            head=head.next;
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return node.next;
    }
}
==========================================
也可以用栈 保险点
 */


package 刷题.leetcode.剑指OfferII021删除链表的倒数第n个结点;
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0,head);
        ListNode cur = node;
        while (n--!=0) head=head.next;
        //直接移动 等出来在删 不急着在里面删
        while (head!=null)
        {
            head=head.next;
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return node.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*  失败了 太丑太粗糙
package 刷题.leetcode.剑指OfferII021删除链表的倒数第n个结点;

class Solution {
    public static void main(String[] args) {
     //       ListNode head = new ListNode(1);
     //      head.next=new ListNode(2);
     //  head.next.next=new ListNode(3);
     //  head.next.next.next=new ListNode(4);
     //  head.next.next.next.next=new ListNode(5);
        ListNode head = new ListNode(1);
        removeNthFromEnd(head,2);
    }
    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        ListNode pre = head;
        while (--n!=0) node=node.next;
        if(node==head&&head.next==null) return new ListNode().next;
        while (true)
        {
            node=node.next;
            if(node.next==null)
            {
                pre.next=pre.next.next;
                break;
            }
            pre=pre.next;
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
 */
