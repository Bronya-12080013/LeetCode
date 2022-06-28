package 刷题.pta乙题;/*
成了。
1.先行版得9/15分,它考虑了9种输出情况，不过题目没有说清楚，如0.00+0.00i的情况怎么处理。我看别人的代码，只是本题只是针对虚部的正负处理即可。
2.要注意，要保留两位小数，那么如果这数小于0.01，它是会变成0.00的，判断正负是要注意保留和判断的先后顺序。
注意到实部和虚部均保留 2 位小数，也就是如果绝对值是小于0.01的数字，都被看作是0，纠正了这个错误，测试通过了；

 */

/*
先行版
import java.text.DecimalFormat;
import java.util.Scanner;

public class 刷题.pta乙题.复数乘法1051 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double R1 = in.nextDouble();
        double P1= in.nextDouble();
        double R2 =in.nextDouble();
        double P2=in.nextDouble();
        double[] value1 = value(R1,P1);
        double[] value2 = value(R2,P2);
        DecimalFormat df = new DecimalFormat("#.00");
        double res1 = value1[0]*value2[0]-value1[1]*value2[1];
        double res2 = value1[1]*value2[0]+value1[0]*value2[1];
        switch (judge(res1,res2))
        {
            case 1 : System.out.print(df.format(res1)+"+"+df.format(res2)+"i"); break;
            case 2 : System.out.print(df.format(res1)); break;
            case 3 : System.out.print(df.format(res1)+""+df.format(res2)+"i"); break;
            case 4 : System.out.print("+"+df.format(res2)+"i"); break;
            case 5 : System.out.print(0); break;
            case 6 : System.out.print(res2+"i"); break;
            case 7 : System.out.print(df.format(res1)+"+"+df.format(res2)+"i"); break;
            case 8 : System.out.print(df.format(res1)); break;
            case 9 : System.out.print(df.format(res1)+""+df.format(res2)+"i"); break;

        }

    }

    static double[] value(double R,double P)
    {
        double[] value = new double[2];
        value[0]=R*(Math.cos(P));
        value[1]=R*(Math.sin(P));
        return value;
    }

    static int judge(double res1,double res2)
    {
        if(Math.abs(res1) < 0.01){
            res1=0.00;
        }
        if(Math.abs(res2) < 0.01){
            res2=0.00;
        }
        if (res1>0)
        {
            if(res2>0)
            {
                return 1;
            }else if (res2==0)
            {
                return 2;
            }
            else if (res2<0)
            {
                return 3;
            }
        }

        if (res1==0)
        {
            if(res2>0)
            {
                return 4;
            }else if (res2==0)
            {
                return 5;
            }
            else if (res2<0)
            {
                return 6;
            }
        }

        if (res1<0)
        {
            if(res2>0)
            {
                return 7;
            }else if (res2==0)
            {
                return 8;
            }
            else if (res2<0)
            {
                return 9;
            }
        }
        return 0;
    }

}


 */


//提交版
import java.text.DecimalFormat;
import java.util.Scanner;

public class 复数乘法1051 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double R1 = in.nextDouble();
        double P1= in.nextDouble();
        double R2 =in.nextDouble();
        double P2=in.nextDouble();
        double[] value1 = value(R1,P1);
        double[] value2 = value(R2,P2);
        DecimalFormat df = new DecimalFormat("#.00");
        double res1 = value1[0]*value2[0]-value1[1]*value2[1];
        double res2 = value1[1]*value2[0]+value1[0]*value2[1];

        if(Math.abs(res1) < 0.01){
            res1=0.00;
        }

        if(Math.abs(res2) < 0.01){
            res2=0.00;
        }


        if(res2<0){
            System.out.printf("%.2f-%.2fi",res1,-res2);
        }else{
            System.out.printf("%.2f+%.2fi",res1,res2);
        }
    }

    static double[] value(double R,double P)
    {
        double[] value = new double[2];
        value[0]=R*(Math.cos(P));
        value[1]=R*(Math.sin(P));
        return value;
    }

}

/*
大佬1 看输入手法
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        //1、读入R1、P1、R2、P2
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bfr.readLine().split("\\s+");   //正则吧 输入一串字符 以空格分开，成字符数组
        double R1=Double.valueOf(split[0]);               //把字符串化为double数字！！！
        double P1=Double.valueOf(split[1]);
        double R2=Double.valueOf(split[2]);
        double P2=Double.valueOf(split[3]);

        //2、A=(R1*R2)cos(P1+P2)，B=(R1*R2)sin(P1+P2)
        double A=(R1*R2)*Math.cos(P1+P2);
        double B=(R1*R2)*Math.sin(P1+P2);

        //3、如果A的绝对值小于0.01，A=0
        if(Math.abs(A) < 0.01){
            A=0.00;
        }
        //如果B的绝对值小于0.01，B=0
        if(Math.abs(B) < 0.01){
            B=0.00;
        }

        //4、如果B小于零，输出A-|B|i，否则B输出A+Bi。输出时，每个数字保留两位
        if(B<0){
            System.out.printf("%.2f-%.2fi",A,-B);
        }else{
            System.out.printf("%.2f+%.2f",A,B);
        }
    }
}

 */



