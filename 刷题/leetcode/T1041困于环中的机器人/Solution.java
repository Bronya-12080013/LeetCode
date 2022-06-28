/*
一次指令之后，只有(x,y)不是原点，并且方向和原来的方向一致，最后才回不去
//如果一次指令后，不在原点，但方向于原来不同，哪这之后多绕几圈也会回去的
========================================================================
过了 摸清规律就行 (这怎么才摸得出，我还是记住吧)
1.规律
2.原点的判断方法（数组）
非原点: (L[0]!=0&&L[1]!=0)||(L[0]+L[1]!=0)
======================================================================
3.看看大佬代码:  方向表示妙极了
int d = 0; // 四个方向 0上1右2下3左  这样定是为了满足 d+1就是向左转 d+3就是向右转
================================================================================
class Solution {
public:
    bool isRobotBounded(string instructions) {
        if (instructions.size() < 1 || instructions.size() > 100) {
            return false;
        }

        // 令x轴正向为北方（向上），y轴正向为东方（向右）
        int d = 0; // 四个方向 0上1右2下3左  这样定是为了满足 d+1就是向左转 d+3就是向右转
        vector<vector<int>> dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int x = 0;
        int y = 0;
        for (const auto& instr : instructions) {
            switch (instr) {
                case 'R':
                    d += 1;
                    break;
                case 'L':
                    d += 3;
                    break;
                case 'G':
                    d = d % 4;
                    x += dirs[d][0];
                    y += dirs[d][1];
                    break;
            }
        }

        return ((x == 0 && y == 0) || (d % 4 != 0));
    }
};
 */

//模拟
package 刷题.leetcode.T1041困于环中的机器人;

class Solution {
    public static void main(String[] args) {
        System.out.println(isRobotBounded("GLGLGGLGL"));
    }
    static boolean isRobotBounded(String instructions) {
        int[]  L = new int[]{0,0};
        char turn = 'N';
        char[] chars = instructions.toCharArray();
        for(int i =0;i<chars.length;i++){
            char c = chars[i];
            if(c=='G') {
                if(turn=='N') L[1]++;
                else if(turn=='E') L[0]++;
                else if(turn=='S') L[1]--;
                else if(turn=='W') L[0]--;
            }
            if(c=='L'){
                if(turn=='N') turn='W';
                else if(turn=='E') turn='N';
                else if(turn=='S') turn='E';
                else if(turn=='W') turn='S';
            }
            if(c=='R'){
                if(turn=='N') turn='E';
                else if(turn=='E') turn='S';
                else if(turn=='S') turn='W';
                else if(turn=='W') turn='N';
            }
        }
        /* 不行 原点不能用 L[0]!=0&&L[1]!=0 判断
        if(L[0]!=0&&L[1]!=0&&turn=='N') return false;
        else return true;
         */
        if(((L[0]!=0&&L[1]!=0)||(L[0]+L[1]!=0))&&turn=='N') return false;
        else return true;
    }
}
