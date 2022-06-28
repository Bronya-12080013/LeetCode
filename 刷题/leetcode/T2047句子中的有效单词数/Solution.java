/*
奇怪的题 不用正则很麻烦
 */
package 刷题.leetcode.T2047句子中的有效单词数;

class Solution {

    public int countValidWords(String sentence) {
        int count = 0;
        for (String s : sentence.split(" ")) {
            if (!s.isEmpty() && s.matches("[a-z]*([a-z]-[a-z])?[a-z]*[!.,]?")) {
                count++;
            }
        }
        return count;
    }
}