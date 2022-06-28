package 刷题.leetcode.T1576替换所有的问号;

public class Solution {
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        for(int i =0;i< arr.length;i++)
        {
            if(arr[i]=='?'){
                for(char j='a';j<='c';j++)
                {
                    if((i>0&&arr[i-1]==j)||(i<arr.length-1&&arr[i+1]==j)) continue;
                    arr[i]=j;
                    break;
                }
            }
        }
        return new String(arr);
    }
}
