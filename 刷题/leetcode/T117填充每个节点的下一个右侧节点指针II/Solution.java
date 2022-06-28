/*
这一题和116的解法都一样 方法都一样适用
 */

package 刷题.leetcode.T117填充每个节点的下一个右侧节点指针II;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Deque<Node> deque =new ArrayDeque();
        //Queue<Node> deque = new LinkedList<Node>();
        deque.add(root);
        while (!deque.isEmpty())
        {
            int size = deque.size();
            for(int i=0;i<size;i++)
            {
                Node node = deque.poll();
                if(i<size-1)
                {
                    node.next=deque.peek();
                }
                if(node.left!=null)
                {
                    deque.add(node.left);
                }
                if(node.right!=null)                      //我把node写成root了
                {
                    deque.add(node.right);               //又把node写成root了
                }
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
