/*
这题怕是有什么大病
=======================
抱歉是我没看清题目要求
==================================
方法一：单指针
思路与算法

我们可以考虑对数组进行两次遍历。在第一次遍历中，我们将数组中所有的 00 交换到数组的头部。
在第二次遍历中，我们将数组中所有的 11 交换到头部的 00 之后。
此时，所有的 22 都出现在数组的尾部，这样我们就完成了排序。

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }
}

见下面大佬代码 也是双指针了
==============================================
思路三 也是双指针 也是方法二的变形 就是各种推
https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/
总结就是 p0在左 p2在右 i从左往右 然后用nums[i]判断与谁交换 及 前进
代码
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }
}

 */
package 刷题.leetcode.T75颜色分类;

import java.util.Arrays;
//大佬代码  超级推
class Solution {
    public void sortColors(int[] nums) {
        int num0 = 0, num1 = 0, num2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[num2++] = 2; //这里也就是i了 ++在后是先执行，再++
                nums[num1++] = 1;
                nums[num0++] = 0;
            }else if(nums[i] == 1) {
                nums[num2++] = 2;
                nums[num1++] = 1;
            }else {
                nums[num2++] = 2;
            }
        }
    }
}
/*
class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}
 */