
/*   排序测试
package utils.降序排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class DescendingSort {
    public static void main(String[] args) {
        //Integer[]才能用Stream输出
        Integer[] score=new Integer[]{4,3,2,5,1};
        Stream.of(score).forEach(e->System.out.print(e));    //43251
        System.out.println("");

        Arrays.sort(score);                                 //升序排序(从小到大)
        Stream.of(score).forEach(e-> System.out.print(e));  //12345
        System.out.println("");

        Comparator cmp=new CMP();
        Arrays.sort(score,cmp);                              //降序排序(从大到小)
        Stream.of(score).forEach(e-> System.out.print(e));  //54321
        System.out.println("");

        //这个方法是对Integer[]才行的
        Arrays.sort(score, Collections.reverseOrder());   //也是 降序排序
        Stream.of(score).forEach(e-> System.out.print(e));  //54321
        System.out.println("");
    }
}

//利用Comparator接口复写compare
class CMP implements Comparator<Integer>{
    @Override //可以去掉。作用是检查下面的方法名是不是父类中所有的
    public int compare(Integer a,Integer b){
        //        两种都可以，升序排序的话反过来就行
        //        return a-b<0?1:-1;
        return b-a;
    }
}
 */

/*
可以直接用的 传入的是int[]
降序排序(从大到小)
 */
package utils.降序排序;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class DescendingSort {
    //法1:
    public int[] descendingSort(int[] num){
        Integer[] arr =new Integer[num.length];
        for(int i =0;i<arr.length;i++)
        {
            arr[i]=Integer.valueOf(num[i]);
        }
        Comparator cmp=new CMP();
        Arrays.sort(arr,cmp);                              //降序排序(从大到小)
        for(int i =0;i<arr.length;i++)
        {
           num[i]=arr[i].intValue();
        }
        return num;
    }

    //法二:
    public int[] descSort(int[] num) {
        Integer[] arr =new Integer[num.length];
        for(int i =0;i<arr.length;i++)
        {
            arr[i]=Integer.valueOf(num[i]);
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i =0;i<arr.length;i++)
        {
            num[i]=arr[i].intValue();
        }
        return num;
    }

    //构造类方法
    public DescendingSort() {
    }
}
class CMP implements Comparator<Integer>{
    @Override //可以去掉。作用是检查下面的方法名是不是父类中所有的
    public int compare(Integer a,Integer b){
        //        两种都可以，升序排序的话反过来就行
        //        return a-b<0?1:-1;
        return b-a;
    }
}