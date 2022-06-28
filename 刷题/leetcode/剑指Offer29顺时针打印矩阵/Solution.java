package 刷题.leetcode.剑指Offer29顺时针打印矩阵;

/*
不写了
（这个方法应该是可行的，就是麻烦，不改了）
======================================
懂了，才设两个怎么够(rowlength,columnlength),多设几个，设四个
我看了答案，再自己写写
=========================================
看着简单，真要写就很麻烦
========================================


 */


/*
package 刷题.leetcode.剑指Offer29顺时针打印矩阵;

import java.util.ArrayList;

public class RangeFreqQuery {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int rowlength=matrix[0].length;
        int row=matrix[0].length;
        int columnlength=matrix.length;
        int column=matrix.length;
        int nums=rowlength*columnlength;
        ArrayList arrayList =new ArrayList();
        int ii=0,jj=0;
        while (nums!=0){
            for(int j=jj+1;j<rowlength+1;j++)
            {
                arrayList.add(matrix[ii][j]);
                nums--;
            }
            columnlength--;
            jj+=rowlength-1;
            for(int i=ii+1;i<columnlength+1;i++){
                arrayList.add(matrix[i][jj]);
                nums--;
            }
            rowlength--;
            ii+=columnlength-1;
            for(int j=jj+1;j>row-rowlength;j--){
                arrayList.add(matrix[ii][j]);
                nums--;
            }
            columnlength--;
            jj-=rowlength-1;
            for(int i =ii+1;i>column-columnlength;i--)
            {
                arrayList.add(matrix[i][jj]);
                nums--;
            }
            rowlength--;
            ii+=columnlength-1;
        }
        int[] n=new int[arrayList.size()];
       for(int i=0;i<arrayList.size();i++)
       {
           n[i]=(int)arrayList.get(i);
       }
       return n;
    }
}
 */


//好好看看，设四个标志，看看break的条件！！！
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int t=0,l=0,r=matrix[0].length-1,b=matrix.length-1,x=0;
        int[] array =new int[matrix.length*matrix[0].length];
        while (true){
            for (int j=l;j<=r;j++) array[x++]=matrix[t][j];
            if(++t>b) break;
            for(int i=t;i<=b;i++) array[x++]=matrix[i][r];
            if(--r<l) break;
            for(int j=r;j>=l;j--) array[x++]=matrix[b][j];
            if(--b<t) break;
            for(int i=b;i>=t;i--) array[x++]=matrix[i][l];
            if(++l>r) break;
        }
        return array;
    }
}
