package 刷题.leetcode.剑指Offer11旋转数组的最小数字;
//本题的二分法要非常注意条件
//这个旋转数组，只要把它想象回去的话，他就是一个二分数组，可以用二分排序
class Solution {
    public int minArray(int[] numbers) {
        int i=0,j=numbers.length-1;
        while (i<j){                       //注意这里不是i<=j
            int m=(i+j)/2;
            if(numbers[m]>numbers[j]) i=m+1;         //注意这里是j
            else if(numbers[m]<numbers[j]) j=m;         //注意这里不是j=m-1;
            else j--;
        }
        return numbers[i];
    }
}

/*
   什么玩意，怎么这也能 100%-99.75%

class RangeFreqQuery {
    public int minArray(int[] numbers) {
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]<numbers[i-1])
            {
                return numbers[i];
            }
        }
        return -1;
    }
}


 */

