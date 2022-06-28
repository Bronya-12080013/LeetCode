/*
这题其实不是很难 但要小心
我一开始就忙于用暴力 超时了(想想就知道不行了 三重循环啊) 所以暴力是达咩

后来改成了一次遍历带子遍历 还过不了
然后带上了len就行了 真是惊心动魄
这个 len 的存在
if(len!=0) {
                sum+=len;
                len--;
            }
尤为关键
它免去了大量重复的遍历
自己去看看
================================
另外那个 while的循环 我也差点混乱了  要小心
我的第四题也涉及到它（虽然我的第四题答案是不完善的）
========================================================
看到了大佬的答案了
我太弱小没有力量。。。
============================================================
大佬答案:  一步步积累len 直到断崖使len=1 然后再次积累   很好理解的
class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        int len = 1;
        long ret = 1;
        for(int i = 1;i < n;i++){
            if(prices[i-1] - prices[i] == 1){
                len++;
            }else{
                len = 1;
            }
            ret += len;
        }
        return ret;
    }
}
 */

/* 超时
package 刷题.比赛.第272场周赛蓝湖.题三;
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{12,11,10,9,8,7,6,5,4,3,4,3,10,9,8,7};
        System.out.println(solution.getDescentPeriods(prices));
    }
    public long getDescentPeriods(int[] prices) {
        int sum = prices.length;
        int[] length = new int[prices.length-1];
        for(int i =2;i<=prices.length;i++) length[i-2]=i;
        for(int i =0;i<length.length;i++){
            int len = length[i];
            for(int j=0;j<prices.length-len+1;j++)
            {
                boolean flag = true;
                for(int k=j+1;k<j+len;k++)
                {
                    if(prices[k]!=prices[k-1]-1)
                    {
                        flag=false;
                        break;
                    }
                }
                if(flag) sum++;
            }
        }
        return sum;
    }
}
 */

package 刷题.比赛.第272场周赛蓝湖.T5958股票平滑下跌阶段的数目;
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 4, 3, 10, 9, 8, 7};
        //int[] prices = new int[]{5,5,5,5,5,4};
        System.out.println(solution.getDescentPeriods(prices));
    }

    public long getDescentPeriods(int[] prices) {
        if(prices.length==0) return 0;
        long sum = 0;
        int len = 0;
        for(int  i =0;i<prices.length;i++)
        {
            if(len!=0) {
                sum+=len;
                len--;
            }
            else {
                sum++;
                int qian = prices[i];
                int index = i;
                while (index + 1 < prices.length) {
                    if (prices[index + 1] == qian - 1) {
                        sum++;
                        qian = prices[index + 1];
                        index++;
                        len++;
                    } else break;
                }
            }
        }
        return sum;
    }
}