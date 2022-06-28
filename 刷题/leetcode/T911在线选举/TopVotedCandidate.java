/*
失败了。。。二分查询太难了
===================================
官方答案是 预计算 + 二分查找
好好看看领领悟悟人家的二分查询细节


 */

/*
package 刷题.leetcode.在线选举911;
import java.util.HashMap;
public class TopVotedCandidate {
    public static void main(String[] args) {
        int[] persons = new int[]{0,1,0,1,1};
        int[] times=new int[]{24,29,31,76,81};
        TopVotedCandidate topVotedCandidate =new TopVotedCandidate(persons,times);
        topVotedCandidate.q(30);

    }
    int[] persons;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
            this.persons=persons;
            this.times=times;
    }
    public int q(int t) {
        int i =0,k=times.length-1;
        //超时
       // for(;i<times.length;i++){
       //     if(times[i]>t) break;
       // }
        while(i<k){
            int mid = i+(k-i)/2;
            if(times[mid]<t) i=mid+1;
            else if(times[mid]>t) k=mid-1;   //这里要加else 不然上面的if和下面的else不连起来
            if(times[k]<times[mid]) {
                i=mid;
                break;
            }
            if(times[mid]<times[i]){
                i=mid;
                break;
            }
            else {
                if(times[mid]==t) i=mid;
                break;
            }
        }
        if(times[i]==t) i++;
        HashMap<Integer,Integer> hashMap = new HashMap();
        int max=0,key=0;
        for(int j =0;j<i;j++){
            if(hashMap.containsKey(persons[j])) hashMap.put(persons[j],hashMap.get(persons[j])+1);
            else hashMap.put(persons[j],1);
            if(max<=hashMap.get(persons[j])){
                max=hashMap.get(persons[j]);
               key=persons[j];
            }
        }
        return key;
    }
}
 */

/*  超时
package 刷题.leetcode.在线选举911;
import java.util.HashMap;
public class TopVotedCandidate {
    public static void main(String[] args) {
        int[] persons = new int[]{0,1,0,1,1};
        int[] times=new int[]{24,29,31,76,81};
        TopVotedCandidate topVotedCandidate =new TopVotedCandidate(persons,times);
        topVotedCandidate.q(30);

    }
    int[] persons;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons=persons;
        this.times=times;
    }
    public int q(int t) {
        int i =0,k=times.length-1;
        while (i < k) {
            int m = i + (k - i + 1) / 2;
            if (times[m] <= t) {
                i = m;
            } else {
                k = m - 1;
            }
        }
        i++;
        HashMap<Integer,Integer> hashMap = new HashMap();
        int max=0,key=0;
        for(int j =0;j<i;j++){
            if(hashMap.containsKey(persons[j])) hashMap.put(persons[j],hashMap.get(persons[j])+1);
            else hashMap.put(persons[j],1);
            if(max<=hashMap.get(persons[j])){
                max=hashMap.get(persons[j]);
                key=persons[j];
            }
        }
        return key;
    }
}
 */

//官方答案
package 刷题.leetcode.T911在线选举;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution{
    class TopVotedCandidate {
        List<Integer> tops;
        Map<Integer, Integer> voteCounts;
        int[] times;

        //预处理
        public TopVotedCandidate(int[] persons, int[] times) {
            tops = new ArrayList<Integer>();
            voteCounts = new HashMap<Integer, Integer>();
            voteCounts.put(-1, -1);
            int top = -1;
            for (int i = 0; i < persons.length; ++i) {
                int p = persons[i];
                voteCounts.put(p, voteCounts.getOrDefault(p, 0) + 1);
                if (voteCounts.get(p) >= voteCounts.get(top)) {
                    top = p;
                }
                tops.add(top);
            }
            this.times = times;
        }

        public int q(int t) {
            int l = 0, r = times.length - 1;
            // 找到满足 times[l] <= t 的最大的 l
            while (l < r) {
                int m = l + (r - l + 1) / 2;     //这里很妙 相当于  m = l + (r - l)/2 + 1/2  当m卡中间时,会偏向右边
                if (times[m] <= t) {         //这个<= 决定了l的最终位置 非常重要
                    l = m;                     //l不越界！
                } else {
                    r = m - 1;
                }
            }
            return tops.get(l);
        }
    }
}

