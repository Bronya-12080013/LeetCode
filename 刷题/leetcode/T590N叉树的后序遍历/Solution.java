/*
好久没写leetcode了
本题的难点在于Node存的不是子节点，而是中序遍历的List<Node> children;
 */
package 刷题.leetcode.T590N叉树的后序遍历;

import java.util.*;

class Solution {
    public List<Integer> postorder(Node root) {
       List<Integer> res = new ArrayList<>();
        handle(root,res);
       return res;
    }
    void handle(Node node,List<Integer> res)
    {
        if(node==null) return;
        for(Node n:node.children) handle(n,res);
        res.add(node.val);
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
