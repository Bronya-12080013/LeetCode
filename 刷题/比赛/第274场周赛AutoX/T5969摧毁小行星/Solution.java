/*
弱智广告题
用贪心 即从小到大一个个吞噬即可
我先用int 结果58/66 解答错误
判断是数太大了
改成long就行了 就行了!就这也配称中等题
=============================================
不知道有没用别的写法
有! 大佬写的:
如果使用基于比较的排序,那么复杂度是O(n\log n)O(nlogn)的.
但是排序不是必须的,考虑将所有值按[1,2),[2,4),[2^i,2^{i+1}],⋯分组,按顺序考虑所有非空的组,
如果当前mass小于组内最小值,那么答案是false;
如果当前mass大于等于组内最小值,那么加上最小值之后必然大于组内所有值,所以可以直接加上组内所有值.
作者：Heltion
链接：https://leetcode-cn.com/problems/destroying-asteroids/solution/yi-chong-xian-xing-zuo-fa-by-heltion-i6y4/

就是不知道java怎么实现
 */

package 刷题.比赛.第274场周赛AutoX.T5969摧毁小行星;

import java.util.Arrays;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long mas =(long) mass;
        for(int i =0;i<asteroids.length;i++)
        {
            long as  =asteroids[i];
            if(mas<as) return false;
            else mas+=as;
        }
        return true;
    }
}