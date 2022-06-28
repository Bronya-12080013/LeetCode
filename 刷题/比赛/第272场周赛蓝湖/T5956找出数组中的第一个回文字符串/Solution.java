/*
简单 一个个判断是否回文即可
本来想用栈的 想想双指针就行了
 */
package 刷题.比赛.第272场周赛蓝湖.T5956找出数组中的第一个回文字符串;

public class Solution {
    public String firstPalindrome(String[] words) {
            for(String s : words)
            {
               if(isit(s)) return s;
            }
            return "";
    }
    boolean isit(String s)
    {
        char[] chars = s.toCharArray();
        int i =0,j=chars.length-1;
        while (i<j){
            if(chars[i]!=chars[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}

/*
大佬代码:
class Solution {
	public String firstPalindrome(String[] words) {
		for (String word : words) {
			if (word.equals(new StringBuilder(word).reverse().toString())) {
			//也可以 if(word.equals("" + new StringBuilder(word).reverse())) {
				return word;
			}
		}
		return "";
	}
}
 */
