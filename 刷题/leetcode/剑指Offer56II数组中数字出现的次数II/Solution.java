/*
呜呜，继续看大佬讲解
========================================
首先，本题没时空要求，可以用hashmap摆烂
=============================================
把1位推到了32位的部分似懂非懂的
 */

//模仿
package 刷题.leetcode.剑指Offer56II数组中数字出现的次数II;

public class Solution {
    public int singleNumber(int[] nums){
        int ones=0,twos=0;
        for(int num:nums){
            ones=ones^num & ~twos;
            twos=twos^num & ~ones;
        }
        return ones;
    }
}
