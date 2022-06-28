/*
这题是简单题？？？
好歹能暴力 5.15% && 14.58%
我用的是枚举的方法 可以用位运算改善我的方法
========================================
字符有判断大小写的方法 如Character.isLowerCase();
===================================================
用位运算记录出现过的字符 a|=b ==>  a=a|b 是位与运算 “有1即1”
  for (int j = i; j < n; ++j) {
                if (Character.isLowerCase(s.charAt(j))) {
                    lower |= 1 << (s.charAt(j) - 'a');
                } else {
                    upper |= 1 << (s.charAt(j) - 'A');
                }
            }

==========================================
方法一：枚举
class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        int maxPos = 0;
        int maxLen = 0;
        for (int i = 0; i < n; ++i) {
            int lower = 0;
            int upper = 0;
            for (int j = i; j < n; ++j) {
                if (Character.isLowerCase(s.charAt(j))) {
                    lower |= 1 << (s.charAt(j) - 'a');
                } else {
                    upper |= 1 << (s.charAt(j) - 'A');
                }
                if (lower == upper && j - i + 1 > maxLen) {
                    maxPos = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(maxPos, maxPos + maxLen);
    }
}
===============================================================
关键是分治！！！！！！！！！！！
=================================================================
方法二：分治
分治思想来源于「395. 至少有K个重复字符的最长子串」，详细的解法与其相似。
题目要求找到最长的美好子字符串，如果字符串本身即合法的美好字符串，此时最长的完美字符串即为字符串本身。
由于字符串中含有部分字符 \textit{ch}ch 只出现大写或者小写形式，如果字符串包含这些字符ch 时，
可以判定该字符串肯定不为完美字符串。一个字符串为美好字符串的必要条件是不包含这些非法字符。
因此我们可以利用分治的思想，将字符串从这些非法的字符处切分成若干段，
则满足要求的最长子串一定出现在某个被切分的段内，而不能跨越一个或多个段

总之,就是分成几段 几段中又分几段 每段分到成功或不可分为止
靠这个来理解代码的实现吧

好好理解分治的代码

 */
package 刷题.leetcode.T1763最长的美好子字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//方法二：分治
class Solution {
    private int maxPos;
    private int maxLen;

    public String longestNiceSubstring(String s) {
        this.maxPos = 0;
        this.maxLen = 0;
        dfs(s, 0, s.length() - 1);
        return s.substring(maxPos, maxPos + maxLen);
    }

    public void dfs(String s, int start, int end) {
        if (start >= end) {
            return;
        }
        int lower = 0, upper = 0;
        for (int i = start; i <= end; ++i) {
            if (Character.isLowerCase(s.charAt(i))) {
                lower |= 1 << (s.charAt(i) - 'a');
            } else {
                upper |= 1 << (s.charAt(i) - 'A');
            }
        }
        if (lower == upper) {
            if (end - start + 1 > maxLen) {
                maxPos = start;
                maxLen = end - start + 1;
            }
            return;
        }
        int valid = lower & upper;  //取出成功配对的
        int pos = start;
        while (pos <= end) {
            start = pos;
            while (pos <= end && (valid & (1 << Character.toLowerCase(s.charAt(pos)) - 'a')) != 0) {  //若这里==0了 那么这个char便是上面没能配对成功的 从这里分开 //这里变大写还是小写倒是无所谓
                ++pos;
            }
            dfs(s, start, pos - 1);  //在没能成功配对的char分开了 可能会把配对好的一对也分开 所以继续dfs
            ++pos;
        }
    }
}


/* 我的方法
class Solution {
    public String longestNiceSubstring(String s) {
        for(int l=s.length();l>0;l--)
        {
            for(int i =0;i+l<=s.length();i++)
            {
                if(isIt(s.substring(i,i+l))) return s.substring(i,i+l);
            }
        }
        return "";
    }
    boolean isIt(String s){
        HashMap<String,boolean[]> hashMap = new HashMap<>();
        for(char c:s.toCharArray())
        {
            hashMap.putIfAbsent(String.valueOf(c).toLowerCase(),new boolean[2]);
            boolean[] booleans = hashMap.get(String.valueOf(c).toLowerCase());
            if(c-'a'<0) booleans[1]=true;
            else booleans[0]=true;
        }
        for(boolean[] booleans:hashMap.values())
        {
            if(!booleans[0]||!booleans[1]) return false;
        }
        return true;
    }
}
 */