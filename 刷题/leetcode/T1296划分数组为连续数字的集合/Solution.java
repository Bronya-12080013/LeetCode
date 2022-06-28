/*
直接搬846. 一手顺子代码
 */

package 刷题.leetcode.T1296划分数组为连续数字的集合;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean  isPossibleDivide(int[] hand, int groupSize) {
        if(hand.length==0||hand.length%groupSize!=0) return false;
        Arrays.sort(hand);
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int h:hand)
        {
            hashMap.put(h,hashMap.getOrDefault(h,0)+1);
        }
        for(int h:hand)
        {
            if(!hashMap.containsKey(h)) continue;
            for(int i=h;i<h+groupSize;i++)  //for(int i=h;i<i+groupSize;i++)是错的 i是会变的
            {
                if(!hashMap.containsKey(i)) return false;
                hashMap.put(i,hashMap.get(i)-1);
                if(hashMap.get(i)==0) hashMap.remove(i);
            }
        }
        return true;
    }
}