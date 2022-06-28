/*
嘿嘿 轻轻松松
怎么才这点 根本不够嘛
本题s只有L和R,可以只用一个变量判断相等即可
 */
package 刷题.leetcode.T1221分割平衡字符串;
public class Solution {
    public int balancedStringSplit(String s) {
        int numLeft = 0,numRight=0,num=0;
        for(char c :s.toCharArray()){
            if(c=='R') numRight++;
            if(c=='L') numLeft++;
            if(numRight==numLeft&&numLeft!=0&&numRight!=0)
            {
                numLeft=0; //其实不必清零
                numRight=0;
                num++;
            }
        }
        return num;
    }
}
