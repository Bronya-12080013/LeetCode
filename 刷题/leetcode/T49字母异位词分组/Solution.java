/*
好好好好好好好好好好看题目！！！所有源单词中的字母通常恰好只用一次!!!(错了 下说)
可以用Set或位运算了
还有strs[i] 仅包含小写字母
=============================================================
对不起 拖了一天我忘了用例
"给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。"
的
”所有源单词中的字母通常恰好只用一次“是说重排时各个字母用一次

班二错了
===============================================================
答案
方法一：排序
由于互为字母异位词的两个字符串包含的字母相同，因此对两个字符串分别进行排序之后得到的字符串一定是相同的，故可以将排序之后的字符串作为哈希表的键。
妙啊 哈哈好简单的思路啊

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

还学到了return new ArrayList<List<String>>(map.values());
==================================================================
方法二：计数
由于互为字母异位词的两个字符串包含的字母相同，因此两个字符串中的相同字母出现的次数一定是相同的，故可以将每个字母出现的次数使用字符串表示，作为哈希表的键。
由于字符串只包含小写字母，因此对于每个字符串，可以使用长度为 2626 的数组记录每个字母出现的次数。
需要注意的是，在使用数组作为哈希表的键时，不同语言的支持程度不同，因此不同语言的实现方式也不同。

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

妙啊 字符期间来用字符（a~z）来把数字隔开


 */
package 刷题.leetcode.T49字母异位词分组;

import java.util.*;

//官方代码
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}


/* 不行 没记录重复单词次数
class Solution {
    public static void main(String[] args) {
        String[] strs={
                "eat","tea","tan","ate","nat","bat"};
        Solution solution =new Solution();
        solution.groupAnagrams(strs);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> List = new ArrayList<>();
        Map<Integer,ArrayList>  hashMap = new HashMap<>();

        for(String s:strs)
        {
            int chars = trans(s);
            hashMap.putIfAbsent(chars,new ArrayList());
            hashMap.get(chars).add(s);
        }
        for (ArrayList list:hashMap.values()) List.add(list);
        return List;
    }
    int trans(String s)
    {
        int chars = 0;
        for(char c:s.toCharArray()) chars|=1<<(c-'a');
        return chars;
    }
}
 */

/* 这题不行了 拖了一天 主要是我不知道怎么把int[] 作为hashMap键
=======================================================
等等等等等等等 又又又又又又又又又看漏题目了
”所有源单词中的字母通常恰好只用一次“
我又行了
class Solution {
    public static void main(String[] args) {
        String[] strs={
                "eat","tea","tan","ate","nat","bat"};
        Solution solution =new Solution();
        solution.groupAnagrams(strs);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> List = new ArrayList<>();
        Map<int[],ArrayList>  hashMap = new HashMap<>();
        for(String s:strs)
        {
            int[] cnt = trans(s);
            ArrayList list = hashMap.get(cnt);
            if(list==null) hashMap.put(cnt,new ArrayList());
            list.add(s);
        }
        for (ArrayList list:hashMap.values()) List.add(list);
        return List;
    }
    int[] trans(String s)
    {
        int[] cnt = new int[26];
        for(char c:s.toCharArray()) cnt[c-'a']+=1;
        return cnt;
    }
}
 */