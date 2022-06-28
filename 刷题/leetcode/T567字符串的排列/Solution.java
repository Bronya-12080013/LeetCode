/*
ohhhhhhhhhhhhhhhhhh 过了    5.05% 16.73%
本来想搞出s1的全排列，再s2.contains()的
不知道怎么搞（emmmmm写过了，待会看看）
后来看了答案的评论，发现既然是全排列，那顺序就无意义
直接判断就行了
但还是踩了好多坑
下面来看看
=========================================================
坑:
1.我本就是写 if(hashMap.get(s2.charAt(j))>0)
但 因为3处
hashMap.put(s2.charAt(j),hashMap.get(s2.charAt(j))-1);
的-1写到全面的括号里了
导致hashMap减一时变成了null
所以改成了 if(hashMap.get(s2.charAt(j))!=null)
在改正3后 1也改了回来

2.原本用 Set<String> set = new HashSet();的
后来发现用数理问题，就改成了hashMap

4.i<s2.length()-num+1 我没把握好位置 写了i<s2.length()-num
=======================================================
String字符全排列方法
记笔记
参考剑指Offer38字符串的排列 用dfs
=======================================================
官方答案:
1.滑动窗口
class Time {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];                //这里前++和后++都一样
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {               //先判断一次
            return true;
        }
        for (int i = n; i < m; ++i) {                  //开始先移动一次，再判断  下面有s2.charAt(i - n)，所以在上面就先判断了第一次，若把它放进来，s2.charAt(i - n)就会错
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
}
优化:
class Time {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {           //先挖坑  正坑负坑都是坑  就像先挖了几个洞 然后有拿同样数量的堆土去埋，一部分埋中了洞，一部分没中，堆在地上了
            --cnt[s1.charAt(i) - 'a'];
            ++cnt[s2.charAt(i) - 'a'];
        }
        int diff = 0;
        for (int c : cnt) {                     //统计坑的数量   diff是坑的数量，而不管坑的深浅（有可能是+1 -1 或 -2等 反正不为0就是个坑）
            if (c != 0) {
                ++diff;
            }
        }
        if (diff == 0) {                        //先判断第一下
            return true;
        }
        for (int i = n; i < m; ++i) {
            int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';          // x是要”加入的“ y是要”去掉的“
            if (x == y) {                                                      //同的话就没必要看了
                continue;
            }


            if (cnt[x] == 0) {                                               //如果这里本来已经没坑了，那么把x加进来就会产生坑（正坑）
                ++diff;
            }
            ++cnt[x];                                                       //把x加进来
            if (cnt[x] == 0) {                                              //如果把x加进来后，坑没了  那就是原来有负的坑，被x填上了 那么坑数diff--
                --diff;                                                     //前面说了  diff是坑数 不是深浅   如果原本是-2  加上一个x变-1 那也不会填坑
             }


            if (cnt[y] == 0) {                                        //同理 如果这里本来已经没坑了 那么再减掉y就会产生坑（负坑）
                ++diff;
            }
            --cnt[y];                                                 //减去y
            if (cnt[y] == 0) {                                          //如果减去y 坑没了 那就是原来有正坑 现在减没了 坑数diff--
                --diff;
            }


            if (diff == 0) {                                         //当坑数==0  即 s1已经被s2这段的子串消化了
                return true;
            }
        }
        return false;
    }
}

2.双指针
class Time {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];                  //挖坑
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {         //从left开始埋坑
            int x = s2.charAt(right) - 'a';
            ++cnt[x];                                     //埋了这个坑
            while (cnt[x] > 0) {                            //如果这个地方凸起来了，那么这个地方原本是没坑的，埋错了
                --cnt[s2.charAt(left) - 'a'];               //这时的right就是埋错了,赶紧喊left铲坑，把刚才right埋过的坑和right现在埋错的坑（凸起来了）都铲了！！！left快救一下
                ++left;                                     //left沿着right的足迹，铲了坑，走到了right的位置，把凸起了的堆铲了（使原本的cnt[x]=1变成cnt[x]=0），然后走到了right的下一位；之后的for的下一轮right++ 与left同步 所以上面才说”从left开始埋坑“
            }
            if (right - left + 1 == n) {               //当 right与left拉开了那么长的距离 那么就是right都没有失败 埋好了所有坑的数量 那么就是所以坑都埋上了 成功
                return true;
            }
        }
        return false;
    }
}

作者：LeetCode-Time
链接：https://leetcode-cn.com/problems/permutation-in-string/solution/zi-fu-chuan-de-pai-lie-by-leetcode-solut-7k7u/
============================================
1.优化前:是用数组来保存的Arrays.equals()来判断，妙啊
数组放 ascll码
优化后:有趣，真厉害
详见解析
2.有了前面滑动窗口的优化的理解，
双指针法的理解就简单了
它不是”从某点开始，进行一段，如果不不行，就放弃，然后从这一点的下一点开始，再进行一段“
而是这段不行，全部放弃，去断点后的下一点
这与我平时的想法不同
============================================
 */
package 刷题.leetcode.T567字符串的排列;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(checkInclusion("hello","ooolleoooleh"));
    }
    static boolean checkInclusion(String s1, String s2) {
        int num=s1.length();
        //Set<String> set = new HashSet();
        Map<Character,Integer> map = new HashMap();
       // Stream.of(s1.toCharArray()).forEach(e->set.add(String.valueOf(e)));
        for(int i = 0 ;i<num;i++)
        {
            //set.add(String.valueOf(s1.charAt(i)));                //2 有重复可能
            if(map.containsKey(s1.charAt(i)))
            {
                map.put(s1.charAt(i),map.get(s1.charAt(i))+1);
            }else map.put(s1.charAt(i),1);
        }
        for(int i =0;i<s2.length()-num+1;i++)                  //4
        {
            HashMap<Character,Integer> hashMap = new HashMap();
            hashMap.putAll(map);
            int sum = s1.length();
            for(int j =i;j<i+num;j++)
            {
                if(hashMap.containsKey(s2.charAt(j)))
                {
                    if(hashMap.get(s2.charAt(j))>0){     //1   不，就是是if(hashMap.get(s2.charAt(j))>0) 因为错误3  不是if(hashMap.get(s2.charAt(j))!=null)
                        sum--;
                        hashMap.put(s2.charAt(j),hashMap.get(s2.charAt(j))-1);           //3 这里我把 -1 的位置放错了
                     }else break;
                }else break;
            }
            if(sum==0) return true;
        }
        return false;
    }
}