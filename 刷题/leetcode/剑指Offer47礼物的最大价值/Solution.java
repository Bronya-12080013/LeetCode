/*
ohhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
我做出来了！！！！！！！中等难度的题目！！！！！！！！！！！！！！！！！！！！！！！
主教万岁！！！！(现在背景用的是风浦可符香那张“嘘”的图片)
刚开始知道用动态规划，但还是不知道怎么下手，去看大佬答案，刚看到一个dp[i][j],就马上有了想法
不必局限于右下角的那个格子，对每一个格子下手
======================================================================
我的答案是 41.90%&23.69%  显然不是最优解法
去看看大佬的
========================================================================
优化方法很简单：
当 gridgrid 矩阵很大时， i = 0i=0 或 j = 0j=0 的情况仅占极少数，相当循环每轮都冗余了一次判断。因此，可先初始化矩阵第一行和第一列，再开始遍历递推。

class RangeFreqQuery {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int j = 1; j < n; j++) // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        for(int i = 1; i < m; i++) // 初始化第一列
            grid[i][0] += grid[i - 1][0];
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
        return grid[m - 1][n - 1];
    }
}
 */
package 刷题.leetcode.剑指Offer47礼物的最大价值;

class Solution {
    public static void main(String[] args) {
        int[][] s={{1,2},{5,6},{1,1}};
        int a=maxValue(s);
    }
    static int maxValue(int[][] grid) {
        for(int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                if(i!=0&&j!=0)
                    grid[i][j]+=Math.max(grid[i-1][j],grid[i][j-1]);
                else if(i==0&&j!=0)
                    grid[i][j]+=grid[i][j-1];
                else if(i!=0&&j==0)
                    grid[i][j]+=grid[i-1][j];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
