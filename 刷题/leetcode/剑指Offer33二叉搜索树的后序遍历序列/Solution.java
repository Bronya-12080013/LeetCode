/*
这题也好难写
看懂了大佬代码后自己写
 */



/*   单纯的想法，怎么可能过
package 刷题.leetcode.剑指Offer33二叉搜索树的后序遍历序列;

public class RangeFreqQuery {
    public boolean verifyPostorder(int[] postorder) {
        int min=postorder[0];
            for(int i=1;i<postorder.length;i=i+2)
        {
            if(postorder[i]<=min||postorder[i+1]<=min||postorder[i]<=postorder[i+1]){
                return false;
            }
            min=postorder[i];
        }
            return true;
    }
}
*/


//模仿大佬的代码
/*
太妙了
先while (postorder[p]<postorder[j]) p++;  int m=p;
所得的m是当前根节点（j）的右边的最小值（刚刚大于j的那个，即“右节点的左节点”）
又while (postorder[p]>postorder[j]) p++;  这样当p==j（postorder[p]=postorder[j]，回到了根节点），才正确
之后的j-1是根j的右节点  m-1是根j的左节点（的位置，我就直接说节点了）   毕竟是后续遍历嘛
 */
package 刷题.leetcode.剑指Offer33二叉搜索树的后序遍历序列;

public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }
    boolean recur(int[] postorder,int i,int j){
        if(i>=j) return true;
        int p=i;
        while (postorder[p]<postorder[j]) p++;
        int m=p;
        while (postorder[p]>postorder[j]) p++;
        return p==j&&recur(postorder,m,j-1)&&recur(postorder,i,m-1);


    }
}