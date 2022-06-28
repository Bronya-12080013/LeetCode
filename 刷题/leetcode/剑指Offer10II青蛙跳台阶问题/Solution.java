package 刷题.leetcode.剑指Offer10II青蛙跳台阶问题;
//建议本题多写几次
/*
超时
这是递归，有大量重复的递归计算
class RangeFreqQuery {
    public int numWays(int n) {
        if(n==1||n==0) return 1;
        return numWays(n-1)+numWays(n-2);
    }
}
 */


/*
用斐波那契数列性质
大佬代码
 */
class Solution {
    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            b = a;
            a = sum;
        }
        return b;
    }
}

/*
作者：jyd
        链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/solution/mian-shi-ti-10-ii-qing-wa-tiao-tai-jie-wen-ti-dong/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */