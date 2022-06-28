package 刷题.leetcode.T199二叉树的右视图;

import java.util.*;

/*
纯学习 官方答案 深度优先搜索
妙啊
这里用的是stack 先入后出（所以先放左）
用queue应该也行
对先左节点还是右节点的放入有要求
从而使每一层的最右先出来 把 rightmostValueAtDepth的位置先抢占了
=============================
不过层序遍历也行 BFS
=========================================================================
上面当我没说  官方的答案报错了  夜深了 我不想找原因了
贴一个大佬的简洁代码 更易理解
 */

//DFS
class Solution {
  List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
             dfs(root, 0); // 从根节点开始访问，根节点深度是0
         return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
        return;
    }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        if (depth == res.size()) {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
             res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
     }
}
/*
作者：sweetiee
链接：https://leetcode.cn/problems/binary-tree-right-side-view/solution/jian-dan-bfsdfs-bi-xu-miao-dong-by-sweetiee/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

/*官方代码
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return null;
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        Deque<TreeNode> nodeStack = new ArrayDeque<TreeNode>();
        Deque<Integer> depthStack = new ArrayDeque<Integer>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 如果不存在对应深度的节点我们才插入
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }
                //注意，是栈
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
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
