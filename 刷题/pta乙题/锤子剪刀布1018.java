/*
     10/20，过不了，暂时找不到原因了。
     看看别人的代码
     大佬：从 谁用什么手势 计数，比起我的方法省了很多事

     import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;


 * 1018 锤子剪刀布 (20分)
 *
 * @思路：得出A和B所有手势赢的次数，然后求平局次数后输出。最后的赢的次数最多的手势因为只有三个直接判断就行。
 * @注意：这题用输入输出和需要快一点，如果最后一个案例还超时就多提交两次
 * @author: ChangSheng
 * @date:   2019年12月30日 下午1:35:46

public class Main {
    public static void main(String[] args) throws IOException{
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        int ABwin = 0, ACwin = 0, AJwin = 0, BBwin = 0, BCwin = 0, BJwin = 0;
        in.nextToken();
        int N = (int)in.nval;
        for (int i = 0; i < N; i++) {
            in.nextToken();
            String A = in.sval;
            in.nextToken();
            String B = in.sval;
            if (A.equals("B") && B.equals("C")) ABwin++;  // A出布B，B出锤子C，A赢一次
            else if (A.equals("C") && B.equals("J")) ACwin++;
            else if (A.equals("J") && B.equals("B")) AJwin++;
            else if (B.equals("B") && A.equals("C")) BBwin++;
            else if (B.equals("C") && A.equals("J")) BCwin++;
            else if (B.equals("J") && A.equals("B")) BJwin++;
        }
        int Acount = ABwin + ACwin + AJwin; // A赢的总次数
        int Bcount = BBwin + BCwin + BJwin;
        int PJcount = N - (Acount + Bcount); // 平局的次数：总次数 -( A赢的次数 +- 和B赢的次数)
        out.println(Acount + " " + PJcount + " " + Bcount);
        out.println(Bcount + " " + PJcount + " " + Acount);
        out.print(max(ABwin, ACwin, AJwin) + " " + max(BBwin, BCwin, BJwin));
        out.flush();
    }

    ** @return：赢的次数最大手势 *
    public static char max(int B, int C, int J) {
        if (B >= C && B >= J) return 'B'; // 大于等于C和J
        if (C > B && C >= J) return 'C'; // 比B大，且大于等于J
        return 'J';
    }
}

*/
package 刷题.pta乙题;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class 锤子剪刀布1018 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int N = scanner.nextInt();
        int[] win01 = new int[3];
        int[] win02 = new int[3];
        int[] winOfTime01 = new int[3];
        int[] winOfTime02 = new int[3];
        for(int i =0;i<N;i++)
        {
            String h1=scanner.next();
            String h2=scanner.next();
            int result =beat(h1,h2);
          //  System.out.println(result);
            doit(result,win01,win02,winOfTime01,winOfTime02,h1,h2);
        }
        for(int i=0;i<3;i++)
        {
            if(i==2)
            {
                System.out.print(win01[i]);
            }else
            System.out.print(win01[i]+" ");
        }
       System.out.print("\n");
        for(int i=0;i<3;i++)
        {
            if(i==2)
                System.out.println(win02[i]);
            else
            System.out.print(win02[i]+" ");
        }
        OutPutMax(winOfTime01,winOfTime02);
    }

    static int beat(String h1,String h2)
    {
        if(h1.equals("C")&&h2.equals("J"))
            return 1;
        if(h1.equals("J")&&h2.equals("B"))
            return 1;
        if(h1.equals("B")&&h2.equals("C"))
            return 1;
        if(h2.equals("C")&&h1.equals("J"))
            return 2;
        if(h2.equals("J")&&h1.equals("B"))
            return 2;
        if(h2.equals("B")&&h1.equals("C"))
            return 2;
        if(h1.equals(h2))
            return 3;
        return 0;
    }
    static void doit(int result,int[] win01,int[] win02,int[] winOfTime01,int[] winOfTime02,String h1,String h2)
    {
        switch (result)
        {
            case 1:
            {
                win01[0]++;
                win02[2]++;
                switch (h1)
                {
                    case "C":winOfTime01[0]++;break;
                    case "J":winOfTime01[1]++;break;
                    case "B":winOfTime01[2]++;break;
                }
                break;
            }

            case 2:
            {
                win02[0]++;
                win01[2]++;
                switch (h2)
                {
                    case "C":winOfTime02[0]++;break;
                    case "J":winOfTime02[1]++;break;
                    case "B":winOfTime02[2]++;break;
                }
                break;
            }

            case 3:{
                win01[1]++;
                win02[1]++;
                break;
            }

        }
    }
    static void OutPutMax(int[] winOfTime01, int[] winOfTime02) {
        int max01=winOfTime01[0];
        int max02=winOfTime02[0];
        int m1=0;
        int m2=0;


        if(winOfTime01[0]==0&&winOfTime01[1]==0&&winOfTime01[2]==0)
        {
            System.out.println("B ");
        }else if((winOfTime01[0]==winOfTime01[1]||winOfTime01[1]==winOfTime01[2]||winOfTime01[0]==winOfTime01[2])||(winOfTime01[0]==winOfTime01[1]&&winOfTime01[1]==winOfTime01[2]&&winOfTime01[0]==winOfTime01[2]))
        {
            if(winOfTime01[2]!=0)
                System.out.print("B ");
            else System.out.print("C ");
        }
        else
        {
            for(int i=1;i<3;i++) {
                if (max01 > winOfTime01[i]) {
                    max01 = winOfTime01[i];
                    m1 = i;
                }
            }
            switch (m1)
            {
                case 0 :System.out.println("C ");break;
                case 1 :System.out.println("J ");break;
                case 2 :System.out.println("B ");break;
            }
        }


        if(winOfTime02[0]==0&&winOfTime02[1]==0&&winOfTime02[2]==0)
        {
            System.out.println("B ");
        }else if((winOfTime02[0]==winOfTime02[1]||winOfTime02[1]==winOfTime02[2]||winOfTime02[0]==winOfTime02[2])||(winOfTime02[0]==winOfTime02[1]&&winOfTime02[1]==winOfTime02[2]&&winOfTime02[0]==winOfTime02[2]))
        {
            if(winOfTime02[2]!=0)
                System.out.println("B");
            else System.out.println("C");
        } else
        {
            for(int i=1;i<3;i++)
            {
                if(max02>winOfTime02[i])
                {
                    max02=winOfTime02[i];
                    m2=i;
                }
            }
            switch (m2)
            {
                case 0 :System.out.println("C");break;
                case 1 :System.out.println("J");break;
                case 2 :System.out.println("B");break;
            }
        }

    }

}
