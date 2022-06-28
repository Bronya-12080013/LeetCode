package 刷题.leetcode.T812最大三角形面积;

/*
百度不靠谱()
由三点坐标算面积： S=Math.abs(x1*y2-x1*y3+x2*y3-x2*y1+x3*y1-x3*y2)/2;
 */

//12.35% && 75.30%
class Solution {
    public static void main(String[] args) {
        System.out.println(measure(new int[]{0,0},new int[]{0,2},new int[]{2,0}));
    }
    public double largestTriangleArea(int[][] points) {
        double res = Double.MIN_NORMAL;
        for(int i=0;i<points.length-2;i++)
        {
            for(int j=1;j<points.length-1;j++)
            {
                for(int k=2;k<points.length;k++)
                {
                    res=Math.max(res,measure(points[i],points[j],points[k]));
                }
            }
        }
        return res;
    }
    static double measure(int[] A,int[] B,int[] C)
    {
        double x1 = A[0];
        double y1 = A[1];
        double x2 = B[0];
        double y2 = B[1];
        double x3 = C[0];
        double y3 = C[1];
       // return (1/2)*(x1*y2-x1*y3+x2*y3-x2*y1+x3*y1-x3*y2); //-0.0 用上面的用例得
        return Math.abs(x1*y2-x1*y3+x2*y3-x2*y1+x3*y1-x3*y2)/2;
    }
}
/*
官方
class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double ret = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    ret = Math.max(ret, triangleArea(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]));
                }
            }
        }
        return ret;
    }

    public double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/largest-triangle-area/solution/zui-da-san-jiao-xing-mian-ji-by-leetcode-yefh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */