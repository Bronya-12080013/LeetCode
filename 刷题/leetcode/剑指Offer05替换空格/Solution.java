/*
这题是来搞笑的？
============================
先总结一下
首先，我想用流，然后，又失败了
然后用循环，再然后就发现了replace方法

值得一提的是：我找不到char的比较方法
要判断想等，还是要用string的equals方法
如下，可以写    " ".equals(s.charAt(i))
但不能    s.charAt(i).equals     因为s.charAt(0)拿的是char，它没有equals
=================================================
看了下官方的答案，也就那样用三倍数组，for循环

还不如直接用replace
下面我去看看它的源码
==============================================
replace 里面用的是Pattern 正则方法

 */

package 刷题.leetcode.剑指Offer05替换空格;

import java.util.Scanner;
import java.util.stream.Stream;

class Solution {
   // public static void main(String[] args) {                                  //错误示例
   //     Scanner scanner = new Scanner(System.in);
   //     String s =scanner.nextLine();
   //     replaceSpace(s);
   // }
    public static String replaceSpace(String s) {
      // for(int i=0;i<s.length();i++)                                           //错误示例
      // {
      //     if(!" ".equals(s.charAt(i)))
      //     {
      //         s.replace
      //     }
      // }
        String string = s.replace(" ","%20");
        return string;
    }
}
