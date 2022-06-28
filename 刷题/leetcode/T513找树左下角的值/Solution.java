package 刷题.leetcode.T513找树左下角的值;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// 63.30% && 48.13%
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque();
        deque.add(root);
        int res = root.val;
        while (!deque.isEmpty()) {
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = deque.poll();
                if (i == 0) res = node.val;
                if (node.left != null) deque.add(node.left);  //注意，不是push 那是栈的压入，是从头部进去的
                if (node.right != null) deque.add(node.right);
            }
        }
        return res;
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

 /*
 方法：深度优先搜索

class Solution {
    int curVal = 0;
    int curHeight = 0;

    public int findBottomLeftValue(TreeNode root) {
        int curHeight = 0;
        dfs(root, 0);
        return curVal;
    }

    public void dfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        height++;
        dfs(root.left, height);
        dfs(root.right, height);
        if (height > curHeight) {
            curHeight = height;
            curVal = root.val;
        }
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/find-bottom-left-tree-value/solution/zhao-shu-zuo-xia-jiao-de-zhi-by-leetcode-weeh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


  */