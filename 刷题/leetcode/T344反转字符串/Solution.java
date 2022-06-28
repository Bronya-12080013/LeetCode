/*
过了   90.18% && 99.05%
注意几点
1.记住String string=new StringBuffer(String.valueOf(s)).reverse().toString();
记住这个写法  记住 StringBuffer类里有reverse()函数
还有 要写String.valueOf(s) 这样就只是使用s，不会改变s的值; 而用s.toString()会改变s
2.foreach也是写for,不是直接写foreach(){}
3.用for给s[]赋值，而不是  s=string.toCharArray();
应该是地址问题
本题是返回void 不知道系统到底看的是什么
输出s明明确实 s=string.toCharArray();
故猜测是地址问题
====================================================
debug一下，
用s=string.toCharArray();
确实是地址变了
但也不是string的哦
是新为string.toCharArray();生成的地址
=====================================================
官方解法，简单的双指针：
class Time {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}
 */

package 刷题.leetcode.T344反转字符串;

public class Solution {
    public static void main(String[] args) {
        reverseString(new char[]{'h','e','l','l','o'});
    }
    static void reverseString(char[] s) {

        String string=new StringBuffer(String.valueOf(s)).reverse().toString();
      //  s=string.toCharArray();
        int count=0;
        for(char c : string.toCharArray())                  //注意，foreach也是写for,不是直接写foreach
        {
         s[count++]=c;
        }
    }
}
