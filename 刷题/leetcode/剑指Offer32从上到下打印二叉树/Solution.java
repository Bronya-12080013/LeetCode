/*
这题时间紧张，主要是参考了大佬的代码

巧妙的运用了队列
Deque<TreeNode> deque =new LinkedList<>(); 是链表，还实现了Deque队列的接口
而List<Integer> array=new ArrayList<>(); 是动态数组


题目要求的二叉树的 从上至下 打印（即按层打印），又称为二叉树的 广度优先搜索（BFS）。
BFS 通常借助 队列 的先入先出特性来实现。
 */

package 刷题.leetcode.剑指Offer32从上到下打印二叉树;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        Deque<TreeNode> deque =new LinkedList<>();
        deque.add(root);
        List<Integer> array=new ArrayList<>();
        while(!deque.isEmpty())
        {
            TreeNode node = deque.poll();
            array.add(node.val);
            if(node.left!=null) deque.add(node.left);
            if(node.right!=null) deque.add(node.right);
        }
        int[] r=new int[array.size()];
        for(int i=0;i<r.length;i++)
        {
            r[i]=array.get(i);
        }
        return r;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/*
class RangeFreqQuery {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>(){{ add(root); }};
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
}

作者：jyd
链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/solution/mian-shi-ti-32-i-cong-shang-dao-xia-da-yin-er-ch-4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
