/*
ohhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
这题我就是大佬
1.输入问题。这次题目有点坑，N和N个数字是在同一行，我没注意，不过问题不大，可以直接用Scanner。也可以用BufferedReader，不过要预留好位置。
2.我看来好几个别人的答案，发现他们都不考虑数字重复的情况，大多直接遍历或归纳得出 结构=各数字*11*N ，而这在数字有重复的情况是不对的。我也没试他们的，反正我的泛用性强
3.还有一些小问题，如我的break打错位置了，搞的我写了好久。
 */
package 刷题.pta乙题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 组合数的和1056 {
    public static void main(String[] args) throws IOException {
        Scanner scanner =new Scanner(System.in);
       // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      // String[1]  = reader.readLine().split(" ");
        //String a = scanner.next
        int N = scanner.nextInt();
        //String[] in = reader.readLine().split(" ");
        int [] array1 =new int[N];
        int [] array2 =new int[9];
        int sum=0;
        for (int i=0;i<N;i++)
        {
            sum++;
           // array1[i]=Integer.parseInt(in[i]);
            array1[i]=scanner.nextInt();
            array2[array1[i]-1]++;
            for(int j=0;j<i;j++)
            {
                if(array1[j]==array1[i])
                {
                    array1[i]=0;
                    sum--;
                    break;
                }
            }
        }
        int[] array3 =new int[sum];
        sum=0;
        for(int i=0;i<N;i++)
        {
            if(array1[i]!=0)
            {
                array3[sum]=array1[i];
                sum++;
            }
        }
        sum=sum*(sum-1);
        int sum2=0;
        for(int i=0;i<9;i++)
        {
            if(array2[i]>1)
            {
                sum2++;
            }
        }
        int[] all = new int[sum+sum2];
        all=doit(array3,array2,sum,sum2);
        int sumall=0;
        for(int i=0;i<all.length;i++)
        {
            sumall=sumall+all[i];
         //   System.out.println(all[i]);
        }
        System.out.print(sumall);
    //  for(int i=0;i<array1.length;i++)
    //  {
    //      System.out.print(array1[i]+" ");
    //  }
    //  System.out.println("\n");
    //  for(int i=0;i<array3.length;i++)
    //  {
    //      System.out.print(array3[i]+" ");
    //  }
    //  System.out.println("\n");
    //  for(int i=0;i<array2.length;i++)
    //  {
    //      System.out.print(array2[i]+" ");
    //  }

    }
    static int[] doit(int [] array3,int[] array2,int sum,int sum2)
    {
        int [] all =new int[sum+sum2];
        for(int i=0;i<sum2;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(array2[j]>1)
                {
                    all[i]=(j+1)*10+(j+1);
                    array2[j]=0;
                    break;
                }
            }
        }
        int n=sum2;
          for(int j=0;j<array3.length;j++)
          {
              for(int k=0;k<array3.length;k++)
              {
                  if(j!=k)
                  {
                      all[n]=array3[j]*10+array3[k];
                      n++;
                  }

              }

          }
        return all;
    }
}
