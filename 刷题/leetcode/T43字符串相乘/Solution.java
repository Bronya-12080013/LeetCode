package 刷题.leetcode.T43字符串相乘;

import java.math.BigDecimal;

/*
        44.26% && 55.35%
        BigDecimal我的超人
 */

/**
 * 这题今天没时间做了
 * 先搁这吧
 * 以后有缘再说
 */

class Solution {
    public String multiply(String num1, String num2) {
        BigDecimal n1 = new BigDecimal(num1);
        BigDecimal n2 = new BigDecimal(num2);
        return n1.multiply(n2).toString();
    }
}


/*
不行 结果数字太大了 Integer和Long都不行
class Solution {
    public String multiply(String num1, String num2) {
        return String.valueOf(Long.valueOf(num1)*Long.valueOf(num2));
    }
}
 */