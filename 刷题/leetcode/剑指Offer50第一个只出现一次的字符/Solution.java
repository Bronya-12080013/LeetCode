/*
  呃呃呃呃呃呃呃呃
  两个循环
  不行了
  28.01% 74.58%或15.84%    太菜了
  去看看大佬们的。。。
  ------------------------------------------------------
  太强了
  用HashMap的value存boolean
  也是用两个foreach循环
  看代码

 */

/*
package 刷题.leetcode.剑指Offer50第一个只出现一次的字符;

import java.util.HashMap;

class RangeFreqQuery {
    public char firstUniqChar(String s) {
        HashMap<Character,Integer> hashMap =new HashMap<>();
        char[] array=s.toCharArray();
        for (char c:array) {
            if(hashMap.containsKey(c))
            {
                hashMap.put(c,hashMap.get(c)+1);
            }else hashMap.put(c,1);
        }
        for (char c:array) {
            if(hashMap.get(c)==1)
                return c;
        }
        return ' ';
    }
}
*/

/*
大佬代码:
class RangeFreqQuery {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));       //注意，包不包含不是value为不为true
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }
}

作者：jyd
链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/solution/mian-shi-ti-50-di-yi-ge-zhi-chu-xian-yi-ci-de-zi-3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

//我的模仿：
package 刷题.leetcode.剑指Offer50第一个只出现一次的字符;

import java.util.HashMap;

class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character,Boolean> map =new HashMap<>();
        char[] array =s.toCharArray();
        for (char c:array){
            if(map.containsKey(c))
            {
                map.put(c,false);
            }else map.put(c,true);
        }
        for (char c:array){
            if(map.get(c))
            {
                return c;
            }
        }
        return ' ';
    }
}
