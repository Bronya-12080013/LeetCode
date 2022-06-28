/*
ohhhhhhhhhhhhhhhh不愧是我(bushi)
总算写出来了   91.88% && 58.43%
本题的难度是去重
版一 : 没有去重方式(这时我没加boolean) 像下面的用例的ABCB的两个B重复使用了
版二 : 添加了去重方式(boolean) 但对多路选择不行
版三 : 根据结果来去重
自己看吧
每次写这种题都没自信 这次写完了也不敢保证下次还行
但还是能写
就这样过吧
 */

package 刷题.leetcode.T79单词搜索;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        };
        System.out.println(solution.exist(board,"ABCB"));
    }
    char[] chars;
    public boolean exist(char[][] board, String word) {
        chars=word.toCharArray();
        for(int i =0;i<board.length;i++)
        {
            for(int j =0;j<board[0].length;j++)
            {
                if(board[i][j]==chars[0]&&DFS(board,i,j,0,new boolean[board.length][board[0].length])) return true;
            }
        }
        return false;
    }

    /*  版一
   boolean DFS(char[][] board,int i,int j,int index)
   {
       if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=chars[index]||booleans[i][j]) return false;
       if(index==chars.length-1) return true;
       return DFS(board,i+1,j,index+1,booleans)||DFS(board,i-1,j,index+1,booleans)||DFS(board,i,j+1,index+1,booleans)||DFS(board,i,j-1,index+1,booleans);
   }

     */
   /*  版二
   boolean DFS(char[][] board,int i,int j,int index,boolean[][] booleans)
   {
       if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=chars[index]||booleans[i][j]) return false;
       booleans[i][j]=true;
       if(index==chars.length-1) return true;
       return DFS(board,i+1,j,index+1,booleans)||DFS(board,i-1,j,index+1,booleans)||DFS(board,i,j+1,index+1,booleans)||DFS(board,i,j-1,index+1,booleans);
   }
    */
    //版三
    boolean DFS(char[][] board,int i,int j,int index,boolean[][] booleans)
    {
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=chars[index]||booleans[i][j]) return false;
        booleans[i][j]=true;
        if(index==chars.length-1) return true;
        if(DFS(board,i+1,j,index+1,booleans)||DFS(board,i-1,j,index+1,booleans)||DFS(board,i,j+1,index+1,booleans)||DFS(board,i,j-1,index+1,booleans)) {
            booleans[i][j]=true;  //不加也行 如果能成功就直接一路返回成功了 不会往别的地方去了
            return true;
        }else
        {
            booleans[i][j]=false;
            return false;
        }

    }
}