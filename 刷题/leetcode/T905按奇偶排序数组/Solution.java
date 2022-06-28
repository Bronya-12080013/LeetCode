package 刷题.leetcode.T905按奇偶排序数组;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int l = 0,r=nums.length-1;
        while (l<r)
        {
            while (l<r&&nums[l]%2==0) l++;
            while (l<r&&nums[r]%2!=0) r--;
            swap(l,r,nums);
        }
        return nums;
    }
    static void swap(int i,int j ,int[] nums){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}