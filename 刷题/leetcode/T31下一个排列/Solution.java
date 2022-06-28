/*
https://leetcode-cn.com/problems/next-permutation/
关键是思路 代码不难
注意到下一个排列总是比当前排列要大，除非该排列已经是最大的排列。
我们希望找到一种方法，能够找到一个大于当前序列的新序列，且变大的幅度尽可能小。
我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。

总结： 从右往左 找第一个不参与递增的i(指下标) 再从右往左 找找到了最小的一个比i大的j 互换(下标i还是i j还是j) 再把右边的全都 升序排序
 */

package 刷题.leetcode.T31下一个排列;

class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while (i>=0&&nums[i]>=nums[i+1]) i--;
        if(i>=0){
            int j =nums.length-1;
            while (j>=0&&nums[i]>=nums[j]) j--;
            swap(nums,i,j);
        }
        /*
        前面 while (i>=0&&nums[i]>=nums[i+1]) i--;  后
        i后面的数 从右到左 是递增的
        又 while (j>=0&&nums[i]>=nums[j]) j--; 在这之中找到了最小的一个比i大的
        把swap(nums,i,j); 后 这组数依然是有序的！ 是倒叙的 （从左到右减小）
        按照升序重新排列 只要对称swap即可 见 reverse的实现
        ================
        若i<0了 这就是最大的了 直接执行 reverse(nums,i+1); 它就会变成最小的
         */
        reverse(nums,i+1);
    }
    public void swap(int[] nums,int i,int j)
    {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(int[] nums,int start)
    {
        int left =start,right = nums.length-1;
        while (left<right)
        {
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}