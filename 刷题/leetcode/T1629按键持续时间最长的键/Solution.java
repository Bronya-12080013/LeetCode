package 刷题.leetcode.T1629按键持续时间最长的键;

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char ans = keysPressed.charAt(0);
        int maxTime  =releaseTimes[0];
        for(int i =1;i<releaseTimes.length;i++)
            {
                int time = releaseTimes[i]-releaseTimes[i-1];
                if(time>maxTime||(time==maxTime&&keysPressed.charAt(i)>ans)){
                    ans=keysPressed.charAt(i);
                    maxTime=time;
                }
            }
        return ans;
    }
}