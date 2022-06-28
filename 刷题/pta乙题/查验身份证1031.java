package 刷题.pta乙题;/*
我的解
失败了
      总结，好好看题，首先要判断格式，可以用正则，而不是存入数组，数组只能存同类型数据，不能放那个x，
      一开始就错了，可以把这18个数当成一个字符串,这样也可以用string中的charAt(int index)方法直接取某个值


import java.util.Scanner;

public class 刷题.pta乙题.查验身份证1031 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
       // System.out.println(S(N,2));
        long[] Num = new long[N];
        for(int i=0;i<N;i++)
        {
            Num[i]= scanner.nextLong();
        }

        for(int i=0;i<N;i++)
        { int sum=0;
           // System.out.println(Num[i]);
           for(int j=0;j<17;j++)
           {
              // System.out.print(S(Num[i], 17-j));

               sum+=SS(S(Num[i], 17-j),j+1);

           }

        //   if()
           {
             // for(int k;k<18;k++)
             // {
             //     System.out.print(Num[k]);
             // }

           }

        }
    }
    public static int S(Long Num, int j) {
        if (j == 1) {
            int a = (int) (Num % 100) / 10;
            return a;
        } else if (j == 0) {
            int a = (int) (Num % 10);
            return a;
        } else {
            int a = (int) (Num % Math.pow(10, j + 1) / Math.pow(10, j));
            return a;
        }

    }
    public static int SS(int Num,int j)
    {
        int n=0;
        switch (j){
            case 1 :n=Num*7; break;
            case 2 :n=Num*9;   break;
            case 3 :n=Num*10;break;
            case 4 :n=Num*5;break;
            case 5 :n=Num*8;break;
            case 6 :n=Num*4;break;
            case 7 :n=Num*2;break;
            case 8 :n=Num*1;break;
            case 9 :n=Num*6;break;
            case 10 :n= Num*3;break;
            case 11 :n= Num*7;break;
            case 12 :n= Num*9;break;
            case 13 :n= Num*10;break;
            case 14 :n= Num*5;break;
            case 15 :n= Num*8;break;
            case 16 :n= Num*4;break;
            case 17 :n= Num*2;break;
        }
      return n;
    }

    public static Object SSS(int num)
    {   Object n=null;
        switch (num)
        {
            case 0 : n= 1 ;
            case 1 : n=0 ;
            case 2 : n="x";
            case 3 : n=9 ;
            case 4 : n=8 ;
            case 5 : n=7 ;
            case 6 : n=6 ;
            case 7 : n=5 ;
            case 8 : n=4 ;
            case 9 : n=3 ;
            case 10 :n= 2 ;
        }
        return  n;
    }
    }
 */

//正解
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 1031 查验身份证 (15分)
 *
 * @思路：先检验前17位是否是数字（用正则），再根据权重算正确值。判断输入的身份证最后一位是否是正确值。
 * @author: ChangSheng
 * @date:   2019年12月29日 下午10:04:45
 */
public class 查验身份证1031 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] weights = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] M = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        StringBuilder sb = new StringBuilder();
        Integer N = Integer.valueOf(in.readLine());
        for (int i = 0; i < N; i++) {
            String sfz = in.readLine();
            String sfzFront17 = sfz.substring(0, 17);
            if (sfzFront17.matches("\\d+")) { // 校验前17位是否都是数字
                // 算权重对应值
                int sum = 0;
                for (int j = 0; j < sfzFront17.length(); j++) {
                    int sfzNum = sfzFront17.charAt(j) - 48;
                    sum = sum + sfzNum * weights[j];
                }
                char rightLast = M[sum % 11]; // 最后一位正确值
                if (sfz.charAt(17) != rightLast) sb.append(sfz + "\n"); // 输入的身份证最后一位是否是正确值
            } else {
                sb.append(sfz + "\n");
            }
        }
        if (sb.length() == 0) System.out.print("All passed");
        else System.out.print(sb);
    }
}



