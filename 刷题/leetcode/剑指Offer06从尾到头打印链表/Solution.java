/*
初版，测试代码过了，提交没过
stack.push(head.val); 这出错了
异常： java.lang.NullPointerException
我看官方答案是在stack里放节点，而不是放节点的值

此外，我尝试用流，但失败了

=============================================================
！！！！
破案了
并不是stack放 节点 还是 节点的值 的问题

关键是（以初级版为例）：

这样行： while (head!=null)
       {
           stack.push(head.val);
            head=head.next;
      }


这样不行：  stack.push(head.val);                                        ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
       while (head.next!=null)
       {
           head=head.next;
           stack.push(head.val);
       }
这样会有异常：java.lang.NullPointerException       （可能是因为head有null的情况，所以leetcode直接给我报错了？j）                            ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
=====================================================================================
重写了初级改良版，行了
==================================================================================
其实 我一开始就是这么写while的，主要是在找一个坑时改掉了

注意！！！！！！！！！！！！！！！！！！
要写
int n=stack.size();
for(int i=0;i<n;i++)
而不是
for(int i=0;i<stack.size();i++)
因为在for里面有stack.pop(),所以stack.size()会变的！！！！！！！！

==============================================================================


package 刷题.leetcode.剑指Offer06从尾到头打印链表;

import java.sql.Struct;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

class RangeFreqQuery {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        stack.push(head.val);
       while (head.next!=null)
       {
           head=head.next;
           stack.push(head.val);
       }
        int[] contraryList=new int[stack.size()];
        int n=stack.size();
        for(int i=0;i<n;i++)
        {
            contraryList[i]=stack.pop();
        }
        //Arrays.stream(contraryList).forEach(e->e=stack.pop());                      //尝试用流，但失败了
        //Stream.of(contraryList).forEach(e->e.equals(stack.pop()));
        //Arrays.stream(contraryList).forEach(e->e=Integer.valueOf(stack.pop()));
        return contraryList;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


 */


//升级版：


package 刷题.leetcode.剑指Offer06从尾到头打印链表;

import java.sql.Struct;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack=new Stack<>();
        while (head!=null)
        {
            stack.push(head);
            head=head.next;
        }
        int[] contraryList=new int[stack.size()];
        int n=stack.size();
        for(int i=0;i<n;i++)
        {
            contraryList[i]=stack.pop().val;
        }
        return contraryList;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


/*
初级改良版：

package 刷题.leetcode.剑指Offer06从尾到头打印链表;

import java.sql.Struct;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

class RangeFreqQuery {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack=new Stack<>();
       while (head!=null)
       {

           stack.push(head.val);
       head=head.next;
       }
        int[] contraryList=new int[stack.size()];
        int n=stack.size();
        for(int i=0;i<n;i++)
        {
            contraryList[i]=stack.pop();
        }
        //Arrays.stream(contraryList).forEach(e->e=stack.pop());                      //尝试用流，但失败了
        //Stream.of(contraryList).forEach(e->e.equals(stack.pop()));
        //Arrays.stream(contraryList).forEach(e->e=Integer.valueOf(stack.pop()));
        return contraryList;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 */