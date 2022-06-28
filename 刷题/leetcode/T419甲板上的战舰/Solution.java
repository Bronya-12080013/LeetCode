/*
虚假的中等题 一遍过   76.71%(100.00%) && 89.35%
=====================================
遍历扫描
class Solution {
    public int countBattleships(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int ans = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == 'X') {
                    board[i][j] = '.';
                    for (int k = j + 1; k < col && board[i][k] == 'X'; ++k) {
                        board[i][k] = '.';
                    }
                    for (int k = i + 1; k < row && board[k][j] == 'X'; ++k) {
                        board[k][j] = '.';
                    }
                    ans++;
                }
            }
        }
        return ans;
    }
}
===========================================================
枚举起点 这个好 战舰的左上角（最上和最左）才会被计数
class Solution {
    public int countBattleships(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int ans = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue;
                    }
                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    }
                    ans++;
                }
            }
        }
        return ans;
    }
}

 */
package 刷题.leetcode.T419甲板上的战舰;

public class Solution {
    public int countBattleships(char[][] board) {
        int num=0;
        for(int i =0;i<board.length;i++)
        {
            for(int j  =0;j<board[0].length;j++)
            {
                if(board[i][j]!='.') {
                    DFS(i,j,board);
                    num++;
                }
            }
        }
        return num;
    }
    void DFS(int i ,int j ,char[][] board)
    {
        //if(i<0||i>=board.length||j<0||j>=board[0].length) return;
        if(i>=board.length||j>=board[0].length) return;
        if(board[i][j]=='.') return;
        board[i][j]='.';
        DFS(i+1,j,board);
      //  DFS(i-1,j,board);  没必要
        DFS(i,j+1,board);
      //  DFS(i,j-1,board);
    }
}
