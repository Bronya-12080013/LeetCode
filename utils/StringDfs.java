/*
方法permutation(String s) 可返回字符串s的全排列 形式为String[]
 */

package utils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class StringDfs {
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
            dfs( x+1);                    //这层定了，去到下一层
            swap(i,x);                       //回来了，这层以i开头的平行世界已经定了，恢复回来    接下来让i++,去到下一个可能性
         }
    }
    void swap(int i,int j){         //交换在数组中的位置
        char temp=c[i];
        c[i]=c[j];
        c[j]=temp;
    }
}