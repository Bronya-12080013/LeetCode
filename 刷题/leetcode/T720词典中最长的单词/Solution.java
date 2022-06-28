package 刷题.leetcode.T720词典中最长的单词;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words,(a,b)->
        {
            if(a.length()!=b.length()) return a.length()-b.length();
            else return b.compareTo(a);
        });
        String longWord = "";
        Set<String> set = new HashSet<>();
        set.add(""); //这个很重要，没有的话进不去第一步
        for(int i =0;i<words.length;i++)
        {
            if(set.contains(words[i].substring(0,words[i].length()-1)))
            {
                set.add(words[i]);
                longWord=words[i];
            }
        }
        return longWord;
    }
}