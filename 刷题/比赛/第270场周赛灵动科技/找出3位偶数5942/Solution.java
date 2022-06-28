/*  题一
================================================
给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。

你需要找出 所有 满足下述条件且 互不相同 的整数：

该整数由 digits 中的三个元素按 任意 顺序 依次连接 组成。
该整数不含 前导零
该整数是一个 偶数
例如，给定的 digits 是 [1, 2, 3] ，整数 132 和 312 满足上面列出的全部条件。

将找出的所有互不相同的整数按 递增顺序 排列，并以数组形式返回。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/finding-3-digit-even-numbers
=================================================================
明明是用暴力法也很容易的一题
首先 我是写
if(((i*100+j*10+k)%2==0)&&i!=0) arrayList.add(i*100+j*10+k);
我把i,j,k直接但数计算了 应该是digits的
所以结果错了 我以为是重复 就写了六个if 后来又改了digit后来加了Hashset
总之这里我写蒙了 如果一开始写对了 就不会有重复了
=====================================================
等等，看来大佬答案 好像是我想错了
以我的答案来说 好像确实要这么去做
因为我是 int i =0; int j =i+1 ; int k =j+1;
所以我要写六个 if
而大佬从int i=0;int j =0;int k=0 开始，所以只用写一个
所以我要Set去重复
而大佬用TreeSet!!!!有序的Set!!!
==========================================================
TreeSet！！！！
TreeSet是一个有序的集合，它的作用是提供有序的Set集合。
另外说一下 泛型<>要有
ArrayList和TreeSet都是
如 TreeSet<Integer>
这样取出来时就不是Object了 不用再强转了
============================================================
大佬代码:
class TopVotedCandidate {
    public int[] findEvenNumbers(int[] digits) {
        TreeSet<Integer> ts = new TreeSet<>();
        int n = digits.length;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                for(int k = 0;k < n;k++){
                    if(i == j || j == k ||  k == i)continue;
                    if(digits[i] == 0)continue;
                    if(digits[k] % 2 != 0)continue;
                    int u = digits[i]*100+digits[j]*10+digits[k];
                    ts.add(u);
                }
            }
        }
        int[] ret = new int[ts.size()];
        int p = 0;
        for(int t : ts)ret[p++] = t;
        return ret;
    }
}
================================================================
另一种思路
class TopVotedCandidate {
public:
    vector<int> findEvenNumbers(vector<int>& digits) {
                int cnt[10] = {};
                for (int x : digits) cnt[x]++;
                vector<int> ans;
                for (int i = 100; i <= 999; i += 2) {
                        int x = i % 10, y = i / 10 % 10, z = i / 100 % 10;
                        cnt[x]--; cnt[y]--; cnt[z]--;
                        if (cnt[x] >= 0 && cnt[y] >= 0 && cnt[z] >= 0) ans.push_back(i);
                        cnt[x]++; cnt[y]++; cnt[z]++;
                }
                return ans;
    }
};
==================================================================

 */


//我的代码
package 刷题.比赛.第270场周赛灵动科技.找出3位偶数5942;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    ArrayList arrayList ;
    public int[] findEvenNumbers(int[] digits) {
        arrayList = new ArrayList();
        for(int i =0;i<digits.length;i++)
        {
            for(int j =i+1;j<digits.length;j++)
            {
                for(int k=j+1;k<digits.length;k++)
                {
                    if(((digits[i]*100+digits[j]*10+digits[k])%2==0)&&digits[i]!=0) arrayList.add(digits[i]*100+digits[j]*10+digits[k]);
                    if(((digits[i]*100+digits[k]*10+digits[j])%2==0)&&digits[i]!=0) arrayList.add(digits[i]*100+digits[k]*10+digits[j]);
                    if(((digits[j]*100+digits[i]*10+digits[k])%2==0)&&digits[j]!=0) arrayList.add(digits[j]*100+digits[i]*10+digits[k]);
                    if(((digits[j]*100+digits[k]*10+digits[i])%2==0)&&digits[j]!=0) arrayList.add(digits[j]*100+digits[k]*10+digits[i]);
                    if(((digits[k]*100+digits[i]*10+digits[j])%2==0)&&digits[k]!=0) arrayList.add(digits[k]*100+digits[i]*10+digits[j]);
                    if(((digits[k]*100+digits[j]*10+digits[i])%2==0)&&digits[k]!=0) arrayList.add(digits[k]*100+digits[j]*10+digits[i]);
                }
            }
        }
        ArrayList array=new ArrayList();

        HashSet set = new HashSet();
        for(int i =0;i<arrayList.size();i++)
        {
            if(!set.contains(arrayList.get(i)))
            {
              array.add(arrayList.get(i));
                set.add(arrayList.get(i));
            }
        }
        int[] nums=new int[array.size()];
        int count=0;
        for(Object num:array)
        {
            nums[count++]=(int) num;
        }
        Arrays.sort(nums);
        return nums;
    }
}
