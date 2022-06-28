/*
过了   82.29% && 19.73%
注意:
1.我本想用
string=new StringBuffer(string).reverse().toString();
return strings.toString();
但输出的好像是地址
看网上String[]转String也是用StringBuffer.append()  或String.join()

2.StringBuffer删除用delete等 不是remove或clear
还有replace StringBuffer的下标是0~length-1 但传参值是左闭右开的
===========================================================
我试了一下  String sss=String.join(" ",strings);
确实可行
不过
 for(String string:strings)
        {
           string=new StringBuffer(string).reverse().toString();
        }
 不行 也是地址变了罢了 不能直接这样对 strings的内容赋值
 不过用for循环应该可行
 ==========================================================
官方答案:
class Time {
    public String reverseWords(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }
}
 */

package 刷题.leetcode.T557反转字符串中的单词III;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
    static String reverseWords(String s) {
        String[] strings =s.split(" ");
        StringBuffer br = new StringBuffer();
        for(String string:strings)
        {
           // string=new StringBuffer(string).reverse().toString();
            br.append(new StringBuffer(string).reverse().toString());
            br.append(" ");
        }
        //return strings.toString();
        br.deleteCharAt(br.length()-1);       //删除最后一个空格
        // br.replace(br.length()-1,br.length(),"");    也行
        // br.replace(br.length()-1,br.length()-1,"");  不行，是左闭右开
        return br.toString();
    }
}
