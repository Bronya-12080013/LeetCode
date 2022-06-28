/*
普通的遍历过了
另外，我求个最大数（9999等）竟然卡住了一会。。。。
应该直接  nums=Math.pow(10,n)-1;的！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
==========================================
力扣好像魔改了
还存在大数问题
=============================================
 */

//大佬的代码，主要是全排列，应用dfs递归全排列，太强了
//我照着有写了一遍
package 刷题.leetcode.剑指Offer17打印从1到最大的n位数;
class Solution {
    int[] res;
    int count = 0;         //后面用count++,这里记得赋初始值

    public int[] printNumbers(int n) {
        res = new int[(int)Math.pow(10, n) - 1];               //总结果有(int)Math.pow(10, n) - 1那么多，都放进res
        for(int digit = 1; digit < n + 1; digit++){            //几位数的（如 3 ）
            //注意，字符也可以这么遍历
            for(char first = '1'; first <= '9'; first++){       //开头是什么数字的  （如当digit是3时，下面就按照1xx,2xx,3xx ... 9xx ; 若上一层循环到digit=2时,就1x,2x,3x ... 9x这么遍历）
                char[] num = new char[digit];
                num[0] = first;                                // 如上面说的，把开头数字设成first!
                dfs(1, num, digit);
                /*
                    开启dfs
                    当digit=1 first=1 这个dfs就会把 1 写入 res
                    当digit=1 first=2  这个dfs就会把 2 写入 res  ...
                    当digit=2 first=1  这个dfs就会把 10~19 写入 res
                    当digit=2 first=2  这个dfs就会把 20~29 写入 res  ...
                    当digit=3 first=1  这个dfs就会把 100~199 写入 res
                    当digit=3 first=2  这个dfs就会把 200~299 写入 res  ...
                    总之，digit是位数，first是首数字
                                                                        */


            }
        }
        return res;
    }

    private void dfs(int index, char[] num, int digit){                     //这里传入的index 最先(!) 传的是1，是首数字的第二位，即先写nums[1](因为上面的nums[0]=first了) ; digit是数组的长度，即num[digit-1]之后的哪里，拿来当结束标志
        if(index == digit){                                                 //例子： 当digit=3 first=1(即nums[0]=1) ,那么这里先会:10，100(写入)，（回去）10，再101(写入),(回去)10..........119(写入),11，12，120，12，120，12，121...  此即dfs深度优先搜索
            //index出界了，该写入，并回去了
            res[count++] = Integer.parseInt(String.valueOf(num));
            return;
        }
        for(char i = '0'; i <= '9'; i++){
            num[index] = i;
            dfs(index + 1, num, digit);  //确认本位数，去到下一位
        }
    }
}

//作者：edelweisskoko 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/jian-zhi-offer-17-da-yin-cong-1dao-zui-d-ngm4/


/*
package 刷题.leetcode.剑指Offer17打印从1到最大的n位数;
public class Time {
    public int[] printNumbers(int n) {
        int nums =9;
        //不要求个位数都写不出啊！
        while (n!=1)
        {
            nums=nums*10+9;
            n--;
        }
        int[] sum = new int[nums];
        for(int i=1;i<=nums;i++)
        {
           sum[i-1]=i;
        }
        return sum;
    }
}
 */

