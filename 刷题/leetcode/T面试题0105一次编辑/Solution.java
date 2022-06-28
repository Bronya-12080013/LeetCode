package 刷题.leetcode.T面试题0105一次编辑;
/*
简单模拟
97.69% && 13.57%
=====
分类讨论
 */
class Solution {
    public boolean oneEditAway(String first, String second) {
        //直接出局
        if(first.equals(second)) return true;
        if(Math.abs(first.length()-second.length())>1) return false;


        if(first.length()==second.length())  //长度相等的情况
        {
            int len = first.length();
            int num = 0;
            char[] f = first.toCharArray();
            char[] s = second.toCharArray();
            for(int i=0;i<len;i++)
            {
                if(f[i]!=s[i]) num++;
                if(num>1) break;
            }
            if(num<=1) return true;
        }else {                         //两单词长度相差一个字符
            //长的设为f 短的设为s 方便操作
            String f = first.length()>second.length()?first:second;
            String s = first.length()>second.length()?second:first;
            char[] fc = f.toCharArray();
            char[] sc = s.toCharArray();
            int len = Math.min(first.length(),second.length());
            int fi=0,si=0;
            boolean chance = true; //只有一次不相等的机会
            for(int i=0;i<len;i++)
            {
                if(fc[fi]!=sc[si])
                {
                    if(chance)
                    {
                        fi++;
                        chance=false;
                    }
                    else return false;
                    if(fc[fi]!=sc[si]) return false;
                }
                si++;
                fi++;
            }
            return true;
        }
        return false;
    }
}

/*
官方写法
class Solution {
    public boolean oneEditAway(String first, String second) {
        int m = first.length(), n = second.length();
        if (n - m == 1) {
            return oneInsert(first, second);
        } else if (m - n == 1) {
            return oneInsert(second, first);
        } else if (m == n) {
            boolean foundDifference = false;
            for (int i = 0; i < m; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (!foundDifference) {
                        foundDifference = true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean oneInsert(String shorter, String longer) {
        int length1 = shorter.length(), length2 = longer.length();
        int index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            if (shorter.charAt(index1) == longer.charAt(index2)) {
                index1++;
            }
            index2++;
            if (index2 - index1 > 1) {
                return false;
            }
        }
        return true;
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/one-away-lcci/solution/yi-ci-bian-ji-by-leetcode-solution-2xkr/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */