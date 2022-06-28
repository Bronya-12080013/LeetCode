/*
注意：仔细看题目所要求，我们要计算一个数字有几种翻译法，并不需要翻译 只要数在0-9和10-25的区别
==============================================================================
参考大佬的答案，过了
明明看起来很简单，就是思路不清，不会分析
 */

package 刷题.leetcode.剑指Offer46把数字翻译成字符串;

class Solution {
    public int translateNum(int num) {
        String string=String.valueOf(num);
        int a=1;
        int b=1;
        for(int i=2;i<string.length();i++)              //如果设i=1，在最后可能越界
        {
            String temp=string.substring(i-2,i);
            int c=temp.compareTo("10")>=0&&temp.compareTo("25")<=0?a+b:a;
            b=a;
            a=c;
        }
        return a;
    }
}
