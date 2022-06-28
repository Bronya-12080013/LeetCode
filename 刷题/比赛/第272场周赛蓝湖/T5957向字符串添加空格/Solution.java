/*
不难 送分 这题是怎么成中等题的
注意用 if(index<spaces.length)判断 再写spaces[index]

也可以 if(index<spaces.length&&i == spaces[index]) {
不可以 if(i == spaces[index]&&index<spaces.length&&i == spaces[index]) {
 */
package 刷题.比赛.第272场周赛蓝湖.T5957向字符串添加空格;

public class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuffer sb = new StringBuffer();
        int index = 0;
        for(int i =0;i<s.length();i++)
        {
            if(index<spaces.length) {
                if (i == spaces[index]) {
                    sb.append(" ");
                    index++;
                }
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

/*

 */