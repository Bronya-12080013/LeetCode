//呜，不会，看答案

package 刷题.leetcode.剑指Offer64;
/*
常见的逻辑运算符有三种，即 “与 \&\&&& ”，“或 ||∣∣ ”，“非 !! ” ；而其有重要的短路效应，如下所示：


        if(A && B)  // 若 A 为 false ，则 B 的判断不会执行（即短路），直接判定 A && B 为 false

        if(A || B) // 若 A 为 true ，则 B 的判断不会执行（即短路），直接判定 A || B 为 true
        本题需要实现 “当 n = 1n=1 时终止递归” 的需求，可通过短路效应实现。


        n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归

        作者：jyd
        链接：https://leetcode-cn.com/problems/qiu-12n-lcof/solution/mian-shi-ti-64-qiu-1-2-nluo-ji-fu-duan-lu-qing-xi-/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */

class Solution {
    int res = 0;
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}

/*
简写：
class RangeFreqQuery {
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
 */