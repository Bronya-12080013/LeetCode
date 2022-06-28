package 刷题.leetcode.T478在圆内随机生成点;

import java.util.Random;

//官方答案  数学不懂啦
class Solution {
    Random random;
    double xc, yc, r;

    public Solution(double radius, double x_center, double y_center) {
        random = new Random();
        xc = x_center;
        yc = y_center;
        r = radius;
    }

    public double[] randPoint() {
        while (true) {
            double x = random.nextDouble() * (2 * r) - r;
            double y = random.nextDouble() * (2 * r) - r;
            if (x * x + y * y <= r * r) {
                return new double[]{xc + x, yc + y};
            }
        }
    }
}



/*
//最后一个用例过不了 7/8    [0.01,-73839.1,-3289891.3]
class Solution {
    double radius;
    double x_center;
    double y_center;
    int[][] turn =new int[][]{{1,1},{1,-1},{-1,1},{-1,-1}};
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center=x_center;
        this.y_center=y_center;
    }

    public double[] randPoint() {
        double r=Math.random()*radius;
        double angle= Math.random()*90;
        int[] t = turn[(int)(Math.random()*4)];
        double x_n = x_center+(r*Math.sin(angle/180*3.14)*t[0]);
        double y_n = y_center+(r*Math.cos(angle/180*3.14)*t[1]);
        return new double[]{x_n,y_n};
    }
}
 */

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */