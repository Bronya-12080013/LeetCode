package 刷题.leetcode.T417太平洋大西洋水流问题;

import java.util.ArrayList;
import java.util.List;

// 25.88% && 70.07%
class Solution {
    boolean[][][] booleans;
    int[][] heights;
    List<List<Integer>> list;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights=heights;
        list = new ArrayList<>();
        booleans = new boolean[heights.length][heights[0].length][2];
        for (int j=0;j<heights[0].length;j++)
        {
            DFS(0,j,0,-1);
            DFS(heights.length-1,j,1,-1);
        }
        for (int i=0;i<heights.length;i++)
        {
            DFS(i,0,0,-1);
            DFS(i,heights[0].length-1,1,-1);
        }
        return list;
    }
    void DFS(int i,int j,int code,int lastNum){
        if(i<0||j<0||i>=heights.length||j>=heights[0].length) return;
        if(heights[i][j]<lastNum) return;
        if(booleans[i][j][code]) return;
        else booleans[i][j][code]=true;
        if(booleans[i][j][0]&&booleans[i][j][1]) {
            List<Integer> l =new ArrayList<>();
            l.add(i);
            l.add(j);
            list.add(l);
        }
        DFS(i-1,j,code,heights[i][j]);
        DFS(i+1,j,code,heights[i][j]);
        DFS(i,j-1,code,heights[i][j]);
        DFS(i,j+1,code,heights[i][j]);
    }
}

/*  V1 5.03% && 46.06%
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                boolean[] booleans = new boolean[2];
                boolean[][] bs = new boolean[heights.length][heights[0].length];
                DFS(i, j, booleans,heights,heights[i][j],bs);
                if (booleans[0] && booleans[1]) {
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    list.add(l);
                }
            }
        }
        return list;
    }
        static void DFS ( int i, int j, boolean[] booleans,int[][] heights,int lastNum,boolean[][] bs)
        {
            if(i<0||j<0)
            {
                booleans[0]=true;
                return;
            }else if(i>=heights.length||j>=heights[0].length)
            {
                booleans[1]=true;
                return;
            }
            if(heights[i][j]>lastNum) return;
            if(bs[i][j]) return;
            bs[i][j]=true;
            DFS(i-1,j,booleans,heights,heights[i][j],bs);
            DFS(i+1,j,booleans,heights,heights[i][j],bs);
            DFS(i,j-1,booleans,heights,heights[i][j],bs);
            DFS(i,j+1,booleans,heights,heights[i][j],bs);
        }
}
 */