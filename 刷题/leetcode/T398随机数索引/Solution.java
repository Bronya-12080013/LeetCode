package 刷题.leetcode.T398随机数索引;

import java.util.ArrayList;
import java.util.HashMap;

/*
    28.60% && 28.68%
    空间换时间
 */
class Solution {
    HashMap<Integer,ArrayList<Integer>> hashMap ;
    public Solution(int[] nums) {
        hashMap = new HashMap();
        for(int i=0;i<nums.length;i++)
        {
            if(!hashMap.containsKey(nums[i]))  //可以用putIfAbsent()
            {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(nums[i],list);
            }else {
                ArrayList list = hashMap.get(nums[i]);
                list.add(i);
            }
        }
    }

    public int pick(int target) {
        ArrayList<Integer> list = hashMap.get(target);
        return list.get((int) (Math.random()*list.size()));
    }
}
/*
官方解法 是我们的老朋友 （一面之缘） 水塘抽样
时间换空间 在这题感觉不如第一种
class Solution {
    int[] nums;
    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int ans = 0;
        for (int i = 0, cnt = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                ++cnt; // 第 cnt 次遇到 target
                if (random.nextInt(cnt) == 0) {
                    ans = i;
                }
            }
        }
        return ans;
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/random-pick-index/solution/sui-ji-shu-suo-yin-by-leetcode-solution-ofsq/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */