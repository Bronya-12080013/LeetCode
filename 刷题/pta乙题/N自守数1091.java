/*
漂亮，15/15(萌新友好版提交)
因为输入格式的问题（把K放循环里面的话，用用例不知道为什么在最后的No前要回个车才动），我用了K[]数组，输入完再输出，这样就没问题了
这题我把他们从int到String来回转换，就为了用String的length和断句取子串。
知识点：用string.substring(int n) 取子串，从下标n取到原子串的结尾（下表从0开始）
当然也可以string.substring(int a,int b),从a截取到b;

我看了下别人的答案，也差不多，再取得所需子串后，可以用String的equal方法判断是否相同即可，不必再次换回int用==比较

 //萌新友好版：

package 刷题.pta乙题;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class N自守数1091 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M =scanner.nextInt();
        int V;
        int[]K =new int[M];
        for(int i=0;i<M;i++)
        {
            K[i]=scanner.nextInt();
        }
        for(int i=0;i<M;i++)
        {
            boolean flag=false;
           // K=scanner.nextInt();
            for(int j=1;j<10;j++)
            {
                V=j*(K[i]*K[i]);
                int l=Integer.toString(K[i]).length();
                int l1=Integer.toString(V).length();              //取K长度
                String v=String.valueOf(V);
                String v1 = v.substring(l1-l);                    //取子串
                int value =Integer.parseInt(v1);                  //把子串换回数字int
               // System.out.println(K+" "+V+" "+l+" "+l1+" "+v+" "+v1+" "+value);
                if(K[i]==value)
                {
                    System.out.print(j+" "+V);
                    flag=true;
                    break;
                }
            }
            if(flag)
            {

            }else {
                System.out.print("No");
            }
            if(i!=M-1)
            {
                System.out.print("\n");
            }

        }
    }
}


*/


//装逼精简版
//正常人谁那么写，会被打死的吧，还一点技术含量也没有，只是无脑套娃。还得从算法减，让程序再短一点
package 刷题.pta乙题;
import java.util.Scanner;
public class N自守数1091 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M =scanner.nextInt();
        int[]K =new int[M];
        for(int i=0;i<M;i++)
        {
            K[i]=scanner.nextInt();
        }
        for(int i=0;i<M;i++)
        {
            boolean flag=true;
            for(int j=1;j<10;j++)
            {
                if(K[i]==Integer.parseInt(String.valueOf(j*(K[i]*K[i])).substring(Integer.toString(j*(K[i]*K[i])).length()-Integer.toString(K[i]).length())))
                {
                    System.out.print(j+" "+j*(K[i]*K[i]));
                    flag=false;
                    break;
                }
            }
            if(flag)
            {
                System.out.print("No");
            }
            if(i!=M-1)
            {
                System.out.print("\n");
            }


        }

    }

}

