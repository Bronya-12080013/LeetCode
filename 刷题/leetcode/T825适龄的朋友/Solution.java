/*
数组降序好麻烦 直接升序然后从后面遍历吧
==================================
找到降序方法了 但只能Integer的数组
public class Solution {
    public int numFriendRequests(Integer[] ages) {
            Comparator cmp = new CMP();
        Arrays.sort(ages,cmp);
    }
}
class CMP implements Comparator<Integer> {
    @Override //可以去掉。作用是检查下面的方法名是不是父类中所有的
    public int compare(Integer a,Integer b){
        //        两种都可以，升序排序的话反过来就行
        //        return a-b<0?1:-1;
        return b-a;
    }
}
====================================================================
排序 + 双指针
class Solution {
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        Arrays.sort(ages);
        int left = 0, right = 0, ans = 0;
        for (int age : ages) {
            if (age < 15) {
                continue;
            }
            while (ages[left] <= 0.5 * age + 7) {
                ++left;
            }
            while (right + 1 < n && ages[right + 1] <= age) {   //我纠结了好久ages[right + 1] <= age 有什么用 果然没吃早餐人傻了 见下面
                ++right;
            }
            ans += right - left;
        }
        return ans;
    }
}
// 我纠结了好久ages[right + 1] <= age 有什么用 果然没吃早餐人傻了
关于while (right + 1 < n && ages[right + 1] <= age)
注意！！！ 这是while！！不是if 那么有可能并不是每次都固定right只加一次
如果是排序后是 16 17 18 等单调不重复的,当然是每次都一个right++
但肯有 1.前面的if (age < 15) 跳过了许多 要在这里把right追上来
2.有重复的  15 16 17 17 17 之类 当age踏入第一个17时 它的射程就到了所有17 那么right就应该超前到最后一个17
====================================================================================================
方法：  计数排序 + 前缀和
详见https://leetcode-cn.com/problems/friends-of-appropriate-ages/solution/gua-ling-de-peng-you-by-leetcode-solutio-v7yk/
太妙了
对我方法这方法比上个方法还容易理解（上个方法在某地方卡了一下）

 */

//计数排序 + 前缀和
package 刷题.leetcode.T825适龄的朋友;

import java.util.*;

class Solution {
    public int numFriendRequests(int[] ages) {
        int[] cnt = new int[121];
        for (int age : ages) {
            ++cnt[age];
        }
        int[] pre = new int[121];
        for (int i = 1; i <= 120; ++i) {
            pre[i] = pre[i - 1] + cnt[i];
        }
        int ans = 0;
        for (int i = 15; i <= 120; ++i) {
            if (cnt[i] > 0) {
                int bound = (int) (i * 0.5 + 8);
                ans += cnt[i] * (pre[i] - pre[bound - 1] - 1);
            }
        }
        return ans;
    }
}


/*  超时了 78/88
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numFriendRequests(new int[]{16,17,18}));
    }
    public int numFriendRequests(int[] ages) {
     Arrays.sort(ages);
     int sum = 0;
     int[] last = new int[]{ages.length-1,ages[ages.length-1]}; //上一个同数字的下标，上一个同数字的值，
     for(int i =ages.length-1;i>=0;i--)
     {
         if(ages[i]!=last[1]){
             last[0]=i;
             last[1]=ages[i];
         }
        for(int j = last[0];j>=0;j--)
        {
            if(i==j) continue;
            if(ages[j]<=0.5*ages[i]+7) continue;
            sum++;
        }
     }
        return sum;
    }
}
 */
