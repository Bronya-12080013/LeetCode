package 刷题.leetcode.T62不同路径;

/*
动态规划
这题只要点卡tag意思到是动态规划就很容易了
之前就写过类似的
很有意思
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] robot = new int[m][n];
        for(int i=0;i<m;i++) robot[i][0]=1;
        for (int j=0;j<n;j++) robot[0][j]=1;
        for(int i =1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                robot[i][j]=robot[i-1][j]+robot[i][j-1];
            }
        }
        //不过把所有格子的数加起来 也能过大部分用例 为什么？leetcode在搞什么
        return robot[m-1][n-1]; //最后要的结果是robot[m-1][n-1]
    }
}

/*
方法二 组会数学
今天怎么都数学
class Solution {
public:
    int uniquePaths(int m, int n) {
        long long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return ans;
    }
};

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/unique-paths/solution/bu-tong-lu-jing-by-leetcode-solution-hzjf/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

/* 不行 我用dfs 我是sb
class Solution {
    boolean[][] booleans;
    int m;
    int n;
    public int uniquePaths(int m, int n) {
        this.m=m;
        this.n=n;
        booleans = new boolean[m][n];
        return DFS(0,0);
    }
    int DFS(int i,int j){
        if(i<0||j<0||i>=m||j>=n||booleans[i][j]) return 0;
        if(i==m-1&&j==n-1) return 1;
        booleans[i][j]=true;
        int res = DFS(i-1,j)+DFS(i+1,j)+DFS(i,j-1)+DFS(i,j+1);
        booleans[i][j]=false;
        return res;
    }
}
 */