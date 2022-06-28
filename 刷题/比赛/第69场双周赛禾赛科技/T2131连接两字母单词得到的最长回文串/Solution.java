/*
ohhhhhhhhhhhhhhh 极限出分
记得明天再把三题提交一次哦！！！
============================================
这题主要是我思路不清晰 刚开始都没考虑遇到两个相同一样的情况 如 fo 和 fo
我的代码:
将 两字符同的(如ff) 和 两字符不同的(如fq) 分开治理
最后再检测看看有没有无法配对的 两字符同的
===================================================
大佬代码:
class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){map.put(words[i],map.getOrDefault(words[i],0)+1);}
        int add=0;
        int ans=0;
        for(String s:map.keySet()){
            if(s.charAt(0)==s.charAt(1)){
                ans+=((map.get(s)>>1)<<2);
                if(((map.get(s)&1)==1)){add=2;}
            }
            else{
                String t=pal(s);
                if(map.containsKey(t)){ans+=Math.min(map.get(s),map.get(t))*2;}
            }
        }
        return ans+add;
    }
    public String pal(String s){
        return new StringBuilder(s).reverse().toString();
    }
}

 */


package 刷题.比赛.第69场双周赛禾赛科技.T2131连接两字母单词得到的最长回文串;

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[]{"qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"};
        System.out.println(solution.longestPalindrome(words));
    }
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> set = new HashMap<>();
        HashMap<String,Integer> seet = new HashMap<>();
        int sum = 0;
        for(int i =0;i<words.length;i++)
        {   String s =new StringBuffer(words[i]).reverse().toString();
            if(words[i].charAt(0)==words[i].charAt(1)){
                if (seet.containsKey(words[i])&&seet.get(words[i])!=0) {
                    sum += 4;
                    seet.put(words[i], seet.get(words[i]) - 1);
                }
                else if (seet.containsKey(s)) seet.put(s, seet.get(s) + 1);
                else if (!seet.containsKey(s)) {
                    seet.put(s, 1);
                }
            }
            else {
                if (set.containsKey(words[i])&&set.get(words[i])!=0) {
                    sum += 4;
                    set.put(words[i], set.get(words[i]) - 1);
                }
                else if (set.containsKey(s)) set.put(s, set.get(s) + 1);
                else if (!set.containsKey(s)) {
                    set.put(s, 1);
                }
            }
        }

        for(Integer i:seet.values())
        {
            if(i>0) {
                sum+=2;
                break;
            }
        }
return sum;
    }
}