/*
第一道困难题  动态规划
我就模仿（CV）答案了
主要思路是慢慢蠕动 然后把遇到的最好值和对应的下标都记下
（第一组只用记最好的值对应的下标 第二组要记第一组和第二种 第三组要记下第一组、第二种和第三组的下标）
 */
package 刷题.leetcode.T689三个无重叠子数组的最大和;

public class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = new int[3];  //这里是要返回的最终结果 也就相当在sum3那行对应的maxSum123Idx1=0,maxSum123Idx2=0,maxSum123Idx3=0;
        int sum1=0,maxSum1=0,maxSum1Idx=0;      //maxsum1是第一组的和（且是历来最大的）
        int sum2=0,maxSum12=0,maxSum12Idx1=0,maxSum12Idx2=0;   //maxSum12=0是第一组和第二组的和（且是历来最大的）
        int sum3=0,maxSumTotal=0;    //maxSum123Idx1=0,maxSum123Idx2=0,maxSum123Idx3=0;  //maxSumTotal是第一组和第二组和第三组的和（且是历来最大的）
        for(int i  = 2*k;i<nums.length;i++)
        {
            sum1+=nums[i-2*k];
            sum2+=nums[i-k];
            sum3+=nums[i];
            if(i>=3*k-1)
            {
                if(sum1>maxSum1)
                {
                    maxSum1=sum1;
                    maxSum1Idx=i - k * 3 + 1;
                }
                if(maxSum1+sum2>maxSum12)
                {
                    maxSum12=maxSum1+sum2;
                    maxSum12Idx1=maxSum1Idx;
                    maxSum12Idx2=i - k * 2 + 1;
                }
                if(maxSum12+sum3>maxSumTotal)
                {
                    maxSumTotal=maxSum12+sum3;
                    ans[0]=maxSum12Idx1;
                    ans[1]=maxSum12Idx2;
                    ans[2]=i - k + 1;
                }
                sum1-=nums[i-k*3+1];
                sum2-=nums[i-k*2+1];
                sum3-=nums[i-k+1];
            }
        }
        return ans;
    }
}

