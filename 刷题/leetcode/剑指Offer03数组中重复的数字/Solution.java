/*
简单

看看大佬的代码，不用HashSet,性能更好了
 */

package 刷题.leetcode.剑指Offer03数组中重复的数字;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set =new HashSet();
        int form = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(!set.add(nums[i]))
            { 
                form=nums[i];
                break;
            };
        }
        return form;
    }
}

/*

因此，可遍历数组并通过交换操作，使元素的 索引 与 值 一一对应（即 nums[i] = inums[i]=i ）。
因而，就能通过索引映射对应的值，起到与字典等价的作用。


class RangeFreqQuery {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}

作者：jyd
链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-yua/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */