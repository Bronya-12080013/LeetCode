/*
很好，简单的粗暴两重for循环过了  11.09% && 5.11%
==============================================================================
本题考的是位运算呜呜呜呜呜位运算好难
==============================================================================
但即使是粗暴版
我写的也有要改进的地方
1.判断包含直接
用String的方法不就行了嘛 用什么Set 这应该是刚写时我的思路不清导致的 或是因为我受了上一题的影响
private boolean hasSameChar1(String word1, String word2) {
    for (char c : word1.toCharArray()) {
        if (word2.indexOf(c) != -1) return false;
    }
    return true;
}

2.判断大小直接用Math.max()啊
写什么
if(istoo(words[i],words[j])&&(words[i].length()*words[j].length()>max))
                    max=words[i].length()*words[j].length();
写
 ans = Math.max(ans, word1.length() * word2.length());
            }
感觉差不多 但前面看着不爽
================================================================================
优化hasSameChar1方法
private boolean hasSameChar2(String word1, String word2) {
    int[] count = new int[26];
    for (char c : word1.toCharArray()) count[c - 'a'] = 1;
    for (char c : word2.toCharArray()) {
        if (count[c - 'a'] == 1) return false;
    }
    return true;
}
依旧是挖坑法
================================================================================
一步步的优化太强了
直接去看视频
https://leetcode-cn.com/problems/aseY1I/solution/jian-dan-yi-dong-javac-pythonjs-zui-da-d-ffga/
对了，前面作者的boolean和我是取反的，我前面都改过来了 下面也是
===================================================================================
优化:
private boolean hasSameChar(String word1, String word2) {
    int bitMask1 = 0, bitMask2 = 0;
    for (char c : word1.toCharArray()) bitMask1 |= (1 << (c - 'a'));    //bitMask1 = bitMask1 | (1 << (c - 'a'));
    for (char c : word2.toCharArray()) bitMask2 |= (1 << (c - 'a'));
    return (bitMask1 & bitMask2) == 0;        //==0即无重复
}
=========================================================================================
优化！！！！！！！！！！！！！！抓住未来吧!!!!!!!
// 位运算 + 预计算
// 时间复杂度：O((m + n)* n)
// 空间复杂度：O(n)
public int maxProduct2(String[] words) {
    // O(mn)
    int n = words.length;
    int[] masks = new int[n];
    for (int i = 0; i < n; i++) {
        int bitMask = 0;
        for (char c : words[i].toCharArray()) {
            bitMask |= (1 << (c - 'a'));
        }
        masks[i] = bitMask;
    }

    // O(n^2)
    int ans = 0;
    for (int i = 0; i < words.length; i++) {
        String word1 = words[i];
        for (int j = i + 1; j < words.length; j++) {
            String word2 = words[j];
            if ((masks[i] & masks[j]) == 0) {
                ans = Math.max(ans, word1.length() * word2.length());
            }
        }
    }
    return ans;
}
==============================================================================
最终版，见下
比起前一种，这个优化的主要是对应 有很多含相同字符但长度不同的单词 我们只需要记最长的      如eg  eeggge eeeeeeeggeggggeeeeegggg 等 只要记最长的
 */


/* 粗暴版
package 刷题.leetcode.剑指OfferII005单词长度的最大乘积;

import java.util.HashSet;
import java.util.Set;

public class TopVotedCandidate {
    public int maxProduct(String[] words) {
        int max=0;
        for (int i =0;i<words.length-1;i++)
        {
            for (int j =i+1;j<words.length;j++)
            {
                if(istoo(words[i],words[j])&&(words[i].length()*words[j].length()>max))
                    max=words[i].length()*words[j].length();
            }
        }
        return max;
    }
    static boolean istoo(String s1,String s2)
    {
        char[] chars1=s1.toCharArray();
        Set<Character> set = new HashSet();
        for (int i =0;i<chars1.length;i++)
        {
                set.add(chars1[i]);
        }
        char[] chars2=s2.toCharArray();
        for (int i =0;i< chars2.length;i++)
        {
            if(set.contains(chars2[i])) return false;
        }
        return true;
    }
}
 */


//最终版
package 刷题.leetcode.剑指OfferII005单词长度的最大乘积;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // 位运算 + 预计算
// 时间复杂度：O((m + n)* n)
// 空间复杂度：O(n)
    public int maxProduct(String[] words) {
        // O(mn)
        Map<Integer, Integer> map = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            int bitMask = 0;
            for (char c : words[i].toCharArray()) {
                bitMask |= (1 << (c - 'a'));
            }
            // there could be different words with the same bitmask
            // ex. ab and aabb
            map.put(bitMask, Math.max(map.getOrDefault(bitMask, 0), words[i].length()));   // getOrDefault()也是取map的value，在没值时有默认返回值，这里默认值设为0
                                                                                                        //这里不压迫写成words.length()
        }

        // O(n^2)
        int ans = 0;
        for (int x : map.keySet()) {                            //keySet():返回此映射中所包含的键的 Set 视图  相当与遍历map中的key
            for (int y : map.keySet()) {
                if ((x & y) == 0) {                             //注意不能if (x & y == 0)
                    ans = Math.max(ans, map.get(x) * map.get(y));
                }
            }
        }
        return ans;
    }
}
