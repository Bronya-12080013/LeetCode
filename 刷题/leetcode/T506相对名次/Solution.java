/*
  过了  76.62% && 60.10%
  用的是hashmap方法
  因为Arrays.sort()是升序，所以是从后面遍历回来的 有点绕
  ========================================================================
  降序排序
  1.Arrays.sort(score,Collections.reverseOrder());         score是Integer的数组 所以这里不能用
  2.利用Comparator接口复写compare
  import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer[] arr={9,8,7,6,5,4,3,2,1};
        Comparator cmp=new CMP();
        Arrays.sort(arr,cmp);
        for(int i:arr){
            System.out.println(i);
        }
    }
}
class CMP implements Comparator<Integer>{
    @Override //可以去掉。作用是检查下面的方法名是不是父类中所有的
    public int compare(Integer a,Integer b){
//        两种都可以，升序排序的话反过来就行
//        return a-b<0?1:-1;
        return b-a;
    }
}
==========================================================================




 */

package 刷题.leetcode.T506相对名次;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        int[] score=new int[]{5,4,3,2,1};
        Stream.of(findRelativeRanks(score)).forEach(e-> System.out.println(e));
    }
    static String[] findRelativeRanks(int[] score) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<score.length;i++)
        {
            map.put(score[i],i);            //（得分,位置）
        }
        //不行，这个对Integer数组才行 对int不行
        //Arrays.sort(score,Collections.reverseOrder());
        Arrays.sort(score);
        String [] temp = new String[score.length];
        String [] winer = new String[]{"Gold Medal","Silver Medal","Bronze Medal"};
        for(int i =score.length-1;i>=0;i--)
        {
            if(i==score.length-1||i==score.length-2||i==score.length-3)
            {
                temp[map.get(score[i])]=winer[score.length-i-1];                         //map.get(score[i])是根据i的得分找到它排序前的位置 对应于temp处 写入
            }else temp[map.get(score[i])]=String.valueOf(score.length-i);
        }
        return temp;
    }
}
