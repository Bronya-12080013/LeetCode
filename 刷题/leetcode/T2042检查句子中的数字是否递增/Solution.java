/*
__________________________________________

失败了，没考虑两位数
今晚没时间了
这题是竞赛题，想着简单，顺手就做起来了
。。。
做不出来
-----------------------------------------------
去看大佬的代码

.....我的圈子是不是绕得太大了，都用的栈去了
其实因为我不知道
String[] array =s.split("")
和
Character.isDigit(c.charAt(0))
这些方法！！！！！！！


*/

/*

package 刷题.leetcode.检查句子中的数字是否递增;


import java.util.Stack;

class RangeFreqQuery {

    public static void main(String[] args) {
       boolean a= areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles");
        System.out.println(a);
    }





    static boolean areNumbersAscending(String s) {
        String[] array =s.split("");
        Stack stack=new Stack();
        for(String c:array)
        {
            if(Character.isDigit(c.charAt(0)))
            {
                stack.push(c);
            }
        }
        while(!stack.empty())
        {
            if(Integer.valueOf((String)stack.pop())<=Integer.valueOf((String)stack.peek()))
                return false;
        }
        return true;
    }
}


*/


//双百大佬：
//记住把String拆分的方式
package 刷题.leetcode.T2042检查句子中的数字是否递增;
class Solution
{
    public boolean areNumbersAscending(String s)
    {
        String [] a = s.split(" ");
        int pre = -1;
        for (String x : a)
        {
            if (Character.isDigit(x.charAt(0)) == true)
            {
                if (pre >= Integer.parseInt(x))
                {
                    return false;
                }
                pre = Integer.parseInt(x);
            }
        }
        return true;
    }
}