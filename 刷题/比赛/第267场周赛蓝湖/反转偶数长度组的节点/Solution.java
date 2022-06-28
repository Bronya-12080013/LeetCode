/*
不行了
==========================================================
题目说返回head
不知道可不可以遍历这个链表，搞出别的链表
算了，不写了
==========================================================
放某位大佬的代码：
class RangeFreqQuery {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ArrayList <Integer> list = new ArrayList();
        ListNode cur = head;
        while(cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int n = list.size();
        for(int i = 0; i * (i - 1) / 2 <= n; i ++) {
            int start = (i - 1) * i / 2, end = Math.min(n - 1, i * (i + 1) / 2 - 1);
            if((end - start) % 2 == 0) continue;
            while(start < end) {
                int tmp = list.get(start);
                list.set(start++, list.get(end));
                list.set(end--, tmp);
            }
        }
        ListNode fake = new ListNode(-1), cur2 = fake;
        for(int i = 0; i < n; i++) {
            cur2.next = new ListNode(list.get(i));
            cur2 = cur2.next;
        }
        return fake.next;
    }
}
 */


package 刷题.比赛.第267场周赛蓝湖.反转偶数长度组的节点;

public class Solution {
    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        ListNode p= node;
        p.next=new ListNode(2);
        p=p.next;
        p.next=new ListNode(6);
        p=p.next;
        p.next=new ListNode(3);
        p=p.next;
        p.next=new ListNode(9);
        p=p.next;
        p.next=new ListNode(1);
        p=p.next;
        p.next=new ListNode(7);
        p=p.next;
        p.next=new ListNode(3);
        p=p.next;
        p.next=new ListNode(8);
        p=p.next;
        p.next=new ListNode(4);
        ListNode res =reverseEvenLengthGroups(node);
    }
        static ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode pre=head;
        ListNode tie=head;
        int sum=0;
        while (tie!=null){
            sum++;
            if(sum%2!=0) {
                for(int i=0;i<sum;i++){
                    pre=pre.next;
                    tie=tie.next;
                }
            }else {
                ListNode node= new ListNode(0);
                ListNode newone =node;
                for(int i=0;i<sum-1;i++){
                    if(tie!=null){
                        ListNode n =new ListNode(tie.val);
                        newone.next=n;
                        newone=newone.next;
                        tie=tie.next;
                    }
                pre.next=reverseList(node);
                }
            }
        }
        return head;
    }
   static ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while(cur != null) {
            ListNode tmp = cur.next; // 暂存后继节点 cur.next
            cur.next = pre;          // 修改 next 引用指向
            pre = cur;               // pre 暂存 cur
            cur = tmp;               // cur 访问下一节点
        }
        return pre;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }