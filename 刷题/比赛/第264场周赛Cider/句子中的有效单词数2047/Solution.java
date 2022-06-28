package 刷题.比赛.第264场周赛Cider.句子中的有效单词数2047;
//关键是正则的应用
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