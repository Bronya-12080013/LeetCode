/*
啊 我不行了
改了好多版 始终破不了 44/59
好好看了一下卡住的用例 应该是思路错了
我想的是对每个水塘都BFS一次 当遇到另一个水塘 或 step大于之前BFS过的截至
不是我思路错了 就是我代码有误
下面敲敲打打的就算了 注意一点 若不用 booleans (又不修改元素) BFS时 两个同级别的 是可能放入同一元素的 这个要想办法避免
 如从[0,0]开始 得同级别的[0,1] [1,0] 先[0,1]放入了[1,1]等 而后[1,0] 也会放入[1,1] 这时队列里就会有两个[1,1]了
 ====================================================================================================
 官方答案
 cao 发现题目看误了 不过这和我的思路好像没有冲突 也和我的超时无关 况且都已经44/59了
 看懂了 是我被过去束缚住了
 我的方法是从每个个点单独出发 而这对本题来说太耗时了 还要解决冲突
 应该是多点同时出发
 当然我一开始也是想过同时出发的 但脑子就是没想过把点先一起放入队列中
 也许是觉得还要先遍历一次太不优雅了

 ！！！总之 BFS 从一点出发 就只先放一点入队列 然后while (!queue.isEmpty())循环
           从多点出发 就把这些点都放到队列(先遍历一遍 顾不上优雅了) 再while (!queue.isEmpty())循环

  另外注意:
 int[][] ans = new int[m][n];
         for (int i = 0; i < m; ++i) {
             Arrays.fill(ans[i], -1); // -1 表示该格子尚未被访问过
         }

  不可以 Arrays.fill(ans, -1); // 二维数组直接这样是达咩的

 */

package 刷题.leetcode.T1765地图中的最高点;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

//官方答案
class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(ans[i], -1); // -1 表示该格子尚未被访问过
        }
        Queue<int[]> queue = new ArrayDeque<int[]>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    queue.offer(new int[]{i, j}); // 将所有水域入队
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int[] dir : dirs) {
                int x = p[0] + dir[0], y = p[1] + dir[1];
                if (0 <= x && x < m && 0 <= y && y < n && ans[x][y] == -1) {
                    ans[x][y] = ans[p[0]][p[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return ans;
    }
}

/*
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.highestPeak(new int[][]{
                {0, 0, 1}, {1, 0, 0}, {0, 0, 0}
        });
    }

    int[][] height;

    public int[][] highestPeak(int[][] isWater) {
        height = new int[isWater.length][isWater[0].length];
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) BFS(isWater, i, j);
            }
        }
        return height;
    }

    void BFS(int[][] isWater, int i, int j) {
        boolean[][] booleans = new boolean[isWater.length][isWater[0].length];
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{i, j, 0});
        booleans[i][j]=true;
        while (!deque.isEmpty()) {
            int[] e = deque.poll();
            int x = e[0], y = e[1], step = e[2];
            if ((x == i && y == j)) {
                if (step != 0) continue;
            } else {
                if (isWater[x][y] == 1) continue;
                if (height[x][y] != 0 && height[x][y] <= step) continue;  //结点一
            }
            height[x][y] = step;
            if (x + 1 < isWater.length&&!booleans[x+1][y])
            {
                booleans[x+1][y]=true;
                deque.offer(new int[]{x + 1, y, step + 1});
            }
            if (x - 1 >= 0&&!booleans[x-1][y])
            {
                booleans[x-1][y]=true;
                deque.offer(new int[]{x - 1, y, step + 1});
            }
            if (y + 1 < isWater[0].length&&!booleans[x][y+1])
            {
                booleans[x][y+1]=true;
                deque.offer(new int[]{x, y + 1, step + 1});
            }
            if (y - 1 >= 0&&!booleans[x][y-1])
            {
                booleans[x][y-1]=true;
                deque.offer(new int[]{x, y - 1, step + 1});
            }
        }
    }
}
 */
/*
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.highestPeak(new int[][]{
                {0, 0, 1}, {1, 0, 0}, {0, 0, 0}
        });
    }

    int[][] height;

    public int[][] highestPeak(int[][] isWater) {
        height = new int[isWater.length][isWater[0].length];
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) BFS(isWater, i, j);
            }
        }
        return height;
    }

    void BFS(int[][] isWater, int i, int j) {
        if (i < 0 || i >= isWater.length || j < 0 || j >= isWater[0].length) return;
        boolean[][] booleans = new boolean[isWater.length][isWater[0].length];
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{i, j, 0});
        booleans[i][j]=true;
        while (!deque.isEmpty()) {
            int[] e = deque.poll();
            int x = e[0], y = e[1], step = e[2];
            height[x][y] = step;
            step++;
            if ((x+1) == i && y == j) {
            }else if(x + 1 >= isWater.length){
            } else if (isWater[x+1][y] == 1) {
            }else if (height[x+1][y] != 0 && height[x+1][y] <= step) {
            } else if(!booleans[x+1][y])
            {
                booleans[x+1][y]=true;
                deque.offer(new int[]{x + 1, y, step});
            }

            if ((x-1) == i && y == j) {
            }else if(x - 1 < 0){
            } else if (isWater[x-1][y] == 1) {
            }else if (height[x-1][y] != 0 && height[x-1][y] <= step) {
            } else if(!booleans[x-1][y])
            {
                booleans[x-1][y]=true;
                deque.offer(new int[]{x - 1, y, step});
            }
            if (x == i && (y+1 )== j) {
            }else if(y + 1 >= isWater[0].length){
            } else if (isWater[x][y+1] == 1) {
            }else if (height[x][y+1] != 0 && height[x][y+1] <= step) {
            } else if(!booleans[x][y+1])
            {
                booleans[x][y+1]=true;
                deque.offer(new int[]{x, y+1, step});
            }

            if (x == i && (y-1 )== j) {
            }else if(y - 1 < 0){
            } else if (isWater[x][y-1] == 1) {
            }else if (height[x][y-1] != 0 && height[x][y-1] <= step) {
            } else if(!booleans[x][y-1])
            {
                booleans[x][y-1]=true;
                deque.offer(new int[]{x, y-1, step});
            }
        }
    }
}
 */

/* 版二 超时
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.highestPeak(new int[][]{
                {0, 0, 1}, {1, 0, 0}, {0, 0, 0}
        });
    }

    int[][] height;

    public int[][] highestPeak(int[][] isWater) {
        height = new int[isWater.length][isWater[0].length];
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) BFS(isWater, i, j);
            }
        }
        return height;
    }

    void BFS(int[][] isWater, int i, int j) {
        if (i < 0 || i >= isWater.length || j < 0 || j >= isWater[0].length) return;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{i, j, 0});
        while (!deque.isEmpty()) {
            int[] e = deque.poll();
            int x = e[0], y = e[1], step = e[2];
            height[x][y] = step;

            step++;

            if ((x+1) == i && y == j) {
            }else if(x + 1 >= isWater.length){
            } else if (isWater[x+1][y] == 1) {
            }else if (height[x+1][y] != 0 && height[x+1][y] <= step) {
            } else deque.offer(new int[]{x + 1, y, step});

            if ((x-1) == i && y == j) {
            }else if(x - 1 < 0){
            } else if (isWater[x-1][y] == 1) {
            }else if (height[x-1][y] != 0 && height[x-1][y] <= step) {
            } else deque.offer(new int[]{x - 1, y, step});

            if (x == i && (y+1 )== j) {
            }else if(y + 1 >= isWater[0].length){
            } else if (isWater[x][y+1] == 1) {
            }else if (height[x][y+1] != 0 && height[x][y+1] <= step) {
            } else deque.offer(new int[]{x, y+1, step});


            if (x == i && (y-1 )== j) {
            }else if(y - 1 < 0){
            } else if (isWater[x][y-1] == 1) {
            }else if (height[x][y-1] != 0 && height[x][y-1] <= step) {
            } else deque.offer(new int[]{x, y-1, step});
        }
    }
}
 */


/*  版一
好不容易写出来 超时了

注意结点一
虽然都是超时 但写<= 比 < 去重多得多了  前者 44/59 后者 14/59
if (height[x][y] != 0 && height[x][y] <= step) continue;

而不是 if (height[x][y] != 0 && height[x][y] < step) continue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.highestPeak(new int[][]{
                {0, 0, 1}, {1, 0, 0}, {0, 0, 0}
        });
    }

    int[][] height;

    public int[][] highestPeak(int[][] isWater) {
        height = new int[isWater.length][isWater[0].length];
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) BFS(isWater, i, j);
            }
        }
        return height;
    }

    void BFS(int[][] isWater, int i, int j) {
        if (i < 0 || i >= isWater.length || j < 0 || j >= isWater[0].length) return;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{i, j, 0});
        while (!deque.isEmpty()) {
            int[] e = deque.poll();
            int x = e[0], y = e[1], step = e[2];
            //if(!(x==i&&y==j)&&(((height[x][y]<step)&&height[x][y]!=0)||isWater[x][y]==1)) continue;
            if ((x == i && y == j)) {
                if (step != 0) continue;
            } else {
                if (isWater[x][y] == 1) continue;
                if (height[x][y] != 0 && height[x][y] <= step) continue;  //结点一
            }
            height[x][y] = step;
            if (x + 1 < isWater.length) deque.offer(new int[]{x + 1, y, step + 1});
            if (x - 1 >= 0) deque.offer(new int[]{x - 1, y, step + 1});
            if (y + 1 < isWater[0].length) deque.offer(new int[]{x, y + 1, step + 1});
            if (y - 1 >= 0) deque.offer(new int[]{x, y - 1, step + 1});
        }
    }
}
 */