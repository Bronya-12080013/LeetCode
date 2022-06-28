/*
思路一： 好强 利用已经放进去的结果进行不断的累积
nums={1，2，3}
0                放一个空的 这里用0代替空
01               j=0,取出nums[j]=1 得(0+1=01)
02 012           j=1,取出nums[j]=2 得(0+2=02 01+2=012)
03 013 023 0123  j=2,取出nums[j]=3 得(0+3=03 01+3=013 02+3=023 012+3=0123)
思路二：
这题好逆天 我拿草稿推了一遍才懂 不愧是回溯题
好吧 又理了一下 变清晰了
它就如同二叉树一般 每层分为两步：
 考虑选择当前位置
 考虑不选择当前位置
 =======================================
 这题能不能把前面写过的全排序方法通过改动截取范围来获得结果？
 */

/*
思路一：
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
           int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }
}
 */

//思路二 这是人能想出来的？
package 刷题.leetcode.T78子集;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    List<List<Integer>> List = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        DFS(0,nums);
        return List;
    }
    void DFS(int cur,int[] nums)
    {
        if(cur == nums.length)
        {
            List.add(new ArrayList<>(ans));
            return;
        }
        // 考虑不选择当前位置
        DFS(cur+1,nums);


        // 考虑选择当前位置
        ans.add(nums[cur]);
        DFS(cur+1,nums);
        ans.remove(ans.size()-1);
    }
}

/*
官方思路二
class Solution {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
}

 */
