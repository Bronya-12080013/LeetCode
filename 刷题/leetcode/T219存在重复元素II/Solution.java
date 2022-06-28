package 刷题.leetcode.T219存在重复元素II;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//滑动窗口
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {    //注意 这里的set.add()是先执行的 成功就true 失败false
                return true;
            }
        }
        return false;
    }
}


/* 哈希法 88.69% && 71.42%
class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashMap<Integer,Integer> hashMap = new HashMap<>(); //值:下标
            for(int i =0;i<nums.length;i++)
            {
                if(hashMap.containsKey(nums[i])&&i-hashMap.get(nums[i])<=k) return true;
                else hashMap.put(nums[i],i);
            }
            return false;
        }
    }
 */
    /*  暴力法 过了 8.84% 45.33%
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<=i+k;j++)
            {
                if(j>=nums.length) break;
                if(nums[i]==nums[j]) return true;
            }
        }
        return false;
    }
     */
