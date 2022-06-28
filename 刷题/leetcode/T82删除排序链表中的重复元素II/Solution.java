/*
好惹 写出来了
=======================================
官方答案 比我还少用了个指针
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;                         //注意这个 是改指向 没有跳过去 这个cur = cur.next;才是跳过去
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
 */

package 刷题.leetcode.T82删除排序链表中的重复元素II;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        head.next.next = new ListNode(2);
        solution.deleteDuplicates(head);
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;

        /* 2       原本是应对[1,1]用例的 但有卡在了[1,2,2] 后来下面加了‘1’解决了  这块不需要了
        if(head.next!=null) {
            if (head.val == head.next.val) {
                ListNode l = head;
                int n = head.val;
                while (l.val == n) {
                    l = l.next;
                    if (l == null) return null;
                }
            }
        }
         */



        ListNode node = new ListNode(0);
        node.next=head;
        ListNode end = head;
        head=node;
        while (head!=null)
        {
            if(end.next!=null) {
                if (end.val == end.next.val) {
                    int n = end.val;
                    while (end.val == n) {
                        end = end.next;
                        if (end == null) break;  //不能用&&放到上面的while中 &&它是同时判断的 如果end==null了 再end.val会报错
                    }
                    head.next = end;
                } else {
                    head.next = end;
                    head = head.next;
                    end = end.next;
                }
                if(end==null) break;   //1
            }else break;
        }
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

  /*
  代码简化版:
  class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode node = new ListNode(0,head);
        ListNode end = head;
        head=node;
        while (head!=null&&end.next!=null)
        {
                if (end.val == end.next.val) {
                    int n = end.val;
                    while (end.val == n) {
                        end = end.next;
                        if (end == null) break;
                    }
                    head.next = end;
                } else {
                    head.next = end;
                    head = head.next;
                    end = end.next;
                }
                if(end==null) break;
        }
        return node.next;
    }
}
   */