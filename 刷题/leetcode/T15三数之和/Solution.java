/*
这好像写过吧 是周赛?好像不是
好像是排序的吧
===================================================
这个方法就是我们常说的「双指针」，当我们需要枚举数组中的两个元素时，
如果我们发现随着第一个元素的递增，第二个元素是递减的，那么就可以使用双指针的方法
================================================================
官方答案:  也是定一移二   好强
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}

 */


//模仿答案写的
package 刷题.leetcode.T15三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        threeSum(new int[]{3,0,-2,-1,1,2});
    }
    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> arraylist = new ArrayList<>();
        for(int first=0;first<nums.length;first++)
        {
            if(first>0&&nums[first]==nums[first-1]) continue;
            int third = nums.length-1;
            for(int second = first+1;second<nums.length;second++)
            {
                if(second>first+1&&nums[second]==nums[second-1]) continue;
                while (second<third&&nums[second]+nums[third]+nums[first]>0) third--;   //nums[second]+nums[third]+nums[first]>0 就是second 和 third 位的和太大了
                if(second==third) break;
                if(nums[first]+nums[second]+nums[third]==0)
                {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    arraylist.add(list);
                }
            }
        }
        return arraylist;
    }
}

/*
超时 315/318
一顿操作猛如虎，点击提交超时了。
二话不说翻题解，评论区里全人才。
反反复复终得道，再次尝试却报错。
行行检查字字改，击败用户百分五。
package 刷题.leetcode.T15三数之和;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<Set<Integer>> set = new HashSet<>();
        for(int i =0;i< nums.length;i++)
            for (int j = i+1;j<nums.length;j++)
                for (int k =j+1;k<nums.length;k++)
                    if(nums[i]+nums[j]+nums[k]==0) {
                        ArrayList<Integer> l = new ArrayList();
                        Set<Integer> s = new HashSet<>();
                        l.add(nums[i]);
                        s.add(nums[i]);
                        l.add(nums[j]);
                        s.add(nums[j]);
                        l.add(nums[k]);
                        s.add(nums[k]);
                        if(!set.contains(s)){
                            list.add(l);
                            set.add(s);
                        }
                    }
        return list;
    }
}
 */

/*  失败了
package 刷题.leetcode.T15三数之和;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> arrayList = new ArrayList();
        if(nums.length==0) return arrayList;
        Set<Set<Integer>> set = new HashSet<>();
        int i =0;
        while (nums[i]<0){
            int j = i+1;
            while (j<nums.length-1)
            {
                int k = j+1;
                while (k<nums.length&&nums[k]<=0) k++;
                while (k<nums.length)
                {
                    if(nums[i]+nums[j]+nums[k]==0)
                    {
                        ArrayList<Integer> l = new ArrayList();
                        Set<Integer> s = new HashSet<>();
                        l.add(nums[i]);
                        s.add(nums[i]);
                        l.add(nums[j]);
                        s.add(nums[j]);
                        l.add(nums[k]);
                        s.add(nums[k]);
                        if(!set.contains(s)){
                            arrayList.add(l);
                            set.add(s);
                        }
                    }
                    k++;
                }
                j++;
            }
            i++;
        }
        return arrayList;
    }
}
 */