/*
我的代码复杂了
可以一次遍历的 因为题目的条件很直接的 谁最大取谁 直接重置次数就行
==========================================================
官方代码
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int res = 0, maxLen = 0;
        for (int[] rectangle : rectangles) {
            int l = rectangle[0], w = rectangle[1];
            int k = Math.min(l, w);
            if (k == maxLen) {
                ++res;
            } else if (k > maxLen) {
                res = 1;
                maxLen = k;
            }
        }
        return res;
    }
}
 */
package 刷题.leetcode.T1725可以形成最大正方形的矩形数目;

import java.util.Arrays;

//29.37% && 5.59%
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int[] res = new int[rectangles.length];
        for(int i=0;i<rectangles.length;i++) res[i]=Math.min(rectangles[i][0],rectangles[i][1]);
        Arrays.sort(res);
        int nums=0,maxLen=res[res.length-1];
        for (int i=res.length-1;i>=0&&res[i]==maxLen;i--) nums++;
        return nums;
    }
}