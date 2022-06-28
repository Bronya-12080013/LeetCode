/*
啊不行了，这种粗暴的方法必会超时
反复试错后，发现Prime()的i大约要设80000才行
设太小不够demo用的
设太小会结果错
设太大超时
应该是方法错了
要不就是可以改进
======================================================
不愧标签为数学的题
看看答案
====================================================
懂了，db
=================================================
好好看看思想
 */

//大佬代码:


package 刷题.leetcode.剑指Offer49丑数;

class Solution {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}

// 作者：jyd 链接：https://leetcode-cn.com/problems/chou-shu-lcof/solution/mian-shi-ti-49-chou-shu-dong-tai-gui-hua-qing-xi-t/



/*
package 刷题.leetcode.剑指Offer49丑数;

import java.util.ArrayList;

public class Time {
    //测试
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    static int nthUglyNumber(int n) {
        ArrayList arrayList = new ArrayList();
        Prime(arrayList);
        for(int i =1;;i++) {
            if (demo(i,arrayList)) n--;
            if (n <= 0) return i;
        }
    }

    //判断这数是否合题意
    static boolean demo(int i,ArrayList arrayList){
    if(i==1) return true;
        for(int j =0;j<arrayList.size()&&j<i;j++)
        {
            if(i%(int)arrayList.get(j)==0) return false;
        }
        if(i%2==0||i%3==0||i%5==0) return true;
        return false;
    }

    //找素数
    static void Prime(ArrayList arrayList){
        for(int i = 2;i<80000;i++)                //找多少素数才够
        {
            if(i==2||i==3||i==5) continue;
            boolean flag =true;
            for(int j=2;j<i;j++)
            {
                if(i%j==0)
                {
                    flag=false;
                    break;
                }
            }
                if(flag) arrayList.add(i);
        }
    }
}
 */
