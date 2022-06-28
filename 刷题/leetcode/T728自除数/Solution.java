/*
好好看题 注意小坑
除数不能为0
=====================================
看看官方的暴力法:  看看就好
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList();
        for (int n = left; n <= right; ++n) {
            if (selfDividing(n)) ans.add(n);
        }
        return ans;
    }
    public boolean selfDividing(int n) {
        for (char c: String.valueOf(n).toCharArray()) {
            if (c == '0' || (n % (c - '0') > 0))
                return false;
        }
        return true;
    }

  //  Alternate implementation of selfDividing:
  //  public boolean selfDividing(int n) {
  //      int x = n;
  //      while (x > 0) {
  //          int d = x % 10;
  //          x /= 10;
  //          if (d == 0 || (n % d) > 0) return false;
  //      }
  //      return true;

}
 */

package 刷题.leetcode.T728自除数;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.selfDividingNumbers(10,10);
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i =left;i<right+1;i++)
        {
            int n=i;
            boolean flag =true;
            while (n!=0)
            {
                if(n%10==0) {
                    n/=10;
                    flag=false;
                    break;
                }
                if(i%(n%10)!=0) {
                    flag=false;
                    break;
                }
                n/=10;
            }
            if(flag) list.add(i);
        }
        return list;
    }
}
