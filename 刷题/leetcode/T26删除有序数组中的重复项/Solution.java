package 刷题.leetcode.T26删除有序数组中的重复项;

//100% && 46.03%
// 双指针
class Solution {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
    }
    static public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int i=0;
        for(int j=0;j<nums.length;)
        {
            while (j<nums.length&&nums[i]==nums[j]) //又打错条件了
            {
                j++;
            }
            i++;
            if(j<nums.length&&i<nums.length) nums[i]=nums[j];
        }
        return i;
    }
}
/*
官方代码:
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-tudo/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */