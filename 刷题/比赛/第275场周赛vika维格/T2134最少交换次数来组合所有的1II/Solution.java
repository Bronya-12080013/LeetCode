/*
完全没思路 题二
=======================================
看看大佬代码
 */

package 刷题.比赛.第275场周赛vika维格.T2134最少交换次数来组合所有的1II;

class Solution {
    public int minSwaps(int[] nums) {
        int count=0,ans=0,num=0;//分别用来记录数组内1总数、滑窗内1最大数、以及现在滑窗内1个数
        for(int i=0;i<nums.length;i++){count+=nums[i];}
        //此时确定滑窗大小为count  //将滑窗大小定为数组内1总数
        for(int i=0;i<count;i++){num+=nums[i];}  //num是现在滑窗内1个数 nums[i]为1才会加上去
        ans=num;
        for(int i=0;i<nums.length-1;i++){
            num+=nums[(count+i)%nums.length]-nums[i];
            ans=Math.max(ans,num);
        }
        return count-ans;
    }
}