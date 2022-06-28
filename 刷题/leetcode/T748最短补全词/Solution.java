/*
过了 但好笨啊   50.15% && 43.40%
方法 toLowerCase() 有返回值
方法Character.isLetter()判断是否为字符
==========================================
官方答案 我还以为我的写法很笨 没想到官方也一样 但效率怎么比我高
class TopVotedCandidate {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] cnt = new int[26];
        for (int i = 0; i < licensePlate.length(); ++i) {
            char ch = licensePlate.charAt(i);
            if (Character.isLetter(ch)) {
                ++cnt[Character.toLowerCase(ch) - 'a'];
            }
        }
        int idx = -1;
        for (int i = 0; i < words.length; ++i) {
            int[] c = new int[26];
            for (int j = 0; j < words[i].length(); ++j) {
                char ch = words[i].charAt(j);
                ++c[ch - 'a'];
            }
            boolean ok = true;
            for (int j = 0; j < 26; ++j) {
                if (c[j] < cnt[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok && (idx < 0 || words[i].length() < words[idx].length())) {
                idx = i;
            }
        }
        return words[idx];
    }
}

 */


package 刷题.leetcode.T748最短补全词;

public class Solution {
    public static void main(String[] args) {
        String licensePlate="1s3 PSt";
        String[] words = new String[]{"step","steps","stripe","stepple"};
        Solution solution = new Solution();
        System.out.println(solution.shortestCompletingWord(licensePlate,words));
    }
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] cur = new int[26];
        int count = 0;
        licensePlate=licensePlate.toLowerCase();    //这是有返回值的
        for(char c : licensePlate.toCharArray())
        {
            if(c==' ') continue;
            if(c<=122&&c>=97)
            {
               cur[c-'a']++;
            }
        }
        int minIndex=-1;
        for(int j =0;j<words.length;j++)
        {
            String s = words[j].toLowerCase();
            int[] bur  = new int[26];
            for(char c : s.toCharArray())
            {
                if(c==' ') continue;
                if(c<=122&&c>=97)
                {
                    bur[c-'a']++;
                }
            }
            boolean flag =true;
            for(int i = 0;i<26;i++)
            {
                if (bur[i]<cur[i]) {
                    flag=false;
                    break;
                }
            }
            if(flag)
            {
                if(minIndex==-1) minIndex=j;
                else if(s.length()<words[minIndex].length()) minIndex=j;
            }
            /*
            可以写成  if(flag&&(minIndex==-1||s.length()<words[minIndex].length()))  minIndex=j;
             */
        }
        return words[minIndex];
    }
}
