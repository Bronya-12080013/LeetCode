/*
比赛时我写的是什么玩意
我分成了三步 但其实第一和第三步是没必要的
第二步其实也不必真的转它
我把int转成String反而变复杂了
归根到底想 转过去有转回来 不就是去掉了后置0吗
那么通过 num%10!=0 就知道有没有后置0了
===========================================
反转 一个整数意味着倒置它的所有位。
例如，反转 2021 得到 1202 。反转 12300 得到 321 ，不保留前导零 。
给你一个整数 num ，反转 num 得到 reversed1 ，接着反转 reversed1 得到 reversed2 。如果 reversed2 等于 num ，返回 true ；否则，返回 false
 */

package 刷题.比赛.第273场周赛蔚来.T5963反转两次的数字;

//修正版
class Solution {
    public boolean isSameAfterReversals(int num) {
        return num == 0 || num % 10 > 0;
    }
}

/*  我写得什么玩意  别看了 回搞混的 变量名都不行
import java.util.SortedSet;
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSameAfterReversals(526));
    }
    public boolean isSameAfterReversals(int num) {
        String s1 = String.valueOf(num);
        char[] chars3 = s1.toCharArray();
        StringBuffer sb2 = new StringBuffer();
        boolean flag = true;
        for(int i =0;i<chars3.length;i++)
        {
            char c = chars3[i];
            if(flag&&c=='0') continue;
            else {
                flag=false;
                sb2.append(c);
            }
        }
        String s=sb2.toString();
        flag = true;
        StringBuffer stringBuffer = new StringBuffer();
        char[] chars1 = s1.toCharArray();
        for(int i = chars1.length-1;i>=0;i--)
        {
            char c = chars1[i];
            if(flag&&c=='0') continue;
            else {
                flag=false;
                stringBuffer.append(c);
            }
        }
        String s2 = stringBuffer.toString();
        char[] chars2 = s2.toCharArray();
        StringBuffer sb = new StringBuffer();
        flag= true;
        for(int i =0;i<s2.length();i++)
        {
            char c = chars1[i];
            if(flag&&c=='0') continue;
            else {
                flag=false;
                sb.append(c);
            }
        }
        return s.equals(sb.toString());
    }
}

 */