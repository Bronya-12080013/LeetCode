/*
第一次部分正确 13/20
修复测试点8：A2的判定有无问题，就是os2是否要用N的问题。注意，五个数中，A1、A3、A4、A5只要为零，那就是为空（不存在），而A2则可能因计算结果而为空，但实际是存在的，所以要单独判断。
这之后达成14/20 (测试点7不稳定，为1分，估计是有关时间)
————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
破案了，是我下面的fg5写错了，现在是20/20了

————————————————————————————————————————————————————————————————————————————————————————————————————————————————————



****请注意我的判断输出方式****

 */
package 刷题.pta乙题;

import java.util.Scanner;

public class 数字分类1012 {
   static int ens1,os2,num3,max5=0;
   static float avg4,n4;
   static boolean flag=true;
   static boolean flag22=false;
    public static void main(String[] args) {
        java.text.DecimalFormat   dF=new   java.text.DecimalFormat("0.0");
        Scanner in = new Scanner(System.in);
        int N =in.nextInt();
        for(int i=0;i<N;i++)
        {
            int n=in.nextInt();
            switch (n%5){
                case 0:doit0(n);break;
                case 1:doit1(n);break;
                case 2:doit2(n);break;
                case 3:doit3(n);break;
                case 4:doit4(n);break;
            }
        }
        boolean fg1=jus(ens1);
        boolean fg2;
        if(flag22){
            fg2=false;
        }else {
            fg2=true;
        }
        boolean fg3=jus(num3);
        boolean fg5=jus(max5);
        boolean fg4=jus(avg4);

        System.out.print(fg1?"N"+" ":ens1+" ");
        System.out.print(fg2?"N"+" ":os2+" ");
        System.out.print(fg3?"N"+" ":num3+" ");
        System.out.print(fg4?"N"+" ": dF.format(avg4)+" ");
        System.out.print(fg5?"N":max5);                         //复制粘贴的时候，这里的fg5没写对，导致测试点1和测试点5没对。
    }
    static boolean jus(int x){
       return x==0;
    }
    static boolean jus(float x){
        return x==0.0;
    }
    static void doit0(int n){
        if(n%2==0)
        {
            ens1+=n;
        }

    }
    static void doit1(int n){
        flag22=true;
        if(flag)
        {
            os2+=n;
            flag=false;
        }else {
            os2-=n;
            flag=true;
        }
    }
    static void doit2(int n){
        num3++;
    }
    static void doit3(int n){
        n4++;
        avg4=(avg4*(n4-1)+(float)n)/n4;
    }
    static void doit4(int n){
        if(max5<n)
        {
            max5=n;
        }
    }
}
