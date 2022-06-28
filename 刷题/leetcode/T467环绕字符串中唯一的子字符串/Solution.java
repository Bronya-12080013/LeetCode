package 刷题.leetcode.T467环绕字符串中唯一的子字符串;

import java.util.Arrays;

//https://leetcode.cn/problems/unique-substrings-in-wraparound-string/solution/huan-rao-zi-fu-chuan-zhong-wei-yi-de-zi-ndvea/
//学到了 用动态规划  因为p可以很大 不能把全子列求出后用s.indexOf()判断存在


/*
由于 ss 是周期字符串，对于在 ss 中的子串，只要知道子串的第一个字符（或最后一个字符）和子串长度，就能确定这个子串。例如子串以 \text{`d'}‘d’ 结尾，长度为 33，那么该子串为 \text{``bcd''}“bcd”。

题目要求不同的子串个数，那么对于两个以同一个字符结尾的子串，长的那个子串必然包含短的那个。例如 \text{``abcd''}“abcd” 和 \text{``bcd''}“bcd” 均以 \text{`d'}‘d’ 结尾，\text{``bcd''}“bcd” 是 \text{``abcd''}“abcd” 的子串。

据此，我们可以定义 \textit{dp}[\alpha]dp[α] 表示 pp 中以字符 \alphaα 结尾且在 ss 中的子串的最长长度，知道了最长长度，也就知道了不同的子串的个数。

如何计算 \textit{dp}[\alpha]dp[α] 呢？我们可以在遍历 pp 时，维护连续递增的子串长度 kk。具体来说，遍历到 p[i]p[i] 时，如果 p[i]p[i] 是 p[i-1]p[i−1] 在字母表中的下一个字母，则将 kk 加一，否则将 kk 置为 11，表示重新开始计算连续递增的子串长度。然后，用 kk 更新 \textit{dp}[p[i]]dp[p[i]] 的最大值。

遍历结束后，pp 中以字符 cc 结尾且在 ss 中的子串有 \textit{dp}[c]dp[c] 个。例如 \textit{dp}[\text{`d'}]=3dp[‘d’]=3 表示子串 \text{``bcd''}“bcd”、\text{``cd''}“cd” 和 \text{``d''}“d”。

最后答案为

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/unique-substrings-in-wraparound-string/solution/huan-rao-zi-fu-chuan-zhong-wei-yi-de-zi-ndvea/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); ++i) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) { // 字符之差为 1 或 -25        //-25是处理前后交接
                ++k;
            } else {
                k = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], k);
        }
        return Arrays.stream(dp).sum(); //流操作
    }
}

