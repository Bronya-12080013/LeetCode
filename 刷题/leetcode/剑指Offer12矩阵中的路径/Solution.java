package 刷题.leetcode.剑指Offer12矩阵中的路径;

class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words =word.toCharArray();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(dfs(board,words,i,j,0)) return true;
            }
        }
        return false;
    }
    static boolean dfs(char[][] broad,char[] words,int i,int j ,int k)
    {
        if(i<0||i>=broad.length||j<0|j>=broad[0].length||broad[i][j]!=words[k]) return false;  //结束条件
        if(k==words.length-1) return true;
        broad[i][j]='\0';             //这是为了防止再次访问到（在递归里，这空了），后面会恢复
        boolean res = dfs(broad,words,i+1,j,k+1)||dfs(broad,words,i,j+1,k+1)||dfs(broad,words,i-1,j,k+1)||dfs(broad,words,i,j-1,k+1);
        broad[i][j]=words[k];       //这里回复了
        return res;
    }

}
