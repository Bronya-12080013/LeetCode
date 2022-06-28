package 刷题.leetcode.T73矩阵置零;
import java.util.ArrayList;


/*区别
boolean是基本数据类型
Boolean是它的封装类
 */

//竟然过了 37.30% && 44.56%
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean flag;
        ArrayList<int[]> arrayList = new ArrayList<>();
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0) arrayList.add(new int[]{i,j});
            }
        }
        for(int i=0;i<arrayList.size();i++)
        {
            int [] arr = arrayList.get(i);
            zero(matrix,arr[0],arr[1]);
        }
    }
    static void zero(int[][] matrix,int i,int j)
    {
        for(int c=0;c<matrix[0].length;c++) matrix[i][c]=0;
        for(int r=0;r<matrix.length;r++) matrix[r][j]=0;
    }
}


/* 不行 没标记
可能把同行列的0直接吞了
class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);

    }
    static boolean[][] vis;
    static public void setZeroes(int[][] matrix) {
        vis = new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0&&!vis[i][j]) zero(matrix,i,j);
            }
        }
    }

    static void zero(int[][] matrix,int i,int j)
    {
        for(int c=0;c<matrix[0].length;c++)
        {
            matrix[i][c]=0;
            vis[i][c]=true;
        }
        for(int r=0;r<matrix.length;r++)
        {
            matrix[r][j]=0;
            vis[r][j]=true;
        }
    }
}
 */
/*
官方方法
自己悟、
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/set-matrix-zeroes/solution/ju-zhen-zhi-ling-by-leetcode-solution-9ll7/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */


