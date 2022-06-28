/*
过不了 超时了  90/92
==================================================
妙啊！！！   把字符串转为对应的26位二进制数
 */
//大佬代码
package 刷题.比赛.第275场周赛vika维格.T2135统计追加字母可以获得的单词数;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Map<Integer, Integer> target = new HashMap();
        for(String s : targetWords){
            int c = code(s);
            target.put(c, target.getOrDefault(c, 0) + 1);  //即使是不同单词 但只要出现的字母即其数量同 就归为一样
        }

        int ans = 0;
        for(String s : startWords){
            int c = code(s);
            for(int i = 0; i < 26; i++){
                int letter = 1 << i, search = c | letter;
                if((c & letter) == 0 && target.containsKey(search)){
                    ans += target.get(search);
                    target.remove(search);
                }
            }
        }

        return ans;
    }

    private int code(String s){
        int res = 0;
        for(char c : s.toCharArray()){
            res |= (1 << (c - 'a')); //妙啊 这个你懂的 好好想一下 //主要题目: 在 startWords 或 targetWords 的任一字符串中，每个字母至多出现一次
        }
        return res;
    }
}

/*  过不了 超时了
package 刷题.比赛.第275场周赛vika维格.题三;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] startWords= new String[]{"ab","a"};
        String[] targetWords= new String[]{"abc","abcd"};
        System.out.println(solution.wordCount(startWords,targetWords));
    }
    public int wordCount(String[] startWords, String[] targetWords) {
        int sum=0;
        ArrayList<char[]> arrayList = new ArrayList();
        for(int i =0;i<startWords.length;i++)
        {
            arrayList.add(startWords[i].toCharArray());
        }
        char[][] chars = arrayList.toArray(new char[arrayList.size()][]);
        for(String s:targetWords)
        {
            Set<Character> set = new HashSet<>();
            for(char c:s.toCharArray()) set.add(c);
            for(int i=0;i<startWords.length;i++)
            {
               int n = 0;
                char[] cs = chars[i];
                if(cs.length!=set.size()-1) continue;
                for(int j =0;j<cs.length;j++){
                    if(set.contains(cs[j])) n++;
                    else break;
                }
                if(n==set.size()-1) {
                    sum++;
                    break;
                }else continue;
            }
        }
        return sum;
    }
}

/*
package 刷题.比赛.ss.题三;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] startWords= new String[]{"ab","a"};
        String[] targetWords= new String[]{"abc","abcd"};
        System.out.println(solution.wordCount(startWords,targetWords));
    }
    public int wordCount(String[] startWords, String[] targetWords) {
        int sum=0;
        for(String s:targetWords)
        {
            for(int i=0;i<startWords.length;i++)
            {
                Set<Character> set = new HashSet<>();
                for(char c:s.toCharArray()) set.add(c);
                char[] chars = startWords[i].toCharArray();
                int sub = 1;
                for(int j =0;j<chars.length;j++){
                    if(set.contains(chars[j])) set.remove(chars[j]);
                    else sub--;
                    if(sub<1) break;
                }
                if(sub==1&&set.size()==1) {
                    sum++;
                    break;
                }else continue;
            }
        }
        return sum;
    }
}
 */