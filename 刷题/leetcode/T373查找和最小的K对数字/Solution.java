/*
用优先队列吧
先说难点1:
就是构造比较方式
int[] 第一个是放num1的下标 第二个是放num2的下标
o1 o2 各自代表一个int[] 要比较它们 就是写 return ((nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]));

难点2:
详细见：
https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/solution/cha-zhao-he-zui-xiao-de-kdui-shu-zi-by-l-z526/
https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/solution/bu-chong-guan-fang-ti-jie-you-xian-dui-l-htf8/
可以用下面的 “另一版本” 它用双重遍历把所有的可以的下标都放进来了
用Math.min() 比较与k的关系 这样不至于像我一开始写的那样超内存
但仍然有大量浪费
用官方的方法先存下标 (0,0) (1,0) (2,0) ... (Math.min(m,k),0)
放入优先队列后会自动排序 先取出下标(0,0)后 [因为num1 num2 是拍好序的 第一个取的就会是(0,0)] 再放入（0,0+1） 放入后又会自己调整排序 以此类推 这样就非常高效了
（总之啊 若画出下标图 答案一般都在左上角 和 上、左边界的 用这种方法就是为了更快的关联起来[取出下标组后再放入相应的(难点2) 就关联得快了]）
 */

package 刷题.leetcode.T373查找和最小的K对数字;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//优先队列 官方方法
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2)->{
             return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];  //难点1
            //其实就是 return ((nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]));
        });
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i,0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idxPair = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[idxPair[0]]);
            list.add(nums2[idxPair[1]]);
            ans.add(list);
            if (idxPair[1] + 1 < n) {
                pq.offer(new int[]{idxPair[0], idxPair[1] + 1});  //难点2
            }
        }

        return ans;
    }
}
/*  另一版本
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2)->{
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < Math.min(m, k); i++) {
            for(int j=0;j<Math.min(n,k);j++)
            {
                pq.offer(new int[]{i,j});
            }

        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idxPair = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[idxPair[0]]);
            list.add(nums2[idxPair[1]]);
            ans.add(list);
        }
        return ans;
    }
}
 */

/* 正常 超内存了
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i =0;i<nums1.length;i++)
        {
            for(int j=0;j< nums2.length;j++)
            {
                priorityQueue.add(new int[]{nums1[i]+nums2[j],nums1[i],nums2[j]});
            }
        }
        List<List<Integer>> List = new ArrayList<>();
        while (k>0) //又来了
        //while (k>0&&!priorityQueue.isEmpty())
        {
            List<Integer> list =  new ArrayList<>();
            list.add(priorityQueue.peek()[1]);
            list.add(priorityQueue.peek()[2]);
            List.add(list);
            priorityQueue.poll();
            k--;
            if(priorityQueue.isEmpty()) break;
        }
        return List;
    }
}
 */
