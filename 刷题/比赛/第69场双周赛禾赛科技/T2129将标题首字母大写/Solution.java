/*
简单 就是不小心看题吃了几个罚时
 */

package 刷题.比赛.第69场双周赛禾赛科技.T2129将标题首字母大写;

class Solution {
    public String capitalizeTitle(String title) {
        String[] strings = title.split(" ");
        StringBuffer sb = new StringBuffer();
            for (int i = 0; i < strings.length; i++) {
                if(strings[i].length()==1||strings[i].length()==2) sb.append(strings[i].toLowerCase());
                else {
                    String s = String.valueOf(strings[i].charAt(0));
                    sb.append(s.toUpperCase());
                    sb.append(strings[i].substring(1).toLowerCase());
                }
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}