/*
看了答案 有了想法
是我陷入了dp题只用一个dp数组的误区
看我了写写
==============
成了
 */
package 刷题.leetcode.T2100适合打劫银行的日子;

import java.util.ArrayList;
import java.util.List;

//动态规划 93.04% && 8.13%
class Solution {
    public List<Integer> goodDaysToRobBank(int[] securit, int time) {
        List<Integer> res =new ArrayList<>();
        int length = securit.length;
        //tip:int数组元素默认为0,下面对于不满足条件的不用额外处理
        int[] right = new int[length];
        int[] left= new int[length];
        for(int i=1;i<length;i++)
        {
            //注意这里的if里的不要写错成securit
            if(securit[i]<=securit[i-1]) left[i]=left[i-1]+1;
            if(securit[length-i-1]<=securit[length-i]) right[length-i-1]=right[length-i]+1;
        }
        for(int i=time;i<length-time;i++)
        {
            if(left[i]>=time&&right[i]>=time) res.add(i);
        }
        return res;
    }
}

/* 版一 当然超时了
class Solution {
    public static void main(String[] args) {
        int[] se=new int[]{5,3,3,3,5,6,2};
        goodDaysToRobBank(se,2);
    }
    static List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> list =new ArrayList<>();
        for(int i=time;i<security.length-time;i++)
        {
            boolean flag=true;
            for(int j=i-time;j<i;j++)
            {
                //if(security[j]<security[j+1]) continue;   这里放了个错，这里的continue不能跳出外面的for
                if(security[j]<security[j+1])
                {
                    flag=false;
                    break;
                }
            }
            for (int j=i;j<i+time;j++)
            {
                //if(security[j]>security[j+1]) continue;
                if(security[j]>security[j+1])
                {
                    flag=false;
                    break;
                }
            }
            if(flag) list.add(i);
        }
        return list;
    }
}
 */