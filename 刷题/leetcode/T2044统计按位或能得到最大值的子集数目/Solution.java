package 刷题.leetcode.T2044统计按位或能得到最大值的子集数目;

//看完这题，我灵魂都升华了
//用二进制表示(全)组合
/*
用可以用一个长度为 n 比特的整数来表示不同的子集
即用 for (int i = 0; i <(1 << nums.length); i++) 就可是表示出数组的全组合
如nums = [3,2,1,5]    (1 << nums.length)表示'10000'  则i从'0000'到'1111'(十进制的0到15)
当i='0101'（即i=5） 表示取子集[2,5]
 */
class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0, cnt = 0;
        for (int i = 0; i <(1 << nums.length); i++) {  //取全组合
            int orVal = 0;
            for (int j = 0; j < nums.length; j++) {   //把i挨个位判断
                if (((i >> j) & 1) == 1) {  // 即要 i>>j == 1  ，也就是i的第j位为1而不是0
                    orVal |= nums[j]; //这是题目所求，没什么理由   “|=”做按位或运算  "有1取1"
                }
            }
            if (orVal > maxOr) {
                maxOr = orVal;
                cnt = 1;
            } else if (orVal == maxOr) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
方法二: 回溯
class Solution {
    int[] nums;
    int maxOr, cnt;

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        this.maxOr = 0;
        this.cnt = 0;
        dfs(0, 0);
        return cnt;
    }

    public void dfs(int pos, int orVal) {
        if (pos == nums.length) {
            if (orVal > maxOr) {
                maxOr = orVal;
                cnt = 1;
            } else if (orVal == maxOr) {
                cnt++;
            }
            return;
        }
        dfs(pos + 1, orVal | nums[pos]);
        dfs(pos + 1, orVal);
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets/solution/tong-ji-an-wei-huo-neng-de-dao-zui-da-zh-r6zd/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
