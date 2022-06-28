/*
过了 这种题就不要太在意效率了 27.67% && 6.68%
=================================================
官方代码
用下标转
class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index >= 0) {
            char[] arr = word.toCharArray();
            int left = 0, right = index;
            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            word = new String(arr);
        }
        return word;
    }
}


 */

package 刷题.leetcode.T2000反转单词前缀;
class Solution {
    public String reversePrefix(String word, char ch) {
        int i=0;
        while (i<word.length()&&word.charAt(i)!=ch) i++;
        if(i<word.length()) word=new StringBuffer(word.substring(0,i+1)).reverse()+word.substring(i+1);
        return word;
    }
}