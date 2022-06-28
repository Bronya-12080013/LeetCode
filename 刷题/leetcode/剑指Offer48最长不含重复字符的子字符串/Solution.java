/* #转
好耶，做出来了
这题还行   65.65% && 70.05%
==================================
 算了，这题不看了
 */

package 刷题.leetcode.剑指Offer48最长不含重复字符的子字符串;

/*  不对，思路不对，不能完全通过
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class RangeFreqQuery {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int max=Integer.MIN_VALUE;
        Set set =new HashSet();
        char[] chars=s.toCharArray();
        for(char c :chars)
        {
            if(set.contains(c))
            {
                set.clear();
                set.add(c);
            }else set.add(c);
            max=max<set.size()? set.size() : max;
        }
        return max;
    }
}
 */


/*
ohhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
我做对了
 */
import java.util.ArrayList;

class Solution{
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int max=Integer.MIN_VALUE;
        ArrayList<Character> arrayList =new ArrayList<Character>();
        char[] chars=s.toCharArray();
        for(char c :chars)
        {
            if(arrayList.contains(c)){
                    for(int i=arrayList.indexOf(c);i>=0;i--)
                    {
                        arrayList.remove(0);
                    }
                    arrayList.add(c);
            }else arrayList.add(c);
            max=max<arrayList.size()? arrayList.size() : max;
        }
        return max;
    }
}