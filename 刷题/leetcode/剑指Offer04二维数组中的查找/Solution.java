/*
我先试水了一下暴力破解版
发现竟然达到了哈人的 100% 92.07%90(最高的一次) 。。。。什么玩意

然后用了二分查询
先用二分查找在最后一列找到比target大的位置，然后对下面的逐行进行二分查找
得 100% 94.26%
应该可以算半二分查找法？

去看看大佬的代码
————————————————————————————————————————————————————————————————————
秒啊啊啊啊啊啊啊啊啊啊啊啊啊
不愧是大佬
自己去网站看解析

思想：列最大和行最小的左下面比target，若小，这列不要了；若大，这行不要了
我写的时候，总想着控制变量，先解决一个方面，再解决另一方面
应该是两方面一起来搞的
不愧是“分治”

 */


package 刷题.leetcode.剑指Offer04二维数组中的查找;
/*

//试水法
class RangeFreqQuery {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
            for(int i=0;i<matrix.length;i++)
            {
                for(int j=0;j<matrix[0].length;j++)
                {
                    if(target==matrix[i][j])
                        return true;
                }
            }
            return false;
    }
}
*/

//正式版
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 14;
        System.out.println(findNumberIn2DArray(matrix, target));
    }
    static boolean findNumberIn2DArray(int[][] matrix, int target) {
        //处理特殊情况
        if(matrix.length==0||matrix[0].length==0)
            return false;

        //
        int i=0;
        int j=matrix.length-1;
        while (i<=j)
        {
            int m=(i+j)/2;
            if(matrix[m][matrix[0].length-1]<target) i=m+1;
            else j=m-1;
        }


        for(int h=i;h<matrix.length;h++)
        {   int k=0;
            j=matrix[0].length-1;
            while (k<=j){
                int m2=(k+j)/2;
                if(matrix[h][m2]<target) k=m2+1;
                else j=m2-1;
            }
            if(matrix[h][k]==target)
            {
                return true;
            }
        }
        return false;
    }
    }

    /*
    大佬代码;
    class RangeFreqQuery {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)
        {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
}

作者：jyd
链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/mian-shi-ti-04-er-wei-shu-zu-zhong-de-cha-zhao-zuo/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */