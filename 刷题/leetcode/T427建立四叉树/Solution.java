package 刷题.leetcode.T427建立四叉树;
/*
终于过了
1.题目看了半天(其实是用的空隙时间，看不下)
2.犯了一堆错
比如 //return dfs(0,0,grid.length,grid[0].length,grid); 心跳骤停 1
我在dfs找了半天，最后debug才发现
然后是
  //if(same) return new Node(grid[r0][r1]==1,true);  //2
        //if(same) return new Node(grid[r0][r0]==1,true);  //3
        发现2后，改成了3,又错了
 */
class Solution {
    public static void main(String[] args) {
        int[][] g = new int[][]{
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}
        };
        construct(g);
    }
    static public Node construct(int[][] grid) {
        //return dfs(0,0,grid.length,grid[0].length,grid); 心跳骤停 1
        return dfs(0,grid.length,0,grid[0].length,grid);

    }

    static public Node dfs(int r0,int r1,int c0,int c1,int[][] grid){
        boolean same = true;
        for(int i=r0;i<r1;i++){
            for(int j=c0;j<c1;j++)
            {
                if(grid[i][j]!=grid[r0][c0])
                {
                    same=false;
                    break;
                }
            }
            if(!same) break; //前面的break只能跳出一次for 这里要再跳一次
        }


        //if(same) return new Node(grid[r0][r1]==1,true);  //2
        //if(same) return new Node(grid[r0][r0]==1,true);  //3
        if(same) return new Node(grid[r0][c0]==1,true);

        return new Node(
                true,
                false,
                dfs(r0,(r0 + r1) / 2,c0,(c0 + c1)/2,grid),
                dfs(r0,(r0 + r1) / 2,(c0 + c1)/2, c1,grid),
                dfs((r0 + r1) / 2,r1, c0, (c0 + c1) / 2,grid),
                dfs((r0 + r1) / 2,r1,(c0 + c1) / 2,c1,grid)
        );
    }
}



class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};