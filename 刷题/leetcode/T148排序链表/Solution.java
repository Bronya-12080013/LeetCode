package 刷题.leetcode.T148排序链表;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
强烈推荐看官方答案
！！！ 自顶向下归并排序 ！！！
https://leetcode.cn/problems/sort-list/solution/pai-xu-lian-biao-by-leetcode-solution/
 */

//优先队列方法 不用想就知道效率不行
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        while (head!=null) {
            pq.add(head);
            head=head.next;
        }
        ListNode root = pq.poll();
        ListNode temp = root;
        while (!pq.isEmpty())
        {
            temp.next=pq.poll();
            temp=temp.next;
        }
        temp.next=null; //记得给恰了
        return root;
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
  官方答案
  自顶向下归并排序！！！

  mid总是偏向右边 在sortList(head, mid);时
  会有
    if (head.next == tail) {
            head.next = null;
            return head;
        }
  从而恰掉右边
  脑内模拟一下会发现 传入的head和mid不会指向一个节点的（ mid总是偏向右边） 所以不必担心这种情况会卡住
  这答案非常巧妙！

  class Solution {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/sort-list/solution/pai-xu-lian-biao-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */