/*
        本题可以用简单粗暴的遍历，但效率不高
        题目中有说数组是有序的，那么就可以用二分查找
        下面的代码是参考大佬的
        仔细理解
        如： target=8
        主要是用8的边界（第一个9）减去7的边界（第一个8）
        从而得出8的个数

        二分查询边界问题  照顾好i或j其中一个（给if条件 另一个直接else ） 这样就可找到边界
        找两个边界就搞两个while 或像这题一样调两次函数

 */

package 刷题.leetcode.剑指Offer53在排序数组中查找数字;

class Solution {
    public int search(int[] nums, int target){
        return binarySearch(nums,target)-binarySearch(nums,target-1);
    }

    public int binarySearch(int[]nums,int target)
    {   int i=0;
        int j=nums.length-1;
        while (i<=j){
            int m=(i+j)/2;
            if(nums[m]<=target) i=m+1;    //这样一来，只有当nums[m]>target时，才不会走这个if，此时i正好是target的边界（第一个9）//i在目标数字右边的第一个非目标数字
            else j=m-1;
        }
        return i;
    }
}
