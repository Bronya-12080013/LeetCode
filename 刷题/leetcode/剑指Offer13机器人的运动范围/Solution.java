//好耶
package 刷题.leetcode.剑指Offer13机器人的运动范围;

//DFS深度优先遍历法(我半（近大半）参考大佬代码写的)
class Solution {
    int m, n, k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m=m;                                     //用这种办法把题目要求的方法中的变量，提到外面去！！！
        this.n=n;
        this.k=k;
        this.visited=new boolean[m][n];               //反正数组的值也没用，用boolean来判断吧
        return DFS(0,0);
    }
    boolean canin(int i,int j){                       //判断能否进入行坐标和列坐标的数位之和大于k的格子的方法
        int sum=0;
        while (i>0){
            sum+=i%10;
            i/=10;

        }
        while (j>0){
            sum+=j%10;
            j/=10;
        }
        return sum<=k?true:false;
    }
    int DFS(int i, int j){
        if(i>=m||j>=n||visited[i][j]) return 0;      //不用i<0和j<0了  i和j有不会减少，只增加;      visited数组是boolean的，直接放上去
        if(!canin(i,j)) return 0;
        visited[i][j]=true;
        return 1+DFS(i+1,j)+DFS(i,j+1);          //这样从(0,0)往下和右走，会重复，但好用

    }
}

//BFS广度优先遍历(大佬代码)
/*
class RangeFreqQuery {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue= new LinkedList<int[]>();
        queue.add(new int[] { 0, 0, 0, 0 });
        while(queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if(i >= m || j >= n || k < si + sj || visited[i][j]) continue;
            visited[i][j] = true;
            res ++;
            queue.add(new int[] { i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj });
            queue.add(new int[] { i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8 });
        }
        return res;
    }
}
作者：jyd
链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/
 */