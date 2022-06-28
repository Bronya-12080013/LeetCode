/*
我的答案应该没问题，就是超时了
=================================
官方的DFS法 不可描述 自己体会
=====================================
官方的拓扑排序  高难 用示例好好把数据一步步记下来推导吧  困困 觉觉
例子

richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
输出：[5,5,2,5,4,5,6,7]

画出指向总图图  认为指向他人（指出去）都是负担
那就可以发现 第一批 因inDeg[i] == 0都是刻意回避他人的高傲之人，他们没有指向任何人 只是被他人指向着 就是没有说明有人比他们富有，可以观察在结果中 这批数位置上的都是自己
从末端往回缩 就会使这一代的上一级 1 和 3 的inDeg[i]归零 从而加入队列
如此 便可最后抵达0 和 7这 只出不进的博爱之人
这样从已定的数一层层下去不断修改 即得到答案


class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<Integer>();
        }
        int[] inDeg = new int[n];
        for (int[] r : richer) {
            g[r[0]].add(r[1]);
            ++inDeg[r[1]];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = i;
        }
        Queue<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : g[x]) {
                if (quiet[ans[x]] < quiet[ans[y]]) {
                    ans[y] = ans[x]; // 更新 x 的邻居的答案
                }
                if (--inDeg[y] == 0) {
                    q.offer(y);
                }
            }
        }
        return ans;
    }
}
 */

/*  超时了 71/86
package 刷题.leetcode.T851喧闹和富有;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.loudAndRich(new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}},new int[]{3,2,5,4,6,1,7,0});
    }
    public int[] loudAndRich(int[][] richer,int[] quiet) {
        Arrays.sort(richer,(a,b)->a[1]-b[1]);
        int[] answer = new int[quiet.length];
        int count=0;
        for(int i=0;i<answer.length;i++)
        {
            ArrayList<Integer> list = new ArrayList();
            Queue<Integer> deque = new ArrayDeque();
            deque.add(i);
            while (!deque.isEmpty())
            {
                int num = deque.poll();
                list.add(num);
                for(int l = 0;l<richer.length;l++)
                {
                    if(richer[l][1]==num) deque.add(richer[l][0]);
                }
            }
            int min = Integer.MAX_VALUE;
            int Idx = 0;
            for(int k =0;k<list.size();k++){
                    if(min>quiet[list.get(k)]){
                        min=quiet[list.get(k)];
                        Idx = list.get(k);
                    }
            }
            answer[count++]=Idx;
        }
        return answer;
    }
}
*/


//DFS法
package 刷题.leetcode.T851喧闹和富有;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n =quiet.length;
        List<Integer>[] g = new List[n];  //链表数组 --用于构建图
        for(int i =0;i<n;i++) g[i]=new ArrayList<Integer>();
        for(int[] r:richer) g[r[1]].add(r[0]);
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i =0;i<n;i++) DFS(i,quiet,g,ans);    //搞一次i就可以把i以及它的邻居和它邻居的邻居对应的ans都填好了
        return ans;
    }
    void DFS(int x,int[] quiet,List<Integer>[] g,int[] ans){
        if(ans[x]!=-1) return;
        ans[x]=x;         //先认为自己是最好的
        for(int y:g[x]){   //g是列表数组 g[x]是一个链表，取出来就是一个数
            DFS(y,quiet,g,ans);
            if(quiet[ans[y]]<quiet[ans[x]]) ans[x]=ans[y];       //给每数找它的邻居 一直到结尾 把上面i对应ans[i]里放上它最优秀的邻居
        }
    }
}
