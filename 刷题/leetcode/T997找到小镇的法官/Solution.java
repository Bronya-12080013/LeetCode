/*
平角裤平角裤 一次过   99.21% && 88.98%
 */
package 刷题.leetcode.T997找到小镇的法官;

import java.util.Arrays;

public class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] arr = new int[n];
        Arrays.fill(arr,1);
        int [] brr = new int[n];
        for(int i =0;i<trust.length;i++)
        {
            arr[trust[i][0]-1]--;
            brr[trust[i][1]-1]++;
        }
        for(int i =0;i<arr.length;i++){
            if(arr[i]==1&&brr[i]==n-1) return i+1;
        }
        return -1;
    }
}
