/*
每日一题 随便一次过 65.28% && 38.14%
===============================================
官方的效率高
class TopVotedCandidate {
    public String truncateSentence(String s, int k) {
        int n = s.length();
        int end = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            if (i == n || s.charAt(i) == ' ') {
                count++;
                if (count == k) {
                    end = i;
                    break;
                }
            }
        }
        return s.substring(0, end);
    }
}
 */
package 刷题.leetcode.T1816截断句子;

public class Solution {
    public String truncateSentence(String s, int k) {
        String[] strings = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i =0;i<k;i++)
        {
            sb.append(strings[i]);
            sb.append(" ");
        }
        return sb.replace(sb.length()-1,sb.length(),"").toString();
    }
}
