/*
很好 过了  56.35% && 34.14%
但是方法好low 我不能接受
===============================================
还是官方的帅
填坑填坑法
class TopVotedCandidate {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
 */
package 刷题.leetcode.T383赎金信;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars = magazine.toCharArray();
        for(char c :ransomNote.toCharArray())
        {
            boolean flag=false;
            for(int i=0;i<chars.length;i++)
            {
                if(chars[i]==c)
                {
                    chars[i]=' ';
                    flag=true;
                    break;
                }
            }
            if(flag) continue;
            else return flag;
        }
        return true;
    }
}
