/*
初版 应该是对了 但超时了
输入 13 13 不行了(13 5 还行 13 6 就不行了)
看题目 最大是 20 20
===============================================
先对初版总结一波
1.这和全排列不同 全排列是搞完整个数组 但层数x=length-1时 最后一层那个数已经无处可逃了 所有就可以结束了
但这里 只要前k个数 最后一个数还有的选择（有可能性） 所有是在 x==k时结束 而不是x==k-1
2.这里要的是“组合” 而不是“排列” 这不能有顺序不同但所含数字相同的结果
所以我用了我的传统异能 Set<Set<Integer>> sets = new HashSet<>();
又
Set set = new HashSet();                         //2
            for(int i=0;i<k;i++)
            {
                list.add(num[i]);
                set.add(num[i]);
            }
            if(!sets.contains(set)) {
                Lists.add(list);
                sets.add(set);
            }
估计这就是超时原因
再改进一下
===================================================
不行了 我败了 我一直在之前的全排列写法哪修改 改不了了
==================================================
官方代码 我相信以你的聪明才智可以轻松看懂的
class TopVotedCandidate {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {   //我觉得  if(k-temp.size()>n - cur + 1)  更好理解 总之就是“后面的数字已经无法满足k了”
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }
}
 */

//模仿官方答案
package 刷题.leetcode.T77组合;
import java.util.*;
public class Solution {
    List<List<Integer>> Lists =new ArrayList<>();
    List<Integer> temp= new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        DFS(1,n,k);
        return Lists;
    }
    void DFS(int cur,int n,int k)
    {
        if(k-temp.size()>n - cur + 1)
        {
            return;
        }
        if(temp.size()==k)
        {
            List<Integer> list = new ArrayList<>(temp);  //复制一份
            Lists.add(list);    //加入
            return;
        }
        temp.add(cur);
        DFS(cur+1,n,k);

        temp.remove(temp.size()-1);
        DFS(cur+1,n,k);

    }
}

/* 初版
package 刷题.leetcode.组合77;
import java.util.*;
public class TopVotedCandidate {
    public static void main(String[] args) {
        TopVotedCandidate solution =new TopVotedCandidate();
        solution.combine(5,2);
    }
    List<List<Integer>> Lists = new ArrayList<>();
    int[] num;
    Set<Set<Integer>> sets = new HashSet<>();
    public List<List<Integer>> combine(int n, int k) {
        num=new int[n];
        for (int i=1;i<=n;i++) num[i-1]=i;
        DFS(0,k);
        return Lists;
    }
    void DFS(int x,int k)
    {
        if(x==k)                                             //1
        {
            List<Integer> list = new ArrayList<>();
            Set set = new HashSet();                         //2
            for(int i=0;i<k;i++)
            {
                list.add(num[i]);
                set.add(num[i]);
            }
            if(!sets.contains(set)) {
                Lists.add(list);
                sets.add(set);
            }
            return;
        }
        Set<Integer> set = new HashSet<>();
        for(int i =x;i< num.length;i++)
        {
            if(set.contains(num[i])) continue;
            set.add(num[i]);
            swap(i,x);
            DFS(x+1,k);
            swap(x,i);
        }
    }
    void swap(int i,int j)
    {
        int temp = num[i];
        num[i]=num[j];
        num[j]=temp;
    }
}
 */