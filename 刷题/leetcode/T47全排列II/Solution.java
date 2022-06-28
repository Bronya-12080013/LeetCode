package 刷题.leetcode.T47全排列II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
俯瞰俯瞰
因为有重复的
那我们每次都全来一遍for
for中带for
每次都从头开始 用vis去重
 */
class Solution {
    List<List<Integer>> res;
    List<Integer> perm;
    boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
       res = new ArrayList<>();
        perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums,  int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            /*
            这里的条件非常重要
            主要是 (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])
            因为有重复
            假设有2个相同的数 设选中为1 未选中为0
            那么这两个数有 00 10 01 11
            可以发现 10 01 其实是一样的
            我们通过条件(i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])
            不要01这个选项 而在其他世界线存在10的可能就行
             */
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums,  idx + 1);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}

