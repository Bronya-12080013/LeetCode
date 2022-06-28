/*  没时间了 本想模拟 但太麻烦了
package 刷题.leetcode.T846一手顺子;
import java.util.Arrays;
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length==0||hand.length%groupSize!=0) return false;
        int index = 0,i=0;
        Arrays.sort(hand);
        int num = hand.length/groupSize;
        boolean flag = true;
        while (num!=0)
        {
            for (i=index+1;i<i+groupSize;i++)
            {
                if(i>=hand.length) {
                    flag=false;
                    break;
                }

            }
            num--;
        }
        return flag;
    }
}
 */

//看了 一下答案 懂了 对HashMap的灵活操作

//搞了半天不得 发现是网页上串题了
package 刷题.leetcode.T846一手顺子;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8},3));
    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length==0||hand.length%groupSize!=0) return false;
        Arrays.sort(hand);
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int h:hand)
        {
            hashMap.put(h,hashMap.getOrDefault(h,0)+1);
        }
        for(int h:hand)
        {
            if(!hashMap.containsKey(h)) continue;
            for(int i=h;i<h+groupSize;i++)  //for(int i=h;i<i+groupSize;i++)是错的 i是会变的
            {
                if(!hashMap.containsKey(i)) return false;
                hashMap.put(i,hashMap.get(i)-1);
                if(hashMap.get(i)==0) hashMap.remove(i);
            }
        }
        return true;
    }
}
