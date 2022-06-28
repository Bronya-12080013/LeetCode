/*
难以理解就debug一遍
总之就是找断点 最后这些断点正好能拼成s即成功  dp[s.length()]==true
可以有多个断点 断点直接不一定要成一个单词 它们是平行宇宙中的量子叠加态
如
"catsandog"
["cats", "cat","dog", "and","og"]
因为有cats又有cat 所以会dp[3]和dp[4]都为true  它们都有潜力最终叠成dp[s.length()]==true
==================================================================================
官方答案
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(solution.wordBreak("applepenapple",wordDict));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];   //这里易混乱 boolean[] dp = new boolean[s.length() + 1]; 里是长度  dp[s.length()]是下标
    }
}
===============================================
注意 看构造方法  HashSet(Collection<? extends E> c) 构造一个包含指定 collection 中的元素的新 set。
可以直接放集合类的(Collection)
Set<String> set = new HashSet<>(wordDict);

 */

package 刷题.leetcode.T139单词拆分;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("cat");
        wordDict.add("dog");
        wordDict.add("and");
        wordDict.add("og");
        System.out.println(solution.wordBreak("catsandog",wordDict));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];  //最后的下标 s.length()
        dp[0]=true;
        for(int i =0;i<=s.length();i++){
            for(int j=0;j<i;j++)
            {
                if(dp[j]&&wordDictSet.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

