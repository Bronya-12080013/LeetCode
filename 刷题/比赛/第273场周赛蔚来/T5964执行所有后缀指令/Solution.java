/*
还行 小点心就行
==============================================================
大佬代码: 怎么写会被打的 算了不看了
class Solution {
	public int[] executeInstructions(int n, int[] startPos, String s) {
		int[] result = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = i, x = startPos[0], y = startPos[1]; j < s.length()
					&& (x += s.charAt(j) == 'U' ? -1 : s.charAt(j) == 'D' ? 1 : 0) >= 0 && x < n
					&& (y += s.charAt(j) == 'L' ? -1 : s.charAt(j) == 'R' ? 1 : 0) >= 0 && y < n; j++, result[i]++) {
			}
		}
		return result;
	}
}
 */

package 刷题.比赛.第273场周赛蔚来.T5964执行所有后缀指令;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.executeInstructions(3,new int[]{0,1},"RRDDLU");
    }
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] answer = new int[s.length()];
        for(int i = 0;i<s.length();i++)
        {
                answer[i]=doit(n,startPos,s.substring(i));
        }
        return answer;
    }
    int doit(int n ,int[] startPos,String s){
        char[] chars = s.toCharArray();
        int i = startPos[0];
        int j = startPos[1];
        //要区分好i和j 下面的j--; j++; i--; i++; 易搞混
        int num = 0;
        while (num<chars.length)
        {
            char c = chars[num];
            if(c=='L') j--;
            if(c=='R') j++;
            if(c=='U') i--;
            if(c=='D') i++;
            if(i<0||i>=n||j<0||j>=n) break;
            num++;
        }
        return num;
    }
}
