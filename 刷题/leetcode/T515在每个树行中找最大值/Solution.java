package 刷题.leetcode.T515在每个树行中找最大值;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// 88.47% && 67.35%   简单题
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Deque<TreeNode> deque = new ArrayDeque();
        deque.add(root);
        while (!deque.isEmpty())
        {
            int len = deque.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<len;i++)
            {
                TreeNode node = deque.poll();
                if(node.left!=null) deque.add(node.left);  //注意，不是push 那是栈的压入，是从头部进去的
                if(node.right!=null) deque.add(node.right);
                max=Math.max(max,node.val);
            }
            list.add(max);
        }
        return list;
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