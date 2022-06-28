/*
方法一，HashMap法     35.58% && 46.53%
过了  写时小心
======================================
算了，不会了（要睡觉了）
双重遍历应该也行，就不写了
一时也没什么法子了
二分法也想不到用途
======================================
ohhh看了一下解析，懂了
试试二分法
=========================================
 */


/*方法一 HashMap法
package 刷题.leetcode.两数之和II输入有序数组167;

import java.util.HashMap;

public class Time {
    public static void main(String[] args) {
        twoSum(new int[]{2,7,11,15},9);
    }
    static int[] twoSum(int[] numbers, int target) {
        HashMap hashMap = new HashMap();
        for(int i =0;i<numbers.length;i++)
        {
            if(hashMap.containsKey(numbers[i]))
            {
                //int[] res = new int[]{i+1,(int)hashMap.get(numbers[i])+1};
                //Arrays.sort(res);
                //return res;
                return  new int[]{(int)hashMap.get(numbers[i])+1,i+1};

           //     1.写时小心，下面放的是hashMap.put(target-numbers[i],i);
           //     那么这里就是取hashMap.get(numbers[i]) 否则会无指针报错
           //     2.因为本题下标要求是1开始，那就直接在结果各加一就行  (int)hashMap.get(numbers[i])+1    i+1
           //     3.结果是要排序的 可以用可以Arrays.sort()
           //     或直接 return  new int[]{(int)hashMap.get(numbers[i])+1,i+1};   就行，
           //     但不要反过来  return  new int[]{i+1,(int)hashMap.get(numbers[i])+1}

            }
            else hashMap.put(target-numbers[i],i);
        }
        return null;
    }
}
 */
package 刷题.leetcode.T167两数之和II输入有序数组;
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length;
        int t1=Integer.MIN_VALUE;
        while (i<j){
            int temp = j+(j-i)/2;
            if(temp>target) j=temp-1;
            else if(temp<target) i=temp+1;
            else {
                t1=numbers[temp];
                break;
            }
        }
        if(t1==Integer.MIN_VALUE) t1=numbers[i];
        i=0;
        j=numbers.length;
        int t2=Integer.MIN_VALUE;
        while (i<j){
            int temp = j+(j-i)/2;
            if(temp>target) j=temp-1;
            else if(temp<target) i=temp+1;
            else {
                t2=numbers[temp];
                break;
            }
        }
        if(t2==Integer.MIN_VALUE) t1=numbers[i];
        return new int[]{t1,t2};


    }
}
