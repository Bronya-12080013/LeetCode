package 刷题.leetcode.剑指Offer45把数组排成最小的数;/*
啊，不行了想不到方法
=============================================
看到了大佬的排序方法，我再试试
===============================================
失败了，对大佬的排序方法未完全了解
去看答案吧
=================================================
突然发现nums是int的
 */

//大佬代码
/*
作者：jyd
        链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/

        下面是快速排序（当然，用别的排序也行，如冒泡等）
        关键是排序的





 */

public class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }


    //快速排序！！！！！！！！！！！！！！！！！！！！！！！！！

    void quickSort(String[] strs, int l, int r) {
        if(l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while(i < j) {
            while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }
}

/*
方法2：
用java内置函数

class RangeFreqQuery {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
}

 */


/*
初版，败了，思路不对
package 刷题.leetcode.剑指Offer45把数组排成最小的数;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashMap;

public class RangeFreqQuery {
    public String minNumber(int[] nums) {
        HashMap<Integer,Integer> hashMap =new HashMap();
            for(int i=0;i<nums.length;i++)
            {
                if(hashMap.containsKey(nums[i])){
                    hashMap.put(nums[i],(Integer) hashMap.get(nums[i])+1);
                }
                else hashMap.put(nums[i],1);
            }
            int n=0;
       StringBuffer stringBuffer =new StringBuffer();
            for(int i=0;;i++){
                if(hashMap.containsKey(i))
                {
                    for(int j=0;j<hashMap.get(i);j++)
                    {
                        stringBuffer.append(String.valueOf(i));
                    }
                    n++;
                }
                if(n==hashMap.size()) break;
            }
            return stringBuffer.toString();
    }
}

 */

/*

不行，思路还是错了    82/222 通过
不过用几点可看看：
1.StringBuffer 的清空方法: stringBuffer.delete(0, stringBuffer.length());
2.字符串数字的比较方法，用内置的compareTo，别化成数字，太大了比不了
if((sb1.toString().compareTo(sb2.toString()))>0)


//改进版
package 刷题.leetcode.剑指Offer45把数组排成最小的数;
import java.util.HashMap;

public class RangeFreqQuery {
    public String minNumber(int[] nums) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        int n=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0) {
                n++;
                continue;
            }
            sb1.append(stringBuffer.toString()).append(nums[i]);
            sb2.append(nums[i]).append(stringBuffer.toString());


           //    if(Integer.valueOf(sb1.toString())>Integer.valueOf(sb2.toString()))
           //    错，太大的数会无法比较
           //    if(Long.valueOf(sb1.toString())>Long.valueOf(sb2.toString()))  也不行
            //   参考一下大佬的比较方法
            if((sb1.toString().compareTo(sb2.toString()))>0)
            {
                stringBuffer.delete(0, stringBuffer.length());
                stringBuffer.append(sb2.toString());
            }
            else {
                stringBuffer.delete(0, stringBuffer.length());
                stringBuffer.append(sb1.toString());
            }
            sb1.delete(0, stringBuffer.length());
            sb2.delete(0, stringBuffer.length());
        }
        sb1.append(stringBuffer.toString());
        stringBuffer.delete(0, stringBuffer.length());
        for(int i =0;i<n;i++)
        {
            stringBuffer.append("0");
        }
        stringBuffer.append(sb1.toString());
        return stringBuffer.toString();
    }
}

 */