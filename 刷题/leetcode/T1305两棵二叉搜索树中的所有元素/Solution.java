package 刷题.leetcode.T1305两棵二叉搜索树中的所有元素;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*  82.48% && 41.54%
你管这叫中等题?
今天五一，leetcode你太温柔辣
 */
class Solution {
    static ArrayList list;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        list =  new ArrayList();
        lrt(root1);
        lrt(root2);
        Collections.sort(list);
        return list;
    }

    static void lrt(TreeNode root){
        if(root==null) return;  //记得处理
        lrt(root.left);
        lrt(root.right);
        list.add(root.val);
    }
}

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