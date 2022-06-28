/*
不行了
现在的问题是超出时间限制  最后输入是 1.00000 2147483647
没有卡在n含有小数的案例？？不知道要不要考虑含小数
有个方法应该可以解决超时  不用x*=X 而用x*=x（成倍计算）  n则减去2的几次方
但要算处2的几次方也很麻烦
=============================================
又改了改
试图用int[] array=new int[31];来实现x成组地*
不知道错那了 算了
看答案
============================================
(好像确实没有n含小数的) 当然了 虽然题目没写，但有public double myPow(double x, int n)啊，有int n,       //我又回来了，发现但凡我看一眼题目...

"快速幂法"
作者：jyd
链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
大佬把答案都放在这了，尽情去找吧


见下面代码:
 */

/* 我的失败代码：
package 刷题.leetcode.剑指Offer16数值的整数次方;

import java.util.ArrayList;
import java.util.Date;

public class RangeFreqQuery {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        int[] array=new int[31];
        array[0]=1;
        int X=1;
        for(int i=1;i<=31;i++)
        {
            X=X*2;
            array[i]=X;
        }
        if(n>=1)
        {
            Double Y=x;
            int j=0;
            for(int i=1;array[i]>n;i++)
            {
                x*=x;
                j=i;
            }
            for(int i =0;i<n-array[j];i++){
                x*=X;
            }
        }
        else if (n<=-1)
        {       Double Y=x;
                int j=0;
                for(int i=1;array[i]>n;i++)
                {
                    x*=x;
                    j=i;
                }
                for(int i =0;i<n-array[j];i++){
                    x*=X;
                }
            x=1/x;
        }
        return x;
    }
}

 */

//快速幂法
package 刷题.leetcode.剑指Offer16数值的整数次方;

public class Solution {
    public double myPow(double x, int n) {
        if(x==0) return 0;
        long b =n;
        if(b<0){
            x=1/x;
            b=-b;
        }
        double res=1.0;
        while (b!=0){
            if((b&1)==1) res*=x;
            x*=x;
            b>>=1;
        }
        return res;
    }
}

