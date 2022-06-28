/*
不行了
package 刷题.leetcode.剑指Offer68I二叉搜索树的最近公共祖先;

import java.util.ArrayList;
import java.util.Stack;

public class RangeFreqQuery {
    Stack stackp =new Stack();
    Stack stackq =new Stack();
    boolean flag =false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dsf(root,p,stackp);
        dsf(root,q,stackq);
        Object[] arrayListp=stackp.toArray();
        Object[] arrayListq=stackq.toArray();
        for(int i=0;i<arrayListp.length;i++)
        {
            for(int j=0;j<arrayListq.length;j++)
            {
                if((TreeNode)arrayListp[i]==(TreeNode)arrayListq[j])
                {
                    return (TreeNode)arrayListp[i];
                }
            }
        }
        return null;
    }
    void dsf(TreeNode treeNode,TreeNode found,Stack stack){
        if(treeNode==null&&!flag) return;
        dsf(treeNode.left,found,stack);
        if(treeNode.val==found.val)
        {
            flag=true;
        }else stack.push(treeNode);
        dsf(treeNode.right,found,stack);
        if(!flag) stack.pop();
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


 */

/*
看解答
===============================================
看题不仔细！！！！！！！！！！！！！！
1.所有节点的值都是唯一的
2.二叉搜索树
================================================
妙啊，分解问题的能力
 */

//看懂了大佬代码了，我写写
//过了
package 刷题.leetcode.剑指Offer68I二叉搜索树的最近公共祖先;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null){
            if(p.val<root.val&&q.val<root.val)
                root=root.left;
            else if(p.val>root.val&&q.val>root.val)
                root=root.right;
            else break;
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


/*
递归法也行
class RangeFreqQuery {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
 */