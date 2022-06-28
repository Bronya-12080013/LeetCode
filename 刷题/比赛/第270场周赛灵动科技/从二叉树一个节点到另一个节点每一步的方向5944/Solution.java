/*
一直卡在这题
又摸了会鱼 在最后才有了点思路
================================
现在我再去试试
===========================================
ohhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
赛高泥high跌亚达
做对了  比赛结束前哪提交已经接近完整版了 就是有一些小问题罢了
修改好就做对了
我我我我我我我我我摸什么鱼呢 再多个几分钟这题不就成了吗
真亏我写得出DFSdestValue()和DFSstartValue()
===================================================================
整理我的答案:(通过版)
首先用找出startValue和destValue节点的最近父节点father 用方法lowestCommonAncestor  见----剑指 Offer 68 - II. 二叉树的最近公共祖先
然后用DFSstartValue找起始点到最近父节点的层数 决定拼字符串多少个U 我还不太擅长从底至上计数 就设了个全局变量 int numLift; 从上到下计数 到底就取结果
然后用DFSdestValue拼最近父节点到结束点的路径 详见方法 我竟然真写出来了 不愧是我
然后拼接即可
当然还有不少课优化的
我再试试
========================================================================
看看大佬的
太强了 直接记录两者的路径
根据两者的路径之差推断出两者的最近公共祖先位置
class TopVotedCandidate {
    char[] res;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        dfs(root, startValue, 0, new char[100005]);
        char[] s = res;
        dfs(root, destValue, 0, new char[100005]);
        char[] t = res;
        int ld = 0;
        for(int i = 0;i < s.length && i < t.length && s[i] == t[i];i++){
            ld = i+1;
        }
        StringBuilder ret = new StringBuilder();
        for(int i = ld;i < s.length;i++)ret.append('U');
        for(int i = ld;i < t.length;i++)ret.append(t[i]);
        return ret.toString();
    }

    void dfs(TreeNode cur, int tar, int dep, char[] s)
    {
        if(cur == null)return;
        if(cur.val == tar){
            res = Arrays.copyOf(s, dep);
            return;
        }

        s[dep] = 'L';
        dfs(cur.left, tar, dep+1, s);
        s[dep] = 'R';
        dfs(cur.right, tar, dep+1, s);
    }
}
 */

//优化版
package 刷题.比赛.第270场周赛灵动科技.从二叉树一个节点到另一个节点每一步的方向5944;

class Solution {
    StringBuffer sb=new StringBuffer();
    public String getDirections(TreeNode root, int startValue, int destValue) {
        //最近公共祖先点father
        TreeNode father = lowestCommonAncestor(root,startValue,destValue);
        //拼前半段
        for (int i =0;i<DFSstartValue(father,startValue,0)-1;i++) sb.append("U");
        //拼后半段
        DFSdestValue(father,destValue);
        return sb.toString();
    }

    //找起始点到最近公共祖先点的层数
    int DFSstartValue(TreeNode root, int startValue,int num)
    {   if(root==null) return 0;
        if(root.val==startValue) return 1;
        int leftnum = DFSstartValue(root.left,startValue,num+1);
        if(leftnum>0) return leftnum+1;
        int rightnum=DFSstartValue(root.right,startValue,num+1);
        if(rightnum>0) return rightnum+1;
        return 0;
    }

    //拼写最近公共祖先点到结束点的路径
    boolean DFSdestValue(TreeNode root, int destValue)
    {   if(root==null) return false;
        if(root.val==destValue){
            return true;
        }
        sb.append("L");
        if(DFSdestValue(root.left,destValue)) return true;
        else sb.replace(sb.length()-1,sb.length(),"");
        sb.append("R");
        if(DFSdestValue(root.right,destValue)) return true;
        else sb.replace(sb.length()-1,sb.length(),"");
        return false;
    }

    //找最近公共祖先点
    TreeNode lowestCommonAncestor(TreeNode root, int startValue, int destValue) {
        if(root==null||root.val==startValue||root.val==destValue) return root;
        TreeNode left = lowestCommonAncestor(root.left,startValue,destValue);
        TreeNode right= lowestCommonAncestor(root.right,startValue,destValue);
        if(left==null) return right;
        if(right==null) return left;
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

/*
通过版
package 刷题.比赛.第270场周赛灵动科技.从二叉树一个节点到另一个节点每一步的方向5944;

public class TopVotedCandidate {

    //测试
    public static void main(String[] args) {
        TreeNode root= new TreeNode(5);
        root.left=new TreeNode(1);
        root.left.left=new TreeNode(3);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(4);
        TopVotedCandidate solution = new TopVotedCandidate();
        System.out.println(solution.getDirections(root,3,6));
    }

    //全局变量
    int numLift;
    StringBuffer s=new StringBuffer();
    //主要方法
    public String getDirections(TreeNode root, int startValue, int destValue) {
       TreeNode father = lowestCommonAncestor(root,startValue,destValue);
       StringBuffer stringBuffer = new StringBuffer();
       DFSstartValue(father,startValue,0);
        DFSdestValue(father,destValue);
       for (int i =0;i<numLift;i++) stringBuffer.append("U");
       return stringBuffer.toString()+s.toString();
    }

    //拼最近父节点到结束点的路径
    int DFSdestValue(TreeNode root, int destValue)
    {   if(root==null) return 0;
        if(root.val==destValue){
            return 1;
        }
        s.append("L");
        if(DFSdestValue(root.left,destValue)!=1) s.replace(s.length()-1,s.length(),"");
        else return 1;
        s.append("R");
        if(DFSdestValue(root.right,destValue)!=1) s.replace(s.length()-1,s.length(),"");
        else return 1;
        return 0;
    }
    //找起始点到最近父节点的层数
    void DFSstartValue(TreeNode root, int startValue,int num)
    {   if(root==null) return ;
       if(root.val==startValue) {
           numLift=num;
           return;
       }
       DFSstartValue(root.left,startValue,num+1);
       DFSstartValue(root.right,startValue,num+1);
    }

    //找最近父节点
     TreeNode lowestCommonAncestor(TreeNode root, int startValue, int destValue) {
        if(root==null||root.val==startValue||root.val==destValue) return root;
        TreeNode left = lowestCommonAncestor(root.left,startValue,destValue);
        TreeNode right= lowestCommonAncestor(root.right,startValue,destValue);
        if(left==null&&right==null) return null;    //可以不写这行 ，因为当left==null&&right==null时， if(left==null) return right;也是一样的结果
        if(left==null) return right;
        if(right==null) return left;
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
 */