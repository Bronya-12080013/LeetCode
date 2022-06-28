/*
ohhhhhhhhhhhhhhhhhh 20/20 过了
原本我想用HashSet存（add可以自动辨别重复），再取出来，但发现它是无序的，取出来的顺序是乱的
........................................................................
HashSet取值用迭代器，是无序的（与存入顺序不同）
取值法：
 Iterator it =set.iterator();
                while (it.hasNext())
                {
                    System.out.print(it.next());
                }
.........................................................................
然后我想再设一个HashMap，先一个for让HashSet存完值后，再一个for边判断（HashSet有则存入）边存入HashMap，key设num++
然后发现真麻烦，只要反过来，HashSet无则输出，然后存入HashSet就行了

总结：HashSet好用与判断！！！重复问题可以把用过的数丢进去。
..........................................................................
看了三个人的答案，一个与我用Set，另两个设boolean数组[127] 即每种字符都搞个 是否值。
思想差不多
 */

package 刷题.pta乙题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;

public class 字符串拼接1093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A= br.readLine();
        String B =br.readLine();
        String C =A.concat(B);
        HashSet set =new HashSet();
        int num=0;
        for(int i=0;i<C.length();i++)
        {
            if(!set.contains(C.charAt(i)))
            {
                System.out.print(C.charAt(i));
                Iterator it =set.iterator();
                while (it.hasNext())
                {
                    System.out.print(it.next());
                }
            }
            set.add(C.charAt(i));
        }


    }
}
