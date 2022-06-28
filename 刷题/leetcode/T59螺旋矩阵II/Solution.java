package 刷题.leetcode.T59螺旋矩阵II;

import java.util.ArrayList;

//参加 T54螺旋矩阵   改一下就行了  100.00% && 67.77%
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int up = 0,down = matrix.length-1,l=0,r=matrix[0].length-1;
        ArrayList<Integer> list = new ArrayList<>();
        int num=1;
        while (true)
        {
            int i=up,j=l;
            for(;j<=r;j++)
            {
                matrix[i][j]=num;
                num++;
            }
            j--;  //注意这里  上面循环过头了 这里要回去
            up++;
            if(up>down) break;
            i=up;

            for(;i<=down;i++) {
                matrix[i][j]=num;
                num++;
            }
            i--; //注意这里  上面循环过头了 这里要回去
            r--;
            if(r<l) break;
            j=r;

            for (;j>=l;j--) {
                matrix[i][j]=num;
                num++;
            }
            j++; //注意这里  上面循环过头了 这里要回去
            down--;
            if(up>down) break;
            i=down;

            for(;i>=up;i--) {
                matrix[i][j]=num;
                num++;
            }
            i++; //注意这里  上面循环过头了 这里要回去
            l++;
            if(r<l) break;
            //j=l;  //没必要了 上面会调整的
        }
        return matrix;
    }
}