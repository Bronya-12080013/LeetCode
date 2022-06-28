package 刷题.leetcode.T942增减字符串匹配;

//贪心
class Solution {
    public int[] diStringMatch(String s) {
        int h = 0,t=s.length();
        int[] perm = new int[s.length()+1];
        for(int i =0;i<s.length();i++)
        {
            perm[i] = s.charAt(i)=='I'?h++:t--; //h和t是先赋值，再变化
        }
        perm[perm.length-1]=h;  //// 最后剩下一个数，此时 h == t
        return perm;
    }
}