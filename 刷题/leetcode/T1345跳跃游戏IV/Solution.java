package 刷题.leetcode.T1345跳跃游戏IV;
/*
困难题 还好 能理解
我感觉我对DFS和BFS还蛮上瘾的
毕竟是个图 还可以反复实验
 */
import java.util.*;

// 官方答案 主要是细节难把握 像队列中放int[] 来保存下标和步数什么的
class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> idxSameValue = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < arr.length; i++) {  //初始化
            idxSameValue.putIfAbsent(arr[i], new ArrayList<Integer>());   // 值:下标们（相同值的下标放一块） //putIfAbsent(K key, V value) 如果指定的键尚未与某个值相关联（或映射到 null ），则将其与给定值相关联并返回 null ，否则返回当前值。
            idxSameValue.get(arr[i]).add(i);  //取值放下标
        }
        Set<Integer> visitedIndex = new HashSet<Integer>();   //放已经去过的下标
        Queue<int[]> queue = new ArrayDeque<int[]>();      //队列 实现BFS  //int[] 第一个放下标 第二个放到此处的步数
        queue.offer(new int[]{0, 0});
        visitedIndex.add(0);     //从下标0开始 就是去过下标0了
        while (!queue.isEmpty()) {
            int[] idxStep = queue.poll();
            int idx = idxStep[0], step = idxStep[1];  //int[] 第一个放下标 第二个放到此处的步数
            if (idx == arr.length - 1) {             //成功条件：到达下标arr.length - 1
                return step;
            }
            //若没成功 就要移动到下一层可能： 按题目 1.后一位 2.前一位 3.瞬移到相同值的位
            int v = arr[idx];    //取现在下标的值 看看能不能瞬移
            step++;
            if (idxSameValue.containsKey(v)) {  //看看能不能瞬移
                for (int i : idxSameValue.get(v)) {
                    if (visitedIndex.add(i)) {
                        queue.offer(new int[]{i, step});
                    }
                }
                idxSameValue.remove(v);
            }
            //看看能不能去前后位
            if (idx + 1 < arr.length && visitedIndex.add(idx + 1)) {    //这里用visitedIndex.add() 添加的同时可以通过返回值判断是否成功
                queue.offer(new int[]{idx + 1, step});
            }
            if (idx - 1 >= 0 && visitedIndex.add(idx - 1)) {   //这里用visitedIndex.add() 添加的同时可以通过返回值判断是否成功
                queue.offer(new int[]{idx - 1, step});
            }
        }
        return -1;
    }
}
