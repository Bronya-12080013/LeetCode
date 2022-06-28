/*
好耶好耶好耶 今天除夕加成 一遍过 58.20% && 5.00%
再优化优化
==========================================================
见大佬代码！！！回溯套循环
这区别于 之前的字符串全排列有 （那个是都是每一层中有数个可能）
class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(path,candidates,target,0,0);
        return res;
    }

    private void backtrack(List<Integer> path,int[] candidates,int target,int sum,int begin) {
        if(sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin;i < candidates.length;i++) {  //这一层的数个可能
            int rs = candidates[i] + sum;
            if(rs <= target) {
                path.add(candidates[i]);
                backtrack(path,candidates,target,rs,i);
                path.remove(path.size()-1);
            } else {
                break;
            }
        }
    }
}
 */


//试着排序后从后边读起 没什么效果
package 刷题.leetcode.T39组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<>();
        List<Integer> combine= new ArrayList<>();
        Arrays.sort(candidates);
        DFS(candidates,target,candidates.length-1,combine);
        return list;

    }
    void DFS(int[] candidates, int target,int index,List<Integer> combine)
    {
        if(index<0||target<0) return;
        if(target==0)
        {
            list.add(new ArrayList<>(combine));
            return;
        }
        DFS(candidates,target,index-1,combine);
        combine.add(candidates[index]);
        DFS(candidates,target-candidates[index],index,combine);
        combine.remove(combine.size()-1);
    }
}

/*  58.20% && 5.00%
    优化优化
class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<>();
        List<Integer> combine= new ArrayList<>();
        DFS(candidates,target,0,combine);
        return list;

    }
    void DFS(int[] candidates, int target,int index,List<Integer> combine)
    {
        if(index>=candidates.length||target<0) return;
        if(target==0)
        {
            list.add(new ArrayList<>(combine));
            return;
        }
        DFS(candidates,target,index++,combine);  //这里的index+1 不能写成index++
        combine.add(candidates[index]);
        DFS(candidates,target-candidates[index],index,combine);
        combine.remove(combine.size()-1);
    }
}
 */