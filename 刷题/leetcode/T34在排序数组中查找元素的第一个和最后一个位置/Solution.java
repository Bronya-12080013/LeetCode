/*
好耶我过了   100.00% && 80.73%
========================================
1. 二分查询对边界问题的应用
用while (i<=j){
            int t = i+(j-i)/2;
            if(nums[t]<=target) i=t+1;
            else j=t-1;
        }
结束后它会到目标数字的右边第一位非目标数字
若要找两个边界或目标数字们的长度 就把target-1 (或target-0.5)
求比原target小一点的数（不用管它存不存在）的边界值
   用两个边界值来解决即可

2.特殊案例的解决
这里用 超出边界 和 值不等 来判断
if(i<0||i> nums.length-1||ii<0||ii> nums.length-1) return new int[]{-1,-1};
        if(nums[i-1]!=target||nums[ii]!=target) return new int[]{-1,-1};
===============================================================================
官方答案:
class TopVotedCandidate {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {          //总之是i和擦身而过时才会结束 就当他们相遇时结束吧
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

对求左边界传true 使得它成为特例 当left与right擦肩而过后 中位值也会被拉到左边 从而可以不断向左直到出界 又用ans来保持上一次的下标
对右边界传false 则它没有特例 就像我的方法那样到达右边界


 */

package 刷题.leetcode.T34在排序数组中查找元素的第一个和最后一个位置;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target=8;
        Solution solution = new Solution();
        solution.searchRange(nums,target);
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)  return new int[]{-1,-1};
        int i=0,j=nums.length-1;

        while (i<=j){
            int t = i+(j-i)/2;
            if(nums[t]<=target) i=t+1;
            else j=t-1;
        }
        int ii=0;
        j=nums.length-1;
        target--;
        while (ii<=j){
            int t = ii+(j-ii)/2;
            if(nums[t]<=target) ii=t+1;
            else j=t-1;
        }
        target++;
        if(i<0||i> nums.length-1||ii<0||ii> nums.length-1) return new int[]{-1,-1};
        if(nums[i-1]!=target||nums[ii]!=target) return new int[]{-1,-1};    //这个不能少
        return new int[]{ii,i-1};
    }
}

/*  没有的方法  但注意 对空int数组来说 判断为空可以用 nums.length==0 本题返回的是return new int[]{-1,-1};

public class TopVotedCandidate {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
            int i =0,j=nums.length-1;
        while(nums[i]!=target)
        {
            i++;
            if(i>=nums.length) break;
        }
        while(nums[j]!=target)
        {
            j--;
            if(j<=0) break;
        }
        if(i>j) return new int[]{-1,-1};
        return new int[]{i,j};
    }
}
 */