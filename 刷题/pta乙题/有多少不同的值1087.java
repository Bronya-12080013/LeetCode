/*
初代代码超时了，改良版过了 20/20分
但改良版代码是‘有几率过’的，我尝试了好几遍才刷出，不知道是不是java的问题，它偶尔前两个点超时，有时是后两个，有时是全部超时，有时全过。而初代代码应该是算法问题。
知识点：重复问题，用HashSet，有方法：add(E e) ：如果此 set 中尚未包含指定元素，则添加指定元素。
contains(Object o)如果此 set 包含指定元素，则返回 true
size()返回此 set 中的元素的数量（set 的容量）。
....................................................................
看了别人的答案，我是sb
....................................................................
大佬1，逆向法
如果不是同时为2、3、5的倍数的话，就无法突破天元，都会和上一个2、3、5的倍数对应的值一样
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		int ans = N;
		for (int i = 2; i <= N; ++i) {						// 从2开始
			if (0 != i % 2 && 0 != i % 3 && 0 != i % 5) {	// 不是2,3,5的倍数
				ans -= 1;									// 个数减1
			}
		}
		System.out.println(ans);
	}
}
.........................................................................
大佬2，思想同上，所有的n/2+n/3+n/5,在整体上是递增的
或者说是，当n从1→N，每个为 2、3、5的倍数 的n,他们的 n/2+n/3+n/5 值是递增的，是分层的，只是每一层中间卡着很多一样的数，哪些不是同时为2、3、5的倍数的n会和他们的层主一样。
这样的话（整体递增），只要一对一地后比前就行了
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int b=0,num=1;
		for (int i = 1; i <= n; i++) {
			int a=i/2+i/3+i/5;
			if(i==1) {
				b=a;
			}
			if(b!=a) {
				num++;
			}
			b=a;
		}
		System.out.println(num);
	}
}


 */

/*
我的初代代码，当然超时了
package 刷题.pta乙题;

import java.util.Scanner;

public class 有多少不同的值1087 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N =scanner.nextInt();
        int[] sum=new int[N];
        for(int n=1;n<=N;n++)
        {
            sum[n-1]=doit(n);
            for(int i=0;i<n-1;i++)
            {
                if(sum[n-1]==sum[i])
                {
                    sum[n-1]=0;
                    break;
                }
            }
        }
        int length=1;
        for(int i=0;i<N;i++)
        {
            if(sum[i]!=0)
                length++;
        }
        System.out.println(length);
    }
    static int doit(int n)
    {
        return n/2+n/3+n/5;
    }

}

 */

//我的改良代码，用Hashset，有一定几率能过
package 刷题.pta乙题;

import java.util.HashSet;
import java.util.Scanner;

public class 有多少不同的值1087 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        也可以：
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
         */
        int N =scanner.nextInt();
        int sum;
        int length=1;
        @SuppressWarnings("unchecked")
        HashSet set = new HashSet();
        for(int n=1;n<=N;n++)
        {
            sum=n/2+n/3+n/5;
                if(!set.contains(sum))
                {
                    set.add(sum);
                    length++;
                }
        }
        System.out.println(set.size());
    }
}

