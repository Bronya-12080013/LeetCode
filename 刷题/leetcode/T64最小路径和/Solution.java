/*
这中等题过于简单了  96.07% && 5.01%
 */
package 刷题.leetcode.T64最小路径和;

class Solution {
    public static void main(String[] args) {
        int[][] grid=new int[][]{
                {1,3,1},{1,5,1},{4,2,1}
        };
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {
        for(int j=1;j<grid[0].length;j++) grid[0][j]+=grid[0][j-1];
        for(int i=1;i<grid.length;i++) grid[i][0]+=grid[i-1][0];
        for(int i=1;i<grid.length;i++)
        {
            for(int j=1;j<grid[0].length;j++)
            {
                grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}