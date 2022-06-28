/*
惨胜  14.60% && 5.05%
本来以为很容易的 结果搞了贼久
==========================================
但终于改出来了
初版:
1.bo是board的复制版  前期改的 后期没用了 删掉也行
本想用bo不修改 board修改 每次传原本的bo 防止修改后有干扰 但这里没必要了

2. 先从矩阵的四边界渗入,再一个个地找边界渗入不到的
如果一开始就一个个地找，可能会有卡住的情况（从一个O到另一个三面都是X的O,这个三面都是X的O会被来路和三个X堵住，造成误判）
所以我先从矩阵的四边界渗入，利用isb,使得从矩阵的四边界渗入的都无条件true

3.注意 if(DFS(bo,i+1,j,b,isb)|DFS(bo,i-1,j,b,isb)|DFS(bo,i,j+1,b,isb)|DFS(bo,i,j-1,b,isb)|(isb))
用的是 | !!!!
||是左边true就不搞右边了
| 不管结果，两边都搞
同理
&&是左边false就不搞右边了
&是| 不管结果，两边都搞
就如同while里面要判断边界的条件话一定放左边
一定要注意 尤其是这种要并列返回boolean的方法的判断
==========================================================================================================
看看官方代码
1.思路比我好多了 也是从边界渗透 直接改（都不用判断是不是了，从边界的开始肯定就是了）
我一开始没想到要从边界出发 才走了许多弯路
2.而且答案是把不用修改的先设为A 最后再改回来 就不用再搞二维boolean了
3.答案对边界的遍历方式也好看
for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
=================================================================================================================
class Solution {
    int n, m;

    public void solve(char[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
}

 */

/*  初版
package 刷题.leetcode.T130被围绕的区域;
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char [][] borad = new char[][]{
             //  {'X','O','O','X','X','X','O','X','O','O'},
             //  {'X','O','X','X','X','X','X','X','X','X'},
             //  {'X','X','X','X','O','X','X','X','X','X'},
             //  {'X','O','X','X','X','O','X','X','X','O'},
             //  {'O','X','X','X','O','X','O','X','O','X'},
             //  {'X','X','O','X','X','O','O','X','X','X'},
             //  {'O','X','X','O','O','X','O','X','X','O'},
             //  {'O','X','X','X','X','X','O','X','X','X'},
             //  {'X','O','O','X','X','O','X','X','O','O'},
             //  {'X','X','X','O','O','X','O','X','X','O'}

              //  {'O','X','O','O','O','X'},{'O','O','X','X','X','O'},
              //  {'X','X','X','X','X','O'},{'O','O','O','O','X','X'},
              //  {'X','X','O','O','X','O'},{'O','O','X','X','X','X'},

                {'X','O','X','O','X','O','O','O','X','O'},
                {'X','O','O','X','X','X','O','O','O','X'},
                {'O','O','O','O','O','O','O','O','X','X'},
                {'O','O','O','O','O','O','X','O','O','X'},
                {'O','O','X','X','O','X','X','O','O','O'},
                {'X','O','O','X','X','X','O','X','X','O'},
                {'X','O','X','O','O','X','X','O','X','O'},
                {'X','X','O','X','X','O','X','O','O','X'},
                {'O','O','O','O','X','O','X','O','X','O'},
                {'X','X','O','X','X','X','X','O','O','O'},

        };
        solution.solve(borad);
    }


    boolean[][] booleans;
    char[][] bo;
    char[][] board;
    public void solve(char[][] board) {
        booleans = new boolean[board.length][board[0].length];
        bo = new char[board.length][board[0].length];
        this.board = board;
        //bo复制board
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                bo[i][j]=board[i][j];
            }
        }

        //先从矩阵的四边界渗入
        for(int i=0;i<board.length;i++)
        {
            if(i==0||i==board.length-1) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 'O' && !booleans[i][j]) {
                        boolean[][] b = new boolean[board.length][board[0].length];
                        boolean isb = (i == 0 || j == 0 || i == bo.length - 1 || j == bo[0].length - 1);
                        DFS(bo, i, j, b, isb);
                    }
                }
            }else {
                int j =0;
                if (board[i][j] == 'O' && !booleans[i][j]) {
                    boolean[][] b = new boolean[board.length][board[0].length];
                    boolean isb = (i == 0 || j == 0 || i == bo.length - 1 || j == bo[0].length - 1);
                    DFS(bo, i, j, b, isb);}
                j=board[0].length-1;
                if (board[i][j] == 'O' && !booleans[i][j]) {
                    boolean[][] b = new boolean[board.length][board[0].length];
                    boolean isb = (i == 0 || j == 0 || i == bo.length - 1 || j == bo[0].length - 1);  //后期可以 直接写 isb=true了
                    DFS(bo, i, j, b, isb);}
            }
        }

        //再一个个地找边界渗入不到的
        for(int i=0;i<board.length;i++){
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !booleans[i][j]) {
                    boolean[][] b = new boolean[board.length][board[0].length];
                    boolean isb = (i == 0 || j == 0 || i == bo.length - 1 || j == bo[0].length - 1);  //后期可以 直接写 isb=false了
                    DFS(bo, i, j, b, isb);
                }
            }
        }


    }
    boolean DFS(char[][] bo,int i ,int j,boolean[][] b,boolean isb)
    {
        if(i<0||j<0||i>=bo.length||j>=bo[0].length) return true;
        if(b[i][j]) return false;
        if(bo[i][j]=='X') return false;
        b[i][j]=true;
        if(DFS(bo,i+1,j,b,isb)|DFS(bo,i-1,j,b,isb)|DFS(bo,i,j+1,b,isb)|DFS(bo,i,j-1,b,isb)|(isb))
        {
            booleans[i][j]=true;
            return true;
        }else {
            board[i][j]='X';
            return false;
        }
    }
}
 */

//修改版
package 刷题.leetcode.T130被围绕的区域;
class Solution {
    boolean[][] booleans;
    char[][] board;
    public void solve(char[][] board) {
        booleans = new boolean[board.length][board[0].length];
        this.board = board;

        for(int i=0;i<board.length;i++)
        {
            if(i==0||i==board.length-1) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 'O' && !booleans[i][j]) {
                        DFS(i, j, true);
                    }
                }
            }else {
                int j =0;
                if (board[i][j] == 'O' && !booleans[i][j]) {
                    DFS( i, j, true);}
                j=board[0].length-1;
                if (board[i][j] == 'O' && !booleans[i][j]) {
                    DFS( i, j, true);
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !booleans[i][j]) {
                    board[i][j]='X';
                }
            }
        }


    }
    boolean DFS(int i ,int j,boolean isb)
    {
        if(i<0||j<0||i>=board.length||j>=board[0].length) return true;
        if(booleans[i][j]) return false;
        if(board[i][j]=='X') return false;
        booleans[i][j]=true;
        if(DFS(i+1,j,isb)|DFS(i-1,j,isb)|DFS(i,j+1,isb)|DFS(i,j-1,isb)|(isb))
        {
            booleans[i][j]=true;
            return true;
        }else {
            board[i][j]='X';
            return false;
        }
    }
}
