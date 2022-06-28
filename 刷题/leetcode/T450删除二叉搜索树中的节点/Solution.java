package 刷题.leetcode.T450删除二叉搜索树中的节点;


//版本二 官方答案
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root, curParent = null;
        while (cur != null && cur.val != key) {
            curParent = cur;
            if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (cur == null) {
            return root;
        }
        if (cur.left == null && cur.right == null) {
            cur = null;
        } else if (cur.right == null) {
            cur = cur.left;
        } else if (cur.left == null) {
            cur = cur.right;
        } else {
            TreeNode successor = cur.right, successorParent = cur;
            while (successor.left != null) {  //找右最大的方法
                successorParent = successor;
                successor = successor.left;
            }
            if (successorParent.val == cur.val) {
                successorParent.right = successor.right;
            } else {
                successorParent.left = successor.right;
            }
            //删除节点的方法 就是让新节点ntr原节点就行了
            successor.right = cur.right;
            successor.left = cur.left;
            cur = successor;
        }
        if (curParent == null) {
            return cur;
        } else {
            if (curParent.left != null && curParent.left.val == key) {
                curParent.left = cur;
            } else {
                curParent.right = cur;
            }
            return root;
        }
    }
}



/*  版本一 不知道怎么删除&方法部分错误
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(key==root.val)
        {
            if(root.left==null&&root.right==null) return null;
            if(root.right==null&&root.left!=null)
            {
                return null;
            }
            //if(root.left==null&&root.right!=null)
            else {
               TreeNode min = findR(root.right);
               root.val=min.val;
               root.right=null; //这里出错了 不能简单粗暴地切割
               deleteNode(min,min.val);
         //  }else{
         //     TreeNode max = findL(root.left);
         //     root.val=max.val;
         //     root.left=null;
         //     deleteNode(max, max.val);
          }
            return root;
        }

        if(key<root.val)
        {
            deleteNode(root.left,key);
        }
        if(key>root.val)
        {
            deleteNode(root.right,key);
        }
        return root;
    }

    static TreeNode findR(TreeNode root){
        if(root.left!=null) return findR(root.left);
        return root;
    }
    static TreeNode findL(TreeNode root){
        if(root.right!=null) return findL(root.right);
        return root;
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