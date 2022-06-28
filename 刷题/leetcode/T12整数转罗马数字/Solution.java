package 刷题.leetcode.T12整数转罗马数字;

/*
注意罗马数字的机制，好好看题目
对了 对比一下下面那个不对的方法 既然后面都要用循环来 sb.append() 那不如 对num不用/ 而是一个个-就好了
 */
class Solution {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }
}

/*
//题目没看完。。。做不对
class Solution {
    public String intToRoman(int num) {
        StringBuffer sb  = new StringBuffer();
        int n = num/1000;
        num%=1000;
        for(int i=0;i<n;i++) sb.append("M");
        if(num==0) return sb.toString();

        n=num/500;
        num%=500;
        for(int i=0;i<n;i++) sb.append("D");
        if(num==0) return sb.toString();

        n=num/100;
        num%=100;
        for(int i=0;i<n;i++) sb.append("C");
        if(num==0) return sb.toString();

        n=num/50;
        num%=50;
        for(int i=0;i<n;i++) sb.append("L");
        if(num==0) return sb.toString();

        n=num/10;
        num%=10;
        for(int i=0;i<n;i++) sb.append("X");
        if(num==0) return sb.toString();

        n=num/5;
        num%=5;
        for(int i=0;i<n;i++) sb.append("V");
        if(num==0) return sb.toString();

        for (int i=0;i<num;i++) sb.append("I");
        return sb.toString();
    }
}
 */