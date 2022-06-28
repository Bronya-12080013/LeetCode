/*
又是困难题 摆了
思想其实不难 把极角排序后（为防止反转的问题，可以在原数组中将每个元素 + 360 添加到原数组的后面） 按范围选择
（记住了 但凡是有循环的 都搞两个并在一起）
关键是数学部分
 */

//官方的二分查找
package 刷题.leetcode.T1610可见点的最大数目;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
        public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
            int sameCnt = 0;
            List<Double> polarDegrees = new ArrayList<>();
            int locationX = location.get(0);
            int locationY = location.get(1);
            for (int i = 0; i < points.size(); ++i) {
                int x = points.get(i).get(0);
                int y = points.get(i).get(1);
                if (x == locationX && y == locationY) {
                    sameCnt++;
                    continue;
                }
                Double degree = Math.atan2(y - locationY, x - locationX);
                polarDegrees.add(degree);
            }
            Collections.sort(polarDegrees);

            int m = polarDegrees.size();
            for (int i = 0; i < m; ++i) {
                polarDegrees.add(polarDegrees.get(i) + 2 * Math.PI);
            }

            int maxCnt = 0;
            Double toDegree = angle * Math.PI / 180;
            for (int i = 0; i < m; ++i) {
                int iteration = binarySearch(polarDegrees, polarDegrees.get(i) + toDegree, false);
                maxCnt = Math.max(maxCnt, iteration - i);
            }
            return maxCnt + sameCnt;
        }

        public int binarySearch(List<Double> nums, Double target, boolean lower) {
            int left = 0, right = nums.size() - 1;
            int ans = nums.size();
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums.get(mid) > target || (lower && nums.get(mid) >= target)) {
                    right = mid - 1;
                    ans = mid;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }

    /*
    官方的滑动窗口
    class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int sameCnt = 0;
        List<Double> polarDegrees = new ArrayList<>();
        int locationX = location.get(0);
        int locationY = location.get(1);
        for (int i = 0; i < points.size(); ++i) {
            int x = points.get(i).get(0);
            int y = points.get(i).get(1);
            if (x == locationX && y == locationY) {
                sameCnt++;
                continue;
            }
            Double degree = Math.atan2(y - locationY, x - locationX);
            polarDegrees.add(degree);
        }
        Collections.sort(polarDegrees);

        int m = polarDegrees.size();
        for (int i = 0; i < m; ++i) {
            polarDegrees.add(polarDegrees.get(i) + 2 * Math.PI);
        }

        int maxCnt = 0;
        int right = 0;
        double toDegree = angle * Math.PI / 180;
        for (int i = 0; i < m; ++i) {
            Double curr = polarDegrees.get(i) + toDegree;
            while (right < polarDegrees.size() && polarDegrees.get(right) <= curr) {
                right++;
            }
            maxCnt = Math.max(maxCnt, right - i);
        }
        return maxCnt + sameCnt;
    }
}
     */
