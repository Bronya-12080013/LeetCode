/*
凭着我的聪明才智终于过了  12.10% && 12.62%
要注意，本题的要求是不可修改 那么节点必须用原本地址的
所以在取出时 先创造一个替身（指针） 然后把它的next废掉，再保持起来
一定要废掉next哦
=============================================================
官方答案一 线性表:放入一个数组 是我的答案升级版
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}
=================================================================
官方答案二: 寻找链表中点 + 链表逆序 + 合并链表
强啊 三个知识点合一
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}

 */

package 刷题.leetcode.剑指OfferII026重排链表;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        reorderList(node);
    }
    static void reorderList(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        Deque<ListNode> deque = new ArrayDeque<>();
        int count = 0;
        while (head!=null)
        {
            ListNode temp = head;    //搞出个临时的
            head=head.next;
            temp.next=null;         //废掉next后再放入 不然会造成循环
            deque.add(temp);
            stack.push(temp);
            count++;
        }
        ListNode node = new ListNode(0);
        ListNode l = node;
        for(int i =0;i<count;i++)
        {
            if(i%2==0) {                //注意 下标是从零开始的
                l.next=deque.poll();
                l=l.next;
            }else {
                l.next=stack.pop();
                l=l.next;
            }
        }
        head=node.next;
        return ;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}