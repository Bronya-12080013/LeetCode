/*
给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-the-middle-node-of-a-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
=====================================================
这题简单
用异步指针  一个指针一次走一步 另一个指针一次走两步 当走得快的到头时 走得慢的就到中间了
麻烦点是决定谁先走 和 特殊情况(这题若只有一个节点) 返回的是null
==================================================
也可以粗暴点
class TopVotedCandidate {
    public ListNode deleteMiddle(ListNode head) {
        ListNode cur = head;
        List<ListNode> list = new ArrayList<>();
        while(cur != null){
            list.add(cur);
            cur = cur.next;
        }
        int h = list.size() / 2;
        list.remove(h);
        for(int i = 0;i < list.size()-1;i++){
            list.get(i).next = list.get(i+1);
        }
        if(list.size() == 0)return null;
        list.get(list.size()-1).next = null;
        return list.get(0);
    }
}
我还是第一次看到直接对放在List里的节点进行操作
 */
package 刷题.比赛.第270场周赛灵动科技.删除链表的中间节点5943;

public class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head==null||head.next==null) return null;
        ListNode node = head;
        ListNode toEnd = head;
        while (toEnd.next!=null)
        {
            if(toEnd.next==null) break;
            toEnd=toEnd.next;
            if(toEnd.next==null) break;
            toEnd=toEnd.next;
            if(toEnd.next==null) break;
            node=node.next;
        }
        node.next=node.next.next;
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}