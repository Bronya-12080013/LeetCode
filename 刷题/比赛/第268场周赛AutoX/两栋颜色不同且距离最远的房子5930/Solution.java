/*
我去上了个厕所，花了10分钟才开始写
题一
很容易，好好看题目
刚开始看错了当然难 条件矛盾又不能把它们的冲突找出来
 */

/*
题目：
街上有 n 栋房子整齐地排成一列，每栋房子都粉刷上了漂亮的颜色。给你一个下标从 0 开始且长度为 n 的整数数组 colors ，其中 colors[i] 表示第  i 栋房子的颜色。
返回 两栋 颜色 不同 房子之间的 最大 距离。
第 i 栋房子和第 j 栋房子之间的距离是 abs(i - j) ，其中 abs(x) 是 x 的绝对值。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-furthest-houses-with-different-colors
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package 刷题.比赛.第268场周赛AutoX.两栋颜色不同且距离最远的房子5930;

public class Solution {
    public int maxDistance(int[] colors) {
        int max=0;
        for(int i=0;i<colors.length;i++)
        {
            for(int j=colors.length-1;j>i;j--){
                if(colors[i]!=colors[j]&&j-i>max)
                {
                    max=j-i;
                }
            }
        }
        return max;
    }
}
