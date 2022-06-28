/*
这是简单题吧
 */
package 刷题.比赛.第274场周赛AutoX.T5968银行中的激光束数量;

class Solution {
    public int numberOfBeams(String[] bank) {
        int lastNum = -1,sum = 0;
        for(int i =0;i<bank.length;i++)
        {
            int num=0;
            for(char c:bank[i].toCharArray())
            {
                if(c=='1') num++;
            }
            if(num>0){
                if(lastNum>=0) sum+=num*lastNum;
                lastNum=num;
            }
        }
        return sum;
    }
}