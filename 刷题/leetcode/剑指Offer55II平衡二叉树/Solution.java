/*
成功了 5.81% && 91.49%
是基于上一题的改编
去看看别人用什么方法
===========================================
此树的深度 等于 左子树的深度 与 右子树的深度 中的 最大值 +1+1 。(注意，是最大值！！！，所以我用maxDepth())
=======================================================
太强了，递归归归归归归归归归归归归归归归归归归归归归归归归归归归归归归归

作者：jyd
链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/solution/mian-shi-ti-55-ii-ping-heng-er-cha-shu-cong-di-zhi/

 class RangeFreqQuery {
    public  boolean isBalanced(TreeNode root) {
        return recur(root)!=-1;
    }
    int recur(TreeNode root){
        if(root==null) return 0;
        int left = recur(root.left);
        if(left==-1) return -1;
        int right = recur(root.right);
        if(right==-1) return -1;
        return Math.abs(right-left)>1?-1:Math.max(left,right)+1;
    }
}

 */



package 刷题.leetcode.剑指Offer55II平衡二叉树;

import javax.sound.midi.Soundbank;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode =new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.left.left=new TreeNode(3);
        treeNode.left.left.left=new TreeNode(4);
        treeNode.right=new TreeNode(2);
        treeNode.right.right=new TreeNode(3);
        treeNode.right.right.right=new TreeNode(4);
        Solution solution =new Solution();
        boolean testflag=solution.isBalanced(treeNode);
      //  System.out.println(testflag);
    }
    boolean flag=true;
    public  boolean isBalanced(TreeNode root) {
        dsf(root);
        return flag;
    }
    public void dsf(TreeNode root){
        if(root==null) return;
        dsf(root.left);
        dsf(root.right);
        if(!nodeisBalanced(root))
        {
            flag=false;
        }
    }
    public boolean nodeisBalanced(TreeNode root) {
        if(root==null) return true;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(right-left,left-right)<=1? true:false;
    }
     int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



/*
//这个不行

public class RangeFreqQuery {
    boolean falg=true;
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if( Math.max(right-left,left-right)<=1)
            falg=true;
        else falg=false;
        return isBalanced(root.left)&&isBalanced(root.right);
    }
     int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
 */