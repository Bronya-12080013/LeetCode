/*
初版过了
但写法太菜鸡了
=====================
搞了好久的修改版，在一个大大大大数的用例哪超时了
emmmmmmmmmmmmmm虽然有简化方法，但不搞了了
看答案
================================================

 */

/*
先试试最简单的
============================
过了  63.56% && 35.79%
当然不可能写这玩意
package 刷题.leetcode.轮转数组189;

public class Time {
    public static void main(String[] args) {
        int[] nums= new int[]{1,2,3,4,5,6,7};
        rotate(nums,3);
    }
    static void rotate(int[] nums, int k) {
        if(k==0) return;
        int[] num=new int[nums.length];
        int count = k ;
        int i = nums.length;
        for(;count!=0;count--)           //又把结束条件写在这了
        {
            i--;
            if(i==-1) i =nums.length-1;
        }
        count=nums.length;
        int n = 0;
        for(;count!=0;count--)
        {
            num[n++]=nums[i];
            i++;
            if(i==nums.length) i=0;
        }
        for(int j=0;j<nums.length;j++)
        {
            nums[j]=num[j];
            //System.out.println(nums[j]);
        }
    }
}

 */

/*
emmmmmmmmmmmmm
修改版
package 刷题.leetcode.轮转数组189;

public class Time {
    public static void main(String[] args) { //测试
        int[] nums= new int[]{1,2,3,4,5,6};
        rotate(nums,4);
    }
    static void rotate(int[] nums, int k) {
        if(k==0) return;
        boolean flag=false;
        int temp2= nums.length*2;
        int time2=0;
        while (temp2<= nums.length*nums.length)
        {
            if(temp2%k==0)
            {
                flag=true;
                time2=temp2/k;
                break;
            }
            temp2+= nums.length;
        }
        //假设k<=nums.length
        int n = nums.length;
        if(nums.length%k==0) flag=false;
        if(flag)
        {
            //     if(nums.length==6&&k==4) time=3;
            int i = 0;
            int temp=nums[0];
            int time22=time2;
            while (n!=0)
            {
                if(time2==0) {
                    i++;
                    time2=time22;
                    //         if(nums.length==6&&k==4) time=3;
                    temp=nums[i];
                }
                time2--;
                for(int j =0;j<k;j++)
                {
                    i++;
                    if(i== nums.length) i =0;
                }
                int t = nums[i];
                nums[i]=temp;
                temp=t;
                n--;
            }
        }
        else if(nums.length%k==0){
            int time=nums.length/k;
       //     if(nums.length==6&&k==4) time=3;
            int i = 0;
            int temp=nums[0];
            while (n!=0)
            {
                if(time==0) {
                    i++;
                    time=nums.length/k;
           //         if(nums.length==6&&k==4) time=3;
                    temp=nums[i];
                }
                time--;
                for(int j =0;j<k;j++)
                {
                    i++;
                    if(i== nums.length) i =0;
                }
                int t = nums[i];
                nums[i]=temp;
                temp=t;
                n--;
            }
        } else {
            int i = 0;
            int temp=nums[0];
            while (n!=0)
            {
                for(int j =0;j<k;j++)
                {
                    i++;
                    if(i==nums.length) i =0;
                }
                int t= nums[i];
                nums[i]=temp;
                temp=t;
                n--;
            }
        }
    }
}
 */

//大佬答案--翻转法  好理解  链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/
package 刷题.leetcode.T189轮转数组;
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}

/*
大佬答案--跳跃法  和我上面改进版的思路一样，但我上面的代码沉长（不知道改一下还会不会超时），本答案的数学推导不想看了，用翻转法吧
class Time {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}

作者：LeetCode-Time
链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/
 */

