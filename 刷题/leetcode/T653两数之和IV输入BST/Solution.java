package 刷题.leetcode.T653两数之和IV输入BST;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;



//  21.76% && 11.75%    2022/3/21
class Solution {
    Set<Integer> set;
    boolean flag;
    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        BFS(root,k);
        return flag;
    }
    void BFS(TreeNode root,int k)
    {
        if(root==null) return;
        if(set.contains(root.val)) flag=true;
        else set.add(k-root.val);
        BFS(root.left,k);
        BFS(root.right,k);
    }
}
/*
class Solution {
    Set<Integer> set = new HashSet<Integer>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/solution/liang-shu-zhi-he-iv-shu-ru-bst-by-leetco-b4nl/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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