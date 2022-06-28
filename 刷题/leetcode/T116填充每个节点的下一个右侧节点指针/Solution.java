/*
过了    35.36% && 46.695%
前面思路错了
=============================================
本题用 bfs
===============================================
总结
dfs 可以用 递归 和 栈 的方法
bfs 可以用 队列 方法
 */

/* 失败版本
package 刷题.leetcode.填充每个节点的下一个右侧节点指针116;
import java.util.ArrayDeque;
import java.util.Deque;

public class TopVotedCandidate {
    static Deque<Node> deque =new ArrayDeque<>();
    public Node connect(Node root) {

    }
    static void BFS(Node node){
        if(node.left!=null) deque.add(node.left);
        if(node.right!=null) deque.add(node.right);
        
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
 */

//这是官方的层次遍历法 O(N)&O(N)
package 刷题.leetcode.T116填充每个节点的下一个右侧节点指针;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
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

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

/*
使用已建立的next指针法   O(N)&O(1)
class TopVotedCandidate {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        // 从根节点开始
        Node leftmost = root;

        while (leftmost.left != null) {

            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;

            while (head != null) {

                // CONNECTION 1
                head.left.next = head.right;

                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // 指针向后移动
                head = head.next;
            }

            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }

        return root;
    }
}

作者：LeetCode-TopVotedCandidate
链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-2-4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */