/*
经过答案思路点播 写出来了    100.00% && 51.48%
dp题有了思路就非常容易写 多理解理解
===================================
不用设max dp就是累计的 不然这么是dp 直接return dp[length - 1];
class TopVotedCandidate {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];   //ohhh
    }
}

 */


package 刷题.leetcode.T198打家劫舍;

public class Solution {
    public static void main(String[] args) {
        int[] nums=new int[]{2,1,1,2};
        System.out.println(rob(nums));
    }
    static int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length];
        int max=0;
        for(int i =0;i<nums.length;i++)
        {
            if(i==0) dp[i]=nums[0];
            else if(i==1) dp[i]=Math.max(nums[0],nums[1]);
            else dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
            max=Math.max(max,dp[i]);
        }
        return max;  //不必设max 直接 return dp[dp.length-1];
    }
}
