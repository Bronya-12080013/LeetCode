/*
二分查找
 */

package 刷题.leetcode.T153寻找旋转排序数组中的最小值;

/*  法二
import java.util.Arrays;
public class Solution {
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }
}
 */

/* 法一
public class Solution {
    public int findMin(int[] nums) {
            int min = Integer.MAX_VALUE;
            for(int i =0;i<nums.length;i++)
            {
                min=Math.min(min,nums[i]);
            }
            return min;
    }
}
 */


//还是参考了官方的 啊啊啊啊啊啊啊啊啊啊好多的边界
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{11,13,15,17};
        Solution solution =new Solution();
        System.out.println(solution.findMin(nums));
    }
    public int findMin(int[] nums) {
        int l = 0,r=nums.length-1;
        while (l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]<nums[nums.length-1]) r=mid;  //守住边界 坑让l来踩
            else l=mid+1;
        }
        return nums[l];
    }
    }