package 刷题.leetcode.T937重新排列日志文件;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
/*
87.77% && 48.59% or 97.19%
 */
class Solution {

    public String[] reorderLogFiles(String[] logs) {
        HashMap<String,String[]> hashMap = new HashMap<>();
        for(int i=0;i<logs.length;i++)
        {
            String o = logs[i];
            String[] s=new String[4];
            s[0]= o.substring(0,o.indexOf(' ')+1); //标识符
            s[1]= o.substring(o.indexOf(' ')+1);    //内容
            if(Character.isDigit(s[1].charAt(0))) s[2]="1"; //判断是否为数字 数字为1
                    else s[2]="0";
            s[3]=String.valueOf(i);                         //存下标
            hashMap.put(logs[i],s);
        }
        Arrays.sort(logs, (o1, o2) -> {

            String[] strings1= hashMap.get(o1);
            String[] strings2= hashMap.get(o2);
           String s1h = strings1[0];
           String s2h = strings2[0];
           String s1t = strings1[1];
           String s2t = strings2[1];
           boolean f1 = "1".equals(strings1[2]);
           boolean f2 = "1".equals(strings2[2]);
           int index1=Integer.valueOf(strings1[3]);
            int index2=Integer.valueOf(strings2[3]);

           if(f1&&!f2) return 1;
            if(!f1&&f2) return -1;
            /*
            这个 if(f1&&f2) return index1-index2; 犹为重要
            现在写的是判断的规则
            o1和o2是判断的两个数
            并没有先后之分
            这里写的是规则，参与排序的是整个数组，不止两个数
            按照题意，数字日志的顺序是保持不变的
            index1-index2产生数字，除了正负之分，其大小也有比重的影响!
            以此来对数组进行排序

            故不能直接return 1;
             */
            if(f1&&f2) return index1-index2;
            if(s1t.equals(s2t)) return s1h.compareTo(s2h);
            else return s1t.compareTo(s2t);
        });
        return logs;
    }
}

/*
官方方法：
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int length = logs.length;
        Pair[] arr = new Pair[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Pair(logs[i], i);
        }
        Arrays.sort(arr, (a, b) -> logCompare(a, b));
        String[] reordered = new String[length];
        for (int i = 0; i < length; i++) {
            reordered[i] = arr[i].log;
        }
        return reordered;
    }

    public int logCompare(Pair pair1, Pair pair2) {
        String log1 = pair1.log, log2 = pair2.log;
        int index1 = pair1.index, index2 = pair2.index;
        String[] split1 = log1.split(" ", 2);
        String[] split2 = log2.split(" ", 2);
        boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
        boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
        if (isDigit1 && isDigit2) {
            return index1 - index2;
        }
        if (!isDigit1 && !isDigit2) {
            int sc = split1[1].compareTo(split2[1]);
            if (sc != 0) {
                return sc;
            }
            return split1[0].compareTo(split2[0]);
        }
        return isDigit1 ? 1 : -1;
    }
}

class Pair {
    String log;
    int index;

    public Pair(String log, int index) {
        this.log = log;
        this.index = index;
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/reorder-data-in-log-files/solution/zhong-xin-pai-lie-ri-zhi-wen-jian-by-lee-egtm/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */