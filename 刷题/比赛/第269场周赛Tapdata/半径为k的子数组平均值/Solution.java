/*
5939. 半径为 k 的子数组平均值
https://leetcode-cn.com/contest/weekly-contest-269/problems/k-radius-subarray-averages/
=====================================================================================
这题耗费了好长时间 导致第三题都做不完（看着能做）

我先用了双循环 每次都逐个加，再求平均数
(过了一些坑，如用 <= 而不是 <)
然后遇到个大数用例  我把sum改成了 long 成了
然后它卡在了最后一个用例（35/36）超时了 emmmmmmmm

然后我 我用别的方法 设sumLeft和sumRight来保存和，动态变化
(又过了一些坑，如要判断过界问题，加if(r!= nums.length-1))
然后又遇到那个大数用例
这次long没用了 不知道为什么
我就改成了 BigInteger类

大坑：
sumLeft.add() 和 sumLeft.subtract()方法 是有返回值的
它不会把计算结果直接写入
所以要赋值，这样写
 sumLeft=sumLeft.subtract(new BigInteger(String.valueOf(nums[l++])));

 而不是 sumLeft.subtract(new BigInteger(String.valueOf(nums[l++])));

然后就过了
==================================================================
事后想想，我不保存总和，直接保存double类型的平均值，动态变化不就行了吗 搞什么大数啊
待会试试
=====================================================================
大佬答案:

class Time {
    public int[] getAverages(int[] nums, int k) {
        int [] result = new int [nums.length];
        Arrays.fill(result, -1);

        long sum = 0;
        int l = 2*k + 1;
        long v;

        for (int i = 0; i < 2*k && i < nums.length; ++i)
            sum += nums[i];

        for (int i = k, j = 2*k; j < nums.length; ++i, ++j){
            sum += nums[j];

            v = sum / l;
            result[i] = (int)v;

            sum -= nums[i - k];
        }

        return result;
    }
}

=======================================================================
也是一块的动态变化啊，为什么他的long可以，我的不行，难道不是大数问题？
但我当时用long的代码都不见了
那就不管了
既然这样能过，那就没必要搞double记平均值的了


 */


/*  emmmmmmmmmm 最后一个示例 超时了
package 刷题.比赛.第269场周赛Tapdata.题二;
import java.math.BigDecimal;
public class Time {
    public static void main(String[] args) {
        getAverages(new int[]{7,4,3,9,1,8,6,2,6},3);
    }
    static int[] getAverages(int[] nums, int k) {
        if(k==0) return nums;
        if(nums.length==1&&k>0) return new int[]{-1};
        int [] res =new int[nums.length];
        for(int i =0;i<nums.length;i++)
        {
            if(i==k) i=nums.length-k;
            res[i]=-1;
        }
        for(int i =k;i<=nums.length-k-1;i++)         //注意是<=
        {
            long sum=0;
            for(int j =i-k;j<=i+k;j++)
            {
                sum+=nums[j];
            }
            res[i]= (int) (sum/(2*k+1));
        }
        return res;
    }
}
 */

package 刷题.比赛.第269场周赛Tapdata.半径为k的子数组平均值;

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        getAverages(new int[]{7,4,3,9,1,8,6,2,6},3);
    }
    static int[] getAverages(int[] nums, int k) {
        if(k==0) return nums;
        if(nums.length<=2*k&&k>0)
        {
            int [] res =new int[nums.length];
            for (int i =0;i<res.length;i++)
                res[i]=-1;
            return res;
        }
        int l=0,r=k+k;
        BigInteger sumLeft=new BigInteger("0");
        BigInteger sumRight=new BigInteger("0");
        for(int i =0;i<k;i++)
        {
            sumLeft=sumLeft.add(new BigInteger(String.valueOf(nums[i])));                      //注意：是返回值！！！
        }
        for(int i =k+1;i<=2*k;i++)
        {
            sumRight=sumRight.add(new BigInteger(String.valueOf(nums[i])));
        }
        int [] res =new int[nums.length];
        for(int i =0;i<nums.length;i++)
        {
            if(i==k) i=nums.length-k;
            res[i]=-1;
        }
        for(int i =k;i<=nums.length-k-1;i++)
        {
            res[i]=sumLeft.add(sumRight.add(new BigInteger(String.valueOf(nums[i])))).divide(new BigInteger(String.valueOf(2*k+1))).intValue();
            sumLeft=sumLeft.subtract(new BigInteger(String.valueOf(nums[l++])));
            sumLeft=sumLeft.add(new BigInteger(String.valueOf(nums[i])));
            sumRight=sumRight.subtract(new BigInteger(String.valueOf(nums[i+1])));
            if(r!= nums.length-1)
            sumRight=sumRight.add(new BigInteger(String.valueOf(nums[++r])));
        }
        return res;
    }
}