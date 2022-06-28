/*
困难的每日一题
贪心
注意 自定义排序的写法
 */

package 刷题.leetcode.T630课程表III;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->(a[1]-b[1]));  //这里是顺序排序  小到大
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b)->(b-a));  //不加泛型是不行的 若不确定a,b类型就不可b-a //这里是逆序排序 大到小
        int total = 0;
        for(int[] course:courses){
            int ti = course[0],di=course[1];
            if(total+ti<=di){
                total+=ti;
                queue.add(ti);
            }else if(!queue.isEmpty()&&ti<queue.peek())
            {
                total=total-queue.poll()+ti;
                queue.add(ti);
            }
        }
        return queue.size();
    }
}
