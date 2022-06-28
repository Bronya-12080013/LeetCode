package 刷题.leetcode.T36有效的数独;

//L题 (干别的事时，没事看看手机leetcode，随便看的题。因为没办法打代码，多半思考一下就去参考答案了。所有和答案很像)
/*
这题也不难
用Set也行
这里是用数组来判断
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] subboxes = new int[3][3][9]; //分成3*3子矩阵
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                char c = board[i][j];
                if(c!='.'){
                    int index = c-'0'-1; //因为是要放入数组的,所有多减个1
                    row[i][index]++;
                    col[j][index]++;
                    subboxes[i/3][j/3][index]++;
                    if(row[i][index]>1||col[j][index]>1||subboxes[i/3][j/3][index]>1) return false;
                }
            }
        }
        return true;
    }
}