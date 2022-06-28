/*
失败了，不过方法应该是对的
================================================
看了大佬代码，太太太妙了
 */

/*

package 刷题.leetcode.剑指Offer27二叉树的镜像;

class RangeFreqQuery {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(9);
        mirrorTree(root);
    }
    static TreeNode mirrorTree(TreeNode root){

        if(root!=null)
            doit(root);
        if(root.left!=null)
        {
            return mirrorTree(root.left);
        }if (root.right!=null){

            return mirrorTree(root.right);
        }else return root;
    }
static TreeNode doit(TreeNode root){
        if(root!=null&&(root.left!=null||root.right!=null))
        {
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;
        }
    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


 */

//修改版


package 刷题.leetcode.剑指Offer27二叉树的镜像;

class Solution {
    static TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;    //递归的结束条件
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;       //这是在最后的最后返回
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}