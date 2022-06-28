//送分题
/*  两个方法 substring() 和 concat()
    注意concat有返回值 不可以L:
                                s1.concat(s2);
                                return s1;
     (但它为什么不报错)

 */
class Solution {
    public String reverseLeftWords(String s, int n) {
        String s1= s.substring(n);
        String s2=s.substring(0,n);
        s=s1.concat(s2);
        return s;
    }
}