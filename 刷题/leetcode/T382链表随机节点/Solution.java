/*
注意 本题是概率题 测试结果和示例不一样很正常
==========================================
好过了 简单
注意
1.方法Math.random()取[0,1)
2. // int rand = (int)Math.random()*arrayList.size();  不行 这样(int) 只强转前面那个
      要  int rand = (int)(Math.random()*arrayList.size());
===========================================================================
水塘抽样算法:
   从链表头开始，遍历整个链表，对遍历到的第 i 个节点，随机选择区间 [0,i)内的一个整数，如果其等于0，则将答案置为该节点值，否则答案不变。
   该算法会保证每个节点的值成为最后被返回的值的概率均为 1/n

   官方答案:
   注意:  Random random = new Random();
   class Solution {
    ListNode head;
    Random random;

    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int i = 1, ans = 0;
        for (ListNode node = head; node != null; node = node.next) {
            if (random.nextInt(i) == 0) { // 1/i 的概率选中（替换为答案）
                ans = node.val;
            }
            ++i;
        }
        return ans;
    }
}

 */

package 刷题.leetcode.T382链表随机节点;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Solution {
    ArrayList<Integer> arrayList = new ArrayList();
    public Solution(ListNode head) {
        while (head!=null) {   //又写成结束条件了
            arrayList.add(head.val);
            head=head.next;
        }
    }
    public int getRandom() {
        if(arrayList.size()==0) return -1;
        // int rand = (int)Math.random()*arrayList.size();  不行 这样(int) 只强转前面那个
        int rand = (int)(Math.random()*arrayList.size());
        return arrayList.get(rand);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}