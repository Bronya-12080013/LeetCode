/*
过了 简单 61.62% && 12.97%
====================================
官方重构字符串法
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String str) {
        StringBuffer ret = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            char ch = str.charAt(i);
            if (ch != '#') {
                ret.append(ch);
            } else {
                if (ret.length() > 0) {
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }
}
=======================================
官方双指针
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
 */
package 刷题.leetcode.T844比较含退格的字符串;

import java.util.ArrayDeque;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        ArrayDeque<Character> stack1 = new ArrayDeque<>();
        ArrayDeque<Character> stack2 = new ArrayDeque<>();
        for(char c : s.toCharArray())
        {
            if(c!='#') stack1.push(c);
            else if(!stack1.isEmpty()) stack1.pop();
        }
        for(char c : t.toCharArray())
        {
            if(c!='#') stack2.push(c);
            else if(!stack2.isEmpty()) stack2.pop();
        }
        if(stack1.size()!=stack2.size()) return false;
        while(stack1.size()!=0&&stack2.size()!=0)   //？？？我把while打成了if 竟然也能112/113 ?? 这用例有什么大病
        {
            if(stack1.pop()!=stack2.pop()) return false;
        }
        return true;
    }
}
