/*
累了 写简单题放松身心  2021/12/1  22:39
不愧是通过率数一数二的题
=======================================
原地tp法   太棒了
class TopVotedCandidate {
    public int[] buildArray(int[] nums) {
        for(int i=0;i<nums.length;i++){nums[i]+=1000*(nums[nums[i]]%1000);}
        for(int i=0;i<nums.length;i++){nums[i]/=1000;}
        return nums;
    }
}

题目是有
1 <= nums.length <= 1000
0 <= nums[i] < nums.length
nums 中的元素 互不相同
的
原地法就是
在第一个for中 使num[i]同时保留 原本的数 和 即将要变成的数
即乘上1000  把即将要变成的数放到 前三位 把原本的数放在后三位   六位:000 000
当第二个for时，只需要/1000 就可以变成 即将要变成的数 了

别问为什么要存原本的数 因为nums[nums[i]]的指向是混乱的，但唯一   所以把原本的数放在后三位 用时就%1000取后三位nums[nums[i]]%1000

 */
package 刷题.leetcode.T1920基于排列构建数组;

public class Solution {
    public int[] buildArray(int[] nums) {
        int[] ans =new int[nums.length];
        for(int i =0;i< nums.length;i++)
        {
            ans[i]=nums[nums[i]];
        }
        return ans;
    }
}
