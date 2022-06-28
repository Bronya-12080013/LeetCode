package 刷题.leetcode.剑指Offer10斐波那契数列其一;
/*
简单，记得从下到上
（从上到下效率低，因为重复多）
注意：从下到上不是用递归，用循环
 */
class Solution {
    public int fib(int n) {
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        int one=1;
        int two=0;
        int newone=0;
        for(int i=2;i<=n;i++)
        {
            newone=(one+two)%1000000007;
            two=one;
            one=newone;
        }
        return newone;
    }
}