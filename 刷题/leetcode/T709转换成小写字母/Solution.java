/*
每日一题
===========================
还可以直接实现方法
class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch >= 65 && ch <= 90) {
                ch |= 32;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
ch |= 32;是把小写字母变成大写字母   “|=”做按位或运算，相当加上32

 */
package 刷题.leetcode.T709转换成小写字母;

public class Solution {
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}
