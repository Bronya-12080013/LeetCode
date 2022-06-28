/*
试水版过了，果然暴力是最方便的手段
下面试试别的方法
看了书中的方法
真是简明的思路
动态规划的思想
总之，我的着眼点是那两个数的确定，实践上没有必要，只要把最小的那个差值保留下来，并不断对比即可
仔细看题，直视目标
====================================================
？？？
让我看看那 1.4% 是什么
===================================================
大佬版，思路差不多，但更简洁了
class RangeFreqQuery {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}

还是过不了 1.4%
 */


package 刷题.leetcode.剑指Offer63股票的最大利润;
/*
class RangeFreqQuery {
    public static void main(String[] args) {
        int[] e={2,4,1};
        int s =maxProfit(e);
    }
    static int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int mum=0;
        int min=prices[0];
        int l=0;
        for(int i=0;i<prices.length-1;i++)
        {
            if(min>prices[i])
            {
                min =prices[i];
                l=i;
            }

            for(int j=prices.length-1;j>0;j--)
            {
                if((mum<prices[j]-min)&&l<j)
                    mum=prices[j]-min;
            }
        }
        return mum;
    }
}
 */

//成功了 98.60% & 57.11%
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2)
            return 0;
        int min=prices[0];
        int maxDiff=prices[1]-min;
        for(int i=2;i<prices.length;i++)
        {
            if(min>prices[i-1])
                min=prices[i-1];
            int currDiff=prices[i]-min;
            if(maxDiff<currDiff)
                maxDiff=currDiff;
        }
        if(maxDiff<0) return 0;
        else return maxDiff;
    }
}