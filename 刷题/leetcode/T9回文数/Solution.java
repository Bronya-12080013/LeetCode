package 刷题.leetcode.T9回文数;

//发现这题我还没做欸 //顺手做了
class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        return s.equals(new StringBuffer(s).reverse().toString());
    }
}