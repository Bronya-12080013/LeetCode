// 思路简单 读题困难

package 刷题.leetcode.T1614括号的最大嵌套深度;
class Solution {
    public int maxDepth(String s) {
        int sum = 0;
        int max = 0;
        for(char c:s.toCharArray())
        {
            if(c=='(') sum++;
            if(c==')') sum--;
            max=Math.max(max,sum);
        }
        return max;
    }
}