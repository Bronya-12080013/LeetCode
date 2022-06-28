/*  注意方法 (Math.random() * n
官方迭代爬坡:
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int idx = (int) (Math.random() * n);

        while (!(compare(nums, idx - 1, idx) < 0 && compare(nums, idx, idx + 1) > 0)) {
            if (compare(nums, idx, idx + 1) < 0) {
                idx += 1;
            } else {
                idx -= 1;
            }
        }

        return idx;
    }

    // 辅助函数，输入下标 i，返回一个二元组 (0/1, nums[i])
    // 方便处理 nums[-1] 以及 nums[n] 的边界情况
    public int[] get(int[] nums, int idx) {
        if (idx == -1 || idx == nums.length) {
            return new int[]{0, 0};           //过边界的
        }
        return new int[]{1, nums[idx]};
    }

    public int compare(int[] nums, int idx1, int idx2) {
        int[] num1 = get(nums, idx1);
        int[] num2 = get(nums, idx2);
        if (num1[0] != num2[0]) {                //有一个过边界，另一个正常
            return num1[0] > num2[0] ? 1 : -1;        //正常的肯定比 过边界 的大
        }
        if (num1[1] == num2[1]) {                //两个都过边界 或 两个都正常 则 return 0;
            return 0;
        }
        return num1[1] > num2[1] ? 1 : -1;      //两个都正常 比较就行
    }
}
=========================================
方法二的二分查找优化 见下方
死缠烂打 像极了我翻字典的样子
 */

/* 暴力 过了
public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[nums.length-2]<nums[nums.length-1]) return nums.length;-1
        for(int i =1;i<nums.length-1;i++)
        {
            if(nums[i-1]<nums[i]&&nums[i]>nums[i+1]) return i;
        }
        return -1;
    }
}
 */

//官方 方法二的二分查找优化
//还是二分查找思想 只是比较对象变成了mid身旁的数罢了
package 刷题.leetcode.T162寻找峰值;

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid + 1) > 0) {
                ans = mid;
                break;
            }
            if (compare(nums, mid, mid + 1) < 0) {      //处于低估就默认向右
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // 辅助函数，输入下标 i，返回一个二元组 (0/1, nums[i])
    // 方便处理 nums[-1] 以及 nums[n] 的边界情况
    public int[] get(int[] nums, int idx) {
        if (idx == -1 || idx == nums.length) {
            return new int[]{0, 0};
        }
        return new int[]{1, nums[idx]};
    }

    public int compare(int[] nums, int idx1, int idx2) {
        int[] num1 = get(nums, idx1);
        int[] num2 = get(nums, idx2);
        if (num1[0] != num2[0]) {
            return num1[0] > num2[0] ? 1 : -1;
        }
        if (num1[1] == num2[1]) {
            return 0;
        }
        return num1[1] > num2[1] ? 1 : -1;
    }
}
