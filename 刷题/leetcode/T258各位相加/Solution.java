//复活题    %2022/3/3 这段时间在搞项目又搞服务器搞域名搞网站搞linux，一个月没写题了
// 看了赛马娘  东海帝皇 奇迹复活！
package 刷题.leetcode.T258各位相加;

class Solution {
    public int addDigits(int num) {
        int newNum = 0;
        while (num<=0)
        {
            newNum+=num%10;
            num/=10;
        }
        if(newNum/10==0) return num;
        else return addDigits(newNum);
    }
}