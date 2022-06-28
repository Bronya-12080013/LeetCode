/*
入门级别的dp  100.00% && 56.54%
 */

package 刷题.leetcode.T70爬楼梯;

public class Solution {
    public int climbStairs(int n) {
        int[] item = new int[n];
        item[0]=1;
        if(n>1) item[1]=2;
        for(int i =2;i<n;i++)
        {
            item[i]=item[i-1]+item[i-2];
        }
        return item[n-1];
    }
}
