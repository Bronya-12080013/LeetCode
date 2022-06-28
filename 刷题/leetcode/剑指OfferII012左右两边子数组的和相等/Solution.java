/*
唔不行了我失败了
==========================================
答案1
前缀和方法 好好看看
注意思想
还有那个 流操作   int total = Arrays.stream(nums).sum();
不愧是简单题 有思路就是简单
=============================================
答案2
思路差不多
tmp1[i]*2 == tmp[i]  就是  tmp1[i]*2== total - nums[i];
 */

/*
失败了
package 刷题.leetcode.剑指OfferII012左右两边子数组的和相等;

public class Time {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{-1,-1,-1,-1,-1,0}));
    }
    static int pivotIndex(int[] nums) {
        int left = 0,right=nums.length-1;
        int numleft=nums[left],numright=nums[right];
        while (left<right)
        {
            if(numleft<=numright)
            {
                numleft+=nums[left];
                left++;
            }else if(numleft>numright){
                numright+=nums[right];
                right--;
            }
            if(numleft==numright&&left+1==right)
                break;
        }

        if((left== nums.length-1||right==0)&&left==right)
        {
            if(left==numleft-1)
            {
                if(numright-nums[nums.length-1]==0)
                {
                    return nums.length-1;
                }
            }
            else if(right==0)
            {
                if(numleft-nums[0]==0)
                {
                    return 0;
                }
            }
        }
        else if(left==right&&numleft==numright&&numleft!=0)
        {
            return -1;
        }
        else if((numleft==numright||numleft!=0)&&left+1==right)
        {
            return left;
        }
        return -1;
    }
}
 */

//答案1  但效率不高
package 刷题.leetcode.剑指OfferII012左右两边子数组的和相等;

import java.util.Arrays;

public class Solution {
    static int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();      //求总和
        int sum = 0;
        for(int i =0;i< nums.length;i++)
        {
            if(sum*2+nums[i]==total) return i;         //sum是左边的和 当sum*2+nums[i]==total 那就是左右相等了
            sum+=nums[i];
        }
        return -1;
    }
}

/* 答案2  效率高
class Time {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int[] tmp = new int[nums.length];
        int[] tmp1 = new int[nums.length];
        //求左半边的和
        for(int i = 0 ; i < nums.length ; i++){
            tmp1[i] = sum;
            sum += nums[i];
        }
        //求除当前下标外其他元素的和
        for(int i = 0 ; i < nums.length ; i++){
            tmp[i] = sum-nums[i];
        }
        for(int i = 0 ; i < nums.length ; i++){
            //这里用除法应该不行吧，有没有可能会出现向下取整后相等的情况？
            if(tmp1[i]*2 == tmp[i]) return i;
        }
        return -1;
    }
}

作者：savage-p
链接：https://leetcode-cn.com/problems/tvdfij/solution/javayu-chu-li-1msji-bai-100-by-savage-z-1pvn/
 */