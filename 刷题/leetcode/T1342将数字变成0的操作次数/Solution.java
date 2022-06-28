/*
除夕简单题
力扣 现在的你 好温柔
========================================
还有一种模拟 不建议模仿

class Solution {
    public int numberOfSteps(int num) {
        int ret = 0;
        while (num > 0) {
            ret += (num > 1 ? 1 : 0) + (num & 0x01);
            num >>= 1;
        }
        return ret;
    }
}

 */
package 刷题.leetcode.T1342将数字变成0的操作次数;

class Solution {
    public int numberOfSteps(int num) {
        int sum=0;
        while (num!=0)
        {
            if((num&1)==0) num>>=1; //不是num>>1;
            else num--;
            sum++;
        }
        return sum;
    }
}
