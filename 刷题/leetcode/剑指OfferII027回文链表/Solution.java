package 刷题.leetcode.剑指OfferII027回文链表;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*  罢了罢了沉死了  中间有两个相同或只有一个在中间的都是回文 继续丢进数组
class Solution {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next=new ListNode(2);
        isPalindrome(node);
    }
    static boolean isPalindrome(ListNode head) {
        if(head.next==null) return true;
        Deque<Integer> deque  = new ArrayDeque<>();
        boolean flag =true;
        while (head!=null)
        {
            if(flag&&(deque.isEmpty()||head.val!=deque.peek())) deque.push(head.val);
            else flag=false;
            if(!flag){
                if(head.val!=deque.poll()) return false;
            }
            head=head.next;
        }
        if(deque.isEmpty()) return true;
        else return false;
    }
}
 */

class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
