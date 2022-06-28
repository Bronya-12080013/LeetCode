/*
方法一竟然过了
你tm故意找茬是吧，你做不做吧
你tm做我题
=====================================
方法二，buff上得多，最后超时了
=======================================
等等，有大佬的初版答案也是减法，但没超时
那我的为什么超时了?
答案1:
public class Time {
    // 因为将 -2147483648 转成正数会越界，但是将 2147483647 转成负数，则不会
// 所以，我们将 a 和 b 都转成负数
// 时间复杂度：O(n)，n 是最大值 2147483647 --> 10^10 --> 超时
    public int divide(int a, int b) {
        // 32 位最大值：2^31 - 1 = 2147483647
        // 32 位最小值：-2^31 = -2147483648
        // -2147483648 / (-1) = 2147483648 > 2147483647 越界了
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        // 环境只支持存储 32 位整数
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a <= b) {
            a -= b;
            res++;
        }
        // bug 修复：因为不能使用乘号，所以将乘号换成三目运算符
        return sign == 1 ? res : -res;
    }
}

答案2：改进版 快速幂思想（就是减成倍的,而且是赞到了最大的哪倍在减去）
(边界条件忘了就别深究了)
// 时间复杂度：O(logn * logn)，n 是最大值 2147483647 --> 10^10
public int divide(int a, int b) {
    if (a == Integer.MIN_VALUE && b == -1)
        return Integer.MAX_VALUE;
    int sign = (a > 0) ^ (b > 0) ? -1 : 1;
    if (a > 0) a = -a;
    if (b > 0) b = -b;
    int res = 0;
    while (a <= b) {
        int value = b;
        int k = 1;
        // 0xc0000000 是十进制 -2^30 的十六进制的表示
        // 判断 value >= 0xc0000000 的原因：保证 value + value 不会溢出
        // 可以这样判断的原因是：0xc0000000 是最小值 -2^31 的一半，
        // 而 a 的值不可能比 -2^31 还要小，所以 value 不可能比 0xc0000000 小
        // -2^31 / 2 = -2^30
        while (value >= 0xc0000000 && a <= value + value) {
            value += value;
            k += k;
        }
        a -= value;
        res += k;
    }
    // bug 修复：因为不能使用乘号，所以将乘号换成三目运算符
    return sign == 1 ? res : -res;
}

作者：tangweiqun
链接：https://leetcode-cn.com/problems/xoh6Oh/solution/jian-dan-yi-dong-javac-pythonjs-zheng-sh-e8r6/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

答案三:在前面的基础上继续优化，使用位运算来优化
见下方
=====================================================
核心是     快速幂思想
=====================================================
 */

/*
方法一过了
package 刷题.leetcode.剑指OfferII001整数除法;

public class Time {
    public int divide(int a, int b) {
        if(a==-2147483648&&b==-1)return 2147483647;
        return a/b;
    }
}
 */

/*
//方法2，行不通，千疮百孔的代码，打了很多补丁，最后死在了时间超时上
package 刷题.leetcode.剑指OfferII001整数除法;

public class Time {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648,2));
    }
    static int divide(int a, int b) {
        if(a==-2147483648&&b==-1)return 2147483647;
        if(a==-2147483648&&b==1) return -2147483648;
        int sum=0;
        int flag=1;
        int flag1=0;
        if(a<0&&b>0) {
           if(a==-2147483648){
               a=-(a+1);
               flag1=1;
           }else a=-a;
            flag=-1;
        }
        if(a>0&&b<0){
            b=-b;
            flag=-1;
        }
        if(a<0&&b<0)
        {
            if(a==-2147483648){
                a=-(a+1);
                flag1=1;
            }else a=-a;
            b=-b;
        }
        while (a>=b)
        {
            if(flag1>0&&a!=2147483647)
            {
                a=a+1;
                flag1=0;
            }
            a=a-b;
            sum++;
        }
        if(flag<0)
        return -sum;
        else return sum;
    }
}
 */



/*
答案三: 位运算，emmmmmm不会
其实和还是答案二的思想，好好看看，很容易的
效率还极高
 */
package 刷题.leetcode.剑指OfferII001整数除法;

public class Solution {
    // 时间复杂度：O(1)
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        a = Math.abs(a);
        b = Math.abs(b);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            // 首先，右移的话，再怎么着也不会越界
            // 其次，无符号右移的目的是：将 -2147483648 看成 2147483648

            // 注意，这里不能是 (a >>> i) >= b 而应该是 (a >>> i) - b >= 0
            // 这个也是为了避免 b = -2147483648，如果 b = -2147483648
            // 那么 (a >>> i) >= b 永远为 true，但是 (a >>> i) - b >= 0 为 false
            if ((a >>> i) - b >= 0) { // a >= (b << i)
                a -= (b << i);
                res += (1 << i);
            }
        }
        // bug 修复：因为不能使用乘号，所以将乘号换成三目运算符
        return sign == 1 ? res : -res;
    }
}
/*
    作者：tangweiqun
            链接：https://leetcode-cn.com/problems/xoh6Oh/solution/jian-dan-yi-dong-javac-pythonjs-zheng-sh-e8r6/
            来源：力扣（LeetCode）
            著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

/*
答案4：  也是快速幂思想 另一种写法
class Time {
    public int divide(int a, int b) {
        long x=a,y=b;
        int flag=1;
        if(x<0){
            flag=-flag;
            x=-x;
        }
        if(y<0){
            flag=-flag;
            y=-y;
        }
        long res=0;
        long weight;
        while (x>=y){
            weight=1;
            long tmp=y;
            while (tmp+tmp<=x){
                weight+=weight;
                tmp+=tmp;
            }
            x-=tmp;
            res+=weight;
        }
        if(flag==-1)res=-res;
        return res>Integer.MAX_VALUE?Integer.MAX_VALUE: (int) res;
    }
}

作者：fszhang
链接：https://leetcode-cn.com/problems/xoh6Oh/solution/jie-jian-kuai-su-mi-si-xiang-shi-xian-zh-xnq6/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */