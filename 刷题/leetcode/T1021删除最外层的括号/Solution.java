package 刷题.leetcode.T1021删除最外层的括号;

//这题比想象中要得考虑得多啊
class Solution {
    public String removeOuterParentheses(String s) {
        int level = 0;
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                level--;
            }
            if (level > 0) {
                res.append(c);
            }
            if (c == '(') {
                level++;
            }
        }
        return res.toString();
    }
}

/*  咕...大意了
因为是简单题 没看题目
class Solution {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }
    static public String removeOuterParentheses(String s) {
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer(s);
        int count = 0;
        int index1 = -1;
        for(int i=0;i<chars.length;i++)
        {
            if(chars[i]=='(') count++;
            else count--;
            if(count==0) {
                index1=i;
                break;
            }
        }
        count=0;
        int index2=-1;
        for(int i=chars.length-1;i>=0;i--)
        {
            if(chars[i]==')') count++;
            else count--;
            if(count==0) {
                index2=i;
                break;
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(index2);
        sb.deleteCharAt(index1);
        sb.deleteCharAt(0);

        return sb.toString();
    }
}
 */