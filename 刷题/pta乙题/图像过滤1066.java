/*
还行，13/15分，超时问题，还是考虑输入的问题，Scanner太慢了。
问题1：输入指定位数可以用printf的%03d就行。
问题2：要求末位不要空格，在输入写判断就行
综上，写System.out.printf("%s%03d",flag==true?"":" ",c);  ！！用flag判断要用 “” 还是 “ ”    ！！%0d规范格式
这样可以不用写那两个方法了
可看别人代码
另外，知识点：
取int的位数，转换成string，再length：
Integer.toString(MN).length()
 */
//我的代码：
package 刷题.pta乙题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 图像过滤1066 {
    public static void main(String[] args) throws IOException {
        Scanner scanner =new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = scanner.nextInt();
       int M = scanner.nextInt();
       int A = scanner.nextInt();
       int B = scanner.nextInt();
       int S = scanner.nextInt();
        int [][] MN = new int[N][M];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                MN[i][j]=scanner.nextInt();
                if(MN[i][j]>=A&&MN[i][j]<=B)
                {
                    MN[i][j]=S;
                }
            }
        }
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(j!=M-1)
                {
                    doit(MN[i][j]);
                }else doit02(MN[i][j]);

            }
            System.out.print("\n");
        }
    }

    private static void doit02(int MN) {
        if(Integer.toString(MN).length()==3)
        {
            System.out.print(MN);
        }else if(Integer.toString(MN).length()==2)
        {
            System.out.print("0"+MN);
        }else if(Integer.toString(MN).length()==1)
        {
            System.out.print("00"+MN);
        }
    }

    private static void doit(int MN)
    {
        if(Integer.toString(MN).length()==3)
        {
            System.out.print(MN+" ");
        }else if(Integer.toString(MN).length()==2)
        {
            System.out.print("0"+MN+" ");
        }else if(Integer.toString(MN).length()==1)
        {
            System.out.print("00"+MN+" ");
        }
    }
}

/*
别人的代码：（不过也超时了）
有人说这题用c语言从不超时

import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int m = sc.nextInt();
	int n = sc.nextInt();
	int a = sc.nextInt();
	int b = sc.nextInt();
	int c = sc.nextInt();

	while(m!=0){
		boolean flag = true;
		for(int i=0;i<n;i++){
			int d = sc.nextInt();
			if(d>=a && d<=b){
				System.out.printf("%s%03d",flag==true?"":" ",c);

			}
			else System.out.printf("%s%03d",flag==true?"":" ",d);
			if(i==n-1) System.out.printf("\n");
			flag=false;
		}
		m--;
	}

}}
 */
