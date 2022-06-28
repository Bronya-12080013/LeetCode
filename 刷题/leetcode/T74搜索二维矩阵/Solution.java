/*
用了两个屑方法
注意 二版 画蛇添足版中:
 if(arr[l]==target) return true;  要有!!!

 也可以用
 while (l < r) {
                int m = l + (r - l + 1) / 2;
                if (arr[m] <= target) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
        if(arr[l]==target) return true;
==========================================================
哈哈哈哈哈经历千辛万苦写出来了
二维数组的二分查找
走了很多弯路 就不赘述了
总之 要分清横纵坐标
matrix[m/col][m%col]
 */



/* 一版暴力版 过了 100.00% &&  29.34% (人品爆发93.88%)
package 刷题.leetcode.T74搜索二维矩阵;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i =0 ; i<matrix.length;i++)
        {
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j]==target) return true;
            }
        }
        return false;
    }
}
 */


/* 二版 画蛇添足版
package 刷题.leetcode.T74搜索二维矩阵;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60},
        };
        int target = 3;
        Solution solution =new Solution();
        System.out.println(solution.searchMatrix(matrix,target));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int [] arr = new int[matrix.length*matrix[0].length];
        int count = 0;
        for(int i =0 ; i<matrix.length;i++)
        {
            for(int j =0;j<matrix[0].length;j++){
                arr[count++]=matrix[i][j];
            }
        }
        int l=0,r=arr.length-1;
        while (l<r){
            int mid = l+(r-l)/2;
            if(arr[mid]<target) l=mid+1;
            else if(target<arr[mid]) r = mid-1;
            else return true;
        }
        if(arr[l]==target) return true;  要有!!!

        // 也可以用
    //   while (l < r) {
    //           int m = l + (r - l + 1) / 2;     //注意这里 不然下面的 i=m会卡住的
    //           if (arr[m] <= target) {
    //               l = m;
    //           } else {
    //               r = m - 1;
    //           }
    //       }
    //   if(arr[l]==target) return true;

        return false;
    }
}
 */

package 刷题.leetcode.T74搜索二维矩阵;

public class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int l =0,r=matrix.length*matrix[0].length-1;
            // int row = matrix.length; 不需要
            int col = matrix[0].length;
            while (l<r){
                int m = l+(r-l)/2;
                //int i =m/col;   优化
               // i=(i==0)?0:i-1;   之前过界了 这是多方面的原因 误判了才写这条  //之前把i当成横坐标了  //因为这条的误判才导致了一系列错误 本来没那么复杂的
               // int j =m%col;  优化
                int mid = matrix[m/col][m%col]; //本来就这样 因为他俩搞反了 才整出去搞了半天
                if(mid<target)  l=m+1;
                else if(target<mid) r = m-1;
                else return true;
            }
            //if(row==1&&col==1) return matrix[0][0]==target;  这是多方面的原因 误判了错误才写这条
            //if(target>matrix[row-1][col-1]) return false;    这是多方面的原因 误判了才写这条
            if(matrix[l/col][l%col]==target) return true;
            return false;
        }
}
