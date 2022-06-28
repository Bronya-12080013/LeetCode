/*
初版，越写越复杂了
本来是用void的dfs 前序遍历
后来又改成 后续遍历
不行 remake了
==============================
remake成了！！！ 19.48% && 69.37%
可恶 区区简单题
思路不难
主要是
1.判断要结合的这两个树在这个节点是重合（都存在），还是一方存在
2.同上，主要是在找叶节点时，叶节点的left和right是null 但null的left和right是不存在的！！！
如果两棵树在某叶节点高度相差2个，就麻烦了
不能直接继续

我在初版为本节点为null，又创造了一个node当替身，传它的left和right
在remake想到可以直接传null

初版是太乱了 root和head脱节了 因为head是在dfs里才赋值的=new Treenode(~),root一直无法因head而赋上值
所以我才想着改成后续遍历的
 初版思路也差不多
========================================================
让我看看别人是怎么解决的
===========================================================
***（C语言）**
官方的答案太强了
class TopVotedCandidate {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;          //返回对方
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }
}

对啊，我干嘛要新创节点呢 能直接用不就直接用了吗
1.直接返回能用的节点  return t2;return t1;
2.用 if (t1 == null)  if (t2 == null) 来判断 即可 即使有(t1==null*t2!=null) (t1!=null&&t2==null) (t1!=null&&t2!=null) 都会达到预期情况
 */
/* 初版
package 刷题.leetcode.合并二叉树617;

public class TopVotedCandidate {
    public static void main(String[] args) {
        TreeNode root1=new TreeNode(1);
        root1.left=new TreeNode(3);
        root1.left.left=new TreeNode(5);
        root1.right=new TreeNode(2);

        TreeNode root2=new TreeNode(2);
        root2.left=new TreeNode(1);
        root2.right=new TreeNode(3);
        root2.left.right=new TreeNode(4);
        root2.right.right=new TreeNode(7);

        mergeTrees(root1,root2);
    }
    static TreeNode root;
    static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //root = new TreeNode(root1.val+root2.val);
        TreeNode head = root;
        dfs(head,root1,root2);
        return head;
    }
    static void dfs(TreeNode head,TreeNode root1,TreeNode root2)
    {
        head.left=new TreeNode(0);
        if(root1!=null&&root2==null)
        {
            TreeNode node =new TreeNode();
            node.left=null;
            node.right=null;
            dfs(head.left,root1.left,node.left);
        }else if(root1==null&&root2!=null){
            TreeNode node =new TreeNode();
            node.left=null;
            node.right=null;
            dfs(head.left,node.left,root2.left);
        }else dfs(head.left,root1.left,root2.left);


        head.right=new TreeNode();
        if(root1!=null&&root2!=null)
        {
            head=new TreeNode(root1.val+root2.val);
        }else if(root1!=null&&root2==null)
        {
            head=new TreeNode(root1.val);
        }else if(root1==null&&root2!=null)
        {
            head=new TreeNode(root2.val);
        }else return;


        if(root1!=null&&root2==null)
        {
            TreeNode node =new TreeNode();
            node.left=null;
            node.right=null;
            dfs(head.right,root1.right,node.right);
        }else if(root1==null&&root2!=null){
            TreeNode node =new TreeNode();
            node.left=null;
            node.right=null;
            dfs(head.right,node.right,root2.right);
        }else dfs(head.right,root1.right,root2.right);

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
 */

//remake版
package 刷题.leetcode.T617合并二叉树;
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null) return null;
        TreeNode root;
        if(root1!=null&&root2!=null){
             root = new TreeNode(root1.val+ root2.val);
        }else if(root1==null){
             root=new TreeNode(root2.val);
        }else {
             root=new TreeNode(root1.val);
        }



        if(root1==null)
        {
            root.left=mergeTrees(null,root2.left);
            root.right=mergeTrees(null,root2.right);
        }else if(root2==null)
        {
            root.left=mergeTrees(root1.left,null);
            root.right=mergeTrees(root1.right,null);
        }else {
            root.left=mergeTrees(root1.left,root2.left);
            root.right=mergeTrees(root1.right,root2.right);
        }


        return root;
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