/*
很好，暴力超时了 但应该可以解决
不过这个写法我也是第一次
用 Set<Set<Integer>> set = new HashSet(); 来防止重复
是可行的
放进去的set保存着三个数   HashSet是没有顺序的  则只要别的set也是保存这三个数，就是一样的
=================================================================================

 */

/*
//先试试简单暴力的三循环
package 刷题.leetcode.剑指OfferII007数组中和为0的三个数;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Time {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        threeSum(nums);
    }
    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList= new ArrayList<>();
        Set<Set<Integer>> set = new HashSet();
        for(int i =0;i<nums.length-2;i++)
        {
            for (int j =i+1;j<nums.length-1;j++)
            {
                for(int k=j+1;k<nums.length;k++)
                {
                    if(nums[i]+nums[j]+nums[k]==0)
                    {
                        Set<Integer> s = new HashSet<>();
                        s.add(nums[i]);
                        s.add(nums[j]);
                        s.add(nums[k]);
                        if(!set.contains(s))
                        {
                            List<Integer> list= new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            listList.add(list);
                            set.add(s);
                        }
                    }
                }
            }
        }
        return listList;
    }
}
 */

package 刷题.leetcode.剑指OfferII007数组中和为0的三个数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0;i<nums.length;i++)
        {
            if(nums[i]>0) break;   //1
            if(i>0&&nums[i]==nums[i-1]) continue;             //重点     这里要用nums[i-1]而不是nums[i+1],因为写nums[i-1]就是要的左边界
                                                            /*
                                                                    因为num[i]和num[left]可以是一样的
                                                                    要留个机会给后面的left
                                                             */
            int left = i+1;
            int right = nums.length-1;
            while (left<right)
            {
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0)
                {
                    listList.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left<right&&nums[left]==nums[left+1]) left++;
                    left++;
                }else if (sum<0) left++;
                else right--;
            }
        }
        return listList;
    }
}

