//2022/1/1 每日一题！

/*
写完了 我只能说好好看题目
========================================================
官方代码，方法:
arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
          从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束。
          从src的下标srcPos到srcPos+length 复制到 dest 的 destPos 到 destPos+length 处
          length是公用的

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < original.length; i += n) {   //注意 是 i += n
            System.arraycopy(original, i, ans[i / n], 0, n);    // ans[i/n]是行  i/n是行的下标
        }
        return ans;
    }
}

 */
package 刷题.leetcode.T2022将一维数组转变成二维数组;

public class Solution {
    public static void main(String[] args) {
        construct2DArray(new int[]{1,2},1,1);
    }
    static int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length!=n*m) return new int[][]{};  //好好看题目 m,n不一定给合适的
        int [][] ans = new int[m][n];
        int count = 0;
        for(int i =0;i<original.length;i++)
        {
            if(i>=m*n) break;
            if(i!=0&&i%n==0) count++;
            ans[count][i%n]=original[i];
        }
        return ans;
    }
}
