/*
过了 62.47% && 72.20%
第一百题！！！！！！！！！！！！!!!!!!!!!
========================================================
看看人家的dfs 稳定的100%时间  比官方效率高
还有鼬鼬鼬！！！！！！！！！！！！！！！
虽然dfs方法是有返回值的 但不一定要接收！！！！！ 看下面直接四个dfs！！！！！
我之前一直提前考虑怎么处置返回值 现在知道了不一定要接收它
class TopVotedCandidate {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return dfs(image, sr, sc, newColor, image[sr][sc]);
    }

    public int[][] dfs(int[][] image, int i, int j, int newColor, int num){
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]==newColor || image[i][j]!=num){

        }else{
            int temp=image[i][j];         //这个是最初image[sr][sc]原本的色值  //它这里每次都int一个，以便下面传参，用于下一步判断
            image[i][j]=newColor;
            dfs(image, i+1, j, newColor, temp);
            dfs(image, i-1, j, newColor, temp);
            dfs(image, i, j+1, newColor, temp);
            dfs(image, i, j-1, newColor, temp);

        }
        return image;
    }
}
==============================================================
官方BFS
虽然dfs方法是有返回值的 但不一定要接收！！！！！ 看下面直接四个dfs！！！！！
我之前一直提前考虑怎么处置返回值 现在知道了不一定要接收它
class TopVotedCandidate {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }
        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }
}
 */

package 刷题.leetcode.T733图像渲染;


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] image = new int[][]{{0,0,0},{0,0,0}};
        solution.floodFill(image,0,0,2);
    }
    int[][] image;
    int color;
    int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image=image;
        boolean[][] booleans = new boolean[image.length][image[0].length];
        //Arrays.fill(booleans,false);           这里是个二维数组 不能这样
        this.color = image[sr][sc];
        dfs(sr,sc,newColor,booleans);
        return image;
    }
    void dfs(int sr,int sc,int newColor,boolean[][]booleans){
        if(booleans[sr][sc]==true) return;
        if(image[sr][sc]==color)
        {
            image[sr][sc]=newColor;
            booleans[sr][sc]=true;
            if(sr>0) dfs(sr-1,sc,newColor,booleans);  //上
            if(sr<image.length-1) dfs(sr+1,sc,newColor,booleans);
            if(sc>0) dfs(sr,sc-1,newColor,booleans);
            if(sc<image[0].length-1) dfs(sr,sc+1,newColor,booleans);   //注意：这里有坑 是sc<image[0].length-1  不是sc<image.length-1
            return;
        }else return;
    }
}
