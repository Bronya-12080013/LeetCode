package 刷题.leetcode.T944删列造序;

// 87.14% && 29.76%
class Solution {
    public static void main(String[] args) {
        String[] strs = new String[]{"cba","daf","ghi"};
        System.out.println(minDeletionSize(strs));
    }
    static int minDeletionSize(String[] strs) {
        int num=0;
        int len = strs[0].length();
        for(int i=0;i<len;i++)
        {
            boolean flag = true;
            for(int j=1;j<strs.length;j++)
            {
                if(strs[j].charAt(i)<strs[j-1].charAt(i))
                {
                    flag=false;
                    break;
                }
            }
            if(!flag) num++;  //注意题目要求
        }
        return num;
    }
}