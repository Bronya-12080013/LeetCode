/*很好，过了    100% && 65.33%(不稳定，有时两个都低,这写的是比较好的)
==============================================================
看代码:
太妙了，思路上还可以提：

根据题意，此 55 张牌是顺子的 充分条件 如下：
除大小王外，所有牌 无重复 ；
设此 55 张牌中最大的牌为 maxmax ，最小的牌为 minmin （大小王除外），则需满足：
max - min < 5
max−min<5

代码1：
class RangeFreqQuery {
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if(num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if(repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}

代码2：
class RangeFreqQuery {
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums); // 数组排序
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0) joker++; // 统计大小王数量
            else if(nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}

 */

package 刷题.leetcode.剑指Offer61扑克牌中的顺子;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums={0,0,1,2,5};
        boolean flag=isStraight(nums);
    }
    static boolean isStraight(int[] nums) {
        Arrays.sort(nums);                           //好好好好好好好好好好好好好好好好好好好好好好好好用的排序方法
        int zero=0;
        boolean flag = true;
        int temp=0,time=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==temp&&nums[i]!=0&&temp!=0) break;     //如果牌有非0的重复，那就直接寄了
            if(nums[i]==0) {
                zero++;
                continue;
            }
            if((nums[i]!=0&&flag)||nums[i]==temp+1){
                flag=false;
                temp=nums[i];
                time++;
            }else if(zero>0&&nums[i]-temp-1<=zero)
            {
                zero-=nums[i]-temp-1;
                time+=nums[i]-temp;
                temp=nums[i];
            }
        }
        if(time==5||time+zero==5) return true;
        else return false;
    }
}