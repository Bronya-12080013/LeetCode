/*
hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh简单一遍过
96.96%　&& 93.48%
 */

package 刷题.leetcode.T1609奇偶树;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int Parity = 0;
        int time = 0;
        while (!deque.isEmpty())
        {
            int lastVal;
            if(time%2==0){ //偶标
                Parity=1;  //奇数
                lastVal = Integer.MIN_VALUE;  //递增
            }
            else {          //奇标
                Parity=0;   //偶数
                lastVal =  Integer.MAX_VALUE;   //递减
            }
            int size = deque.size();
            while (size-->0) // for(int i =0;i<size;i++)
            {
                TreeNode node = deque.poll();
                if(node.val%2!=Parity) return false;
                if(Parity==1){  // 偶标 奇数 递增
                    if(node.val<=lastVal) return false;
                }else if(Parity==0){ //奇标 偶数 递减
                    if(node.val>=lastVal) return false;
                }
                if(node.left!=null) deque.add(node.left);
                if (node.right!=null) deque.add(node.right);
                lastVal= node.val;
            }
            time++;
        }
        return true;
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