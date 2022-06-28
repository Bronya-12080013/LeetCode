/*
好耶，靠着前两题的铺垫过了
初版还是太臃肿了
我再改改
==========================================
我的改进版：我只能改到这了
看大佬代码
==========================================
看了大佬代码
我的问题是：

1.没想到可以从List的size判断奇偶行
2.没想起队列有addFirst和addLast

===========================================
还要注意一个：
类似的栈和队列有关的循环语句这么写：
for(int i=deque.size();i>0;i--)
而不是
for(int i=0;i<deque.size();i--)
因为后者若for内有deque.size()的改变，则判断条件i<deque.size()也变。
如果：
int length=deque.size();
for(int i=0;i<length;i--)
又会浪费空间
 */

/*
初版：

package 刷题.leetcode.剑指Offer32从上到下打印二叉树其3;

import java.util.*;

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
        Deque<TreeNode> deque =new LinkedList<>();
        if(root!=null) deque.add(root);
        boolean flag=true;
        while (!deque.isEmpty())
        {
            List<Integer> list =new ArrayList<>();
            if(flag)
            {
                flag=false;
                for(int i=deque.size();i>0;i--)
                {
                    TreeNode node =deque.poll();
                    if(node.left!=null) deque.add(node.left);
                    if(node.right!=null) deque.add(node.right);
                    list.add(node.val);
                }
            }
            else {
                flag=true;
                Stack<TreeNode> stack =new Stack<>();
                int dlength=deque.size();
                for(int i=0;i<dlength;i++)
                {
                    stack.add(deque.poll());
                }
                int slength=stack.size();
                Stack<TreeNode> stack1 =new Stack<>();
                for(int i=0;i<slength;i++)
                {
                    TreeNode node =stack.pop();
                    if(node.right!=null) stack1.add(node.right);
                    if(node.left!=null) stack1.add(node.left);
                    list.add(node.val);
                }
                if(!stack1.isEmpty())
                {
                    int s1length=stack1.size();
                    for (int i=0;i<s1length;i++)
                    {
                        deque.add(stack1.pop());
                    }
                }
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



 */

//我的改进版：
package 刷题.leetcode.剑指Offer32从上到下打印二叉树其3;

import java.util.*;

class Solution {

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
        Deque<TreeNode> deque =new LinkedList<>();
        if(root!=null) deque.add(root);
        boolean flag=true;
        while (!deque.isEmpty())
        {
            List<Integer> list =new ArrayList<>();

            if(flag)
            {
                flag=false;
                for(int i=deque.size();i>0;i--)
                {
                    TreeNode node =deque.poll();
                    if(node.left!=null) deque.add(node.left);
                    if(node.right!=null) deque.add(node.right);
                    list.add(node.val);
                }
            }
            else {
                flag=true;
                Stack<TreeNode> stack =new Stack<>();
                for(int i=deque.size();i>0;i--)
                {
                    TreeNode node =deque.pop();
                    if(node.left!=null) deque.add(node.left);
                    if(node.right!=null) deque.add(node.right);
                    stack.add(node);
                }
                for(int i=stack.size();i>0;i--)
                {
                    list.add(stack.pop().val);
                }
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


//大佬代码：
/*
class RangeFreqQuery {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
 */
