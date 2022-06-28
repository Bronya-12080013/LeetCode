/*
简单的题
也有要注意的
1. 是n！=1
2. if((n&1)==0) 用位运算是要括号的 应该是优先级问题
==============================================
方法二
在每一场比赛中，输的队伍无法晋级，且不会再参加后续的比赛。由于最后只决出一个获胜队伍，因此就有 n-1n−1 个无法晋级的队伍，也就是会有 n-1n−1 场比赛。

class Solution {
    public int numberOfMatches(int n) {
        return n - 1;
    }
}

 */
package 刷题.leetcode.T1688比赛中的配对次数;

class Solution {
    public int numberOfMatches(int n) {
        int sum=0;
        while (n!=1)  //注意是 n！=1
        {
            if((n&1)==0) {
                sum+=n/2;
                n=n/2;
            }
            else {
                sum+=(n-1)/2;
                n=(n-1)/2+1;
            }
        }
        return sum;
    }
}