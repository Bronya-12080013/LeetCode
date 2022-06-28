/*
KMP算法
https://www.bilibili.com/video/BV1Px411z7Yo?from=search&seid=12619944045340560478&spm_id_from=333.337.0.0
https://www.bilibili.com/video/BV1jb411V78H?from=search&seid=12619944045340560478&spm_id_from=333.337.0.0
 */

package 刷题.leetcode.T28实现strStr;

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];       //最长前缀表
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}


/*  我搁这搁这搁这呢
public class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
 */

/*  暴力匹配
public class Solution {
    public int strStr(String haystack, String needle) {
        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        int n = haystacks.length,m=needles.length;
        for(int i =0;i+m<=n;i++)
        {
                boolean flag = true;
                for(int j = 0;j<m;j++)
                {
                    if(haystacks[i+j]!=needles[j]){
                        flag=false;
                        break;
                    }
                }
                if(flag) return i;
        }
        return -1;
    }
}
 */
