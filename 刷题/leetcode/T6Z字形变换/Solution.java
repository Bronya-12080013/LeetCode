package 刷题.leetcode.T6Z字形变换;

//25.46% && 17.18%
/*
暴力模拟
主要是确定col有点麻烦
 */
class Solution {
    public String convert(String s, int numRows) {
        int col = 0;
        int num = s.length();
        if(numRows==1) return s;
        col+=num/(numRows+numRows-2)*(numRows-1);
        num%=(numRows+numRows-2);
        if(num<=numRows&&num>0) col++;
        else if(num>numRows) col+=1+num-numRows;
        String[][] strings = new String[numRows][col];
        char[] ss = s.toCharArray();
        int i=0,j=0;
        boolean flag = true;
        for(int k=0;k<ss.length;k++)
        {
            strings[i][j]=String.valueOf(ss[k]);
            if(i==0) flag=true;
            if(i==numRows-1) flag=false;
            if(flag) i++;
            else {
                i--;
                j++;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int k=0;k<numRows;k++){
            for(int l=0;l<col;l++){
                if(strings[k][l]!=null) sb.append(strings[k][l]);
            }
        }
        return sb.toString();
    }
}
/*
官方模拟
class Solution {
    public String convert(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        int t = r * 2 - 2;
        int c = (n + t - 1) / t * (r - 1);
        char[][] mat = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i) {
            mat[x][y] = s.charAt(i);
            if (i % t < r - 1) {
                ++x; // 向下移动
            } else {
                --x;
                ++y; // 向右上移动
            }
        }
        StringBuffer ans = new StringBuffer();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/zigzag-conversion/solution/z-zi-xing-bian-huan-by-leetcode-solution-4n3u/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */