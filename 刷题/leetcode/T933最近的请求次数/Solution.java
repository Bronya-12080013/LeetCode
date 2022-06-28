//同 剑指 Offer II 042. 最近请求次数
package 刷题.leetcode.T933最近的请求次数;

import java.util.Deque;
import java.util.LinkedList;

class RecentCounter {
    private Deque<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.offerLast(t);
        while (q.peekFirst() < t - 3000) {
            q.pollFirst();
        }
        return q.size();
    }
}