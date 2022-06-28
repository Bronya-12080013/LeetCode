/* 存在错误 不正确
卡在了 61/92  但底子就是错的
输入：
[12,6,12,6,14,2,13,17,3,8,11,7,4,11,18,8,8,3]
1
输出：
13
预期结果：
12
我甚至不知道怎么用人脑改
================================================================
我的代码:
package 刷题.比赛.第272场周赛蓝湖.题四;
public class Solution {
    public int kIncreasing(int[] arr, int k) {
        int time = 0;
        for(int i =0;i<k;i++)
        {
            int index = i+k;
            int front = arr[i];
            while (index<arr.length)
            {
                if(arr[index]<front){
                    arr[index]=front;
                    time++;
                }else front=arr[index];
                index+=k;
            }
        }
        return time;
    }
}

 */

//大佬代码:
/*
方法LIS
注意，只可以求长度，方法最后得到数组链表里不是最长递增子序列
 */
package 刷题.比赛.第272场周赛蓝湖.T5959使数组K递增的最少操作次数;

import java.util.ArrayList;
import java.util.List;

class Solution
{
    public static void main(String[] args) {
        int [] nums = new int[]{12,6,12,6,14,2,13,17,3,8,11,7,4,11,18,8,8,3};
        Solution solution = new Solution();
        System.out.println(solution.kIncreasing(nums,1));
    }
    public int LIS(List<Integer> nums)
    {
        List<Integer> a = new ArrayList<>();
        for (int x : nums)
        {
            int l = 0;
            int r = a.size();
            while (l < r)
            {
                int mid = (l + r) >> 1;
                if (a.get(mid) > x)
                    r = mid;
                else
                    l = mid + 1;
            }
            if (l == a.size())
            {
                a.add(x);
            }
            else
            {
                a.set(l, x);
            }
        }
        return a.size();
    }

    public int kIncreasing(int[] arr, int k)
    {
        int an = arr.length;
        int res = 0;
        for (int l = 0; l < k; l ++)
        {
            List<Integer> cur = new ArrayList<>();
            for (int r = l; r < an; r += k)
            {
                cur.add(arr[r]);
            }
            res += cur.size() - LIS(cur);
        }
        return res;
    }
}
