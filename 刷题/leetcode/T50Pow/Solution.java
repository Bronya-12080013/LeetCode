package 刷题.leetcode.T50Pow;

/*
官方代码
用递归 至上而下更好理解
 */
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        //return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);  两种都行
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
/*
迭代方法
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/powx-n/solution/powx-n-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
/*  过慢 超时了
class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        boolean flag=true;
        if(n<0){
            n=-n;
            flag=false;
        }
        for(int i=0;i<n;i++)
        {
            res=res*x;
        }
        return flag?res:1/res;
    }
}
 */