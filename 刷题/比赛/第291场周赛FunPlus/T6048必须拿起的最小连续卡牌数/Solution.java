package 刷题.比赛.第291场周赛FunPlus.T6048必须拿起的最小连续卡牌数;

import java.util.HashMap;

//hash法plus
class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> hashMap = new HashMap<>(); //value存入的是上次的下标
        int min = Integer.MAX_VALUE;
        for(int i=0;i<cards.length;i++) {
            if(hashMap.containsKey(cards[i])){
                min=Math.min(min,i-hashMap.get(cards[i])+1);
                hashMap.put(cards[i],i);
            }else {
                hashMap.put(cards[i],i);
            }
        }
       return min==Integer.MAX_VALUE?-1:min;
    }
}

/*  hash法
class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,ArrayList<Integer>> hashMap = new HashMap<>();
        for(int i=0;i<cards.length;i++)
        {
            if(hashMap.containsKey(cards[i]))
            {
                hashMap.get(cards[i]).add(i);
            }else {
                ArrayList list = new ArrayList();
                list.add(i);
                hashMap.put(cards[i],list);
            }
        }
        if(hashMap.size()==cards.length) return -1;
        int min =Integer.MAX_VALUE;
        for (Integer key:hashMap.keySet()){
            ArrayList<Integer> list = hashMap.get(key);
            for(int i=0;i<list.size()-1;i++)
            {
                min=Math.min(min,list.get(i+1)-list.get(i)+1);
            }
        }
        if(min==Integer.MAX_VALUE) return -1;
        else return min;
    }
}
 */



/*  超时
class Solution {
    public int minimumCardPickup(int[] cards) {
       for(int i=2;i<cards.length;i++){
           int len = i;
           for(int j=0;j+len<=cards.length;j++)
           {
               if(cards[j]==cards[j+len-1]) return len;
           }
       }
       return -1;
    }
}

 */

/* 看错题目
class Solution {
    public int minimumCardPickup(int[] cards) {
        Set<Integer> set = new HashSet();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<cards.length;i++)
        {
            if(!set.contains(cards[i])) set.add(cards[i]);
            else list.add(cards[i]);
        }
        if(list.size()==0) return -1;
        for(int i=0;i<list.size();i++)
        {
            if(!set.contains(list.get(i))) return -1;
        }
        return set.size();

    }
}
 */