//看看大佬周赛（257）视频，用暴力法，我也写了一个

/*
2021/12/29 每日一题刷到了
之前是暴力法 这次换个方法

 */

/*  暴力法
package 刷题.leetcode.T1995统计特殊四元组;

public class Solution {
    public int countQuadruplets(int[] nums) {
        int n =nums.length;
        int arg=0;
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++)
            {
                for(int k=j+1;k<n-1;k++)
                {
                    for(int l=k+1;l<n;l++)
                    {
                        if(nums[i]+nums[j]+nums[k]==nums[l])
                            arg++;
                    }
                }
            }

        }
        return arg;
    }
}
 */

package 刷题.leetcode.T1995统计特殊四元组;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int b = n - 3; b >= 1; --b) {
            for (int d = b + 2; d < n; ++d) {
                cnt.put(nums[d] - nums[b + 1], cnt.getOrDefault(nums[d] - nums[b + 1], 0) + 1);
            }
            for (int a = 0; a < b; ++a) {
                ans += cnt.getOrDefault(nums[a] + nums[b], 0);
            }
        }
        return ans;
    }
}
