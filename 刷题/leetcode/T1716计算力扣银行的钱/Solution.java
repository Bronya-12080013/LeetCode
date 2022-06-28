/*
暴力计算
======================================
官方法 每天存的钱等于 \textit{week} + \textit{day} - 1week+day−1
class Solution {
    public int totalMoney(int n) {
        int week = 1, day = 1;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            res += week + day - 1;
            ++day;
            if (day == 8) {
                day = 1;
                ++week;
            }
        }
        return res;
    }
}
 */

package 刷题.leetcode.T1716计算力扣银行的钱;

class Solution {
    public static void main(String[] args) {
        System.out.println(totalMoney(20));
    }
    static int totalMoney(int n) {
        int num=1,sum=0;
        for(int i =0;i<n/7;i++)
        {
            sum+=num*7+21;
            num+=1;
        }
        for(int i=0;i<n%7;i++)
        {
            sum+=num;
            num+=1;
        }
        return sum;
    }
}