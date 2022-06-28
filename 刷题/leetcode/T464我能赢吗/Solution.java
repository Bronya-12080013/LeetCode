package 刷题.leetcode.T464我能赢吗;

import java.util.HashMap;
import java.util.Map;

/*
这题有意思
模仿官方答案写的 犯了很多错误
=============
双方轮流选
这题看起来是并列有顺序的的
实际上是相套的
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().canIWin(4,6));
    }
    static Map<Integer,Boolean> hashmap = new HashMap<>();
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal<=maxChoosableInteger) return true;
        if((maxChoosableInteger*(maxChoosableInteger+1)/2)<desiredTotal) return false;  //给的数字都凑不到desiredTotal 双方都赢不了
        return DFS(maxChoosableInteger,desiredTotal,0,0);
    }
     boolean DFS(int maxChoosableInteger, int desiredTotal,int usedNumbers,int currentTotal)
    {
        if(!hashmap.containsKey(usedNumbers)){
            boolean res =false;
            for(int i=0;i<maxChoosableInteger;i++)   //一个个找没用过的
            {
                if(((usedNumbers>>i)&1)==0)  //找到了没用过的
                {
                    if(i+1+currentTotal>=desiredTotal){  //用这个没用过的数字  直接赢了
                        res = true;
                        break;
                    }
                    if(!DFS(maxChoosableInteger,desiredTotal,usedNumbers|(1<<i),currentTotal+i+1))  //这里是用!  //意思是我选了i 希望对手不会赢  //所有说是"相套的"
                    {
                        res=true;
                        break;
                    }
                }
            }
            hashmap.put(usedNumbers,res); //注意不要放错位置
        }
        return hashmap.get(usedNumbers);
    }
}
/*
class Solution {
    Map<Integer, Boolean> memo = new HashMap<Integer, Boolean>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * (maxChoosableInteger) / 2 < desiredTotal) {
            return false;
        }
        return dfs(maxChoosableInteger, 0, desiredTotal, 0);
    }

    public boolean dfs(int maxChoosableInteger, int usedNumbers, int desiredTotal, int currentTotal) {
        if (!memo.containsKey(usedNumbers)) {
            boolean res = false;
            for (int i = 0; i < maxChoosableInteger; i++) {
                if (((usedNumbers >> i) & 1) == 0) {
                    if (i + 1 + currentTotal >= desiredTotal) {
                        res = true;
                        break;
                    }
                    if (!dfs(maxChoosableInteger, usedNumbers | (1 << i), desiredTotal, currentTotal + i + 1)) {
                        res = true;
                        break;
                    }
                }
            }
            memo.put(usedNumbers, res);
        }
        return memo.get(usedNumbers);
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/can-i-win/solution/wo-neng-ying-ma-by-leetcode-solution-ef5v/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */