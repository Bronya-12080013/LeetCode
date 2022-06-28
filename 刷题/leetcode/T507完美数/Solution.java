/*
2021/12/31   每日一题
今早考完了光学
2021的最后的最后一题 完美
=================================================
还有一种方法 究极打表 用数学方法而得

class Solution {
    public boolean checkPerfectNumber(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }
}

 */

//优化了一点   i<Math.sqrt(num)  或写成 i*i<=num
package 刷题.leetcode.T507完美数;

public class Solution {
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }
    static boolean checkPerfectNumber(int num) {
        int sum = 0;
        for(int i =1;i<Math.sqrt(num);i++)
        {
            if(num%i==0){
                sum+=i;
                if(i!=1) sum+=num/i;
            }
        }
        return sum==num;
    }
}

/* 暴力写法 过了 真是完美
package 刷题.leetcode.T507完美数;

public class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for(int i =1;i<num;i++)
        {
            if(num%i==0) sum+=i;
        }
        return sum==num;
    }
}
 */
