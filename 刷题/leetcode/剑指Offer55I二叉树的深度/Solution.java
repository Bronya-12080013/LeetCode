/*
不是很难  100% && 17.95%
但一定得小心思考
尤其是用 后序遍历 和 temp的方法
===================================================
对了，DFS不一定要用递归，也可先用栈遍历树入栈，在一个个取出即可。这样就不用递归了
  如果用 后序遍历倒序 遍历入栈，取时就相当于 后序遍历

还有 BFS基本（吧）绑定队列

=========================================================
大佬代码！！！！！！！！！！！！！！！！！！！！妙啊
class RangeFreqQuery {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

妙啊，直接返回int类型来统计！！！！！！！
我之前见过，这次还是不会写
这个递归有“同时”的感觉，这我当时想不到这种感觉,总是想递归先到左再到右，没法直接比较
==============================================================
 */

package 刷题.leetcode.剑指Offer55I二叉树的深度;

public class Solution {
    int max=0,temp=0;
    public int maxDepth(TreeNode root) {
        dfs(root);
        return max;
    }
    void dfs(TreeNode root){
        if(root==null) return;
        temp++;   //每到一层加一个
        dfs(root.left);   //不要下意识地把递归和return返回在一起
        dfs(root.right);
        if(temp>max) max =temp;
        temp--;  //每退出一层减一个
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }