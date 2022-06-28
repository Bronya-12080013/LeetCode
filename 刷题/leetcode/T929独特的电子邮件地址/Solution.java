package 刷题.leetcode.T929独特的电子邮件地址;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        String[] strings = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(strings));
    }
    static public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<emails.length;i++)
        {
            StringBuffer sb = new StringBuffer();
            char[] chars = emails[i].toCharArray();
            boolean flag = true;
            for(int j=0;j<chars.length;j++)
            {
                while(chars[j]=='.'&&flag) j++;
                if(chars[j]=='+'&&flag)
                {
                    while (chars[j]!='@') j++;
                }
                if(chars[j]=='@') flag=false;
                sb.append(chars[j]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}