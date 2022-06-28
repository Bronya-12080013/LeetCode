/*
不行了，卡在这了
我本来也想到了建立hash表，但没想到hash里可以放数组，我想的是left和right都未定，放hash能干什么
没想到可以在hash里的数组里两次二分查询找left和right
====================================================
题目
请你设计一个数据结构，它能求出给定子数组内一个给定值的 频率 。
子数组中一个值的 频率 指的是这个子数组中这个值的出现次数。
请你实现 RangeFreqQuery 类：
RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例。
int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的 频率 。
一个 子数组 指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内 的中间一段连续元素。

class RangeFreqQuery {

    public RangeFreqQuery(int[] arr) {

    }

    public int query(int left, int right, int value) {

    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */





//超时了
package 刷题.比赛.第268场周赛AutoX.区间内查询数字的频率5186;

import java.util.Arrays;

public class RangeFreqQuery {
    static int[] arr;
    public RangeFreqQuery(int[] arr) {
            this.arr=Arrays.copyOf(arr,arr.length);
            if(arr.length==0) this.arr=new int[0];
    }

    static int query(int left, int right, int value) {
        if(left==right)
        {
            if(arr[left]==value) return 1;
            else return 0;
        }
        int nums=0;
        int newArray[] = Arrays.copyOfRange(arr, left, right+1);
       for (int i : newArray) {
           if(i==value) nums++;
       }
        return nums;
    }
}

/*
思路:
我们可以有序的记录每个值对应的所有下标，然后在查询时时，就可以对下标进行二分，找到左右端点的下标a,b，这样每次查询的频率就为b - a + 1;
正确代码:
class RangeFreqQuery {
    List<List<Integer>> all = new ArrayList<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i <= 10000; i++) {
            all.add(new ArrayList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            // 下标是按顺序加入的，所以是有序的，所以后面可以进行二分
            all.get(arr[i]).add(i);
        }
     }

    public int query(int left, int right, int value) {
        if (all.get(value).size() == 0) return 0;
        // 当前值对应的下标集合
        List<Integer> now = all.get(value);
        // 第一次二分找左端点下标
        int a = binarySearch(now, 0, now.size() - 1, left);
        // 不存在这样的左端点
        if (now.get(a) > right || now.get(a) < left) return 0;

        // 第二次二分，找右端点的下标
        int b = binarySearch(now, a, now.size() - 1, right);
        if (now.get(b) > right) {
            b--;
        }
        return b - a + 1;
    }

    // 找到大于等于target的第一个位置
    public int binarySearch(List<Integer> nums, int l , int r, int target) {
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}

作者：merickbao-2
链接：https://leetcode-cn.com/problems/range-frequency-queries/solution/java-er-fen-by-merickbao-2-phux/


 */