package 刷题.leetcode.T1332删除回文子序列;
/*
这题纯纯考语文的
读题  是子序列 如baabb  aa是子序列 bbb也是子序列 子序列可以跨格取的 读题
那么答案不是1就是2了
判断整体是否回文即可
整体不回文就 先删a再删b
 */


//暴力  不行思路错
/*
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removePalindromeSub("baabb"));
    }
    public int removePalindromeSub(String s) {
        int sum  =0;
        while (s.length()!=0)
        {
            int j=s.length()-1;
            while (j>0&&!isit(s.substring(0,j+1)))
            {
                j--;
            }
            s=s.substring(j+1);
            sum++;
        }
        return sum;
    }
    static boolean isit(String s)
    {
        return String.valueOf(new StringBuffer().append(s).reverse()).equals(s);
    }
}
 */

//  100.00% && 86.74%
class Solution {
    public int removePalindromeSub(String s) {
        if(String.valueOf(new StringBuffer().append(s).reverse()).equals(s)) return 1;
        else return 2;
    }
}