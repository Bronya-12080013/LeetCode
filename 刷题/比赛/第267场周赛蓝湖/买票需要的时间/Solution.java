/*
过了，暴力法
但卡在了 for(int i=tickets[k];i>0;i--)
我当时写 for(int i=0;i<tickets[k];i--) 这是错的，tickets[k]会变化
============================================
赛后想想
可以
int sum=0
遍历
下标i在k前且tickets[i]大于等于tickets[k]的 取 sum+=tickets[k]
下标i在k后且tickets[i]大于等于tickets[k]的 取 sum+=tickets[k]-1  （因为最后一次不用往后了）
下标k的 sum+=tickets[k]
其他tickets[i]小于tickets[k]的 直接 sum+=tickets[i]
这样不就成了吗
 */



package 刷题.比赛.第267场周赛蓝湖.买票需要的时间;

public class Solution {
    public static void main(String[] args) {
        int [] tickets={5,1,1,1};
        int sum =timeRequiredToBuy(tickets,0);
    }
    static int timeRequiredToBuy(int[] tickets, int k) {
        int sum=0;
        for(int i=tickets[k];i>0;i--)
        {
            for(int j=0;j<tickets.length;j++)
            {
                if(tickets[j]>0)
                {
                    sum++;
                    tickets[j]--;
                }
                if(tickets[k]==0) return sum;
            }
        }
        return sum;
    }
}
