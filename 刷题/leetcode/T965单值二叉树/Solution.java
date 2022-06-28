package 刷题.leetcode.T965单值二叉树;

//v2
class Solution {
    int val;
    public boolean isUnivalTree(TreeNode root) {
        if(root==null) return true; //默认的吧
        val= root.val;
        return lrm(root);
    }

    public boolean lrm(TreeNode node)
    {
        if(node==null) return true;
        if(node.val!=val) return false;
        else return lrm(node.left)&&lrm(node.right);
    }
}

/*
//v1
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root==null) return false;
        return lrm(root, root.val);
    }

    public boolean lrm(TreeNode node,int val)
    {
        if(node==null) return true;
        if(node.val!=val) return false;
        else return lrm(node.left, node.val)&&lrm(node.right,node.val);
    }
}
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  /*
  官方答案
  class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.val != root.left.val || !isUnivalTree(root.left)) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.val != root.right.val || !isUnivalTree(root.right)) {
                return false;
            }
        }
        return true;
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/univalued-binary-tree/solution/dan-zhi-er-cha-shu-by-leetcode-solution-15bn/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */