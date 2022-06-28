package 刷题.leetcode.T436寻找右区间;

import java.util.Arrays;

//暴力 过了   5.18% && 20.73%
//注意看题目
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int [] arr = new int[intervals.length];
        Arrays.fill(arr,-1);
        for(int i=0;i<intervals.length;i++)
        {
            int end = intervals[i][1];
            int dtn = Integer.MAX_VALUE;
            for(int j=0;j<intervals.length;j++)
            {
                int start = intervals[j][0];
                if(start>=end&&dtn>start)
                {
                        arr[i]=j;
                        dtn=start;
                }
            }
        }
        return arr;
    }
}
/*  官方 二分法
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] startIntervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
        }
        Arrays.sort(startIntervals, (o1, o2) -> o1[0] - o2[0]);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            int target = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (startIntervals[mid][0] >= intervals[i][1]) {
                    target = startIntervals[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = target;
        }
        return ans;
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/find-right-interval/solution/xun-zhao-you-qu-jian-by-leetcode-solutio-w2ic/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */