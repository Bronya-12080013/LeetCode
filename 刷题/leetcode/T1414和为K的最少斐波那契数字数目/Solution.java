/*
注意 int index=Arrays.binarySearch(fe,k);
这个方法的二分查询一定会只去找目标的k 如果找不到 返回的下标会是别的数(负数)
我下面要的是去找最大的大于等于k的数的下标 所以自己写了方法
==================================================================
注意 其中，每个斐波那契数字都可以被使用多次。
注意是证明本题能使用贪心 我看了标签 误打误撞地想出了
证明 ： https://leetcode-cn.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/solution/he-wei-k-de-zui-shao-fei-bo-na-qi-shu-zi-shu-mu-by/
官方代码 没什么行的 没我效率高
====================================================================
看看大佬的递归代码
class Solution {
   public int findMinFibonacciNumbers(int k) {
    if (k == 0) {
      return 0;
    }
    // 计算小于k的最大斐波那契数
    int one = 1;
    int two = 1;
    while (two <= k) {
      int three = one+two;
      one = two;
      two = three;
    }
    return findMinFibonacciNumbers(k-one)+1;
  }
}

 */
package 刷题.leetcode.T1414和为K的最少斐波那契数字数目;

import java.util.ArrayList;
import java.util.Arrays;

/* 版二 没有的优化 60.57% && 5.15%
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinFibonacciNumbers(7));
    }
    public int findMinFibonacciNumbers(int k) {
        ArrayList<Integer> arr = new ArrayList();
        arr.add(1);
        arr.add(1);
        int l=0,r=44; //因为斐波那契数字到第45个就到int极限了
        int i = 2;
        while (true)
        {
            arr.add(arr.get(i-1)+arr.get(i-2));
            if(i>45||arr.get(i)>=k) {
                r = i;
                break;
            }
            i++;
        }
        Integer[] fe = arr.toArray(new Integer[arr.size()]);  //int[] fe = arr.toArray(new int[arr.size()]); 不行 不是包装类 //String[] 可以
        while (l<r)
        {
            int mid = l+(r-l)/2;
            if(fe[mid]>k) r=mid-1; //r=mid 也能过
            else l=mid+1;
        }
        int index=l;
        int sum=0;
        while (index>=0)
        {
            if(k==0) break;
            if(k>=fe[index])
            {
                k-=fe[index];
                sum++;
            }
            index--;
        }
        return sum;
    }
}
 */

//  版一 2022/2/3 不愧是我 过了 83.43% && 5.15%  再优化优化  这二分真要命
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinFibonacciNumbers(7));
    }
    public int findMinFibonacciNumbers(int k) {
        int[] fe = new int[45];
        fe[0]=1;
        fe[1]=1;
        for(int i=2;i<fe.length;i++) fe[i]=fe[i-1]+fe[i-2];
        //Arrays.sort(fe);
        //int index=Arrays.binarySearch(fe,k);
        int l=0,r=fe.length-1;
        while (l<r)
        {
            int mid = l+(r-l)/2;
            if(fe[mid]>k) r=mid-1; //r=mid 也能过
            else l=mid+1;
        }
        int index=l;
        int sum=0;
        while (index>=0)
        {
            if(k==0) break;
            if(k>=fe[index])
            {
                k-=fe[index];
                sum++;
            }
            index--;
        }
        return sum;
    }
}
