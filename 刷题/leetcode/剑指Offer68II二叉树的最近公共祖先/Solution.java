/*
过了  23.37% && 64.38%
用了上一题的方法
先dfs（root） 中序遍历树 把树的值都按顺序变成1，2，3...
这样root树就变成搜索二叉树了  同时把树原本的值和替换后的值记在hashmap里
在用上一题的方法lowestCommonAncestor00找公共点
得公共点node
再放入dfsback(node) 把原本的值换回来就行
看看大佬代码
=====================================================
妙啊
public class RangeFreqQuery {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null||root==p||root==q) return root;                                  //发现个奇怪的东西 if(root==null|root==p|root==q) 也行，好像效率会下降
            TreeNode left = lowestCommonAncestor(root.left,p,q);                           //懂了，&于&& |与|| 前者两边都判断 后者先判断左边，一旦得出就直接结束，不管后面了
            TreeNode right= lowestCommonAncestor(root.right,p,q);
            if(left==null&&right==null) return null;    //可以不写这行 ，因为当left==null&&right==null时， if(left==null) return right;也是一样的结果
            if(left==null) return right;
            if(right==null) return left;
            return root;
    }
}
分析 只有 root==p||root==q 的情况 才会使这条链有值，其他都是null
一个节点 只有当它的 left为p||q或right为p||q 或它的子节点中有人是这样时，它才不会返回null
=============================================================
总结一下，
上题是顶至底的，可以用数值判断
本题是底至顶，当某一节点的left和right都存在时，就是公共点


 */

package 刷题.leetcode.剑指Offer68II二叉树的最近公共祖先;

import java.util.HashMap;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root);
            TreeNode node = lowestCommonAncestor00(root,p,q);
            dfsback(node);
            return node;
    }

    TreeNode lowestCommonAncestor00(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null){
            if(p.val<root.val&&q.val<root.val)
                root=root.left;
            else if(p.val>root.val&&q.val>root.val)
                root=root.right;
            else break;
        }
        return root;
    }

    int sum=1;
    HashMap hashMap =new HashMap();
    void dfs(TreeNode root)
    {
        if(root==null) return;
        dfs(root.left);
        hashMap.put(sum,root.val);
        root.val=sum;
        sum++;
        dfs(root.right);
    }
    void dfsback(TreeNode root)
    {
        if(root==null) return;
        dfs(root.left);
        root.val=(int)hashMap.get(root.val);
        dfs(root.right);
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }