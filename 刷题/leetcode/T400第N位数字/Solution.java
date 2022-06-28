/*
每日一题
================================================
第一版当然不行
但有要注意的点:
======================================
Integer.valueOf()里面要放String才会变成对应的int值，如果放的是char,就会变成对应的ASCLL值 ，如 Integer.valueOf('4')  ==  52
下面的 return Integer.valueOf(stringBuffer.toString().charAt(n)) 就是返回的 52
应该写 return Integer.parseInt(String.valueOf(stringBuffer.toString().charAt(n)));
====================================================
看答案

 */

/* 这当然不行 V1   开在n=1000000000 是报错
package 刷题.leetcode.第N位数字400;
public class Time {
    public static void main(String[] args) {
        System.out.println(findNthDigit(3));
    }
    static int findNthDigit(int n) {
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 1;i<Integer.MAX_VALUE/10000;i++)
        {
            stringBuffer.append(i);
        }
       //n=3
      //  System.out.println(stringBuffer.toString().charAt(n));               //4
      //  System.out.println(String.valueOf(stringBuffer).charAt(n));//4
      //  System.out.println(String.valueOf(stringBuffer).charAt(n));   //4            //括号里的是字符！！！
       // return Integer.valueOf(stringBuffer.toString().charAt(n)).intValue();
       // return Integer.valueOf(stringBuffer.toString().charAt(n));
        return Integer.parseInt(String.valueOf(stringBuffer.toString().charAt(n)));  //4
       // return (stringBuffer.toString().charAt(n));
    }
}
 */

/*
V2 死心不改   和V1是卡在同用例 但是是超时  n=1000000000
package 刷题.leetcode.第N位数字400;
public class Time {
    static int findNthDigit(int n) {
        for(int i = 1;i<Integer.MAX_VALUE;i++)
        {
            if(n>String.valueOf(i).length())
            {
                n-=String.valueOf(i).length();
            }else {
                return Integer.parseInt(String.valueOf(String.valueOf(i).charAt(n-1)));  //4
            }
        }
        return -1;
    }
}
 */

//答案:        啊是数学我死了
package 刷题.leetcode.T400第N位数字;
class Solution {
    public static void main(String[] args) {
        System.out.println(findNthDigit(11));
    }
    static int findNthDigit(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }
}

/*
大佬注解版:
大致能理解，但自己真搞不出这些关系式子:
class Time {
    public int findNthDigit(int n) {
        // num表示具体的整数
        int num = 1;
        // count表示几位数
        int count = 1;
        // 9 * num * count 表示几位数总共有多少位数，比如，三位数从100~999，一共是 9 * 100 * 3 = 2700 位数
        while (n > 9 * (long) num * count) {
            // 从小到到依次减去一位数、两位数、三位数，直到减不了为止
            n -=  9 * num * count;
            // num此时记录的是几位数的第一个数，依次是1、10、100、1000
            num *= 10;
            // count表示几位数，每经过一轮加1，表示下一次判断的位数加1
            count++;
        }

        // 此时的 n 表示从 num 开始取第多少位
        // 比如，此时n=5,num=100,count=3，表示从100开始取第5位
        // 那么，100是三位，101是三位，所以，第5位肯定在101这个整数的第2位，也就是0
        // num += (n - 1) / count; 用来确定是哪个具体的整数了，这里 n-1 是为了防止边界情况，比如n=3,count=3，这时候会取超了
        // n -= (n - 1) / count * count; 用来确定是哪个具体的位，n=5-3=2，注意 4/3*3=3，不等于4
        // count-n，上面算出来的n是从高到低的第几位，通过 count-n 转成第低到高的第几位
        // (num / (int) Math.pow(10, count - n)) % 10; 取出那个位的数字


        // 确定是具体哪个整数
        num += (n - 1) / count;
        // 确定是这个整数中的哪个位
        n -= (n - 1) / count * count;

        // 取出那个位的数字
        return (num / (int) Math.pow(10, count - n)) % 10;
    }
}

作者：tong-zhu
链接：https://leetcode-cn.com/problems/nth-digit/solution/tong-ge-lai-shua-ti-la-zhao-gui-lu-by-to-nvfa/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */