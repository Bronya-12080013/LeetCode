/*
题很简单，就是不知道怎么提高
新方法: Arrays.copyOfRange取子数组 (三参数，从那取到那)
        Arrays.copyOf (两参数，从头取到那)
========================================================
答案一：
class RangeFreqQuery {
    public int[] getLeastNumbers1(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }
}
===========================================================
好棒的快速排序：
class RangeFreqQuery {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) return arr;
        return quickSort(arr, k, 0, arr.length - 1);
    }
    private int[] quickSort(int[] arr, int k, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (i > k) return quickSort(arr, k, l, i - 1);
        if (i < k) return quickSort(arr, k, i + 1, r);
        return Arrays.copyOf(arr, k);
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

作者：jyd
链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/jian-zhi-offer-40-zui-xiao-de-k-ge-shu-j-9yze/
 */

package 刷题.leetcode.剑指Offer40最小的k个数;

import java.util.Arrays;

/*
好，我过了。。。。？
版1:
public class RangeFreqQuery {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] array=new int[k];
        for(int i=0;i<k;i++)
        {
            array[i]=arr[i];
        }
        return array;
    }
}
 */

//版2:   71.81% && 77.92%
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] array=new int[k];
        int newArray[] = Arrays.copyOfRange(arr, 0, k);  //k是下标，包括k
        return newArray;
    }
}