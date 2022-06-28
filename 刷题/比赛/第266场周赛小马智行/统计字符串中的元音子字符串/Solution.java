/*

https://leetcode-cn.com/contest/weekly-contest-266/
5918. 统计字符串中的元音子字符串
子字符串 是字符串中的一个连续（非空）的字符序列。
元音子字符串 是 仅 由元音（'a'、'e'、'i'、'o' 和 'u'）组成的一个子字符串，且必须包含 全部五种 元音。
给你一个字符串 word ，统计并返回 word 中 元音子字符串的数目 。

==============================================================

这题用笨方法做出来了，过了
还有几处可优化，本题与第二题有关系(第二题没过)
=======================================================
看大佬的答案：
class RangeFreqQuery {
    public int countVowelSubstrings(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < word.length(); j++) {
                if ("aeiou".indexOf(word.charAt(j)) < 0) {      //返回指定子字符串在此字符串中第一次出现处的索引.若无，则-1   //这里是用来判断(word.charAt(j)是否为"aeiou"中的一个字符
                    break;
                }
                set.add(word.charAt(j));
                if (set.size() == 5) {
                    count++;
                }
            }
        }
        return count;
    }
}

妙啊，是我没看清楚题目，导致前期出错
set.add会自动判断原先有没有这个值的，不必先用set.contains()判断


知识点：indexOf可以用来判断‘是否存在’

 */


















package 刷题.比赛.题一;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int i =countVowelSubstrings("cuaievovac");
    }
    public static int countVowelSubstrings(String word) {
        int sum=0;
            ArrayList strings =show(word);
        for(int i = 0; i <strings.size(); i++){
            String str = strings.get(i).toString();
           if(todo(str)) sum++;
        }
        return sum;
    }
    static boolean todo(String str){
        int sum=0;
        Set set =new HashSet();
        for(int j=0;j<str.length();j++)
        {

            if((str.charAt(j)=='a'||str.charAt(j)=='e'||str.charAt(j)=='i'||str.charAt(j)=='o'||str.charAt(j)=='u'))
            {
                if(!set.contains(str.charAt(j)))
                {
                    sum++;
                    set.add(str.charAt(j));
                }
            }else return false;
        }
        if(sum==5) return true;
        else return false;
    }
    public static ArrayList show( String str){
        ArrayList arrayList =new ArrayList();
        for(int i = 0; i < str.length(); i++){
            for (int j = i+1; j<=str.length(); j++){
                arrayList.add(str.substring(i,j));
            }
        }
        return arrayList;
    }
}

