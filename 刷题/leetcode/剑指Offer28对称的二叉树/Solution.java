package 刷题.leetcode.剑指Offer28对称的二叉树;
//不能简单套用前几题
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetrical(root,root);
    }
    static boolean isSymmetrical(TreeNode A,TreeNode B)
    {
        if(A==null&&B==null)
            return true;
        if(A==null||B==null)
            return false;
        if(A.val!=B.val)
            return false;
        return isSymmetrical(A.left,B.right)&&isSymmetrical(A.right,B.left);   //在本题中，从第一步看着
                                                                            // &&isSymmetrical(A.right,B.left)是多余的，但其实是必须的
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}