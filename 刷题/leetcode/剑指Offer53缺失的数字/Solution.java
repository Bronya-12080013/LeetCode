/*
从结果来看，我的答案也很好啊！！！！！
但还是用的循环
其实这个缺失的数是可以定位的，他是“右子数组的首位元素”，
那么，这题可以用二分查找
见大佬代码

（虽然我的代码时间也是100%,但内存消耗不行）

 */

package 刷题.leetcode.剑指Offer53缺失的数字;


import java.util.Scanner;

class Solution {

   // public static void main(String[] args) {
   //     Scanner scanner=new Scanner(System.in);
   //     int[] num=new int[2];
   //     for(int i=0;i<num.length;i++)
   //     {
   //         num[i]=scanner.nextInt();
   //     }
   //     System.out.println(missingNumber(num));
   // }

    public int missingNumber(int[] nums) {
        if (nums[0] != 0) {
            return 0;
        } else if (nums.length!=1) {
            for (int i = 1; i < nums.length; i++) {
                if ((nums[i] - nums[i - 1])!= 1) {
                    return nums[i] - 1;
                }
            }
        }
        return nums[nums.length-1]+1;
    }
}

/*
大佬代码：

class RangeFreqQuery {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}

作者：jyd
链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/mian-shi-ti-53-ii-0n-1zhong-que-shi-de-shu-zi-er-f/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */