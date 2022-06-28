/*
好耶 考完毛概了 2021/12/21 心情就行过年换上新内裤一样舒爽 刷题
==========================================================
过了 简单   方法date.substring() 截取子字符串  左闭右开
 */
package 刷题.leetcode.T1154一年中的第几天;

public class Solution {
    public static void main(String[] args) {
        Solution solution =new Solution();
        System.out.println(solution.dayOfYear("2019-01-09"));
    }
    public int dayOfYear(String date) {
        int [] mouths = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        if((Integer.parseInt(date.substring(0,4)))%4==0) mouths[1]=29;
        int days = 0 ;
        for(int i =0;i<Integer.parseInt(date.substring(5,7))-1;i++)
        {
            days+=mouths[i];
        }
        days+=Integer.parseInt(date.substring(8,10));
        return days;
    }
}
