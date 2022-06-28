//半参考代码写完了
//好好看代码，一些我在自己写时会难以判断的情况，这都有解决


package 刷题.leetcode.剑指Offer34二叉树中和为某一值的路径;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    LinkedList<List<Integer>> listAll =new LinkedList<>();                //把这两个掌控全局的表放外面，就不用纠结什么时候放进和插入了
    LinkedList<Integer> list =new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        doit(root,target);
        return listAll;                                                 //妙啊，把表放外面，去doit里解决，在这直接返回全局的表，就不用管递归该返回什么了
    }
    void doit(TreeNode root,int target){
        if(root==null) return;                                             //如果在上一层的子叶节点未能达成下面的if、成功add的话，在这里就没了
        list.add(root.val);
        target-=root.val;                                                //不用顾忌，直接减!!!!!!!  这是递归这里减了，返回上一层又是没减过的target
        if(target==0&&root.left==null&&root.right==null)
            listAll.add(new LinkedList<Integer>(list));                  //注意这里不能直接直接放list（那是指针，会变的），要new一个新的
        doit(root.left,target);
        doit(root.right,target);
        list.removeLast();                                              //这里最妙了，在前面左和右返回后，删掉list的最后一个
                /*
                注意！！！！！
                这里如果前面写的是 List<Integer> list =new LinkedList<>();
                list就没有removeLast()
                而写成 LinkedList<Integer> list =new LinkedList<>(); 才有
                 */

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