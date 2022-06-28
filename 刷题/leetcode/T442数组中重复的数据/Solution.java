package 刷题.leetcode.T442数组中重复的数据;

import java.util.*;
/*
1.好好看题，"其中 nums 的所有整数都在范围 [1, n] 内"
把相应的数字放在相应的位置
没正确座位的就是重复的
2.学到了
 */

//将元素交换到对应的位置
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (nums[i] - 1 != i) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}


/* 能过 但不合要求
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(!set.add(nums[i])) res.add(nums[i]);
        }
        return res;
    }
}
 */