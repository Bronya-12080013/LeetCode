package 刷题.pta乙题;//成了，这个简单
//注意，若用BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
//  in.read() 方法是读取单个字符    in.readline中的空格不是停止字符，所以不行   多看看文档吧

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class 划拳1046 {
    public static void main(String[] args) throws IOException {
        Scanner scanner =new Scanner(System.in);
       // BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        Integer N =Integer.valueOf(scanner.nextInt());
      //  StringBuilder sb = new StringBuilder();
     //  int N = scanner.nextInt();
        int [] h =new int[2];
        for(int i=0;i<N;i++)
        {
            int [] n =new int[4];
            for(int j=0;j<4;j++)
            {
                n[j]=scanner.nextInt() ;
            }
            int sum=n[0]+n[2];
            if(n[1]==sum&&n[3]!=sum)
            {
                h[1]++;
            }else if (n[1]!=sum&&n[3]==sum)
            {
                h[0]++;
            }


        }
        System.out.println(h[0]+" "+h[1]);
    }
}
