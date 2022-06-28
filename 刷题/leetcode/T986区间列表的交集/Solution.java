/*
不行失败了 这题的时间间隔也太长了 中间隔了几个期末考试吧
===============================================
看答案
===============================================
重点： 1.求交集的方法
      2.灵活应用修改二维数组:
      用ArrayList<int[]> ans = new ArrayList<>();
      写入ans.add(new int[]{});
      转为二维数组 ans.toArray(new int[ans.size()][]);
 */

//模仿官方答案
package 刷题.leetcode.T986区间列表的交集;
import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> ans = new ArrayList<>();
        int i=0,j=0;
        while (i<firstList.length&&j<secondList.length){
            int lo = Math.max(firstList[i][0],secondList[j][0]);
            int hi = Math.min(firstList[i][1],secondList[j][1]);
            if(lo<=hi) ans.add(new int[]{lo,hi});
            if(firstList[i][1]<secondList[j][1]) i++;
            else j++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

/*
package 刷题.leetcode.T986区间列表的交集;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] firstList = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList= new int[][]{{1,5},{8,12},{15,24},{25,26}};
        solution.intervalIntersection(firstList,secondList);
    }
    public ArrayList intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<firstList.length;i++)
        {
            for(int j =firstList[i][0];j<=firstList[i][1];j++){
                list.add(j);
            }
        }
        ArrayList list1 = new ArrayList();
        for(int i=0;i<secondList.length;i++)
        {
            for(int j =secondList[i][0];j<=secondList[i][1];j++){
                if(list.contains(j)) list1.add(j);
            }
        }
        return list1;
    }
}
*/