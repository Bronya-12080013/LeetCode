/*

int tar =(i+j)/2;
可以写   int tar = i+ (j-i)/2;        如果直接 i+j 可能太大了出界


 */

package 刷题.leetcode.T704二分查找;

public class Solution {
    public static void main(String[] args) {
        int[] n = new int[]{-1,0,3,5,9,12};
        search(n,9);
    }
    static int search(int[] nums, int target) {
        int i =0,j=nums.length-1;
        while (i<=j)                              //我写while有个严重的习惯，老是写否定条件          //！！！！！！！注意这里要写i<=j
        {
            int tar =(i+j)/2;
            //也可以写   int tar = i+ (j-i)/2;        如果直接 i+j 可能太大了出界
            if(target<nums[tar]) j=tar-1;
            else if(target>nums[tar]) i=tar+1;
            else return tar;
        }
        return -1;
    }
}
