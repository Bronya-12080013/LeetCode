package 刷题.leetcode.T7整数反转;

//14.63% && 31.01%
//数学难 人生苦短，字符反转  用try catch 抓异常(第一次那么用，成功了)
class Solution {
    public int reverse(int x) {
        StringBuffer sb = new StringBuffer();
        sb.append(x);
        boolean flag=true;
        if(sb.toString().charAt(0)=='-') {
            flag=false;
            sb.deleteCharAt(0);
        }
        try {
            int res = flag?Integer.valueOf(sb.reverse().toString()):Integer.valueOf("-"+sb.reverse());
            return res;
        }catch (Exception e){
            return 0;
        }
    }
}

/*
数学
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode-solution-bccn/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */