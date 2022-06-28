package 刷题.leetcode.T1037有效的回旋镖;

//比预想的还有费劲  100.00% && 9.24% //取第一、第二点求直线，判断第三点是否在线上 //如果x1==x2 分母会出错，所以单独判断
class Solution {
    public static void main(String[] args) {
        System.out.println(isBoomerang(new int[][]{{22,33},{37,27},{67,15}}));
    }
    static public boolean isBoomerang(int[][] points) {
        if(points[0][0]==points[1][0]&&points[0][1]==points[1][1]) return false;
        if(points[0][0]==points[2][0]&&points[0][1]==points[2][1]) return false;
        if(points[1][0]==points[2][0]&&points[1][1]==points[2][1]) return false;
        double fun=-1;
        if (points[1][0]==points[0][0])
        {
            fun=points[1][0];
            if(points[2][0]==fun) return false;
            else return true;
        }
        else {
            double x1 = points[0][0];
            double y1 = points[0][1];
            double x2 = points[1][0];
            double y2 = points[1][1];
            double k = (y2-y1)/(x2-x1);
            double b = y1-k*x1;

             double x3=points[2][0];
             double y3=points[2][1];
             double sub = Math.abs(y3-(k*x3+b));  //注意，这里要用差还判断 //计算物理常用的
             if(sub<Math.pow(10,-7)) return false;
             else return true;
        }
    }
}
/* 官方答案  大学生失格
class Solution {
    public boolean isBoomerang(int[][] points) {
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }
}
 */


/*
//失败了 203/206  当分母为0时，k无穷，Math.abs(k1-k2)<Math.pow(10,-7)判断失败
//注意已知条件 points.length == 3
class Solution {
    public static void main(String[] args) {
        System.out.println(isBoomerang(new int[][]{{73,31},{73,19},{73,45}}));
    }
    static public boolean isBoomerang(int[][] points) {
        if(points[0][0]==points[1][0]&&points[0][1]==points[1][1]) return false;
        if(points[0][0]==points[2][0]&&points[0][1]==points[2][1]) return false;
        if(points[1][0]==points[2][0]&&points[1][1]==points[2][1]) return false;
     double k1 =(double)(points[1][1]-points[0][1])/(points[1][0]-points[0][0]);
     double k2 =(double)(points[2][1]-points[1][1])/(points[2][0]-points[1][0]);
     if(Math.abs(k1-k2)<Math.pow(10,-7)) return false;
     else return true;
    }
}
 */