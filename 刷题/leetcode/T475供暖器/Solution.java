/*
思路不对 是昨天的每日一题 昨天备考 今晚才写的 看答案
===========================================
官方答案 双指针法:
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            int curDistance = Math.abs(houses[i] - heaters[j]);
            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                curDistance = Math.min(curDistance, Math.abs(houses[i] - heaters[j]));
            }
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }
}
 */

/*
思路不对
package 刷题.leetcode.T475供暖器;
import javax.sound.midi.Soundbank;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution =new Solution();
        int[] houses = new int[]{1,2,3,4};
        int[] heaters = new int[]{1,4};
        System.out.println(solution.findRadius(houses,heaters));
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int len = Integer.MIN_VALUE;
        for(int i =1;i<heaters.length;i++) len=Math.max(len, Math.abs(heaters[i]-heaters[i-1]));
        len=len/2;
        int a = Math.min(Math.abs(heaters[0]-houses[houses.length-1]),Math.abs(heaters[heaters.length-1]-houses[houses.length-1]));
        int b = Math.min(Math.abs(heaters[0]-houses[0]),Math.abs(heaters[heaters.length-1]-houses[0]));
        int c =Math.max(a,b);
        len=Math.max(len,c);
        return len;
    }
}
 */

//官方答案 二分法
package 刷题.leetcode.T475供暖器;

import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        Arrays.sort(heaters);
        for(int house:houses)
        {
            int i = binarySrarch(heaters,house);   //i是house左边的供暖器
            int j = i+1;                            //j是house右边的供暖器，在heaters[i]的右边：heaters[i+1]
            int leftDistance = (i<0) ? Integer.MAX_VALUE:house-heaters[i];
            int rightDistance = (j>=heaters.length) ? Integer.MAX_VALUE:heaters[j]-house;   //leftDistance和rightDistance是不会同时为Integer.MAX_VALUE的
            int curDistance = Math.min(leftDistance,rightDistance);
            ans=Math.max(ans,curDistance);
        }
        return ans;
    }
    int binarySrarch(int[] nums,int target){
        int left=0,right = nums.length-1;
        if(target<nums[0]) return -1;
        while (left<right){
            int mid = (right-left+1)/2+left;  //这里加1 但left和right贴贴时 mid偏向右 使得right=mid-1;
            if(target<nums[mid]) right=mid-1;
            else left=mid;
        }
        return left;
    }
}