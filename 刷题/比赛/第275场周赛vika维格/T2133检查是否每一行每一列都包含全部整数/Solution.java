/*
简单 暴力过了
---------------------------------------------
不需要hashmap
因为是数独 所以 每一行每一列的和都相同 即 n!
判断和即可
-----------------------------------------------
上面是大嘘
===============================================
震惊 我之前通过的代码竟然过不了了 哈哈哈  223/224
输入:   [[3,2,3,2],[4,1,2,3],[2,4,3,1],[1,3,2,4]]
看来 不能用和方法呢
=================================================
用hashmap或数组吧

class Solution {
    public boolean checkValid(int[][] matrix) {
        int length = matrix.length;
        int[] array = new int[length + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
        for (int i = 0; i < matrix.length; i++) {
            int[] temp =Arrays.copyOf(matrix[i],length);
            if (!check(array, temp)) return false;
            for (int j = 0; j < matrix.length; j++) {
                temp[j] = matrix[j][i];
            }
            if (!check(array, temp)) return false;
        }
        return true;
    }

    private boolean check(int[] arr, int[] temp) {
        int[] a = Arrays.copyOf(arr, arr.length);
        for (int i : temp) {
            a[i]--;
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] != 0) return false;
        }
        return true;
    }
}
*/

package 刷题.比赛.第275场周赛vika维格.T2133检查是否每一行每一列都包含全部整数;

class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        int sum = 0;
        for(int i =1;i<=n;i++) sum+=i;
        for(int i =0;i<matrix.length;i++)
        {
            int s = 0;
            for(int j=0;j<matrix[i].length;j++)
            {
                s+=matrix[i][j];
                if(j>0&&matrix[i][j]==matrix[i][j-1]) return false;
            }
            if(s!=sum) return false;
        }
        for(int j =0;j<matrix[0].length;j++)
        {
            int s=0;
            for(int i =0;i<matrix.length;i++)
            {
                s+=matrix[i][j];
                if(i>0&&matrix[i][j]==matrix[i-1][j]) return false;
            }
            if(s!=sum) return false;
        }
        return true;
    }
}