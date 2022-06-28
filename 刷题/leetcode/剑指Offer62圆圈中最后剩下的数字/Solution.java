/*
wuwuwuwuwuwuwuw超时了两次
一次用队列，一次用树
======================================
这次我试试直接遍历
======================================
唔？额，嗯？啊！（绝望四回头）
绝望了，对不管用多少方法都超时的我绝望了!
遍历也超时了
========================================
实际上，本题是著名的 “约瑟夫环” 问题，可使用 动态规划 解决
数学，递归,动态规划,脑筋急转弯
class RangeFreqQuery {
    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
作者：jyd
链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/jian-zhi-offer-62-yuan-quan-zhong-zui-ho-dcow/

============================================
好难
 */


/*
不行，超时了
package 刷题.leetcode.剑指Offer62圆圈中最后剩下的数字;

import java.util.ArrayDeque;
import java.util.Deque;

public class RangeFreqQuery {
    public static void main(String[] args) {
        int n = lastRemaining(5,3);
    }
    static int lastRemaining(int n, int m) {
        Deque deque =new ArrayDeque();

        for(int i=0;i<n;i++)
        {
            deque.add(i);
        }
        int nums=0;
        while (deque.size()!=1)
        {
            nums++;
            if(nums%m==0)
            {
                deque.poll();
            }
            else deque.addLast(deque.poll());

        }
        return (int)deque.getFirst();
    }
}
 */


/*
又又又超时了

package 刷题.leetcode.剑指Offer62圆圈中最后剩下的数字;

import javax.xml.soap.Node;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class RangeFreqQuery {
    public static void main(String[] args) {
        int n = lastRemaining(5,1);
        System.out.println(n);
    }
    static int lastRemaining(int n, int m) {
        TreeNode node = new TreeNode(0);
        TreeNode temp = node;
        int all=1;
        for(int i=1;i<n;i++)
        {
           temp.next = new TreeNode(i);
           all++;
           temp=temp.next;
        }
        temp.next=node;
        int nums=1;
        while (all!=1){
            if((nums)%m==0)
            {
                node=node.next;
                temp.next=node;
                nums=0;
                all--;
            }else
            {
                temp= temp.next;
                node=node.next;
            }
            nums++;
        }
        return node.val;
    }
}

class TreeNode {
    int val;
    TreeNode next;
    TreeNode(int x) { val = x; }
}
 */


//直接遍历，又超时了
package 刷题.leetcode.剑指Offer62圆圈中最后剩下的数字;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int n = lastRemaining(5,3);
    }
    static int lastRemaining(int n, int m) {
        Set set = new HashSet();
        int nums=0;
        int i=0;
       for(;i<n;i++)
       {
           nums++;
           while (set.contains(i))
           {
               if(i+1==n) i=0;
               else i++;
           }
           if(nums%m==0)
               set.add(i);
           if(i+1==n&&set.size()!=n-1) i=-1;
           if(set.size()==n-1) break;
       }
       while (set.contains(i))
       {    if(i+1==n) i=0;
           else i++;

       }
       return i;
    }
}