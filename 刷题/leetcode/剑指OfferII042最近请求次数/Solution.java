//仔细理解题意
package 刷题.leetcode.剑指OfferII042最近请求次数;

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