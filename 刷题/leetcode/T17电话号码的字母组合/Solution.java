/*
好 又写出个回溯  100.00% && 5.06%
还是遍历回溯(有几层要回溯 每层又有多个数（要遍历）)
===============================================
官方答案 差不多
注意　: HashMap还有这种构造方法 : HashMap(Map<? extends K,? extends V> m)

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}

 */
package 刷题.leetcode.T17电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    List<String> List ;
    HashMap<Character,char[]> hashMap;
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<>();
        List= new ArrayList<>();
       hashMap = new HashMap<>();
        hashMap.put('2',new char[]{'a','b','c'});;
        hashMap.put('3',new char[]{'d','e','f'});
        hashMap.put('4',new char[]{'g','h','i'});
        hashMap.put('5',new char[]{'j','k','l'});
        hashMap.put('6',new char[]{'m','n','o'});
        hashMap.put('7',new char[]{'p','q','r','s'});
        hashMap.put('8',new char[]{'t','u','v'});
        hashMap.put('9',new char[]{'w','x','y','z'});
        DFS(digits,0,new StringBuffer());
        return List;
    }
    void DFS(String digits,int index,StringBuffer sb)
    {
        if(index>=digits.length())
        {
            List.add(sb.toString());
            return;
        }
        for (char c:hashMap.get(digits.charAt(index)))
        {
            sb.append(c);
            DFS(digits,index+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}