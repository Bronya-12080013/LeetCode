/*
关键是思路!!!  动态规划的环问题
环状排列意味着第一个房子和最后一个房子中只能选择一个偷窃，
因此可以把此环状排列房间问题约化为两个单排排列房间子问题
把[0,n-1] 断成 [0,n-2]与[1,n-1] 分别动态规划再取大的就行
========================================================
大佬代码: 这动态规划妙啊
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                        myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur); //类比Math.max(dp[i-2]+nums[i],dp[i-1]);  cur是最大值,max里面的cur也就是dp[i-1]!!!  pre是dp[i-2]

            pre = tmp;                      //pre取了没变前的cur也就是这轮的dp[i-1] 在下一轮就变成了dp[i-2]
        }
        return cur;         //cur就是目前最右边的dp值 即是最大值
    }
}
 */

/* 初版
package 刷题.leetcode.T213打家劫舍II;
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int[] numsMove1 = new int[nums.length-1];
        int[] numsMove2 = new int[nums.length-1];
        for(int i =0;i<nums.length;i++){
            if(i< nums.length-1) numsMove1[i]=nums[i];
            if(i>0) numsMove2[i-1]=nums[i];
        }
        return Math.max(r(numsMove1),r(numsMove2));
    }
    static int r(int[] nums) {
        int[] dp = new int[nums.length];
        int max=0;
        for(int i =0;i<nums.length;i++)
        {
            if(i==0) dp[i]=nums[0];
            else if(i==1) dp[i]=Math.max(nums[0],nums[1]);
            else dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
            max=Math.max(max,dp[i]);
        }
        return dp[dp.length-1];
    }
}
 */

//修改版 就是j和i的关系有点麻烦 100.00% && 61.09%
package 刷题.leetcode.T213打家劫舍II;
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{1,2,3,1}));
    }
    public int rob(int[] nums) {
            if(nums.length==0) return 0;
            if(nums.length==1) return nums[0];
            if(nums.length==2) return Math.max(nums[0],nums[1]);
            int[] dp1 = new int[nums.length-1];
            int[] dp2 = new int[nums.length-1];
            int max1=0,max2=0;
            for(int i =0;i<nums.length;i++)
            {
                if(i< nums.length-1) {
                    if (i == 0) dp1[i] = nums[0];
                    else if (i == 1) dp1[i] = Math.max(nums[0], nums[1]);
                    else dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
                    max1 = Math.max(max1, dp1[i]);
                }
                if(i>0){
                    int j =i-1;
                    if (j == 0) dp2[j] = nums[1];
                    else if (j == 1) dp2[j] = Math.max(nums[1], nums[2]);
                    else dp2[j] = Math.max(dp2[j - 2] + nums[i], dp2[j - 1]); //注意这里是nums[i]
                    max2 = Math.max(max2, dp2[j]);
                }
            }
            return Math.max(max1,max2);
        }
    }