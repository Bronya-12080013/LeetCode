package 刷题.leetcode.T961在长度2N的数组中找出重复N次的元素;

import java.util.Arrays;

//每日一题
//简单 不愧是我（   48.66% && 46.13%
class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        return nums[0]==nums[nums.length/2-1]?nums[nums.length/2-1]:nums[nums.length/2]; //简单的推理 自己想想
    }
}

/*
啊 题目没好好看
“nums 包含 n + 1 个 不同的 元素”

官方答案 随机选择法
class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        Random random = new Random();

        while (true) {
            int x = random.nextInt(n), y = random.nextInt(n);
            if (x != y && nums[x] == nums[y]) {
                return nums[x];
            }
        }
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/solution/zai-chang-du-2n-de-shu-zu-zhong-zhao-chu-w88a/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */