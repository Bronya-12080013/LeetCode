package 刷题.leetcode.T357统计各位数字都不同的数字个数;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
    排列组会，简单的排列组会而已
    与之前的dp题不同
    不同位数的结果不需要考虑影响(不必用m-1位的去考虑m位的)
    只是题目要[0,Math.pow(m))的把m位的，m-1位的..0位的加起来即可
//V2
class Solution {
    Set<Integer> set = new HashSet<>();
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        if(n==1) return 10;
        int sum=10,pl = 9;
        for(int i=0;i<n-1;i++)
        {
            pl=pl*(9-i);
            sum+=pl;
        }
        return sum;
    }
}

/* V1 超时 最后执行的输入：8
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int sum = 0;
        for(int i=0;i<Math.pow(10,n);i++)
        {
            if(unique(i)) sum++;
        }
        return sum;
    }
    boolean unique(int num)
    {
        Set<Integer> set = new HashSet<>();
        while(num!=0)
        {
            if(!set.add(num%10)) return false;
            num/=10;
        }
        return true;
    }
}
 */