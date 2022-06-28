//https://leetcode-cn.com/problems/rotate-image/
package 刷题.leetcode.T48旋转图像;

/*
方法一 数学法
顺时针 一下是顺时针的方法 其他方向自己修改
记就完事了 考虑四个角 和它们接下来的走向
(若第一组是左上角(0,0) 它转到（0，n-1） 则下一组就是（0，1） 到 （1，n-1）  那么第一组是（0，0） 第二组是（0，1） 就是i不变 j变 ；看看对应的 （0，n-1）和 （1，n-1）)
（我们就猜出了matrix[i][j]=matrix[n-j-1][i]; 但当j变i不变时 [n-j-1]变 而 [i] 不变）
看 横 纵 那个变 那个不变
然后 把 i j n-i-1 n 一一放入 就那么几个
 */
class Solution {
    public void rotate(int[][] matrix) { //是正方形
        int n = matrix.length;
        for(int i=0;i<n/2;i++)
        {
            for(int j=0;j<(n+1)/2;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=temp;
            }
        }
    }
}
/*
方法二 用翻转代替旋转
顺时针旋转  相当于  水平翻转（上下翻）+主对角线翻转

代码
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

 */