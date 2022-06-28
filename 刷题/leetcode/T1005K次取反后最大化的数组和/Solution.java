/*
过了  41.98% && 85.94%
简单 但要注意特殊情况 就是所有的数都是负数
所以才写
while (index<nums.length)
        {
            if(nums[index]<0)
            index++;
            else break;
        }
        if(index==nums.length) index--;
而不是
while (nums[index]<0)
      {
            index++;
      }
否则在这个while和下面都会因越界报错
================================================
我的思路是
先排序 力所能及地从最小的负数开始，把所有负数变成正数 之后，多余的k 2个可以在一个负数上抵消 所以不用计数 k%=k;
如果k还剩下1 那就不得不做出牺牲 比较原先最大的负数和最小的非负数（0或正数）（index指向的）若全数组都是负数 那 就就是变最大的负数了（index和negative都在一个位上）
====================================================
妙啊
class TopVotedCandidate {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 排序，把可能有的负数排到前面
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 贪心：如果是负数，而k还有盈余，就把负数反过来
            if (nums[i] < 0 && k > 0) {
                nums[i] = -1 * nums[i];
                k--;
            }
            sum += nums[i];
        }
        Arrays.sort(nums);
        // 如果k没剩，那说明能转的负数都转正了，已经是最大和，返回sum
        // 如果k有剩，说明负数已经全部转正，所以如果k还剩偶数个就自己抵消掉，不用删减，如果k还剩奇数个就减掉2倍最小正数。(因为sum原本的数没了，没了的部分还变成了负数反咬了一口，所以是两倍)
        return sum - (k % 2 == 0 ? 0 : 2 * nums[0]);
    }
}
 */
package 刷题.leetcode.T1005K次取反后最大化的数组和;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegations(new int[]{-4,-2,-3},4));
    }
    static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int index = 0;
        while (index<nums.length)
        {
            if(nums[index]<0)
            index++;
            else break;
        }
        if(index==nums.length) index--;
        int negative=0;
        for(int i=0;i<index;i++)
        {
            nums[i]=-nums[i];
            k--;
            negative=i;
            if(k==0) break;
        }
        k%=2;
        if(k==1)
        {
            if(Math.abs(nums[negative])<Math.abs(nums[index])) nums[negative]=-nums[negative];
            else nums[index]=-nums[index];
        }
        return Arrays.stream(nums).sum();
    }
}
