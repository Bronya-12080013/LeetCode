package 刷题.leetcode.T433最小基因变化;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
稳健的BFS和不稳定的String

注意：
1.别整String拼接了（包括string.substring()) 很慢 尽量用StringBuffer
2.这题要考虑各种条件（看，那么多if）
 */
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> banks = new HashSet<>();
        for (String b:bank) banks.add(b);
        Set<String> visited = new HashSet<>();
        char[] keys = {'A', 'C', 'G', 'T'};
        if(start.equals(end)) return 0;
        if(!banks.contains(end)) return -1;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);
        int step = 1;
        while (!queue.isEmpty())
        {
            int size = queue.size(); //queue会变长，要先把它确立下来
            for(int i=0;i<size;i++)
            {
                String string = queue.poll();
                for(int j=0;j<8;j++){
                    for(int k=0;k<keys.length;k++)
                    {
                       //String next = string.substring(0,j)+keys[k]+string.substring(j+1);    变这一个方法 能快不少 //别再整String拼接了
                        StringBuffer sb = new StringBuffer(string);
                        sb.setCharAt(j,keys[k]);
                        String next = sb.toString();
                       if(!visited.contains(next)&&banks.contains(next))
                       {
                           if(end.equals(next)) return step;
                           queue.offer(next);
                           visited.add(next);
                       }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}


/*
肯定不行了 因为bank中可能不连贯
当我还是想试试  结果：10/14
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<bank.length;i++) set.add(bank[i]);
        if(!set.contains(end)) return -1;
        int res = 0;
        for(int i=0;i<end.length();i++)
        {
            if(start.charAt(i)!=end.charAt(i)) res++;
        }
        return res;
    }
}
 */