/*过了，但效率不稳定，  100% && 22.34%  or  41.30% && 46.09%
应该不是最优解法
=======================================================
官方解法:
class Time {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }
}

思路和我一模一样啊
是不是Math.abs()和Math.pow()不给力啊

 */
package 刷题.leetcode.T977有序数组的平方;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int left=0,right=nums.length-1;
        int[] numsNew=new int[nums.length];
        int count=numsNew.length-1;
        while (left<=right){
            if(Math.abs(nums[left])>=Math.abs(nums[right]))
            {
                numsNew[count--]= (int) Math.pow(nums[left],2);
                left++;
            }else {
                numsNew[count--]= (int) Math.pow(nums[right],2);
                right--;
            }
        }
        return numsNew;
    }
}
