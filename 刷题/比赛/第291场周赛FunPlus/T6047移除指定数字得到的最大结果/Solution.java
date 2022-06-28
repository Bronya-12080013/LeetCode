package 刷题.比赛.第291场周赛FunPlus.T6047移除指定数字得到的最大结果;

/*
    V1本来是用ArrayList<Integer>把所有都存入，然后排序得结果的
    不行
    number可以很大，int放不了
    改BigDecimal
    *注意,在leetcode用BigDecimal的话，包要自己导入，上面加上 import java.math.BigDecimal;
    我直接把V1的类型改成BigDecimal，在leetcode上不行
    以为是ArrayList不能装BigDecimal，就改成直接判断了
    然后才发现要导包
    ===============================================
    比赛完后，才发现(记起？)number的字符都是数字，String可以直接比较的
    直接比较就好，用V3
 */

//V3
// number的字符都是数字，String可以直接比较的
class Solution {
    public String removeDigit(String number, char digit) {
        String res="";
        for(int i =0;i<number.length();i++)
        {
            if(number.charAt(i)==digit)
            {
                String num = number.substring(0,i)+number.substring(i+1);
                if(res.compareTo(num)<0) res= num;
            }
        }
        return res;
    }
}



/*  V2
用BigDecimal，可以，但没必要
import java.math.BigDecimal;
class Solution {
    public String removeDigit(String number, char digit) {
       BigDecimal max = new BigDecimal(-1);
        for(int i =0;i<number.length();i++)
        {
            if(number.charAt(i)==digit)
            {
                BigDecimal it;
                it = new BigDecimal(number.substring(0,i)+number.substring(i+1));
                if(max.compareTo(it)<0) max=it;
            }
        }
        return max.toString();
    }
}
 */


/*  V1
不行，number可以很大
class Solution {
    public String removeDigit(String number, char digit) {
        ArrayList<Integer> list = new ArrayList();
        for(int i =0;i<number.length();i++)
        {
            if(number.charAt(i)==digit)
            {
                if(i!=number.length()-1)
                list.add(Integer.valueOf(number.substring(0,i)+number.substring(i+1)));
                else list.add(Integer.valueOf(number.substring(0,i)));
            }
        }
        Collections.sort(list);
        return String.valueOf(list.get(list.size()-1));
    }
}
 */