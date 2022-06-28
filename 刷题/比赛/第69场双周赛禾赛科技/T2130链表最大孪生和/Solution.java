/*
我用的粗暴遍历 过了
==========================================
官方思路: 快满指针 + 反转链表
我们首先使用快满指针找出后一半部分的起始节点。
具体地，我们用慢指针slow 指向 head，快指针fast 指向head的下一个节点。
随后，我们每次将slow 向后移动一个节点，同时fast 向后移动两个节点。
当 fast 到达链表的最后一个节点（即下一个节点是空节点）时：
slow 刚好指向链表前一半部分的末尾节点；
slow 的下一个节点即为链表后一半部分的起始节点。
随后，我们需要将链表的后一半部分进行反转。如果读者不知道如何实现这一步，可以参考「206. 反转链表」的官方题解。
当链表的后一半部分被反转后，原先我们需要求出的是第 ii 个节点和第 n-1-in−1−i 的节点的和，
此时就变成了求出第 ii 个节点和第 i+n/2i+n/2 个节点的和。
这样一来，我们就可以使用两个指针分别从「链表前一半部分的起始节点」和「链表后一半部分的起始节点」开始遍历。
在遍历的过程中，我们计算两个指针指向节点的元素之和，并维护最大值即可。
代码:
class Solution {
    public int pairSum(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode oddListNode = slow.next;
        slow.next = null;

        ListNode cur = oddListNode;
        ListNode prev = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        int res = 0;

        while(head != null){
            res = Math.max(prev.val+head.val,res);
            head = head.next;
            prev = prev.next;
        }
        return res;

    }
}

===============================================
妙啊
好好看看  i 与 (n-1-i)  不觉得它们很对称吗
 */
package 刷题.比赛.第69场双周赛禾赛科技.T2130链表最大孪生和;

import java.util.ArrayList;

class Solution {
    public int pairSum(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList();
        while (head!=null) {
            arrayList.add(head.val);
            head=head.next;
        }
        int max = 0,n=arrayList.size();
        for(int i =0;i<arrayList.size();i++)
        {
            if(i>n/2-1) break;
            int index = n-1-i;
            int val = arrayList.get(i)+arrayList.get(index);
            max=Math.max(max,val);
        }
        return max;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
