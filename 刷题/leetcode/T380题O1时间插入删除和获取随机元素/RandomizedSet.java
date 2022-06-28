
package 刷题.leetcode.T380题O1时间插入删除和获取随机元素;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 1.取随机整数值，在0到数组arr长度(不包含)的范围
 * ===
 *  Random random = new Random();
 *  int index = random.nextInt(arr.length());
 * ===
 *  int idx = (int) (Math.random() * arr.length());
 * ===
 *
 * 2.优解是 变长数组（List） + 哈希表
 * 变长数组可以在 O(1) 的时间内完成获取随机元素操作，但是由于无法在 O(1) 的时间内判断元素是否存在，
 * 因此不能在 O(1) 的时间内完成插入和删除操作。哈希表可以在 O(1) 的时间内完成插入和删除操作，
 * 但是由于无法根据下标定位到特定元素，因此不能在 O(1)的时间内完成获取随机元素操作。为了满足插入、删除和获取随机元素操作的时间复杂度都是O(1)，
 * 需要将变长数组和哈希表结合，变长数组中存储元素，哈希表中存储每个元素在变长数组中的下标。
 *
 * 删除操作的重点在于将变长数组的最后一个元素移动到待删除元素的下标处，然后删除变长数组的最后一个元素。该操作的时间复杂度是 O(1)。
 * ====
 * 看来取随机还是在List好
 */




//  V1  7.23% 67.07
class RandomizedSet {
    Set<Integer> set;
    public RandomizedSet() {
      set = new HashSet<>();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(set.size());
        return (int)set.toArray()[index];
    }
}

/*
官方答案 变长数组 + 哈希表
class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> indices;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        indices = new HashMap<Integer, Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indices.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        int index = indices.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(index, last);
        indices.put(last, index);
        nums.remove(nums.size() - 1);
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1/solution/o1-shi-jian-cha-ru-shan-chu-he-huo-qu-su-rlz2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
