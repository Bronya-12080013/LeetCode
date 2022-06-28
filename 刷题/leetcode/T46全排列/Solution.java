/*
全排列问题
方法传承至 剑指 Offer 38. 字符串的排列
我可以自己写出大体了 又参考了一下它才写出来
==============================================
思路就去剑指 Offer 38. 字符串的排列 看吧
这里说一下遇到的坑:
我刚开始是写
static List<List<Integer>> Lists= new ArrayList<>();
static int[] num;
把它们设成全局变量
当我在leetcode用示例测试时 都没错
但我提交时 就会在“通过用例1/26”哪里卡住
（说明一下，“通过用例1/26”是我已经通过了第一个用例，卡在了第二个用例哪里）
:
最后执行的输入： [0,1]
输出：
[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,2,1],[3,1,2],[0,1],[1,0]]
预期结果：
[[0,1],[1,0]]
可以发现
我的输出的最后哪里就是预期结果
那么前面哪些应该是第一个用例的结果 后面哪些是第二个用例的结果
在leetcode“执行代码”哪有个^ 可以“执行示例” 把三个题目用例执行了
会发现 我的结果就像上面累加了

这是因为我return的是static的Lists
所有我改成了
List<List<Integer>> Lists= new ArrayList<>();
int[] num;
同时 为了它们在方法能用
void DFS(int X)
void swap(int i ,int j)
都不要static

下面有错误的代码
=============================================================
好了 说回全排列DFS
记住我的代码即可 83.34% && 64.33%
官方的代码:
class TopVotedCandidate {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}

 */

package 刷题.leetcode.T46全排列;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permute(new int[]{0,1});
    }
     List<List<Integer>> Lists= new ArrayList<>();
     int[] num;
    public List<List<Integer>> permute(int[] nums) {
        num=nums;
        DFS(0);
        return Lists;
    }
    void DFS(int X)
    {
        if(X==num.length-1)           //结束
        {
            List<Integer> list = new ArrayList<>();
           for (int i =0;i<num.length;i++)        // for (int num : nums){} 逼格高
           {
               list.add(num[i]);
           }
           Lists.add(list);
            return;
        }
        Set<Integer> set = new HashSet();
        for(int i=X;i< num.length;i++)
        {
            if(set.contains(num[i])) continue;
            set.add(num[i]);
            swap(X,i);
            DFS(X+1);
            swap(i,X);
        }
    }
    void swap(int i ,int j)         //其实有 Collections.swap()方法
    {
        int temp = num[i];
        num[i]=num[j];
        num[j]=temp;
    }
}

/*   错误示范代码
public class TopVotedCandidate {
    static List<List<Integer>> Lists= new ArrayList<>();
    static int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==2&&nums[0]==0&&nums[1]==1)
        {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(1);
            Lists.add(list);
            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            list1.add(0);
            Lists.add(list1);
            return Lists;
        }
        this.nums=nums;
        DFS(0);
        return Lists;
    }
    static  void DFS(int X)
    {
        if(X==nums.length-1)
        {
            List<Integer> list = new ArrayList<>();
           for (int i =0;i<nums.length;i++)
           {
               list.add(nums[i]);
           }
           Lists.add(list);
            return;
        }
        Set<Integer> set = new HashSet();
        for(int i=X;i< nums.length;i++)
        {
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(X,i);
            DFS(X+1);
            swap(i,X);
        }
    }
    static void swap(int i ,int j)
    {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
 */