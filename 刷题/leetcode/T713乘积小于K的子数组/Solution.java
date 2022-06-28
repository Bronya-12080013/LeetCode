package 刷题.leetcode.T713乘积小于K的子数组;

/*
数学不懂啦
https://leetcode-cn.com/problems/subarray-product-less-than-k/solution/cheng-ji-xiao-yu-k-de-zi-shu-zu-by-leetc-92wl/
 */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;
    }
}
