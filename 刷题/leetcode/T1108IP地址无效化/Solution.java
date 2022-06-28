package 刷题.leetcode.T1108IP地址无效化;

//真简单题 100.00% && 96.15%
class Solution {
    public String defangIPaddr(String address) {
        StringBuffer sb = new StringBuffer();
        for (char c:address.toCharArray()){
            if(c=='.') {
                sb.append("[.]");
            }else sb.append(c);
        }
        return sb.toString();
    }
}