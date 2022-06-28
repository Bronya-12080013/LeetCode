/*
ohhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
通过率 28.7%的中等题过了！！！！！！！！！！！！！！！！！！！
虽然  6.85% && 5.05%
但就是过了
=============================================================
先总结一下
1.我又搞混了 字符比较 和 字符串比较
字符用'' 字符串用:""
字符比较  '+'==chars[i]
字符串比较 "+".equals(chars[i])
2.我本想用
else if (Long.valueOf(stringBuffer.toString())>Integer.MAX_VALUE) return Integer.MAX_VALUE;
else if(Long.valueOf(stringBuffer.toString())<Integer.MIN_VALUE) return Integer.MIN_VALUE;
来判断是否大于或小于
Integer.MAX_VALUE;
Integer.MIN_VALUE; 的
但Long也不够大

又换成
if(stringBuffer.toString().compareTo(String.valueOf(Integer.MAX_VALUE))>0) return Integer.MAX_VALUE;
if(stringBuffer.toString().compareTo(String.valueOf(Integer.MIN_VALUE))<0) return Integer.MIN_VALUE;
但总是不对，比较有误，不知道为什么，不知道+和-是怎么比较的

后来用BigDecimal解决了 创建对象，传String 再compareTo比较就行了
================================================================
看看大佬答案
代码:
class RangeFreqQuery {
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length == 0) return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if(c[0] == '-') sign = -1;                  //判断正负
        else if(c[0] != '+') i = 0;                 //无正负情况
        for(int j = i; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') break;    //妙啊，可以直接这样，字符用'',可以直接比大小
            if(res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;    //判断是否（即将）越界
            res = res * 10 + (c[j] - '0');          //妙啊，字符''可以直接减
        }
        return sign * res;
    }
}

作者：jyd
链接：https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/solution/mian-shi-ti-67-ba-zi-fu-chuan-zhuan-huan-cheng-z-4/

 */

package 刷题.leetcode.剑指Offer67把字符串转换成整数;

import org.omg.CORBA.LongLongSeqHelper;

import java.math.BigDecimal;                        //不知道为什么，这个也也要提交才行

public class Solution {
    public static void main(String[] args) {
        System.out.println(strToInt("20000000000000000000"));
    }
    static int strToInt(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] chars = str.trim().toCharArray();
        for(int i =0;i<chars.length;i++)
        {
            if(('+'==chars[i]||'-'==(chars[i]))&&i==0)    // if(("+".equals(chars[i])||"-".equals(chars[i]))&&i==0) 是错的
            {
                stringBuffer.append(chars[i]);
            }
            else if(Character.isDigit(chars[i])) stringBuffer.append(chars[i]);
            else break;
        }
        if("+".equals(stringBuffer.toString())||"-".equals(stringBuffer.toString())) return 0;
        if("".equals(stringBuffer.toString())) return 0;

        BigDecimal bd = new BigDecimal(stringBuffer.toString());
        if(bd.compareTo(new BigDecimal(String.valueOf(Integer.MAX_VALUE)))>0) return Integer.MAX_VALUE;
        if(bd.compareTo(new BigDecimal(String.valueOf(Integer.MIN_VALUE)))<0) return Integer.MIN_VALUE;

        //if(stringBuffer.toString().compareTo(String.valueOf(Integer.MAX_VALUE))>0) return Integer.MAX_VALUE;
        //if(stringBuffer.toString().compareTo(String.valueOf(Integer.MIN_VALUE))<0) return Integer.MIN_VALUE;


       //else if (Long.valueOf(stringBuffer.toString())>Integer.MAX_VALUE) return Integer.MAX_VALUE;
       //else if(Long.valueOf(stringBuffer.toString())<Integer.MIN_VALUE) return Integer.MIN_VALUE;

            else return Integer.valueOf(stringBuffer.toString());
    }
}
