package 刷题.leetcode.T1672最富有客户的资产总量;

class Solution {
    public int maximumWealth(int[][] accounts) {
        int sum,max=Integer.MIN_VALUE;
        for(int i=0;i<accounts.length;i++){
            sum = 0;
            for(int j=0;j<accounts[0].length;j++) sum+=accounts[i][j];
            max=Math.max(max,sum);
        }
        return max;
    }
}