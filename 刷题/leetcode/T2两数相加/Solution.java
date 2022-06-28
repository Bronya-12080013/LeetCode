/*
暴力过了 45.33% && 5.22%  //非常稳定
//用Integer 32/1568   用Long 1565/1568
//求助BigInteger类 成了
注意BigInteger是用add()来两数相加的
sb.append(可以放BigInteger)
记得在力扣中用的话 要导入import java.math.BigInteger;

注意：leetcode永远会存在输入为空的情况，这也是我没有考虑到的
===============================
现在是 2022/1/25 2:36 明天再试试字符运算 不依靠函数 模拟运算
淦 这链表故意倒过来就是为了让我模拟运算的啊
 */

package 刷题.leetcode.T2两数相加;

import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuffer sb1 = new StringBuffer();
        while (l1!=null) {
            sb1.append(l1.val);
            l1=l1.next;
        }
        sb1.reverse();
        StringBuffer sb2 = new StringBuffer();
        while (l2!=null){
            sb2.append(l2.val);
            l2=l2.next;
        }
        sb2.reverse();
        StringBuffer sb = new StringBuffer();
        //用Integer 32/1568   用Long 1565/1568
        //sb.append(Long.valueOf(sb1.toString())+Long.valueOf(sb2.toString())).reverse();

        //求助BigInteger 成了
        BigInteger bigInteger1 = new BigInteger(sb1.toString());
        BigInteger bigInteger2 = new BigInteger(sb2.toString());
        sb.append(bigInteger1.add(bigInteger2)).reverse();
        char[] chars = sb.toString().toCharArray();
        ListNode listNode = new ListNode(0);
        ListNode l = listNode;
        for(int i =0;i<chars.length;i++){
            ListNode node = new ListNode(Integer.valueOf(String.valueOf(chars[i])));
            l.next=node;
            l=l.next;
        }
        return listNode.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }