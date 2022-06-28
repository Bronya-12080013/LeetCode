package 刷题.leetcode.T83删除排序链表中的重复元素;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 100% && 43.01%
// 懒得对原链表修改了 直接新搞一个
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode node = new ListNode();
        ListNode temp = node;
        while (head!=null)
        {
            if(set.add(head.val)) {
                temp.next = new ListNode(head.val);
                temp=temp.next;
            }
            head=head.next;
        }
        return node.next;
    }
}
/*
官方答案
我还以为要用两个指针 没想到一个就够了
但好像效率没我高
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-list/solution/shan-chu-pai-xu-lian-biao-zhong-de-zhong-49v5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }