package 刷题.leetcode.T面试题1711单词距离;

class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int index1 = -1,index2= -1;
        int res = Integer.MAX_VALUE;
        for(int i=0;i< words.length;i++)
        {
            if(words[i].equals(word1)) index1=i;
            if(words[i].equals(word2)) index2=i;
            if(index1>0&&index2>0) res=Math.min(res,Math.abs(index1-index2));
        }
        return res;
    }
}