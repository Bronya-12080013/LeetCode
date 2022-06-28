/*
没法子了
这是昨天做的了
这办法应该是哪里冲突了
看别人的代码
===========================================================================
我傻了，用两个循环互套就行了嘛
我模仿写一下
 */


/*

package 刷题.leetcode.剑指Offer32从上到下打印二叉树其2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class RangeFreqQuery {

    public static void main(String[] args) {
        TreeNode root =new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        List<List<Integer>> L =levelOrder(root);
    }

    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> List =new ArrayList<>();
        List<Integer> list =new ArrayList<>();
        Deque<TreeNode> deque =new LinkedList<>();
        deque.add(root);
        int sum=1;
        int n=0;
        int v=0;
        while (!deque.isEmpty())
        {
            TreeNode node =deque.poll();
            v++;
            list.add(node.val);
            if(v==sum)
            {
                n++;
                sum+= (int) Math.pow(2,n);
                List.add(new ArrayList<Integer>(list));
                list.clear();
            }
            if(node.left!=null)
            {
                deque.add(node.left);
            }else sum--;
            if (node.right!=null)
            {
                deque.add(node.right);
            }else sum--;
        }
        return List;
    }
}



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


 */


//模仿大佬版： 过了
package 刷题.leetcode.剑指Offer32从上到下打印二叉树其2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> List =new ArrayList<>();
        Deque<TreeNode> deque =new LinkedList<>();
        if(root!=null) deque.add(root);
        while (!deque.isEmpty())
        {
            List<Integer> list =new ArrayList<>();
            for(int i=deque.size();i>0;i--)
            {
                TreeNode node =deque.poll();
                if(node.left!=null) deque.add(node.left);
                if(node.right!=null) deque.add(node.right);
                list.add(node.val);
            }
            List.add(list);
        }
        return List;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}