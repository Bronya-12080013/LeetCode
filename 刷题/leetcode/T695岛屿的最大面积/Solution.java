/*
hhh写出来了 99.93%(人品爆发 时而49.63%) && 57.69%（时而84.77%）
===================================================
其实不用 static boolean[][] booleans;嘛 直接沉岛就好了 把 grid位的1改成0就行
=====================================================
感觉dfs返回值 已经可以靠感觉掌握了 但仔细理理 真不敢说下一次一定会写得出
=====================================================
大佬代码:  也可以再克隆一份grid了 直接改也不太好
class TopVotedCandidate {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }
        return res;
    }
    // 每次调用的时候默认num为1，进入后判断如果不是岛屿，则直接返回0，就可以避免预防错误的情况。
    // 每次找到岛屿，则直接把找到的岛屿改成0，这是传说中的沉岛思想，就是遇到岛屿就把他和周围的全部沉默。
    // ps：如果能用沉岛思想，那么自然可以用朋友圈思想。有兴趣的朋友可以去尝试。
    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs(i + 1, j, grid);
        num += dfs(i - 1, j, grid);
        num += dfs(i, j + 1, grid);
        num += dfs(i, j - 1, grid);
        return num;

    }
}

 */

package 刷题.leetcode.T695岛屿的最大面积;

public class Solution {
    static int[][] grid;
    static boolean[][] booleans;
    int max=0;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid=grid;
        booleans =new boolean[grid.length][grid[0].length];

        for(int i =0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(!booleans[i][j]&&grid[i][j]==1)
                {
                    int nums=0;
                    nums=dfs(i,j,nums);
                    max=Math.max(max,nums);
                    //max=Math.max(max,dfs(i,j,nums)); //可以合写
                }
            }
        }
        return max;
    }
    static int dfs(int sr,int sc,int num)
    {
        if(booleans[sr][sc]==true) return num;
        if(grid[sr][sc]==0)
        {
            return num;
        }else {
            num++;
            booleans[sr][sc]=true;
            if(sr>0) num=dfs(sr-1,sc,num);  //上
            if(sr<grid.length-1) num=dfs(sr+1,sc,num);
            if(sc>0) num=dfs(sr,sc-1,num);
            if(sc<grid[0].length-1) num=dfs(sr,sc+1,num);
        }
        return num;
    }
}
