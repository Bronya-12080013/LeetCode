package 刷题.pta乙题;/*
部分成功，11/15分，有部分超时了
看看大佬的不超时答案
应该是Scanner输入方法超时了
人家遍历法都能过，我的哈希法超时了
大佬2用 BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 而readline中空格不是断句符 所以用了spilt（“”）即：
br.readLine().split(" ");
但split断句是只能用与String类型的***
所以大佬2把数字全设成String
而大佬1在 BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 基础上自己写了一个输出方法Reader
好好看大佬1的定义方法
 */

/*
import other.Student;

import java.util.*;

public class 刷题.pta乙题.考试座位号1041 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Student[] students = new Student[N];
        HashMap V =new HashMap();
        HashMap X =new HashMap();
        for(int i=0;i<N;i++)
        {
            Long no=in.nextLong();
            int falseno = in.nextInt();
            int trueno = in.nextInt();
            students[i]=new Student(no,falseno,trueno);
            V.put(falseno,trueno);
            X.put(falseno,no);
        }
        int M =in.nextInt();
        int[] m =new int[M];
        for(int i=0;i<M;i++)
        {
            m[i]=in.nextInt();
            System.out.println(X.get(m[i])+" "+V.get(m[i]));
        }


    }
}
*/

//大佬1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 考试座位号1041{

    public static void main(String[] args) throws IOException {

//      Scanner in = new Scanner(System.in);
        int n1 = Reader.nextInt();
        String[][] data = new String[n1][3];

        for ( int i = 0; i < n1; i++ ) {
            for (int j = 0; j < 3; j++ ) {
                data[i][j] = Reader.next();
            }
        }

//      for ( String[] d1 : data ) {
//          for ( String d2 : d1 ) {
//              System.out.println(d2);
//          }
//      }

        int n2 = Reader.nextInt();
        String[] n = new String[n2];
        for ( int i = 0; i < n2; i++ ) {
            n[i] = Reader.next();
//          System.out.println(n[i]);
        }


        for ( int i = 0; i < n2; i++ ) {
            for ( int j = 0; j < n1; j++ ) {
                if ( n[i].equals(data[j][1]) ) {
                    System.out.println(data[j][0] +" "+ data[j][2]);
                }
            }
        }
    }

    public static class Reader {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer tokenizer = new StringTokenizer("");

        static String nextLine() throws IOException {// 读取下一行字符串
            return reader.readLine();
        }                                           //因为空格也是字符串，要把它从输入的字符中筛选出来，所以写了next（“”） 前面的nextLine只是工具人

        //实际用的是next（）
        static String next() throws IOException {// 读取下一个字符串
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());   //readLine()只在这当工具人 //StringTokenizer有参构造:为指定字符串构造一个 string tokenizer。
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {// 读取下一个int型数值
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {// 读取下一个double型数值
            return Double.parseDouble(next());
        }
    }
}
/*
大佬2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m =Integer.parseInt(br.readLine());
		long[][] ks = new long[m+1][2];      //第0行让它空着，方便理解，所以数组容量+1行。
		for (int i = 0; i < m; i++) {
			String[] str = br.readLine().split("\\s+");
			int  sz = Integer.parseInt(str[1]);   //试座号即存储的行号
			ks[sz][0] = Long.parseLong(str[0]);  //准考证号
			ks[sz][1] = Long.parseLong(str[2]);  //座位号
		}
		int n = Integer.parseInt(br.readLine());
        String[] search = br.readLine().split(" ");    //要查找的人数
		for (int j = 0; j < n; j++) {
			int c = Integer.parseInt(search[j]);  //试座号即要查找的行号
			System.out.println(ks[c][0] + " " + ks[c][1]);
		}
	}

}

 */
