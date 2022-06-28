/*
成了 不愧是我   92.26% &&　19.49%
不过若不看标签 我好像也想不到用栈
写起来还是有点磕
1.那个while直接写就行了 刚开始我还写了if 后发现重复了
2.我是用队列Deque模拟栈 注意了 peek() 和 offer()都是队列的 要改成peekLast()和pollLast()
或者用纯纯的 peek() pop() push()
见: https://blog.csdn.net/gech0/article/details/121940345?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522164300327216780261947669%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=164300327216780261947669&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~baidu_landing_v2~default-1-121940345.first_rank_v2_pc_rank_v29&utm_term=ArrayDeque+pop+push&spm=1018.2226.3001.4187
while (!stack.isEmpty()&&temperatures[i]>stack.peek()[0])
                {
                    int[] day = stack.pop();
                    days[day[1]]=i-day[1];
                }
                stack.push(new int[]{temperatures[i],i});

 总之 ArrayDeque类 若用栈 ： 看顶值peek() 压栈push() 出栈pop()   它们都是相当于对头部元素操作的（就是对队列的头 而不是尾）
 若用队列 就用别的 不要混着用
 如  pop()相当poll()  pop()是操作栈的 poll()是操作队列的  但其实一样 都取头元素
 总之 用ArrayDeque类模拟栈就相当于用双端队列的头部来模拟栈 pop() //得到的是头部元素 push() //插入的也是头部
 */

package 刷题.leetcode.剑指OfferII038每日温度;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static void main(String[] args) {
        Solution solution =new Solution();
        solution.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i = 0;i<temperatures.length;i++)
        {
               // while (!stack.isEmpty()&&temperatures[i]>stack.peek()[0])
                while (!stack.isEmpty()&&temperatures[i]>stack.peekLast()[0])
                {
                    int[] day = stack.pollLast();
                    days[day[1]]=i-day[1];
                }
                stack.offer(new int[]{temperatures[i],i});
        }
        while (!stack.isEmpty()){
            int[] day = stack.poll();
            days[day[1]]=0;
        }
        return days;
    }
}

/* 暴力 过了 5.08% && 47.21%
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        for(int i =0;i<days.length;i++)
        {
            int result = 0;
            for(int j =i+1;j<temperatures.length;j++)
            {
                if(temperatures[j]>temperatures[i])
                {
                    result=j-i;
                    break;
                }
            }
            days[i]=result;
        }
        return days;
    }
}
 */