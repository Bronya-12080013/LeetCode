/*
动态规划!!! 回文串判定！

对于一个子串而言，如果它是回文串，并且长度大于 22，那么将它首尾的两个字母去除之后，它仍然是个回文串。
例如对于字符串“ababa”，如果我们已经知道“bab” 是回文串，那么“ababa” 一定是回文串，这是因为它的首尾两个字母都是“a”
即如果 “ababa”首尾都是“a” 那么 “ababa”是否为回文 相当于 “bab”是否为回文  继续推到底 所有长度为 1 的子串都是回文串（“a”）

官方答案:
public class Solution {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}

 */

//模仿官方写一遍
package 刷题.leetcode.T5最长回文子串;

class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<2) return s;
        int len  = s.length();
        int maxLen = 1,beginIndex=0;
        boolean[][] dp = new boolean[len][len];
        for(int i=0;i<len;i++) dp[i][i]=true;
        char[] chars = s.toCharArray();
        for(int length =2;length<=len;length++){
            for(int i=0;i<len;i++)
            {
                int j = i+length-1;
                if(j>len-1) break;
                if(chars[i]==chars[j])
                {
                    if(j-i<=2) dp[i][j]=true;
                    else dp[i][j]=dp[i+1][j-1];
                }else dp[i][j]=false;

                if(dp[i][j]&&j-i+1>maxLen){
                    maxLen=j-i+1;
                    beginIndex=i;
                }
            }
        }
        return s.substring(beginIndex,beginIndex+maxLen);
    }
}

/* 超时 120/180w
class Solution {
    public String longestPalindrome(String s) {
        if(s.equals("")) return "";
        for(int length=s.length();length>0;length--)
        {
            for(int i =0;i+length<=s.length();i++)
            {
                if(isIt(s.substring(i,i+length+1))) return s.substring(i,i+length+1);
            }
        }
        return "";
    }
    boolean isIt(String s)
    {
        StringBuffer sb = new StringBuffer(s);
        return sb.toString().equals(sb.reverse().toString());
    }
}
 */