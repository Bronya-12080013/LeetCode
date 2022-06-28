/*
没时间了
能不能暴力（估计不行了）地从1开始找n个数 对每个数的各个位放进一个数组，再判断数组是否对称
就怎么找出n个
 */

//不行
package 刷题.比赛.第268场周赛AutoX.数字k镜像数字的和5933;

import java.util.ArrayList;

public class Solution {
    public long kMirror(int k, int n) {

        //不写了，反正暴力没前途
        return 0;
    }

    //判断数组对称
    public boolean isSymmetric(ArrayList list)
    {
        int i = 0,j=list.size()-1;
        while (i<j)
        {
            if(list.get(i)!=list.get(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

/*
代码，能过。好像可以再用hashmap
class Time {
    public long kMirror(int k, int n) {
        return getN(k, n);
    }
    private long getN(int k, int n){
        int i=0;
        List<String> ret = new ArrayList();
        int digit=1;
        long lret = 0;
        while(i<n){
            List<String> nums = getNDigit(k, digit);
            for(int j=0; j<nums.size() && i<n; ++j){
                String num = nums.get(j);
                if(num.charAt(0)=='0') continue;
                long tenV = tenVal(k, num);
                if(isTenValid(tenV)){
                    ++i;
                    lret+=tenV;
                }
            }
            ++digit;
        }
        return lret;
    }

    private List<String> getNDigit(int k, int len){
        if(len==0) return new ArrayList();
        List<String> ret = new ArrayList();
        for(int i=0; i<k; ++i){
            ret.add(String.valueOf(i));
        }
        if(len==1) return ret;

        List<String> res = new ArrayList();
        List<String> sub = getNDigit(k, len-2);
        for(int i=0; i<k; ++i){
            if(sub.size()>0){
                for(String s : sub){
                    res.add(String.valueOf(i)+s+String.valueOf(i));
                }
            }else{
                res.add(String.valueOf(i)+String.valueOf(i));
            }
        }
        return res;
    }
    private long tenVal(int k, String knum){
        long ret=0;
        for(int i=knum.length()-1; i>=0; --i){
            ret += Math.pow(k, (knum.length()-1)-i) * (knum.charAt(i)-'0');
        }
        return ret;
    }

    private boolean isTenValid(long ret){
        String sret = String.valueOf(ret);
        int i=0, j=sret.length()-1;
        while(i<j){
            if(sret.charAt(i)!=sret.charAt(j)) return false;
            ++i;
            --j;
        }
        return true;
    }
}

作者：qbout
链接：https://leetcode-cn.com/problems/sum-of-k-mirror-numbers/solution/fei-chang-uglyde-dai-ma-bu-guo-ju-you-to-umww/
 */
