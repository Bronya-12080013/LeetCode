/*
这题好难啊 评论区也很难 我看答案了
=========================================
主要是分析
然后直接可以统计推出答案了
不会是模拟的 毕竟两人是理智的 那么一定可以由那组石头推出结果！
https://leetcode-cn.com/problems/stone-game-ix/solution/shi-zi-you-xi-ix-by-leetcode-solution-kk5f/

 */

package 刷题.leetcode.T2029石子游戏IX;

import sun.net.RegisteredDomain;

import java.util.Random;

class Solution {
    public boolean stoneGameIX(int[] stones) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int val : stones) {
            int type = val % 3;
            if (type == 0) {
                ++cnt0;
            } else if (type == 1) {
                ++cnt1;
            } else {
                ++cnt2;
            }
        }
        if (cnt0 % 2 == 0) {
            return cnt1 >= 1 && cnt2 >= 1;
        }
        return cnt1 - cnt2 > 2 || cnt2 - cnt1 > 2;
    }
}

/*  玄学法  欧气够 acall
class Solution {
    public boolean stoneGameIX(int[] stones) {
        return Math.random()<0.5 ? true:false;
    }
}
 */