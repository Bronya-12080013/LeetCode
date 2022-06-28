/*
好耶 不断地debug终于过了
不够这题通过率怎么那么高 呜呜呜很容易吗
=============================================
官方答案
1. 用stack来当List<Integer> 方便入栈出栈
stack.offerLast(y);
stack.pollLast();
不用像我的
 list.add(i);
 list.remove(list.size()-1);
2.我和官方的思路有少些不同 我是对graph[0]中的数一个个来
官方把graph[0]也直接放下去了
3.注意 可以用List.add(new ArrayList<>(list));

class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> stack = new ArrayDeque<Integer>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    public void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            ans.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs(graph, y, n);
            stack.pollLast();
        }
    }
}
 */

package 刷题.leetcode.T797所有可能的路径;

import java.util.ArrayList;
import java.util.List;
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = new int[][]{
             //   {4,3,1},{3,2,4},{3},{4},{}
                {2},{},{1}
        };
        solution.allPathsSourceTarget(graph);
    }
    List<List<Integer>> List;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List = new ArrayList<>();
        for(int i=0;i<graph[0].length;i++)
        {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            DFS(graph[0][i],list,graph);
        }
        return List;
    }

    void DFS(int i,List<Integer> list,int[][] graph){
        list.add(i);  //在这增加
        //if(graph[i].length==0){  //不行 最后一个不见得就是空的
        if(i==graph.length-1){
           // if(list.get(list.size()-1)==graph.length-1) {  这层没必要
                List.add(new ArrayList<>(list));  //怎么我之前不行 之前我怎么写的
              // 用上面的 下面是初版写的
              // List<Integer> l = new ArrayList();
              // for(int k =0;k<list.size();k++) l.add(list.get(k));
              // List.add(l);
            //}
            list.remove(list.size()-1);  //注意在这删去 出口1
            return;
        }
        for(int j = 0;j<graph[i].length;j++)
        {
           // list.add(graph[i][j]);      //不要在这里增加和删除 上面的if出口会吃不到它 （如从第一个直接就到最后一个的 它从allPathsSourceTarget下来就直接进上面的if了）
            DFS(graph[i][j],list,graph);
           // list.remove(list.size()-1);
        }
        list.remove(list.size()-1);  //注意在这删去 出口2
    }
}

/*
我的简化版  100.00% && 88.69%
class Solution {
    List<List<Integer>> List = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        for(int i=0;i<graph[0].length;i++)
        {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            DFS(graph[0][i],list,graph);
        }
        return List;
    }
    void DFS(int i,List<Integer> list,int[][] graph){
        list.add(i);
        if(i==graph.length-1){
             List.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        for(int j = 0;j<graph[i].length;j++) DFS(graph[i][j],list,graph);
        list.remove(list.size()-1);
    }
}
 */

/*
把我的代码修改成官方答案的思路
class Solution {
    List<List<Integer>> List = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            DFS(0,list,graph);
            return List;
    }
    void DFS(int i,List<Integer> list,int[][] graph){
        if(i==graph.length-1){
             List.add(new ArrayList<>(list));
            return;
        }
        for(int j = 0;j<graph[i].length;j++)
        {   list.add(graph[i][j]);
            DFS(graph[i][j],list,graph);
            list.remove(list.size()-1);
        }
    }
}
 */