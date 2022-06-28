package 刷题.leetcode.T55跳跃游戏;

import java.util.ArrayDeque;
import java.util.Queue;

//平角库（  11.14% && 11.52%
class Solution {
    public boolean canJump(int[] nums) {
        if(nums[0]>=nums.length-1) return true; //应对特殊情况 num[1]{0}
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[nums.length];
        queue.add(0);
        vis[0]=true;
        while (!queue.isEmpty())
        {
            int index = queue.poll();
            int jump = nums[index];
            for(int i=1;i<=jump;i++)
            {
                int newLefIndex = index-i;
                int newRigIndex = index+i;
                if(newLefIndex>=0&&!vis[newLefIndex])
                {
                    queue.add(newLefIndex);
                    vis[newLefIndex]=true;
                }
                if(newRigIndex>= nums.length-1) return true;  //这里注意题目要求
                else if(!vis[newRigIndex]){
                    queue.add(newRigIndex);
                    vis[newRigIndex]=true;
                }
            }
        }
        return false;
    }
}
/*
贪心就行
这不是乱跳的(某题是num[i]是可以跳向的下标)
它是有一个范围的
用贪心就好 慢慢扩大范围

public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */