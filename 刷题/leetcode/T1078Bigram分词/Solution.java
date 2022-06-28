/*
简单一遍过 还学到了  return list.toArray(new String[list.size()]);
官方也只有遍历法：
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> list = new ArrayList<String>();
        for (int i = 2; i < words.length; i++) {
            if (words[i - 2].equals(first) && words[i - 1].equals(second)) {
                list.add(words[i]);
            }
        }
        int size = list.size();
        String[] ret = new String[size];
        for (int i = 0; i < size; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}

 */
package 刷题.leetcode.T1078Bigram分词;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String [] strings = text.split(" ");
            for(int i =0;i<strings.length;i++)
            {
                if(strings[i].equals(first))
                {
                    if(i+1<strings.length&&strings[i+1].equals(second))
                    {
                        if(i+2<strings.length) list.add(strings[i+2]);
                    }
                }
            }
            return list.toArray(new String[list.size()]);
    }
}
