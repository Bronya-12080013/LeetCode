package 刷题.leetcode.T462最少移动次数使数组元素相等II;

import java.util.Arrays;

//都回到中间就好
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res = 0,mid=nums[nums.length/2];
        for(int i=0;i<nums.length;i++) res+=Math.abs(mid-nums[i]);
        return res;
    }
}