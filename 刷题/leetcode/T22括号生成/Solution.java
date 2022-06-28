/*
折腾了那么就 终于搞成了 走了好多弯路
回头想想 好像也不难 也写过类似的 其实一开始画画图就能把思路理清的 还是太莽了
版一 脑子抽了 每吃早餐 写完就去吃 我还没见过回溯加双重方法的 没见过就别乱写
写着写着就发现杂鱼了 改成版二 稍加修改就过了 思路很简单
注意！！！！ sb.deleteCharAt(sb.length()-1);  //注意 sb是引用数据类型 传的是实参 会改变 所有要删除的 //基本数据类型如int 传形参 不改变
 但还是依靠 方法来判断成立和Set去重(Set是在版一用的 在版二没必要了 可以去了)

 版二是全列举后筛选
 优化成版三还是费了不少功夫
 设了stock和flag来剪枝 、
 详见代码注解
 */

package 刷题.leetcode.T22括号生成;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//版三 74.16% && 67.81%
class Solution {
    List<String> List;
    public java.util.List<String> generateParenthesis(int n) {
        List = new ArrayList<>();
        DFS(new StringBuffer(),0,0,n,true);
        return List;
    }
    void DFS(StringBuffer sb,int index,int stock,int n,boolean flag)  //stock存入的是纯纯的"("加入数,也就是已经加入的“(”数量 不会因加入")"而减少
    {
        if(index==n*2){
            List.add(sb.toString());
            return;
        }
        if(stock==n) flag=false; //这之后都不要加"("了
        if(flag)
        {
            sb.append("(");
            DFS(sb,index+1,stock+1,n,flag);
            sb.deleteCharAt(sb.length()-1); //注意 sb传的是实参 会改变 所有要删除的 //基本数据类型如int 传形参 不改变
        }
        if(sb.length()<stock*2)  //这里意识是 : sb.length()-stock<stock 也就是 目前的“)”数量比"("少
            /*
            (我本来是想让stock收支平衡的 这也是前面版本的思想 )
            这里原本是 (stock>0) 而下面写的是 DFS(sb,index+1,stock-1,n,flag);
            但仔细想想就不行 这会宽恕"("的 让“(”在达到极限前降下来 之后再次增加 会错的  (刚才竟然想不出哪里错了 果然没吃早餐不行啊)
            所以我竟然想出了 if(sb.length()<stock*2) 这么好的法子
            把stock改成了纯纯的"("加入数

             */
        {
            sb.append(")");
            DFS(sb,index+1,stock,n,flag); //因为加入的是")" 所以stock不增加
            sb.deleteCharAt(sb.length()-1); //注意 sb传的是实参 会改变 所有要删除的 //基本数据类型如int 传形参 不改变
        }
    }
}

/*
//版二 9.80% && 5.04%
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateParenthesis(3);
    }
    List<String> List;
    Set<String> set = new HashSet<>();
    public java.util.List<String> generateParenthesis(int n) {
        List = new ArrayList<>();
        DFS(new StringBuffer(),0,n*2);
        return List;
    }
    void DFS(StringBuffer sb,int index,int n)
    {
        if(index>=n){
            String string = sb.toString();
            if(isIt(string)&&set.add(string)) List.add(string);
            return;
        }
        sb.append("(");
        DFS(sb,index+1,n);
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        DFS(sb,index+1,n);
        sb.deleteCharAt(sb.length()-1);  //注意 sb传的是实参 会改变 所有要删除的 //基本数据类型如int 传形参 不改变
    }
    boolean isIt(String s)
    {
        int stock = 0;
        for(char c:s.toCharArray())
        {
            if(c=='(') stock++;
            else stock--;
            if(stock<0) return false;
        }
        if(stock==0) return true;
        else return false;
    }
}
 */

/*  版一 错了
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateParenthesis(3);
    }
    List<String> List;
    Set<String> set = new HashSet<>();
    public java.util.List<String> generateParenthesis(int n) {
        List = new ArrayList<>();
        DFS(new StringBuffer(),0,n*2);
        return List;
    }
    void DFS(StringBuffer sb,int index,int n)
    {
        if(index>=n){
            String string = sb.toString();
            if(isIt(string)&&set.add(string)) List.add(string);
            return;
        }
        sb.append("(");
        DFS(sb,index+1,n);
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        DFSfake(sb,index+1,n);
        sb.deleteCharAt(sb.length()-1);  //注意 sb传的是实参 会改变 所有要删除的 //基本数据类型如int 传形参 不改变
    }
    void DFSfake(StringBuffer sb,int index,int n)
    {
        if(index>=n){
            String string = sb.toString();
            if(isIt(string)&&set.add(string)) List.add(string);
            return;
        }
        sb.append(")");
        DFS(sb,index+1,n);
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        DFSfake(sb,index+1,n);
        sb.deleteCharAt(sb.length()-1);  //注意 sb传的是实参 会改变 所有要删除的 //基本数据类型如int 传形参 不改变
    }
    boolean isIt(String s)
    {
        int stock = 0;
        for(char c:s.toCharArray())
        {
            if(c=='(') stock++;
            else stock--;
            if(stock<0) return false;
        }
        if(stock==0) return true;
        else return false;
    }
}
 */