package 刷题.leetcode.T449序列化和反序列化二叉搜索树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//模仿答案代码
public class Codec {
    //测试
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left=new TreeNode(1);
        treeNode.right=new TreeNode(3);
        Codec codec = new Codec();
        String test  = codec.serialize(treeNode);
        System.out.println(test);
        codec.deserialize(test);
    }
    public String serialize(TreeNode root) {
        //数字又不是只有个位 用什么 StringBuffer
        //StringBuffer sb = new StringBuffer();
        ArrayList<Integer> list = new ArrayList<>();
        postOrder(root,list);
        /**ArrayList也有这个方法哦
           但是注意它的返回形式
           如 list=[1,3,2]
            那么list.toStirng 得 "[1,3,2]"
         括号和,都会加进去的
         */
        String res = list.toString();
        return res.substring(1,res.length()-1); //逗号不管，等解码时再去调，因为需要逗号来把数字分开
    }

    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        Deque<Integer> stack = new ArrayDeque<>();  //这是用栈的功能
        //for(char c:data.toCharArray()) stack.push(Integer.valueOf((c)));   不要用Integer.valueOf转char 会变ascll码的
        for(String s:data.split(", ")) stack.push(Integer.valueOf(s));
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE,stack);
    }

    //后序遍历
    private void postOrder(TreeNode root, ArrayList list) {
        if(root==null) return;
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.val);
    }

    private TreeNode construct(int lower, int upper, Deque<Integer> stack) {
        if(stack.isEmpty()||stack.peek()<lower||stack.peek()>upper) return null;
        TreeNode root = new TreeNode(stack.pop());
        root.right=construct(root.val,upper,stack);
        root.left=construct(lower, root.val, stack);
        return root;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }