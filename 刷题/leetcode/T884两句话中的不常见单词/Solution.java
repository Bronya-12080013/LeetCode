/*
这简单题 99.60% && 5.06%
1.别害羞了 多几层遍历不会死人的
2.好好看题目 我看成要求 第一个句子有且只有一次 而 第二个句子没有的 看错了
3.它又来了
遍历哈希表

遍历哈希表！！！! 是遍历 映射关系 是把k和v一对拿出来
for (Map.Entry<Integer, Map<Integer, Integer>> map : cnt.entrySet())
然后用 map.getValue() map.getKey() 方法
!!!!!

 */

package 刷题.leetcode.T884两句话中的不常见单词;

import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer> hashMap = new HashMap();
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for(String s:s1.split(" "))
        {
            hashMap.put(s,hashMap.getOrDefault(s,0)+1);
        }
        for(String s:s2.split(" "))
        {
            hashMap.put(s,hashMap.getOrDefault(s,0)+1);
        }
        for(Map.Entry<String,Integer> map : hashMap.entrySet())
        {
            if(map.getValue()==1) list.add(map.getKey());
        }
        return list.toArray(new String[list.size()]);
    }
}