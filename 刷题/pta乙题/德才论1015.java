/*
        初版，16/25 有三个测试点运行超时
        主要问题是： sort排序运用了冒泡排序
                    我从后往前数， 写成了        for(int j=subset.size()-1;j<0;j--)
                                                for(int i=j;i<0;i--)
                           应该是                for(int j=subset.size()-1;j>0;j--)
                                                for(int i=j;i>0;i--)

                          ;
                          除此之外，还要注意break的写法，三重判断，每层都要else break，这是节省时间的关键
                          万万不能少了else

                          下面我看看哪里超时了
————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
淦，算了，算法问题，日后算账
我就记得冒泡排序了，仔细想想，它也太慢了
我先看看算法书先
————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
啊，看了两个大佬的答案回来了
大佬说这题java过不了，换个语言做吧     哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈
配图也是这三个测试点过不了
另一个大佬的评论区也有说三个测试点过不了

那不管了，看看怎么写就好
————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
大佬都是用BufferedReader的吗。。。

又学到了一个类： StringTokenizer

 */

package 刷题.pta乙题;

import java.util.ArrayList;
import java.util.Scanner;

public class 德才论1015 {
    static Scanner scanner =new Scanner(System.in);
    static int N =scanner.nextInt();
    static int L=scanner.nextInt();
    static int H=scanner.nextInt();
    public static void main(String[] args) {

        ArrayList<Student> students =new ArrayList<>();
        int nums=0;
        for(int i=0;i<N;i++){
            Student student =new Student();
            student.id=scanner.nextInt();
            student.morality=scanner.nextInt();
            student.talent=scanner.nextInt();
            student.score=student.morality+student.talent;
            if(student.morality>=L&&student.talent>=L)
            {
                student.grade=classification(student);
                students.add(student);
                nums++;
            }
        }
        System.out.println(nums);
        for(int i=1;i<=4;i++){
            ArrayList<Student> subset=new ArrayList<>();
            for(int j=0;j<students.size();j++)
            {
                if(students.get(j).grade==i)
                {
                    subset.add(students.get(j));
                }
            }
            sort(subset);

            for (int j=subset.size()-1;j>=0;j--)
            {
                System.out.println(subset.get(j).id+" "+subset.get(j).morality+" "+subset.get(j).talent);
            }
        }

    }

    static void sort(ArrayList<Student> subset)
    {
        for(int j=subset.size()-1;j>0;j--)
        {
            for(int i=j;i>0;i--)
            {   Student substitute=null;
                if(subset.get(i).score<subset.get(i-1).score)
                {
                    substitute=subset.get(i);
                    subset.remove(i);
                    subset.add(i,subset.get(i-1));
                    subset.remove(i-1);
                    subset.add(i-1,substitute);
                }else if(subset.get(i).score==subset.get(i-1).score)
                {
                    if(subset.get(i).morality<subset.get(i-1).morality)
                    {
                        substitute=subset.get(i);
                        subset.remove(i);
                        subset.add(i,subset.get(i-1));
                        subset.remove(i-1);
                        subset.add(i-1,substitute);
                    }else if(subset.get(i).morality==subset.get(i-1).morality)
                    {
                        if(subset.get(i).id>subset.get(i-1).id)
                        {
                            substitute=subset.get(i);
                            subset.remove(i);
                            subset.add(i,subset.get(i-1));
                            subset.remove(i-1);
                            subset.add(i-1,substitute);
                        }else break;
                    }
                    else break;
                }else break;
            }
        }

    }

    static int classification(Student student)
    {
        if(student.morality>=H&&student.talent>=H)
        {
            return 1;
        }else if(student.morality>=H&&student.talent<H)
        {
            return 2;
        }else if (student.morality<H&&student.talent<H&&student.morality>student.talent)
        {
            return 3;
        }else return 4;
    }

}

class Student{
    int id;
    int morality;
    int talent;
    int grade;
    int score;
}