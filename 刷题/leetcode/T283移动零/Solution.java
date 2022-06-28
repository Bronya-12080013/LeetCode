/*
过了，要万万小心
1.我把好几处的i--或j-- 写成了++
2.要小心越界情况，有部分是上面那些++造成的
部分是j--过界 while (j!=0)并不够 ，但凡有j--的都要判别 如下面的

                if(j==0) return;

            while (nums[j]!=0&&j>0) j--;
            if(j==0&&nums[j]!=0) return;

            等
===============================================
做到了在原数组上操作，不能拷贝额外的数组。
但只有    6.46% && 22.88%
=============================================
官方答案: 但只有 44.66% && 42.71%

class Time {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

 */
package 刷题.leetcode.T283移动零;

public class Solution {
    public static void main(String[] args) {
        //int[] nums = new int[]{0,1,0,3,12};
        int[] nums = new int[]{0,0};
        moveZeroes(nums);
    }
    static void moveZeroes(int[] nums) {
        int i=nums.length-1,j=nums.length-1;
        while (j!=0)      //又又又又有写了结束条件
        {
            while (nums[i]==0&&nums[j]==0)
            {
                i--;
                j--;
                if(j==0) return;
            }
            while (nums[j]!=0&&j>0) j--;
            if(j==0&&nums[j]!=0) return;
            doit(nums,i,j);
            i--;
        }
    }
    static void doit(int[] nums,int i,int j){
        for(int k=j;k<i;k++)
        {
            nums[k]=nums[k+1];
        }
        nums[i]=0;
    }
}