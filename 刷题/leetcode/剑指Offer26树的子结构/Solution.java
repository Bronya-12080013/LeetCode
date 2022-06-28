package 刷题.leetcode.剑指Offer26树的子结构;
//试图模仿大佬版
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!=null&&B!=null)&&(equals(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B));
    }
    static boolean equals(TreeNode root,TreeNode B)
    {
        if(B==null) return true;
        if(root==null||root.val!=B.val) return false;
        return equals(root.left,B.left)&&equals(root.right,B.right);
    }
}
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }




/*

package 刷题.leetcode.剑指Offer26树的子结构;

public class RangeFreqQuery {
    public boolean isSubStructure(TreeNode A, TreeNode B) {

    }
    public TreeNode preorder(TreeNode root,TreeNode B){

        if(root != null){
           //list.add(root.val);
            if(root.val==B.val)
            {

            }
            preorder(root.left,B.val);
            preorder(root.right,B.val);
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