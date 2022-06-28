package 刷题.pta乙题;

import java.util.Scanner;

public class 判断题1061 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        Integer N = Integer.valueOf(in.nextInt());
        Integer M = Integer.valueOf(in.nextInt());
        int [] value = new int[M];
        int [] trueanswer =new int[M];
        for(int i=0;i<M;i++)
        {
            value[i] = in.nextInt();
        }
        for(int i=0;i<M;i++)
        {
            trueanswer[i] = in.nextInt();
        }
        for(int i=0;i<N;i++)
        {
            int[] answer =new int[M];
            for(int j=0;j<M;j++)
            {
                answer[j]=in.nextInt();
            }
            doit(answer,value,trueanswer,M);
        }
    }


    public static void doit(int[] answer,int[] value,int [] trueanswer,Integer M){
        int sum=0;
        for(int i=0;i<M;i++)
        {
            if(answer[i]==trueanswer[i])
            {
                sum+=value[i];
            }
        }
        System.out.println(sum);
    }
}
