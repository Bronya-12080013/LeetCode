/*
初版过了
逐步看看大佬答案，看能不能自己写
======================================================
啊，我忘了这是个递增数组
双★指★针★法★   车~车~
摸清关系
递增数组使nums[i] + nums[j]与target的大小比较就有了意义，
int i = 0, j = nums.length - 1;
j--才可使nums[i] + nums[j]变小，
i++才可使nums[i] + nums[j]变大。
 */

package 刷题.leetcode.剑指Offer57和为s的两个数字;

/*
初版           17.02% && 12.31%
import java.util.HashSet;
import java.util.Set;

class RangeFreqQuery {
    public int[] twoSum(int[] nums, int target) {
        Set set =new HashSet();
        int[] returnone;
        for (int i:nums) {
            if(set.contains(i))
            {
                returnone= new int[]{i, target - i};
                return returnone;
            }else set.add(target-i);
        }
        return null;
    }
}
 */

//改进版
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=nums.length-1,s;
        while (i<j){
            s=nums[i]+nums[j];
            if(s<target) i++;
            else if(s>target) j--;
            else return new int[]{nums[i],nums[j]};

        }
        return new int[0];
    }
}