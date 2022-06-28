/*
    版一：  14/20   实在找不到漏洞了

    package 刷题.pta甲题;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ABFormat1001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] c =br.readLine().split(" ");
        long a=Long.valueOf(c[0]);
        long b=Long.valueOf(c[1]);
        String s =String.valueOf(a+b);
        int n=1;
        System.out.print(s.charAt(0));
        if((s.length()-1)%3!=0)
        {
            for(int i=0;i<(s.length()-1)%3;i++)
            {
                System.out.print(s.charAt(n));
                n++;
            }
            System.out.print(",");
        }

            for(int i=0;i<(s.length()-1)/3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    System.out.print(s.charAt(n));
                    n++;
                }
                if(i!=(s.length()-1)/3-1)
                {
                    System.out.print(",");
                }


            }
    }
}
 */


//版2：      改良法，换了一个方法，20/20分

//!!!!!!!!!!!!!!!!!强调 DecimalFormat

package 刷题.pta甲题;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class ABFormat1001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] c =br.readLine().split(" ");
        int a=Integer.valueOf(c[0]);
        int b=Integer.valueOf(c[1]);
        if(String.valueOf(a+b).length()<4)
        {
            System.out.println(a+b);
        }
        else {
            DecimalFormat df =new DecimalFormat(",###");
            System.out.println(df.format(a+b));
        }

            }
    }

