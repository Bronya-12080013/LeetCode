/*
人生苦短，我用正则
但正则也难写啊
用了别人的正则方程，过了，就是效率不高   5.82% && 5.01%
=====================================================
更好的答案是 “有限状态自动机”
太棒了，安装不同情况跳步（就像书上的性格测试之类的。也可以写成许许多多的if-else之类的）,涵盖了所有的情况
就是写起来费头发
class RangeFreqQuery {
    public boolean isNumber(String s) {
        Map[] states = {
            new HashMap<>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
            new HashMap<>() {{ put('d', 2); put('.', 4); }},                           // 1.
            new HashMap<>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
            new HashMap<>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
            new HashMap<>() {{ put('d', 3); }},                                        // 4.
            new HashMap<>() {{ put('s', 6); put('d', 7); }},                           // 5.
            new HashMap<>() {{ put('d', 7); }},                                        // 6.
            new HashMap<>() {{ put('d', 7); put(' ', 8); }},                           // 7.
            new HashMap<>() {{ put(' ', 8); }}                                         // 8.
        };
        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') t = 'd';
            else if(c == '+' || c == '-') t = 's';
            else if(c == 'e' || c == 'E') t = 'e';
            else if(c == '.' || c == ' ') t = c;
            else t = '?';
            if(!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}

好好理解吧

作者：jyd
链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/mian-shi-ti-20-biao-shi-shu-zhi-de-zi-fu-chuan-y-2/

 */


/*
题目都没看，就看了个标题
package 刷题.leetcode.剑指Offer20表示数值的字符串;

public class RangeFreqQuery {
    public boolean isNumber(String s) {
        char[] ch = s.toCharArray();
        for (char c:ch) {
            if(!Character.isDigit(c))
                return false;
        }
       return true;
    }
}
 */

package 刷题.leetcode.剑指Offer20表示数值的字符串;

//别人写的正则,妙啊
public class Solution {
    public boolean isNumber(String s) {
        return s.trim().matches("^[+|-]?((\\d+\\.?)|(\\d*\\.\\d+))([E|e][+|-]?\\d+)?$"); //+ 一次或多次  *任意次数  ?零次或一次
                                                                                                //注意，(\d+\.?)既可以匹配整数部分，也可以匹配小数的“至少一位数字，后面跟着一个点 '.'情况”
    }
}