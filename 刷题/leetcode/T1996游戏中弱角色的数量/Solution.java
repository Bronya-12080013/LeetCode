/*
过了  93.55% && 5.24% 非常稳定

这题很简单 但对我挺麻烦的
吃了个麦片 有点糖分后才解开
原因是我对 “断层” 的不了解和害怕
一想到    int ack = properties[0][0],maxDef =-1,nextDef=-1; 和 开头层 四个元素叠加 脑子就乱了
另外 这题要理清思路 清楚到底要求什么 是弱角色的数量 弱角色就是弱角色 不是”谁是谁的弱角色“ 可以直接拿历代的最强者比
进入下一代后 最强者可能更新 也可能不更新
好好看看我的代码 也很有参考意义
================================================
官方代码
妙啊！！！
对ack大到小排 对相同ack的按照def小到大排 这样一次遍历就可以无所顾忌的比较maxDef了
!!!

class Solution {
    public static void main(String[] args) {
        int[][] p = new int[][]{{10,1},{5,1},{7,10},{4,1},{5,9},{6,9},{7,2},{1,10}};
        Solution solution = new Solution();
        System.out.println(solution.numberOfWeakCharacters(p));
    }
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> {
            return o1[0] == o2[0] ? (o1[1] - o2[1]) : (o2[0] - o1[0]);
        });
        int maxDef = 0;
        int ans = 0;
        for (int[] p : properties) {
            if (p[1] < maxDef) {
                ans++;
            } else {
                maxDef = p[1];
            }
        }
        return ans;
    }
}
 */

package 刷题.leetcode.T1996游戏中弱角色的数量;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[][] p = new int[][]{{10,1},{5,1},{7,10},{4,1},{5,9},{6,9},{7,2},{1,10}};
        Solution solution = new Solution();
        System.out.println(solution.numberOfWeakCharacters(p));
    }
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(a,b)->b[0]-a[0]); //这里不加比较方法会报错的哦
        int ack = properties[0][0],maxDef =-1,nextDef=-1;
        int sum=0;
        for(int i=0;i<properties.length;i++)
        {
            if(properties[i][0]!=ack) // if(i>0&&properties[i-1][0]>properties[i][0])
            {
                ack=properties[i][0];
                maxDef = Math.max(maxDef,nextDef);
                nextDef = -1;
            }
            if(properties[i][1]<maxDef) sum++;
            nextDef= Math.max(nextDef,properties[i][1]);
        }
        return sum;
    }
}
