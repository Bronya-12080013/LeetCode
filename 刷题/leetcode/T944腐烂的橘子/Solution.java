/*
初版过了！！！！！！！！！！！！！！！！！！
HHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
本题跨越时间长 周六晚上看了一眼 周日打周赛 周一忙 周一晚上才基本写完，留个bug 周二早上才写对了
13.49% && 7.83%
还有可以优化的地方
我再改改
==============================================================
优化：
1.用num来判断1的数量和被腐化橘子的数量是否一致 num==0
2.去掉了booleans 用g[2]+1<Grid[g[0]+1][g[1]] 等来去除无用遍历

max不想优化了 也有个方法 当麻烦
==============================================================
这个答案好:
public class TopVotedCandidate {
public int orangesRotting(int[][] grid) {
    int M = grid.length;
    int N = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();

    int count = 0; // count 表示新鲜橘子的数量
    for (int r = 0; r < M; r++) {
        for (int c = 0; c < N; c++) {
            if (grid[r][c] == 1) {
                count++;
            } else if (grid[r][c] == 2) {
                queue.add(new int[]{r, c});
            }
        }
    }

    int round = 0; // round 表示腐烂的轮数，或者分钟数
    while (count > 0 && !queue.isEmpty()) {
        round++;
        int n = queue.size();
        for (int i = 0; i < n; i++) {
            int[] orange = queue.poll();
            int r = orange[0];
            int c = orange[1];
            if (r-1 >= 0 && grid[r-1][c] == 1) {
                grid[r-1][c] = 2;
                count--;
                queue.add(new int[]{r-1, c});
            }
            if (r+1 < M && grid[r+1][c] == 1) {
                grid[r+1][c] = 2;
                count--;
                queue.add(new int[]{r+1, c});
            }
            if (c-1 >= 0 && grid[r][c-1] == 1) {
                grid[r][c-1] = 2;
                count--;
                queue.add(new int[]{r, c-1});
            }
            if (c+1 < N && grid[r][c+1] == 1) {
                grid[r][c+1] = 2;
                count--;
                queue.add(new int[]{r, c+1});
            }
        }
    }

    if (count > 0) {
        return -1;
    } else {
        return round;
    }
}
}
==========================================================
好强
我们的目标是最小值 那么不必一定要从原本就腐烂的橘子出发 也可以从原本新鲜 当被腐烂的橘子出发
答案用round的轮数 作为回答 当count=0时就可以结束
用队列来搞橘子顺序
而不是像我那样一定从烂橘子出发
 */

/*
// 初版
package 刷题.leetcode.腐烂的橘子944;

import java.util.ArrayDeque;
import java.util.Deque;

public class TopVotedCandidate {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {2,0,1,1,1,1,1,1,1,1},
                {1,0,1,0,0,0,0,0,0,1},
                {1,0,1,0,1,1,1,1,0,1},
                {1,0,1,0,1,0,0,1,0,1},
                {1,0,1,0,1,0,0,1,0,1},
                {1,0,1,0,1,1,0,1,0,1},
                {1,0,1,0,0,0,0,1,0,1},
                {1,0,1,1,1,1,1,1,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1}
        };
        TopVotedCandidate solution = new TopVotedCandidate();
        System.out.println(solution.orangesRotting(grid));
    }
    int[][] Grid;
    int[][] grid;
    Deque<Integer[]> deque = new ArrayDeque<>();
    public int orangesRotting(int[][] grid) {
        this.grid=grid;
        //Grid=grid.clone();
        Grid=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2) BFS(i,j);
            }
        }
        int max =0 ;
        for(int i =0;i<grid.length;i++)
        {
            for(int j =0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    if(Grid[i][j]==0) return -1;
                    else  max=Math.max(max,Grid[i][j]);
                }
            }
        }
        return max;
    }
    void BFS(int i,int j){
        deque.add(new Integer[]{i,j,0});
        boolean[][] booleans = new boolean[grid.length][grid[0].length];
        while (deque.size()!=0)
        {
            Integer[] g =deque.pop();
            if(grid[g[0]][g[1]]==1){
               booleans[g[0]][g[1]]=true;
               if(Grid[g[0]][g[1]]==0) Grid[g[0]][g[1]]=g[2];
               else Grid[g[0]][g[1]]=Math.min(Grid[g[0]][g[1]],g[2]);
            }
            if(g[0]<grid.length-1&&grid[g[0]+1][g[1]]==1&&!booleans[g[0]+1][g[1]]) deque.add(new Integer[]{g[0]+1,g[1],g[2]+1});
            if(g[0]>0&&grid[g[0]-1][g[1]]==1&&!booleans[g[0]-1][g[1]])  deque.add(new Integer[]{g[0]-1,g[1],g[2]+1});
            if(g[1]<grid[0].length-1&&grid[g[0]][g[1]+1]==1&&!booleans[g[0]][g[1]+1]) deque.add(new Integer[]{g[0],g[1]+1,g[2]+1});
            if(g[1]>0&&grid[g[0]][g[1]-1]==1&&!booleans[g[0]][g[1]-1]) deque.add(new Integer[]{g[0],g[1]-1,g[2]+1});
        }
    }
}

 */

//优化了
package 刷题.leetcode.T944腐烂的橘子;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    int[][] Grid;
    int[][] grid;
    int num=0;
    public int orangesRotting(int[][] grid) {
        this.grid=grid;
        Grid=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1) num++;
                if(grid[i][j]==2) BFS(i,j);
            }
        }
        if(num!=0) return -1;
        int max =0 ;
        for (int[] G:Grid)
        {
            for (int g:G) max=Math.max(max,g);
        }
        return max;
    }
    void BFS(int i,int j){
        Deque<Integer[]> deque = new ArrayDeque<>();
        deque.add(new Integer[]{i,j,0});
        while (deque.size()!=0)
        {
            Integer[] g =deque.pop();
            if(grid[g[0]][g[1]]==1) {          //这个必须要留着 因为第一个deque是i和j那个腐烂的橘子 它不能进这里
                if (Grid[g[0]][g[1]] == 0) {
                    Grid[g[0]][g[1]] = g[2];
                    num--;
                } else Grid[g[0]][g[1]] = g[2];
            }
            if(g[0]<grid.length-1&&grid[g[0]+1][g[1]]==1&&(g[2]+1<Grid[g[0]+1][g[1]]||Grid[g[0]+1][g[1]]==0)) deque.add(new Integer[]{g[0]+1,g[1],g[2]+1});
            if(g[0]>0&&grid[g[0]-1][g[1]]==1&&(g[2]+1<Grid[g[0]-1][g[1]]||Grid[g[0]-1][g[1]]==0))  deque.add(new Integer[]{g[0]-1,g[1],g[2]+1});
            if(g[1]<grid[0].length-1&&grid[g[0]][g[1]+1]==1&&(g[2]+1<Grid[g[0]][g[1]+1]||Grid[g[0]][g[1]+1]==0)) deque.add(new Integer[]{g[0],g[1]+1,g[2]+1});
            if(g[1]>0&&grid[g[0]][g[1]-1]==1&&(g[2]+1<Grid[g[0]][g[1]-1]||Grid[g[0]][g[1]-1]==0)) deque.add(new Integer[]{g[0],g[1]-1,g[2]+1});
        }
    }
}