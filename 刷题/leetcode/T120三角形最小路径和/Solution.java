/*
简单 13.71% && 53.71%
但效率不高
今天晚了 明天再看
===============================================================
官方代码: 动态规划
class TopVotedCandidate {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }
}
=======================================================================
是不是我的get()方法调得太多了 效率才低的
========================================================================
答案:  动态规划 + 空间优化   这个妙啊 只把上一行给搞下来即可
class TopVotedCandidate {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }
}
===========================================================================
还有自底向上的方法！！！！！！！！！！！！！！！！！
 */
package 刷题.leetcode.T120三角形最小路径和;

import java.util.List;

public class Solution {
  // public static void main(String[] args) {
  //     List<List<Integer>> triangle = new ArrayList<>();
  //     List<Integer> list1 = new ArrayList<>();
  //     list1.add(2);
  //     List<Integer> list2 = new ArrayList<>();
  //     list2.add(3);
  //     list2.add(4);
  //     List<Integer> list3 = new ArrayList<>();
  //     list3.add(6);
  //     list3.add(5);
  //     list3.add(7);
  //     List<Integer> list4 = new ArrayList<>();
  //     list4.add(4);
  //     list4.add(1);
  //     list4.add(8);
  //     list4.add(3);
  //     triangle.add(list1);
  //     triangle.add(list2);
  //     triangle.add(list3);
  //     triangle.add(list4);
  //     TopVotedCandidate solution =new TopVotedCandidate();
  //     solution.minimumTotal(triangle);
  // }
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] arr = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        int max = Integer.MAX_VALUE;
        for(int i=0;i<triangle.size();i++)
        {
            for (int j =0;j<triangle.get(i).size();j++)
            {
                arr[i][j]=triangle.get(i).get(j);
                if(i>0)
                {
                    if(j==0) arr[i][j]=arr[i-1][0]+arr[i][0];
                    else if(j==triangle.get(i).size()-1) arr[i][j]=arr[i-1][triangle.get(i-1).size()-1]+arr[i][triangle.get(i).size()-1];
                    else arr[i][j]=Math.min(arr[i-1][j-1]+arr[i][j],arr[i-1][j]+arr[i][j]);
                }
                if(i==triangle.size()-1) max=Math.min(max,arr[i][j]);
            }
        }
        return max;
    }
}
