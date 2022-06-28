package 刷题.leetcode.T747至少是其他数字两倍的最大数;

//暴力 过了
/*
class Solution {
    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{3,6,1,0}));
    }
    static int dominantIndex(int[] nums) {
        int max  = Integer.MIN_VALUE;
        int Index=0;
        for(int i =0;i<nums.length;i++) max=Math.max(max,nums[i]);
        for(int i =0;i<nums.length;i++){
            if(nums[i]==max) Index = i;
            else if(max<nums[i]*2) return -1;
        }
        return Index;
    }
}
 */

//方法二 过了 效率还没暴力法高         思想:遍历找最大值 同时把其他人的值乘2 再排序 看右边最大的还是不是那个最大值
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{3,6,1,0}));
    }
    static int dominantIndex(int[] nums) {
        int max  = Integer.MIN_VALUE;
        int Index=-1;
        for(int i =0;i<nums.length;i++) {
            if(max<nums[i]){
                max=nums[i];
                if(Index!=-1)nums[Index]=nums[Index]*2;
                Index=i;
            }else nums[i]=nums[i]*2;
        }
        Arrays.sort(nums);
        return nums[nums.length-1]==max?Index:-1;
    }
}



/*
方法三 效率高  只找最大和次最大  （这个找最大和次最大的方法可以看看！！！）
class Solution {
    public int dominantIndex(int[] nums) {
        int m1 = -1, m2 = -1;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > m1) {
                m2 = m1;    //这样让m2比m1慢了一步
                m1 = nums[i];
                index = i;
            } else if (nums[i] > m2) {
                m2 = nums[i];
            }
        }
        return m1 >= m2 * 2 ? index : -1;
    }
}

 */