/*
这题很强 https://leetcode-cn.com/problems/intervals-between-identical-elements/
这题不管是暴力还是我的Hashmap都超时了 看看大佬代码
=============================================
对于我写的代码，还有一种升级版（不过这种方法也是超时的） 这种方法直接在添加时修改不用像我那样最后再来个for统计
class Solution {
public long[] getDistances(int[] arr) {
    Map<Integer, List<Integer>> m = new HashMap<>();
    int length = arr.length;
    long[] re = new long[length];

    for (int i = 0; i < length; i++) {
        List<Integer> orDefault = m.getOrDefault(arr[i], new ArrayList<>());
        int size = orDefault.size();
        for (int j = 0; j < size; j++) {
            re[orDefault.get(j)] += i - orDefault.get(j);
            re[i] += i-orDefault.get(j);
        }
        orDefault.add(i);
        m.put(arr[i], orDefault);
    }
    return re;
}
}
==========================================================================
前缀和+后缀和的方法: re1[i] = 前一个与arr[i]相同的值对应的re[pro] + 前一个到当前这个的距离 × 个数
(因为个数就是前面出现的次数（不包括本次的这个）,因为有几个就要走几次这段路嘛，画个坐标轴好理解)

public class Solution {
public long[] getDistances(int[] arr) {
    //前缀，<key,val>表示值为key的前面一个相同的下标为val[0]，相同的个数为val[1]
    Map<Integer, int[]> m1 = new HashMap<>();
    int n = arr.length;
    long[] re1 = new long[n];
    for (int i = 0; i < n; i++) {
        int[] orDefault = m1.getOrDefault(arr[i], new int[2]);
        //当其前面有与他下相同的时候。相同的下标为ordefaule[0],相同了几个为orderfault[1]
        if (orDefault[1] != 0) {
            re1[i] += re1[orDefault[0]] + (i - orDefault[0]) * orDefault[1];
        }
        orDefault[0] = i;
        orDefault[1]++;
        m1.put(arr[i], orDefault);
    }
    //后缀
    Map<Integer, int[]> m2 = new HashMap<>();
    long[] re2 = new long[n];
    for (int i = n - 1; i >= 0; i--) {
        int[] orDefault = m2.getOrDefault(arr[i], new int[2]);
        //当其后面有与他下相同的时候。相同的下标为ordefaule[0],相同了几个为orderfault[1]
        if (orDefault[1] != 0) {
            re2[i] += re2[orDefault[0]] + (orDefault[0] - i) * orDefault[1];
        }
        orDefault[0] = i;
        orDefault[1]++;
        m2.put(arr[i], orDefault);
    }
    long[] re = new long[n];
    for (int i = 0; i < n; i++) {
        re[i] = re1[i]+re2[i];
    }
    return re;
}
}
 */
package 刷题.比赛.第273场周赛蔚来.T5965相同元素的间隔之和;


/* 超时了
public class Solution {
    public long[] getDistances(int[] arr) {
        Map<Integer,List<Integer>> hashMap = new HashMap();
        for(int i =0;i<arr.length;i++)
        {
            int k = arr[i];
            if(hashMap.containsKey(k)){
                hashMap.get(k).add(i);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(k,list);
            }
        }
        long[] longs = new long[arr.length];
        for(int i =0;i<longs.length;i++)
        {
            int k =arr[i];
            List<Integer> list = hashMap.get(k);
            for(int j=0;j<list.size();j++) longs[i]+=Math.abs(list.get(j)-i);
        }
        return longs;
    }
}
 */


/* 超时
public class Solution {
    public long[] getDistances(int[] arr) {
        long[] longs = new long[arr.length];
        for(int i = 0;i<arr.length;i++)
        {
            for(int j =0;j<arr.length;j++)
            {
                if(arr[i]==arr[j]) longs[i]+=Math.abs(i-j);
            }
        }
        return longs;
    }
}
 */
