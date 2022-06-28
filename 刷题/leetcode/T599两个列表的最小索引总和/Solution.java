/*
复建题
写是写出来了 但不够优~！雅！！！  87.25% && 35.05%
                             能刷出奇迹 99.27% && 41.56%
 */
package 刷题.leetcode.T599两个列表的最小索引总和;

import java.util.*;

/* 错了，好好理解题目，还要在乎下标。用哈希
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for(String s:list1) set.add(s);
        for (String s:list2) if(set.contains(s)) list.add(s);
       // return list.toArray(String[3] string); 不是这么写的
        return list.toArray(new String[list.size()]);
    }
}
 */

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) { //明明是数组，叫什么list
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<list1.length;i++) map.put(list1[i],i);
        int size = 0;
        List<String> list = new ArrayList<>();
        //for (int i=0;i<list2.length&&!(size>0&&i>size);i++)
        boolean flag= true;
        for (int i=0;i<list2.length;i++)
        {
            String l2 = list2[i];
            if(map.containsKey(l2))
            {
                if(flag||size>i+map.get(l2))
                {
                    list.clear();
                    list.add(l2);
                    size=i+map.get(l2);
                    flag=false;
                }
                else if(size==i+map.get(l2))
                {
                    list.add(l2);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
}