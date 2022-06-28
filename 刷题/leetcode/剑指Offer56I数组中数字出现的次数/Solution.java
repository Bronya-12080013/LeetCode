/*还是位运算，不太会
好像有点开窍了

思路：

作者：jyd
链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/jian-zhi-offer-56-i-shu-zu-zhong-shu-zi-tykom/

代码：
class RangeFreqQuery {
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for(int num : nums)               // 1. 遍历异或
            n ^= num;
        while((n & m) == 0)               // 2. 循环左移，计算 m
            m <<= 1;
        for(int num: nums) {              // 3. 遍历 nums 分组
            if((num & m) != 0) x ^= num;  // 4. 当 num & m != 0
            else y ^= num;                // 4. 当 num & m == 0
        }
        return new int[] {x, y};          // 5. 返回出现一次的数字
    }
}
 */


//仿大佬代码:
package 刷题.leetcode.剑指Offer56I数组中数字出现的次数;

public class Solution {
    public int[] singleNumbers(int[] nums) {
       int n=0,x=0,y=0,m=1;                            //使x=0，y=0 这样无论异或^什么值都会变成对方
        for(int num : nums){
            n^=num;                                    //这里得到的最后结果就是x^y
        }
      //  while ((n&m)!=1) m<<=1;
        while ((n&m)==0) m<<=1;
        for(int num:nums){
          //  if((num&m)!=1) x^=num;
                                                    /*  注意！！！！！！！！！！！！！！！                               如：1，2，5，2
                                                         这里的判断不能写!=1   判断的结果应该是0或非0  而非0并不一定是1 m的那个1并不一定在最左边
           //  else y^=num;                               当然可写成if((num & m) == 0) x ^= num;
                                                           else y ^= num;
                                                     */
            if((num & m) != 0) x ^= num;
            else y ^= num;                            //    通过(num & m) != 0可以把x和y（那两个相同的值分开，其它值看情况被x ^= num或 y ^= num，但相同的值一定是分在一组的，所有一定会被消去）


        }
        return new int[] {x, y};
    }
}
