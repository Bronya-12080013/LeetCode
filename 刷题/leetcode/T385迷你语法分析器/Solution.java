package 刷题.leetcode.T385迷你语法分析器;

/**
//用dfs    //还是参考了答案
class Solution{
    int index = 0;
    public NestedInteger deserialize(String s) {
        if(s.charAt(index)=='[')
        {
            index++;
            NestedInteger ni = new NestedInteger();
            while (s.charAt(index)!=']')
            {
                ni.add(deserialize(s));
                if(s.charAt(index)==',') index++;
            }
            index++;  //这个很重要，虽然对最后一个(第一组[])没必要，但在递归中有用
            return ni;
        }else {
            boolean isNegative =false;
            if(s.charAt(index)=='-') {
                isNegative=true;
                index++;
            }
            int num = 0;
            while (index<s.length()&&Character.isDigit(s.charAt(index)))
            {
                //num=num*10+Integer.valueOf(s.charAt(index));
                num=num*10+s.charAt(index)-'0';
                index++;
            }
            if(isNegative) num=-1*num;
            return new NestedInteger(num); //即使只有一个数字，也装入NestedInteger
        }
    }
}
 **/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
