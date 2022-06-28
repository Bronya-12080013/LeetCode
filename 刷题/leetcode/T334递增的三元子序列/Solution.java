/*
贪心思想：
为了找到递增的三元子序列，first 和 second 应该尽可能地小，此时找到递增的三元子序列的可能性更大。

要注意！！  first的下标 不一定 会在 second前面 在遍历过程中可能跑到前面去
但这并不会出错
因为 “first和second是有前一种可能的，如先是 2和3 但出现了1 first就从2变成了1 但它仍小于3 这个事实没有改变
成功的条件仍是找到大于second（3）的数 与first无关   若又出现2，second就变成了2 到了first前面了”
 */


package 刷题.leetcode.T334递增的三元子序列;

class Solution {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{2,4,3,1,5}));
    }
    static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }
}



/*  暴力 超时
class Solution {
    public boolean increasingTriplet(int[] nums) {
        for(int i =0;i<nums.length;i++){
            for(int j =i+1;j<nums.length;j++){
                for(int k= j+1;k<nums.length;k++)
                {
                    if(nums[i]<nums[j]&&nums[j]<nums[k]) return true;
                }
            }
        }
        return false;
    }
}
 */