/*
题三：
给你一个下标从 0 开始的数组 nums ，数组由若干 互不相同 的整数组成。
nums 中有一个值最小的元素和一个值最大的元素。分别称为 最小值 和 最大值 。你的目标是从数组中移除这两个元素。
一次 删除 操作定义为从数组的 前面 移除一个元素或从数组的 后面 移除一个元素。
返回将数组中最小值和最大值 都 移除需要的最小删除次数。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/removing-minimum-and-maximum-from-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
================================================================================
没时间了
题目又没看清楚 下面的初版思路不对
结束后十分钟 我再看看题目 这不就是双指针？待会试试
=============================================================================
试试双指针
==============================================================================
成了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了了
100% && 100%
双百百百百百百百百百百百百百百百百百百百百百百百百百百百百百百百！！！！！！！！！！！！！！！！！！！！！！！！！！
稳定的双百！！！！！！！！！！ (是不是比赛题提交的人不多啊)
代码还可以优化，我就不改了
等等，前面比赛都是 “通过” 了  那来的百分比
=======================================================================
我试试再提交别的题  也是双百。。。
唔
===========================================================================
大佬代码:
class Time {
    public int minimumDeletions(int[] nums) {
        int min = 100_000;             //题目给的极限值
        int max = -100_000;

        for (int num : nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int s = 0, l = 0;

        for (int i = 0; i < nums.length; ++i){
            if (nums[i] == min)
                s = i;
            else if (nums[i] == max)
                l = i;
        }

        max = Math.max(s, l);
        min = Math.min(s, l);

        int result = min + 1 + nums.length - max;        //两头的
        result = Math.min(result, max + 1);             //左向右的
        result = Math.min(result, nums.length - min);     //右向左的

        return result;                                    //取得三者中最小的
    }
}
==========================================================
妙啊，
1.用
for (int num : nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
来取max,min  不必像我那样搞新数组排序

2.用几个Math.min来比较 不用if...else了


 */

/* 初版
package 刷题.比赛.第269场周赛Tapdata.从数组中移除最大值和最小值;

import java.util.Arrays;

public class Time {
    public int minimumDeletions(int[] nums) {
        int[] n = new int[nums.length];
        for(int i =0;i<nums.length;i++)
        {
            n[i]=nums[i];
        }
        Arrays.sort(n);
        int min = n[0];
        int max = n[n.length-1];
        int minindex=-1;
        int minsum=0;
        int maxindex=-1;
        int maxsum=0;

        for(int i =0;i<nums.length;i++)
        {
            if(nums[i]==min) {
                if (nums.length - i > i) {
                    minindex = 0;
                    minsum = i+1;
                } else {
                    minindex = 1;
                    minsum = nums.length - i;
                }
            }
              if(nums[i]==max)
              {
                  if (nums.length - i > i) {
                      maxindex = 0;
                      maxsum = i+1;
                  } else {
                      maxindex = 1;
                      maxsum = nums.length - i;
                  }
              }
            }
       // if(minindex==maxindex) return maxsum+minsum-1;
        return maxsum+minsum;
        }
    }
 */

//双指针  100% && 100%        很臃肿，还可以提
package 刷题.比赛.第269场周赛Tapdata.从数组中移除最大值和最小值;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(minimumDeletions(new int[]{-1,-53,93,-42,37,94,97,82,46,42,-99,56,-76,-66,-67,-13,10,66,85,-28}));;
    }
    static int minimumDeletions(int[] nums) {
        if(nums.length==1) return 1;
        int[] n = new int[nums.length];
        for(int i =0;i<nums.length;i++)
        {
            n[i]=nums[i];
        }
        Arrays.sort(n);
        int min = n[0];
        int max = n[n.length-1];
        int timeLeft=0,timeRight=0,time=0;
        int[] leftnum= new int[2];
        int[] rightnum= new int[2];
        int countleft=0;
        int countright=0;
        for(int left=0,right= nums.length-1;left< nums.length||right>0;)
        {
            timeLeft++;          //3
            if(nums[left]==min||nums[left]==max)
            {
                leftnum[countleft++]=timeLeft;
                    timeLeft=0;
                    time++;
            }
            timeRight++;
          //  if(left!=right)        //1
            if(nums[right]==min||nums[right]==max)
            {
                rightnum[countright++]=timeRight;
                    timeRight=0;
                    time++;
            }
         //   if(time==2||(time==1)&&left==right) return sum;      //2
            if(time==4)
            {
                if(leftnum[0]+leftnum[1]<rightnum[0]+ rightnum[1])
                {
                    if(leftnum[0]+leftnum[1]< leftnum[0]+rightnum[0])
                    {
                        return leftnum[0]+leftnum[1];
                    }
                    else return  leftnum[0]+rightnum[0];
                }else {
                    if(rightnum[0]+ rightnum[1]<leftnum[0]+rightnum[0])
                    {
                        return rightnum[0]+ rightnum[1];
                    }
                    else return leftnum[0]+rightnum[0];
                }

            }
            left++;
            right--;
        }
        return -1;
    }
}