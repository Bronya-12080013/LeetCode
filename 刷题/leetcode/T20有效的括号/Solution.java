/*
过了
 */

package 刷题.leetcode.T20有效的括号;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

class Solution {
    public static void main(String[] args) {
        Solution solution =new Solution();
        System.out.println(solution.isValid("()"));
    }
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c: s.toCharArray())
        {
            if(c=='('||c=='{'||c=='[') stack.push(c);
            else {
                if(stack.isEmpty()) return false;  //注意判断非空
                if(c==')'&&stack.peek()=='(') stack.pop();
                else if(c=='}'&&stack.peek()=='{') stack.pop();
                else if(c==']'&&stack.peek()=='[') stack.pop();
                else return false;
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}

/* 思路错了 括号间不能混用 如 ([)]
class Solution {
    public boolean isValid(String s) {
        int num1=0,num2=0,num3=0;
        for(char c:s.toCharArray())
        {
            if(c=='(')
            {
                num1++;
            }else if(c==')')
            {
                num1--;
                if(num1<0) return false;
            }

            if(c=='{')
            {
                num2++;
            }else if(c=='}')
            {
                num2--;
                if(num2<0) return false;
            }

            if(c=='[')
            {
                num3++;
            }else if(c==']')
            {
                num3--;
                if(num3<0) return false;
            }
        }
        if(num1==0&&num2==0&&num3==0) return true;
        else return false;
    }
}
 */