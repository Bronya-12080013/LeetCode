/*
啊直接遍历都能100% && 65.67%啊
哪二分法不得1000%？
=============================================
呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜 我写的什么bug制造机
硬生生从1个通过用例改到18个用例 又变回10个了
不写了
我记得这题在书上见过的 好像就是思想上把它拼起来
看答案
================================================
看完了 思路明确 果然二分法是细节魔鬼
我模仿试试
======================================================
过了 好难
尤其是
if(nums[0]<=target&&target<nums[temp])
if(nums[temp]<target&&target<=nums[nums.length-1])
等号绝不能省略 不然target在边界的用例无法实现
 */

//模仿官方答案
package 刷题.leetcode.T33搜索旋转排序数组;
public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        if(nums.length==1) return nums[0]==target?0:-1;
        int left = 0,right = nums.length-1;
        while (left<=right){
            int temp =left+(right-left)/2;
            if(nums[temp]==target) return temp;
            if(nums[temp]>=nums[0]){
                    if(nums[0]<=target&&target<nums[temp]) right = temp-1;   //if的等号绝不能省略
                    else left=temp+1;
            }else {
                if(nums[temp]<target&&target<=nums[nums.length-1]) left=temp+1; //if的等号绝不能省略
                else right=temp-1;
            }
        }
        return -1;
    }
}



/* 哈哈
package 刷题.leetcode.搜索旋转排序数组33;
public class TopVotedCandidate {
    public int search(int[] nums, int target) {
        for(int i = 0;i<nums.length;i++)
        if(nums[i]==target) return i;
        return -1;
    }
}
 */


/*   写的什么玩意
package 刷题.leetcode.搜索旋转排序数组33;
public class TopVotedCandidate {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5};
        TopVotedCandidate solution =new TopVotedCandidate();
        System.out.println(solution.search(nums,3));
    }
    public int search(int[] nums, int target) {
      int i = 0,j=nums.length-1;
      int leftVal = nums[i],rightVal =nums[j];
      if(target>rightVal&&target<leftVal) return -1;
      while (i<=j)
      {
          if(nums[i]==target) return i;
          if(nums[j]==target) return j;
          int temp = i+(j-i)/2;
          if(nums[temp]==target) return temp;
          if(nums[temp]>leftVal)
          {
              if(target>nums[temp]&&target>leftVal) i=temp+1;
              else if(target<nums[temp]&&target>leftVal) j=temp-1;
              else if(target<nums[temp]&&target<rightVal) i=temp+1;
          }
         else if(nums[temp]<rightVal)
         {
             if(target<nums[temp]&&target<rightVal) j=temp-1;
             else if(target>nums[temp]&&target<rightVal) i=temp+1;
             else if(target>nums[temp]&&target>leftVal) j=temp-1;
         }
         if(i>=nums.length||j<=0) return -1;
         if(nums[i]==target) return i;              //二分法写多了都傻了  这里要break啊 不然真的等i>=j吗 //本题也可以直接return   //上面两个if不要=
          if(nums[j]==target) return j;

      }
      return -1;
    }
}
 */