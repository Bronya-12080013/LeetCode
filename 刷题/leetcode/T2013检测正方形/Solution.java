/*
搞出来了 瞄了一眼答案 摸了一会鱼 自己写出来了
hhhhh
还是自己写的思路看得清晰
注意    // 根据对称性，这里可以不用取绝对值

新的用法出现了！！！

 Map<Integer, Map<Integer, Integer>> cnt;
 Set<Map.Entry<Integer, Map<Integer, Integer>>> entries = cnt.entrySet();
 for (Map.Entry<Integer, Map<Integer, Integer>> entry : entries) {}
  Map<Integer, Integer> colCnt = entry.getValue();
  虽然也不一定要用


官方答案: 差不多了
class DetectSquares {
    Map<Integer, Map<Integer, Integer>> cnt;

    public DetectSquares() {
        cnt = new HashMap<Integer, Map<Integer, Integer>>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        cnt.putIfAbsent(y, new HashMap<Integer, Integer>());
        Map<Integer, Integer> yCnt = cnt.get(y);
        yCnt.put(x, yCnt.getOrDefault(x, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0;
        int x = point[0], y = point[1];
        if (!cnt.containsKey(y)) {
            return 0;
        }
        Map<Integer, Integer> yCnt = cnt.get(y);
        Set<Map.Entry<Integer, Map<Integer, Integer>>> entries = cnt.entrySet();
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : entries) {
            int col = entry.getKey();
            Map<Integer, Integer> colCnt = entry.getValue();
            if (col != y) {
                // 根据对称性，这里可以不用取绝对值
                int d = col - y;
                res += colCnt.getOrDefault(x, 0) * yCnt.getOrDefault(x + d, 0) * colCnt.getOrDefault(x + d, 0);
                res += colCnt.getOrDefault(x, 0) * yCnt.getOrDefault(x - d, 0) * colCnt.getOrDefault(x - d, 0);
            }
        }
        return res;
    }
}
 */

package 刷题.leetcode.T2013检测正方形;

import java.util.HashMap;
import java.util.Map;

class DetectSquares {
    public static void main(String[] args) {
        DetectSquares ds = new DetectSquares();
        ds.add(new int[]{3,10});
        ds.add(new int[]{11,2});
        ds.add(new int[]{3,2});
        ds.count(new int[]{11,10});
        ds.count(new int[]{14,8});
        ds.add(new int[]{11,2});
        System.out.println(ds.count(new int[]{11,10}));
    }
        Map<Integer, HashMap<Integer,Integer>> map;
    public DetectSquares() {
        map=new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0],y=point[1];
        map.putIfAbsent(y,new HashMap<>());
        Map<Integer,Integer> yMap = map.get(y);
        yMap.put(x,yMap.getOrDefault(x,0)+1);
    }

    public int count(int[] point) {
        int x = point[0],y=point[1];
        if(!map.containsKey(y)) return 0;  //注意这里要避免空指针异常
        Map<Integer,Integer> yMap = map.get(y);
        int res= 0;
        for(int otherY : map.keySet())
        {
            Map<Integer,Integer> otheryMap = map.get(otherY);
            if(y==otherY) continue;
            int d = y - otherY;
            res+=yMap.getOrDefault(x+d,0)*otheryMap.getOrDefault(x+d,0)*otheryMap.getOrDefault(x,0);
            res+=yMap.getOrDefault(x-d,0)*otheryMap.getOrDefault(x-d,0)*otheryMap.getOrDefault(x,0);
        }
        return res;
    }
}

