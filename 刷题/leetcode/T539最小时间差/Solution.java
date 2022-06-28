/*
好 简单
=============================================
官方答案
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440) {
            return 0;
        }
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int t0Minutes = getMinutes(timePoints.get(0));
        int preMinutes = t0Minutes;
        for (int i = 1; i < n; ++i) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - preMinutes); // 相邻时间的时间差
            preMinutes = minutes;
        }
        ans = Math.min(ans, t0Minutes + 1440 - preMinutes); // 首尾时间的时间差
        return ans;
    }

    public int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }
}
===========================================
也可以先转换为分钟在放进去排序
 */


package 刷题.leetcode.T539最小时间差;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size()>1440) return 0;
        Collections.sort(timePoints);
        int ans=Integer.MAX_VALUE;
        for(int i =1;i<timePoints.size();i++)
        {
            ans=Math.min(ans,gitIt(timePoints.get(i))-gitIt(timePoints.get(i-1)));
        }
        ans=Math.min(ans,gitIt(timePoints.get(0))+1440-gitIt(timePoints.get(timePoints.size()-1)));
        return ans;
    }
    static int gitIt(String s){
        return ((s.charAt(0)-'0')*10+(s.charAt(1)-'0'))*60+((s.charAt(3))*10+s.charAt(4)); //字符相减 就变成int了
    }
}