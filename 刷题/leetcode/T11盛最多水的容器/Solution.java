/*
这题我在别的地方见过类似的，但也不是完全一样
=============================================
淦 理解错题目了 先入为主了
===============================================
简单，看了一下提示后很简单就写出了
====================================================
大佬答案： 是一个个地移动并比较 （我的是直接移到比原先大的位置）
class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j) {
            res = height[i] < height[j] ?
                Math.max(res, (j - i) * height[i++]):
                Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}

 */
/*
package 刷题.leetcode.T11盛最多水的容器;
class Solution {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    static int maxArea(int[] height) {
        int left=0,right = height.length-1;
        int lh = height[left],rl = height[right];
        int sum = 0;
        while (left<right){
            if(lh<rl){
                lh=height[left];
                while (left<right&&height[left]<=lh)
                {
                    left++;
                    sum+=lh;
                }
                lh=height[left];
            }else {
                rl = height[right];
                while (left<right&&height[right]<=rl){
                    right--;
                    sum+=rl;
                }
                rl=height[right];
            }
        }
        return sum;
    }
}
 */

package 刷题.leetcode.T11盛最多水的容器;

import static java.lang.Math.max;

class Solution {
    static int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int sum = Math.min(height[l],height[r])*(r-l);
        while (l<r){
            if(height[l]<height[r]){
                int lh = height[l];
                while (l<r&&height[l]<=lh) l++;
            }else {
                int rh = height[r];
                while (l<r&&height[r]<=rh) r--;
            }
            sum=Math.max(sum,Math.min(height[l],height[r])*(r-l));
        }
        return sum;
    }
}