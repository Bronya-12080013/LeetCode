/*
对比一下 78. 子集
就知道重复的子串是什么了
先排个序  返回顺序无所谓, T78不重复就不用排序
画一下图（类似二叉树的图 看一下重复子串的位置 就知道重复子串出现原因了：前一个数不选择&&这个数有与前一个数相同  从而不同分支的下和上产生相同）
（有三个及以上的也奉行相同法则，而且在两个是就把支路的苗条断了 ，不用担心连环套）
对T78代码改造
对 考虑不选择当前位置（前一个数不选择）的情况  传个false
再判断数是否于前一个相同
 */
package 刷题.leetcode.T90子集II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<java.util.List<Integer>> List = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        DFS(false,0,nums);
        return List;
    }
    void DFS(boolean choosePre,int cur,int[] nums)
    {
        if(cur == nums.length)
        {
            List.add(new ArrayList<>(ans));
            return;
        }
        // 考虑不选择当前位置
        DFS(false,cur+1,nums);  //false表没选择
        if(!choosePre&&cur>0&&nums[cur]==nums[cur-1]) return; //注意cur>0 或者可以 第一个传true 就不用cur>0 了
        // 考虑选择当前位置
        ans.add(nums[cur]);
        DFS(true,cur+1,nums);
        ans.remove(ans.size()-1);
    }
}