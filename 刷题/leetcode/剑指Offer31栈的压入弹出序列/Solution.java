/*
:中等题，这不行吧
.......
:说不定可以
:也许可以
:可以可以
:可以
💡!
:或许..可以吧
 */

/*
过了 85.69% && 60.05%
就是写着麻烦，为了判断stack是否为空和i，j是否过界，打了很多补丁
==================================================
我和大佬思路一样，是我的实现较为繁琐
不必急着入栈，一个个来，每次都视图用popped一波清了


class RangeFreqQuery {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
作者：jyd
链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/solution/mian-shi-ti-31-zhan-de-ya-ru-dan-chu-xu-lie-mo-n-2/
 */

package 刷题.leetcode.剑指Offer31栈的压入弹出序列;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] pushed =new int[]{8,9,2,3,7,0,5,4,6,1};
        int[] popped = new int[]{6,8,2,1,3,9,0,7,4,5};
        System.out.println(validateStackSequences(pushed,popped));
    }
    static boolean validateStackSequences(int[] pushed, int[] popped) {
        int i=0,j=0;
        Stack stack = new Stack();
        while (true){
            boolean flag =false;
            if(i>=pushed.length&&j>=popped.length) break;
            if(i<pushed.length)
            {
                while (pushed[i]!=popped[j]){
                    stack.push(pushed[i]);
                    i++;
                    if(i>=popped.length) break;
                };
                if(i<pushed.length)
                {
                    stack.push(pushed[i]);
                    i++;
                }

            }
            while (popped[j]==(int)stack.peek()) {
                flag=true;
                stack.pop();
                j++;
                if(j>=popped.length) break;
                if(stack.size()==0) break;
            }
            if(!flag) break;
        }
        if(stack.size()==0) return true;
        else return false;
    }
}
