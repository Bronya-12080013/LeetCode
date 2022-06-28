/* #转
初版写了一半，隔了一晚，思路乱了，
原本写dfs的，今早改了
算了，重写
==============================================
wuwuwuw不写了
=================================================
本题很重量级
 */

/*
初版
package 刷题.leetcode.剑指Offer38字符串的排列;

public class Time {
    String[] strings;
    int count =0;
    char[] chars;
    public String[] permutation(String s) {
        chars = s.toCharArray();
        strings=new String[Waytwo(chars.length)];
        for(int i=0;i<chars.length;i++)
        {
            char[] nums =new char[chars.length];
            nums[0]=chars[i];
            char[] chares = new char[chars.length-1];
            int n=0;

            for(int j=0;j<chars.length;j++) {
                if(j==i) continue;
                chares[n++]=chars[j];
            }



            int index=0;
            for(int j=index;;j++)
            {
                //不行了
                if(j==chares.length-1){
                    j=-1;
                }

        }
        return strings;
    }



    }
     static int Waytwo(int num) {
        int sum=1;
        if(num<0) {
            throw new IllegalArgumentException("需要计算的参数必须为正数！");//抛出不合理参数异常
        }
        if(num==1) {
            return 1;//跳出循环
        }else {
            sum=num*Waytwo(num-1);//递归
            return sum;
        }
    }
}
*/

//模仿大佬的代码:
package 刷题.leetcode.剑指Offer38字符串的排列;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c=s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);   //等完全经历了dfs后，res已经成型了
    }
    void dfs(int x){        //x一直代表的是层数 前面是已确定的，后面是未定的,第一个传入开启的是0
        if(x==c.length-1){     //结束条件,写入
           // res.add(c.toString());                  //这个不行
            res.add(String.valueOf(c));             //把char[] 转成 String
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i=x;i<c.length;i++)          //这里最易搞混      牢记，x是层数  这里的目的是遍历本层所有的可能性 如当x=0，它就是第一层，有c.length可能;当第一层确定，就到第二层x=1,这时就有c.length-1种可能...
        {
            if(set.contains(c[i])) continue;     // 重复，因此剪枝(自己推看看)  //意思是在同一层只要有相同的就跳过     //如用例"abb"  aab aba  aab(跳，aba也不要了) baa baa(跳)   这两个跳不是同一层的
                                                //就是这一层的所有可能性中的某一可能失去了机会，那就去到另一可能，而不是去到它的下层
            set.add(c[i]);                    //把它放进去，防止重复
            swap(x,i);                       //不要懵， 牢记，x是层数  这就是把本层的数确定了（前面的for就是为了让后面的数都有机会放在这层），确定这层，把这层原本的数放到后面，待选
            dfs( x+1);                    //这层定了，去到下一层  可以看，传的是x+1 与i无关 这就是因为i是为了“找寻本层所有的可能”
            swap(i,x);                       //回来了，这层以i开头的平行世界已经定了，恢复回来    接下来让i++,去到下一个可能性
         }
    }
    void swap(int i,int j){         //交换在数组中的位置
        char temp=c[i];
        c[i]=c[j];
        c[j]=temp;
    }
}

