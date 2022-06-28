/*
。。。
本来打算存放最大最小值和它们的下标的 等有时间相同的数覆盖时再遍历一次的
但搞了一下 不知道怎么实现 遍历Hashmap不知道怎么找v对于的k 罢了 次次遍历吧
=================================================
超时了 9/18
===================================================
官方方法 ！！！ 有序集合!!! 我都把它忘了
======================================================
过了过了 哈希表 + 有序集合
要理清思路真有点麻烦 确实 是还没吃早餐吗
=========================================================
方法二：哈希表 + 两个优先队列
对 pqMax pqMin 来说
过期的要装 更新的要装 这才称得上是健全的 至福🤤
在用的时候再判断它现在过期没
class StockPrice {
    int maxTimestamp;
    HashMap<Integer, Integer> timePriceMap;
    PriorityQueue<int[]> pqMax;
    PriorityQueue<int[]> pqMin;

    public StockPrice() {
        maxTimestamp = 0;
        timePriceMap = new HashMap<Integer, Integer>();
        pqMax = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]); //从大到小
        pqMin = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);    //从小到大
    }

    public void update(int timestamp, int price) {
        maxTimestamp = Math.max(maxTimestamp, timestamp);
        timePriceMap.put(timestamp, price);
        pqMax.offer(new int[]{price, timestamp});
        pqMin.offer(new int[]{price, timestamp});
    }

    public int current() {
        return timePriceMap.get(maxTimestamp);
    }

    public int maximum() {
        while (true) {
            int[] priceTime = pqMax.peek();
            int price = priceTime[0], timestamp = priceTime[1];
            if (timePriceMap.get(timestamp) == price) {
                return price;
            }
            pqMax.poll();
        }
    }

    public int minimum() {
        while (true) {
            int[] priceTime = pqMin.peek();
            int price = priceTime[0], timestamp = priceTime[1];
            if (timePriceMap.get(timestamp) == price) {
                return price;
            }
            pqMin.poll();
        }
    }
}

 */


package 刷题.leetcode.T2034股票价格波动;

import java.util.*;

//TreeMap是一个能比较元素大小的Map集合，会对传入的key进行了大小排序。
class StockPrice {
    int maxTimestamp;
    HashMap<Integer, Integer> timePriceMap;
    TreeMap<Integer, Integer> prices;

    public StockPrice() {
        maxTimestamp=Integer.MIN_VALUE;
        timePriceMap=new HashMap<>();
        prices=new TreeMap<>();
    }

    /* 初版 粗糙但好理解
    public void update(int timestamp, int price) {
        maxTimestamp=Math.max(maxTimestamp,timestamp);
        if(timePriceMap.containsKey(timestamp)) {
            prices.put(timePriceMap.get(timestamp),prices.get(timePriceMap.get(timestamp))-1);
            if(prices.get(timePriceMap.get(timestamp))==0) prices.remove(timePriceMap.get(timestamp));
            if(!prices.containsKey(price)) prices.put(price,1);
            else prices.put(price,prices.get(price)+1);
        }else {
            if(!prices.containsKey(price)) prices.put(price,1);
            else prices.put(price,prices.get(price)+1);
        }
        timePriceMap.put(timestamp,price);
    }
     */

    //我的改进
    public void update(int timestamp, int price) {
        maxTimestamp=Math.max(maxTimestamp,timestamp);
        if(timePriceMap.containsKey(timestamp)) {
            int prevPrice = timePriceMap.get(timestamp);
            prices.put(prevPrice,prices.get(prevPrice)-1);
            if(prices.get(prevPrice)==0) prices.remove(prevPrice);
        }
        prices.put(price,prices.getOrDefault(price,0)+1);
        timePriceMap.put(timestamp,price); //这个方法里 这条要放后面 因为前面有判断 if(timePriceMap.containsKey(timestamp))
    }
    /*
    官方版
    public void update(int timestamp, int price) {
        maxTimestamp = Math.max(maxTimestamp, timestamp);
        int prevPrice = timePriceMap.getOrDefault(timestamp, 0);
        timePriceMap.put(timestamp, price);
        if (prevPrice > 0) {
            prices.put(prevPrice, prices.get(prevPrice) - 1);
            if (prices.get(prevPrice) == 0) {
                prices.remove(prevPrice);
            }
        }
        prices.put(price, prices.getOrDefault(price, 0) + 1);
    }
     */

    public int current() {
        return timePriceMap.get(maxTimestamp);
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }
}


/* 超时 9/18
class StockPrice {
    Map<Integer,Integer>  map;
    int timeMax;
    public StockPrice() {
        map= new HashMap<>();
        timeMax = Integer.MIN_VALUE;
    }

    public void update(int timestamp, int price) {
        map.put(timestamp,price);
        timeMax = Math.max(timeMax,timestamp);
    }

    public int current() {
        return map.get(timeMax);
    }

    public int maximum() {
        int highestPrice = Integer.MIN_VALUE;
        for (int v:map.values()) highestPrice=Math.max(highestPrice,v);
        return highestPrice;
    }

    public int minimum() {
        int lowestPrice = Integer.MAX_VALUE;
        for (int v:map.values()) lowestPrice=Math.min(lowestPrice,v);
        return lowestPrice;
    }
}
 */