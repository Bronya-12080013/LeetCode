/*
竟然有点烦人
=====================================
关键点:
1.本题是[1,n] 不是从零开始
2. ！！！！！！！本题是二分查找断层题 区别与 二分查找特定值题！！！！！！！！！
所以直接right=tar / left=tar;   而不是 right=tar-1 / left=tar+1
见下面标准答案 可以 right=tar / left=tar+1;
3.本题函数isBadVersion是题目限定,写完我就注释掉了注释掉
题目要求调用 函数isBadVersion 尽可能少
我一次循环掉了两次，所以效率不高
我去看看别人的答案
===========================================
官方答案：
public class Time extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }
}

我的判断是 if(!isBadVersion(left)&&right==left+1) return right;
意为 right守住最后的黑(错误的)，left守住最后的白，这样两者即相差一位，此时输出right
所以 right=tar / left=tar;

答案是用 right守住最后的黑 ， left从最后的白位黑堕到第一个黑位，left和right合体(left==right),跳出循环，return即可
这样就省了一步 函数isBadVersion

这就是   ！！！！！二分查找断层题！！！！！！！！！

=================================
提一下，还可以
把 int tar=left+(right-left)/2;
改成 int tar=left+((right-left)>>1);
做位运算
 */

package 刷题.leetcode.T278第一个错误的版本;

public class Solution {
    public int firstBadVersion(int n) {
            int left=0,right=n;
            while (left<right)
            {
                int tar=left+(right-left)/2;  // 防止计算时溢出 不用int tar=(left+right)/2;
           //     if(!isBadVersion(left)&&right==left+1) return right;       //函数isBadVersion是题目限定,这里注释掉
           //     if(isBadVersion(tar)) right=tar;
          //      else left=tar;
            }
            return -1;
    }
}
