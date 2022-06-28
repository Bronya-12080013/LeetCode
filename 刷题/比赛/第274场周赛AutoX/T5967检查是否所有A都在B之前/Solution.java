/*
简单 其实只要判断s中包不包含ab即可
 */

package 刷题.比赛.第274场周赛AutoX.T5967检查是否所有A都在B之前;
/* 可以
class Solution {
    public boolean checkString(String s) {
        boolean flag = true;
        for(char c : s.toCharArray())
        {
            if(flag&&c=='a') continue;
            else if(!flag&&c=='a') return false;
            if(c=='b') flag=false;
        }
        return true;
    }
}
 */

class Solution {
    public boolean checkString(String s) {
        return s.contains("ab");
    }
}