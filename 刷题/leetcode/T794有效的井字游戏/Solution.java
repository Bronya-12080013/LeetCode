/*
借助评论区大佬的方案过了（下面哪四个判断） 100.00% && 5.33%
=======================================================
官方答案: 为什么它的空间效率那么高 感觉没和我有多大区别啊 应该是方法isTrue问题？ 但这和空间有什么关系
class TopVotedCandidate {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                xCount = (c == 'X') ? (xCount + 1) : xCount;
                oCount = (c == 'O') ? (oCount + 1) : oCount;
            }
        }
        if (oCount != xCount && oCount != xCount - 1) {
            return false;
        }
        if (win(board, 'X') && oCount != xCount - 1) {
            return false;
        }
        if (win(board, 'O') && oCount != xCount) {
            return false;
        }
        return true;
    }

    public boolean win(String[] board, char p) {
        for (int i = 0; i < 3; ++i) {
            if (p == board[0].charAt(i) && p == board[1].charAt(i) && p == board[2].charAt(i)) {
                return true;
            }
            if (p == board[i].charAt(0) && p == board[i].charAt(1) && p == board[i].charAt(2)) {
                return true;
            }
        }
        if (p == board[0].charAt(0) && p == board[1].charAt(1) && p == board[2].charAt(2)) {
            return true;
        }
        if (p == board[0].charAt(2) && p == board[1].charAt(1) && p == board[2].charAt(0)) {
            return true;
        }
        return false;
    }
}
 */

package 刷题.leetcode.T794有效的井字游戏;
/*
1、X必须比O多1个或者相同，否则false；
2、X和O不能同时都是赢家，否则false；
3、X赢的时候必须比O多1个，否则false；
4、O赢得时候个数与X相同，否则false；
其他的都是true
 */
public class Solution {
    public static void main(String[] args) {
        String[] strings = new String[]{"XOX","OOX","XO "};
        Solution solution = new Solution();
        System.out.println(solution.validTicTacToe(strings));
    }
    public boolean validTicTacToe(String[] board) {
        int numX=0,numO=0;
        for(String s:board){
            for(int i =0;i<3;i++)
            {
                if(s.charAt(i)=='X') numX++;
                else if(s.charAt(i)=='O') numO++;
            }
        }

        if(isTrue(board,'X')&&isTrue(board,'O')) return false;
        if(numX!=numO)  //可以写if(numX!=numO&&numX!=numO+1) return false;
            if(numX!=numO+1)
                return false;
        if(isTrue(board,'X'))
        {
            if(numX!=numO+1) return false;
            else return true;
        }
        else if(isTrue(board,'O'))
        {
            if(numX!=numO) return false;
            else return true;
        }
        return true;
    }
    boolean isTrue(String[] board,char v){
        if(board[0].charAt(0)==v&&board[0].charAt(1)==v&&board[0].charAt(2)==v) return true;
        if(board[1].charAt(0)==v&&board[1].charAt(1)==v&&board[1].charAt(2)==v) return true;
        if(board[2].charAt(0)==v&&board[2].charAt(1)==v&&board[2].charAt(2)==v) return true;
        if(board[0].charAt(0)==v&&board[1].charAt(0)==v&&board[2].charAt(0)==v) return true;
        if(board[0].charAt(1)==v&&board[1].charAt(1)==v&&board[2].charAt(1)==v) return true;
        if(board[0].charAt(2)==v&&board[1].charAt(2)==v&&board[2].charAt(2)==v) return true;
        if(board[0].charAt(0)==v&&board[1].charAt(1)==v&&board[2].charAt(2)==v) return true;
        if(board[0].charAt(2)==v&&board[1].charAt(1)==v&&board[2].charAt(0)==v) return true;
        return false;
    }
}
