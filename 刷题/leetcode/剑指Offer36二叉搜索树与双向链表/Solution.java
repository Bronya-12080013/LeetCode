/*
ohhhhhhhhhhhhhhhhhhh
中等题，过了！！！！！！！！！！！！！！！
100% && 5%~60+%
中序遍历

好像空间效率不如大佬好，看看代码
//过了一夜，我也想到了用两个指针，直接在树里改，不用新建那么多节点了
算了，懒得写了，看代码
================================================
//妙啊，这双指针写法
class RangeFreqQuery {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}

作者：jyd
链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/


 */


package 刷题.leetcode.剑指Offer36二叉搜索树与双向链表;

public class Solution {

    //测试
    public static void main(String[] args) {
        Node root1 =new Node(4);
        Node left =new Node(2);
        Node right =new Node(5);
        left.left=new Node(1);
        left.right=new Node(3);
        root1.left=left;
        root1.right=right;
       Solution solution=new Solution();
       solution.treeToDoublyList(root1);
    }


    Node head =new Node(0);
    Node temp =head;
    public Node treeToDoublyList(Node root) {
       dfs(root);
       temp.right=head.right;
       head.right.left=temp;
       return head.right;
       /*
       或：
       Node node = head.right;
       node.left=temp;
       return node;
        */
    }
    void dfs(Node root){
        if(root==null) return;
        dfs(root.left);
        Node t=new Node(root.val);
        temp.right=t;
        t.left=temp;
        temp=t;
        dfs(root.right);
        return;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

