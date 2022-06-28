/*
简单，过了
 */

package 刷题.leetcode.T35搜索插入位置;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int i =0,j=nums.length-1;
        while (i<=j){
            int tar =(i+j)/2;
            if(target<nums[tar]) j=tar-1;
            else if(target>nums[tar]) i=tar+1;
            else return tar;
        }
        return i;

        //下面傻了，没看清楚题目，以为要插入

        /*
        //到这，就是前面没return，失败了，那就插入它
        //应该j位的值比target小，i位的值比target大
     //   int[] num=new int[nums.length+1];
     //   int count=0;
     //   for(int k =0;k<nums.length;k++){
     //       if(k==i)
     //       {
     //           nums[count++]=target;
     //           k--;
     //           continue;
     //       }
     //       num[count++]=nums[k];
     //   }
        return i;
         */

    }
}
