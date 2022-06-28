/*
好耶好耶好耶好耶好耶好耶好耶好耶好耶好耶好耶
简单简单简单简单简单简单简单简单简单简单简单
木大木大木大木大木大木大木大木大木大木大木大
（还是费了点功夫 中间隔了段晚餐及休闲）
但这个写出来还真是成就感爆棚
=================================================
官方代码：  和我的大差不差
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, provinces, i);
                circles++;
            }
        }
        return circles;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int provinces, int i) {
        for (int j = 0; j < provinces; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, provinces, j);
            }
        }
    }
}
 */
package 刷题.leetcode.T547省份数量;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] isConnected = new int[][]{
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(solution.findCircleNum(isConnected));
    }
    boolean[] booleans ;
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        this.booleans=new boolean[isConnected.length];
        for(int i = 0;i<isConnected.length;i++)
        {
            if(!booleans[i]) {
                DFS(isConnected,i);
                count++;
            }
        }
        return count;
    }

    void DFS(int[][] isConnected,int i){
        if(booleans[i]) return;
        booleans[i]=true;
        for(int k =0;k<isConnected[i].length;k++){
            if(k==i) continue;
            if(isConnected[i][k]==1) DFS(isConnected,k);
        }
    }
}
