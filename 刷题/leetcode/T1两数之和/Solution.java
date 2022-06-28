//新手村
package 刷题.leetcode.T1两数之和;

//暴力
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0 ;i<nums.length-1;i++)
        {
            for(int j =i+1;j<nums.length;j++)
            {
                if(nums[i]+nums[j]==target)
                    return new int[]{i,j};
            }
        }
        return new int[0];
    }
}
/*
哈希表
class Time {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
 */