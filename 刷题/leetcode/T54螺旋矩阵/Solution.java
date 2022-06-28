package 刷题.leetcode.T54螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

//小心仔细！  100.00% && 54.04%
class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        spiralOrder(matrix);
    }
    static public List<Integer> spiralOrder(int[][] matrix) {
        int up = 0,down = matrix.length-1,l=0,r=matrix[0].length-1;
        ArrayList<Integer> list = new ArrayList<>();
        int i=up,j=l;
        while (true)
        {
            for(i=up,j=l;j<=r;j++) list.add(matrix[i][j]);
            j--;  //注意这里  上面循环过头了 这里要回去
            up++;
            if(up>down) break;
            i=up;

            for(;i<=down;i++) list.add(matrix[i][j]);
            i--; //注意这里  上面循环过头了 这里要回去
            r--;
            if(r<l) break;
            j=r;

            for (;j>=l;j--) list.add(matrix[i][j]);
            j++; //注意这里  上面循环过头了 这里要回去
            down--;
            if(up>down) break;
            i=down;

            for(;i>=up;i--) list.add(matrix[i][j]);
            i++; //注意这里  上面循环过头了 这里要回去
            l++;
            if(r<l) break;
            //j=l;  //没必要了 上面会调整的
        }
        return list;
    }
}