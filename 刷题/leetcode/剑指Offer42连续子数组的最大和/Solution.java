/*
?????
看了大佬的思路，好像和我的差不多
？？？？我开窍了？？？
我再试试
========================================
应该是我的判断条件错了
记住，“动态规划是利用历史记录来判断的”
我应该是用前面的和的正负来判断本次的选取
============================================
好耶，过了
看了大佬思路，没看代码
 */

package 刷题.leetcode.剑指Offer42连续子数组的最大和;

import java.util.ArrayList;



/*
呜呜呜，我不行了
class RangeFreqQuery {
    public int maxSubArray(int[] nums) {
        ArrayList arrayList =new ArrayList();
        int sum=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int curr=sum+nums[i];
            if(curr>=0)
                sum=curr;
            else if(curr<sum&&curr>=0)
            {
                arrayList.add(sum);
                sum=0;
            }
            else sum=0;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arrayList.size();i++)
        {
            if(max<(int)arrayList.get(i))
            {
                max=(int)arrayList.get(i);
            }
        }
        if(max>0)
        return max;
        else return 0;
    }
}
 */

//再次尝试
//成功！
class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]>0)
            {
                nums[i]=nums[i-1]+nums[i];
                if(max<nums[i])
                    max=nums[i];
            }
            else  if(max<nums[i])
                max=nums[i];
        }
        return max;
    }
}

/*
贴贴大佬代码
简洁
class RangeFreqQuery {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

作者：jyd
链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/mian-shi-ti-42-lian-xu-zi-shu-zu-de-zui-da-he-do-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */