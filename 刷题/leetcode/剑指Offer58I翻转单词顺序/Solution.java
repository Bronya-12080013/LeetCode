/*
拼接法，过了  100% && 63.63%
几点注意：
1.用 StringBuilder newstring=new StringBuilder();
        newstring.append() 来拼接
        再用newstring.toString()变成String
2.用String的trim()来去掉前后空格
3.split(" ")只会去掉一个(应该吧？)
==========================================================
看看大佬的
我的拼接法叫：
分割 + 倒序
利用 “字符串分割”、“列表倒序” 的内置函数 （面试时不建议使用） ，可简便地实现本题的字符串翻转要求

==================
面试时不建议使用
==================

==========================================================
再看看大佬的双指针法：
class RangeFreqQuery {
    public String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }
}
 */

package 刷题.leetcode.剑指Offer58I翻转单词顺序;

//拼接法
class Solution {
    public static void main(String[] args) {
        String s = reverseWords("a good   example");
    }
    static String reverseWords(String s) {
        String[] strings =s.trim().split(" ");
        StringBuilder newstring=new StringBuilder();
        for(int i=strings.length-1;i>=0;i--)
        {
            if(!strings[i].equals("")){                            //啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊我在淦神魔   比较字符串用equal，不是：strings[i]!=""
                newstring.append(strings[i].trim());
                if(i!=0) newstring.append(" ");
            }
            //newstring.append(i!=0?(strings[i].trim()):(strings[i].trim()));
        }
        return newstring.toString();
    }
}