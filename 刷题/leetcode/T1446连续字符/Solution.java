/*
每日一题 过了 100.00% && 13.84%
要小心
如在最后不是return max  而是 return Math.max(max,num);  防止如 “ee”等最后一段是最长的类型
或者把max=Math.max(max,num);加到//1处
 */
package 刷题.leetcode.T1446连续字符;

public class Solution {
    public int maxPower(String s) {
        int num=1,max=0;
        char[] chars = s.toCharArray();
        for (int i=1;i<chars.length;i++)
        {
            if(chars[i]==chars[i-1]) num++;   //1
            else {
                max=Math.max(max,num);
                num=1;
            }
        }
        return Math.max(max,num);
    }
}
/*
官方答案:
class TopVotedCandidate {
    public int maxPower(String s) {
        int ans = 1, cnt = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ++cnt;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 1;
            }
        }
        return ans;
    }
}

 */
