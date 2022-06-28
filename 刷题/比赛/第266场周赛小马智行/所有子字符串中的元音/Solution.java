/*
给你一个字符串 word ，返回 word 的所有子字符串中 元音的总数 ，元音是指 'a'、'e'、'i'、'o' 和 'u' 。
子字符串 是字符串中一个连续（非空）的字符序列。
注意：由于对 word 长度的限制比较宽松，答案可能超过有符号 32 位整数的范围。计算时需当心。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/vowels-of-all-substrings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

=======================================================
本题与第一题有关
我先用了第一题的方法，内存超了
改进一下，把一个方法去了，少用了数组ArrayList
再试试，时间超了(n的三次方。。。)
我在网上搜到一个KMP算法，不知道有没有用
改不动了，
只能..到这了吗..
鸭达呐
====================================================
看大佬代码：
方法一：脑筋急转弯法(反推法（我自定的名字）):
作者：endlesscheng
链接：https://leetcode-cn.com/problems/vowels-of-all-substrings/solution/dan-du-ji-suan-mei-ge-yuan-yin-de-chu-xi-eyjf/
来源：力扣（LeetCode）

总结就是：
正推: "有多少个子列，遍历每个子列-->每个子列有多少个元音"
反推: "有多少个元音字符，遍历每个元音字符-->每个元英字符能出现在多少个字符串中"
用反推如下：

class RangeFreqQuery {

	public long countVowels(String word) {
		long count = 0;
		for (int i = 0; i < word.length(); i++) {
			if ("aeiou".indexOf(word.charAt(i)) >= 0) {
				count += (i + 1L) * (word.length() - i);
			}
		}
		return count;
	}
}
======================================================================
动态规划！！！！！！！！！！！！！！！！！！！！！！！！！！！
(好像这才是官方的解法吧)
解题思路
对于以字符wrd[idx]为末尾字符的字符串，可看做由以wrd[idx-1]为末尾字符的字符串，添加字符wrd[idx]得来。
那么所求答案就是上一个字符串的结果，加上“新添加字符的影响”。

在添加新字符时，原有字符所能组成的子串会增加（即原有字符到新字符组成的串）。此时，新增的字符有两种可能：

是元音字符。
对于这种情况，增加了一个元音字符，其自身作为子串使得总答案+1；也使得前面每个字符的“最大长度子串（即该字符到末尾字符组成的字符串）”的元音字符数量+1。我们可以用一个变量prevNum保存之前子串中元音字符的个数。

不是元音字符。
此时，前面每个字符的“最大长度子串”的元音字符数量不变。直接加入这个数量即可（因为新加入字符使得这些子串，作为新串的一部分被遍历到了）。

作者：qing-ping-jie-lu
链接：https://leetcode-cn.com/problems/vowels-of-all-substrings/solution/xiang-yao-dian-zan-ji-chu-de-dong-tai-gu-jhkv/

总结：如果新格子是元音，就在总数sum加上   [前一个的格子数+i+1]  (i:前面的格子数量，正好等于这个格子的下标i)(1是当前这个格子自己作子串的)
如果新格子不是元音，就在总数sum加上       [前一个的格子数]                 (应该表述没错吧)

代码:

public class RangeFreqQuery {
    private long dp = 0;
    private long sum = 0;
    public long countVowels(String word) {
        if (isValid(word.charAt(0))) {
            dp = 1;
            sum += dp;
        }
        for (int i = 1; i < word.length(); i++) {
            if (isValid(word.charAt(i))) {
                dp += (i + 1);
            }
            sum += dp;
        }
        return sum;
    }

    private boolean isValid(char c) {
        return c == 'a' || c == 'e' || c== 'o' || c == 'i' || c == 'u';
    }
}

作者：feyman2016
链接：https://leetcode-cn.com/problems/vowels-of-all-substrings/solution/java-you-hua-de-dp-shuang-bai-by-feyman2-hvth/

 */




package 刷题.比赛.第266场周赛小马智行.所有子字符串中的元音;

import java.util.ArrayList;

public class Solution {
    public long countVowels(String word) {
        long sum =0;
        for(int i = 0; i < word.length(); i++){
            for (int j = i+1; j<=word.length(); j++){
                    sum+=todo(word.substring(i,j));
            }
        }
        return sum;
    }
    static long todo(String str) {
        long sum = 0;
        char[] character=str.toCharArray();
        for (int j = 0; j < character.length; j++) {
            if ((character[j]== 'a'||character[j] == 'e' ||character[j]== 'i' ||character[j]== 'o' ||character[j] == 'u')) {
                sum++;
            }
        }
        return sum;
    }
}
