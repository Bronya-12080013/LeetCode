/*
这题摆了 优先队列实在不熟 正好学习一下
=================================================
需要使用优化的表示法。可以在优先队列中存储二元组，
每个二元组表示苹果的腐烂日期和在该日期腐烂的苹果个数
https://leetcode-cn.com/problems/maximum-number-of-eaten-apples/
==========================================================
官方答案:
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int n = apples.length;
        int i = 0;
        while (i < n) {
            while (!pq.isEmpty() && pq.peek()[0] <= i) {
                pq.poll();
            }
            int rottenDay = i + days[i];
            int count = apples[i];
            if (count > 0) {
                pq.offer(new int[]{rottenDay, count});
            }
            if (!pq.isEmpty()) {
                int[] arr = pq.peek();
                arr[1]--;
                if (arr[1] == 0) {
                    pq.poll();
                }
                ans++;
            }
            i++;
        }
        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && pq.peek()[0] <= i) {
                pq.poll();
            }
            if (pq.isEmpty()) {
                break;
            }
            int[] arr = pq.poll();
            int curr = Math.min(arr[0] - i, arr[1]);
            ans += curr;
            i += curr;
        }
        return ans;
    }
}
 */
package 刷题.leetcode.T1705吃苹果的最大数目;

import java.util.PriorityQueue;

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]); //0是过期日期 1是剩余数量
        int i =0,ans = 0;   //i是天数 ans是能吃苹果的天数（看题目，不是每天都能吃苹果的）
        while (i<days.length)
        {
            while (!pq.isEmpty()&&pq.peek()[0]<=i) pq.poll();  //i是从0开始的 当pq.peek()[0]==i时就已经超天数了  //用while一直去除不要的
            if(apples[i]>0) pq.offer(new int[]{i+days[i],apples[i]});     //存储的是日期 不是剩余天数
            if(!pq.isEmpty()){
                int[] arr = pq.peek();                          //这里很重要 是替身攻击！！！  int[] arr = pq.peek(); 可以让int[] arr代理pg.peek()
                arr[1]--;                                       //因为下面每次都判断 if(arr[1]==0) 所以不必担心它已经为0了
                if(arr[1]==0) pq.poll();
                ans++;
                /*
                也可以
                pq.peek()[1]--;
                if(pq.peek()[1]==0) pq.poll();
                ans++;
                 */
            }
            i++;
        }
        //处理苹果数不结果之后的日子
        while (!pq.isEmpty())
        {
            while (!pq.isEmpty()&&pq.peek()[0]<i) pq.poll();
            if(pq.isEmpty()) break;
            int[] arr = pq.poll();
            int curr = Math.min(arr[0]-i,arr[1]);
            ans+=curr;
            i+=curr;
        }
        return ans;
    }
}
