/*
==========================================
看了大佬的答案，
对啊本题标签是双指针，数组可以直接赋新值
对链表，指针是替身节点
对数组，指针是下标i,j
========================================
注意看看细节实现
 */


package 刷题.leetcode.剑指Offer21调整数组顺序使奇数位于偶数前面;

import java.util.ArrayList;

/*
 初版   5.14% && 17.95%
class RangeFreqQuery {
    public int[] exchange(int[] nums) {
        ArrayList a1=new ArrayList();
        ArrayList a2=new ArrayList();
        for (int i:nums) {
            if((i&1)==1)
                a1.add(i);
            else a2.add(i);
        }
        int [] newone=new int[a1.size()+a2.size()];
        int n=0;
        for (Object i:a1)
        {
            newone[n]=(Integer)i;
            n++;
        }
        for (Object i:a2)
        {
            newone[n]=(Integer)i;
            n++;
        }
        System.out.println(a1);
        System.out.println(a2);
        return newone;
    }
}
 */

class Solution {
    public int[] exchange(int[] nums) {
        int i=0,j=nums.length-1,temp;
        while (i<j){
            while (i<j&&(nums[i]&1)==1) i++;
            while (i<j&&(nums[j]&1)==0) j--;
            temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        return nums;
    }
}

