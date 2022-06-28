package 刷题.比赛.第291场周赛FunPlus.T6049含最多K个可整除元素的子数组;

import java.util.HashSet;
import java.util.Set;
/*
1.没想到这题真能双重for去重
2.滑动窗口，我常常是 1个for确定步长，另一个for确定起点，本题又要对窗口的每个位进行判断，我又得加一个for
可以像下面代码一样
1个for是起点，一个for移动，每次移动都记录，这样也可以遍历所有窗口
 */


//https://leetcode-cn.com/problems/k-divisible-elements-subarrays/solution/by-shou-hu-zhe-t-moiy/
class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int ans=0;
        Set<String> set=new HashSet<>();//去重使用
        for(int i=0;i<nums.length;i++)
        {
            int count=k;
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<nums.length;j++)
            {
                sb.append(nums[j]+" "); //加空格非常重要，否则无法区分 2,2 和 22 等有多位的数字
                if(nums[j]%p==0) count--;
                if(count>=0&&!set.contains(sb.toString())){
                    set.add(sb.toString());
                    ans++;
                }
            }
        }

        return ans;
    }
}


/*  无法去重，失败
class Solution {
    public static void main(String[] args) {
        int[] num = new int[]{
                2,3,3,2,2
        };
        System.out.println(countDistinct(num,2,2));
    }
    static public int countDistinct(int[] nums, int k, int p) {
        int count=0;
        for(int len = 1;len<=nums.length;len++)
        {
            for(int i=0;i+len<=nums.length;i++)
            {
                int time=k;
                for(int j=i;j<i+len;j++)
                {
                    if(nums[j]%p==0) time--;
                    if(time<0) break;
                }
                if(time>=0) count++;
            }
        }
        return count;
    }
}
 */