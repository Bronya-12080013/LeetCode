/*
给你一个下标从 0 开始的整数数组 nums 以及一个目标元素 target 。
目标下标 是一个满足 nums[i] == target 的下标 i 。
将 nums 按 非递减 顺序排序后，返回由 nums 中目标下标组成的列表。如果不存在目标下标，返回一个 空 列表。返回的列表必须按 递增 顺序排列。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-target-indices-after-sorting-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
==================================================================================================
送分题
=============================
和大佬的答案 这次全球第一的大佬也是用java写的耶
 */

package 刷题.比赛.第269场周赛Tapdata.找出数组排序后的目标下标;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List list = new ArrayList();
        Arrays.sort(nums);
        for(int i =0;i<nums.length;i++)
        {
            if(nums[i]==target) list.add(i);
        }
        return list;
    }
}
