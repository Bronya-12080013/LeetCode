//呜呜，之前在书上看过这题了，但还是写不出
//这题好强
//大佬的代码还涉及了分治法
//解读了好久,来看看吧

//大佬代码:
package 刷题.leetcode.剑指Offer07重建二叉树;

import java.util.HashMap;

public class Solution {
    int[] preorder;                                                            //有两个表，preorder和inorder
    HashMap<Integer,Integer> hashMap =new HashMap();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        for(int i=0;i<inorder.length;i++)
        {
            hashMap.put(inorder[i],i);                                         //把inorder放入hashmap 以inorder的值做hashmap的键 方便联系preorder和inorder
        }
        return recur(0,0,inorder.length-1);                    //开始分治法    root是preorder的，而left和right是inorder的,表示子树的左右边界
    }
    TreeNode recur(int root,int left,int right){
        if(left>right) return null;
        TreeNode node =new TreeNode(preorder[root]);
        int i=hashMap.get(preorder[root]);                                   //取得preorder中对应root位置的节点在inorder中的位置i
        node.left=recur(root+1,left,i-1);                         //preorder中对应root+1的位置便是此节点（root对应节点）的左节点    子树的左边界还是left,右边界从中间往右一位
        node.right=recur(root+(i-left)+1,i+1,right);               //i-left是preorder中root后占据的位置数，再加上1个，就是右节点的位置
        return node;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

//这题好好看看！


/*
作者：jyd
        链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-di-gui-fa-qin/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */