/*
啊啊啊啊啊啊啊啊这题写得乱七八糟 磨了好久边界判断
但好歹写出来了 23.76% && 82.18% (人气爆发 82.67% && 96.53%)
我感觉思路就有问题 就不想优化它了
===========================================================
官方DFS
public class TopVotedCandidate {

        public int[][] colorBorder(int[][] grid, int row, int col, int color) {
            int m = grid.length, n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            List<int[]> borders = new ArrayList<>();
            int originalColor = grid[row][col];
            visited[row][col] = true;
            dfs(grid, row, col, visited, borders, originalColor);
            for (int i = 0; i < borders.size(); i++) {
                int x = borders.get(i)[0], y = borders.get(i)[1];
                grid[x][y] = color;
            }
            return grid;
        }

        private void dfs(int[][] grid, int x, int y, boolean[][] visited, List<int[]> borders, int originalColor) {
            int m = grid.length, n = grid[0].length;
            boolean isBorder = false;
            int[][] direc = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int i = 0; i < 4; i++) {
                int nx = direc[i][0] + x, ny = direc[i][1] + y;
                if (!(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == originalColor)) {
                    isBorder = true;
                } else if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(grid, nx, ny, visited, borders, originalColor);
                }
            }
            if (isBorder) {
                borders.add(new int[]{x, y});
            }
        }
    }
======================================================================================
总结
1.官方并不急着修改 而是先把边界值用borders记下来
等全记入完了 再统一修改 这样好判断多了
而我是变判断它是不是边界值 边修改 所以判断的难度很大
总之我的很乱 真亏我写得出来
2.for (int i = 0; i < 4; i++)有四个循环 不要认为
if（）else if() 在if结束了边界值就无法扩展
对边界值 四个循环中 达成边界条件的会在if结束 而达不成边界条件的回去到else if的
 */


package 刷题.leetcode.T1034边界着色;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{
                {2,1,1},
                {2,1,1},
                {2,1,2}
        };
        int row = 1;
        int col = 1;
        int color = 3;
        System.out.println(solution.colorBorder(grid,row,col,color));
    }
    int[][] grid;
    int color;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.grid=grid;
        this.color= color;
        int[][] G = new int[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++)
            {
                if(grid[i][j]==grid[row][col])
                G[i][j]=grid[i][j];
            }
        }
        int gcolor = grid[row][col];
        DFS(row,col,grid[row][col]);
        for (int i=1;i<grid.length-1;i++)
        {
            for(int j =1;j<grid[0].length-1;j++)
            {
                if(grid[i][j]==color&&G[i][j]!=0)
                if(G[i-1][j]!=0&&G[i+1][j]!=0&&G[i][j-1]!=0&&G[i][j+1]!=0)
                    grid[i][j]=G[i][j];
            }
        }
        return grid;
    }

    Boolean DFS(int i ,int j,int gcolor)
    {
    if(gcolor==color) return false;
        if(i<0||i>grid.length-1||j<0||j>grid[0].length-1) return true;  //这两个合起来就和官方的判断一样
        if(grid[i][j]!=gcolor) return true;
        if(grid[i][j]==gcolor){
            if(i<grid.length) {
                if(DFS(i+1,j,gcolor)){
                    grid[i][j]=color;
                };
            }

            if(i>0){
                if(DFS(i-1,j,gcolor)){
                    grid[i][j]=color;
                }
            }

            if(j<grid[0].length)
            {
                if(DFS(i,j+1,gcolor)){
                    grid[i][j]=color;
                };
            }

            if(j>0){
                if(DFS(i,j-1,gcolor)){
                    grid[i][j]=color;
                };
            }
        }
        return false;
    }
}
