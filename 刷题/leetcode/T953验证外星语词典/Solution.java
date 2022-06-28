package 刷题.leetcode.T953验证外星语词典;

import javax.naming.ldap.HasControls;
import java.util.*;


//33.57% && 29.58%
class Solution {
    HashMap<Character,Integer> hashMap = new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {
        for(int i=0;i<order.length();i++) hashMap.put(order.charAt(i),i);
        for(int i=1;i<words.length;i++)
        {
            if(!isOrder(words[i-1],words[i])) return false;
        }
        return true;
    }
    public boolean isOrder(String s1,String s2)
    {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for(int i=0;i<c1.length&&i<c2.length;i++)
        {
            if(c1[i]!=c2[i]) {
                return hashMap.get(c1[i])-hashMap.get(c2[i])<0?true:false;
            }
        }
        return c1.length<=c2.length?true:false;  //两个完全一样的话也算按序了 所有是<=
    }
}

/*
官方答案
妙啊
用order.charAt(i) - 'a'来做下标


class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            boolean valid = false;
            for (int j = 0; j < words[i - 1].length() && j < words[i].length(); j++) {
                int prev = index[words[i - 1].charAt(j) - 'a'];
                int curr = index[words[i].charAt(j) - 'a'];
                if (prev < curr) {
                    valid = true;
                    break;
                } else if (prev > curr) {
                    return false;
                }
            }
            if (!valid) {
                if (words[i - 1].length() > words[i].length()) {
                    return false;
                }
            }
        }
        return true;
    }
}


 */

/*  失败
当然的 比较方法有明显的错误
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Set<String[]> set = new HashSet<>();
        set.add(words);
        String[] w = new String[words.length];
        for(int i=0;i<words.length;i++) w[i]=words[i];
        Arrays.sort(w, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                char[] c1 = s1.toCharArray();
                char[] c2 = s2.toCharArray();
                for(int i=0;i<c1.length&&i<c2.length;i++)
                {
                    if(c1[i]!=c2[i]) {
                        return order.indexOf(c1[1])-order.indexOf(c2[i]);
                    }
                }
                return c1.length-c2.length;
            }
        });
        if(set.contains(w)) return true;
        else return false;
    }
}
 */

