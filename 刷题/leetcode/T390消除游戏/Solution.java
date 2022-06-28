package 刷题.leetcode.T390消除游戏;

class Solution {
    public int lastRemaining(int n) {
        int al = 1;  //起始位置  从左到右 又从右到左的位置
        int k =0,cut = n,step = 1;      //k是纯用来判断正向or反向 //cut是长度 正向或反向一次都会cut/2   //step是下一个的步子 正向或反向一次都会step*2
        while (cut>1){
            if(k%2==0) al=al+step;      // 正向
            else al=(cut%2==0)? al:al+step;     // 反向
            k++;
            cut=cut/2;
            step=step*2;
        }
        return al;
    }
}