
/*
过了，但效率不高
直接看看大佬代码
========================================================
1.不用用中序遍历，而是 中序遍历倒序 ！！！！！！！！！！！！！！！！
虽然学了 前序遍历 中序遍历 后序遍历
但其实把它们倒过来 还有 前序遍历倒序 中序遍历倒序 后序遍历倒序
它们并不难写出
(今早我写时还以为k是正的呢，傻了，就直接中序遍历)

2.用了 中序遍历倒序 后，就可以不用数组了
可以 提前返回： 若 k = 0k=0 ，代表已找到目标节点，无需继续遍历，因此直接返回

代码:
class RangeFreqQuery {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
}

 */



package 刷题.leetcode.剑指Offer54二叉搜索树的第k大节点;

import java.util.ArrayList;

public class Solution {
    ArrayList arrayList =new ArrayList();
    public int kthLargest(TreeNode root, int k) {
            dfs(root,k);
            return (Integer) arrayList.get(arrayList.size()-k);
    }

    void dfs(TreeNode root,int k){           //返回值不必TreeNode，dfs（类型）
        if(root==null) return;
        dfs(root.left, k);                   //不要return dfs(root.left, k); dfs是返回void的
        arrayList.add(root.val);
        dfs(root.right,k);
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
