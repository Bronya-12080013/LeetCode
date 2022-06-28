/*
本题是要修改root 是修改给定root地址的值
即使把root指向不同地方 也是判定那个地址的
================================================
过了 我用队列 竟然过了一会才想到
=================================================
大佬代码!!! 这就是我想要的代码 压力马斯捏
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        flatten(right);
        root.right = right;
    }
}
=====================================================
官方代码 寻找前驱节点
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/er-cha-shu-zhan-kai-wei-lian-biao-by-leetcode-solu/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
package 刷题.leetcode.T114二叉树展开为链表;

import java.util.ArrayDeque;
import java.util.Deque;

//34.82% && 5.02%
class Solution {
    Deque<Integer> deque = new ArrayDeque<>();
    public void flatten(TreeNode root) {
        if(root==null) return;
        toDo(root);
        deque.poll();
        root.left=null;
        TreeNode p = root;
        while (!deque.isEmpty())
        {
            p.right=new TreeNode(deque.poll());
            p=p.right;
        }
    }
    void toDo(TreeNode root)
    {
        if(root==null) return;
        deque.offer(root.val);
        toDo(root.left);
        toDo(root.right);
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