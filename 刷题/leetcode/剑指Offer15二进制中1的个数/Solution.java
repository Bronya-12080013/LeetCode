package 刷题.leetcode.剑指Offer15二进制中1的个数;

public class Solution {
    public int hammingWeight(int n) {
     //   Integer.toBinaryString(n);
        int sum=0;
       while (n!=0){
           if((n&1)!=0) sum++;
           n>>>=1;
       }
       return sum;
    }
}
