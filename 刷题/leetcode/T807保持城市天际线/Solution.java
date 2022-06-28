/*
几乎送饭的中等题    83.37% && 13.86%
 */

package 刷题.leetcode.T807保持城市天际线;

public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax = new int[grid.length];
        int[] colMax = new int [grid[0].length];
        for(int i =0;i<grid.length;i++)
        {
            for(int j =0;j<grid[0].length;j++)
            {
                rowMax[i]=Math.max(grid[i][j],rowMax[i]);
                colMax[j]=Math.max(grid[i][j],colMax[j]);
            }
        }
        int ans = 0;
        for(int i =0;i<grid.length;i++)
        {
            for(int j =0;j<grid[0].length;j++)
            {
                ans+=Math.min(rowMax[i],colMax[j])-grid[i][j];
            }
        }
        return ans;
    }
}
