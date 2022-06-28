/*

package 刷题.pta乙题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 反转链表1025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int firstAd =Integer.valueOf(str[0]);
        int N=Integer.valueOf(str[1]);
        int K=Integer.valueOf(str[2]);
        DoubleLinkedList list =new DoubleLinkedList();
        list.getHeadNode().pre=firstAd;
        Node node=new Node();
        for(int i=0;i<N;i++)
        {
            str=br.readLine().split(" ");
            node.Address=Integer.valueOf(str[0]);
            node.Data =Integer.valueOf(str[1]);
            node.Next=Integer.valueOf(str[2]);
            list.charu(node);
        }
        list.list();

    }
}

class DoubleLinkedList{
    private Node headNode = new Node(0,0,0);
    //返回头节点
    public Node getHeadNode(){
        return headNode;
    }

    //遍历
    public void list()
    {
        if(headNode.Next==null)
        {
            System.out.println("空空的");
            return;
        }
        Node temp=headNode.nextNode;
        while (true)
        {
            if(temp==null)
            {
                break;
            }
            System.out.println(temp);
            temp=temp.nextNode;
        }
    }
    //插入节点
    public void charu(Node node){
        Node temp=headNode;
        while (true)
        {
            if(temp.nextNode!=null)
        {
            if((temp.Next==node.Address))
            {   node.nextNode=temp.nextNode;
                node.preNode=node;
                node.preNode.nextNode=node;
                node.nextNode.preNode=node;
                break;
            }
        }
            if(temp.nextNode==null)
            {
                node.preNode=temp;
                node.preNode.nextNode=node;
                break;
            }
            temp=temp.nextNode;
        }

    }

}


//节点
class Node{
    public Integer pre;
    public Integer Address;
    public Integer Data;
    public Integer Next;
    public Node nextNode;
    public Node preNode;

    public Node() {
    }

    public Node(int address, int data, int next) {

        Address = address;
        Data = data;
        Next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "pre=" + pre +
                ", Address=" + Address +
                ", Data=" + Data +
                ", Next=" + Next +
                ", nextNode=" + nextNode +
                ", preNode=" + preNode +
                '}';
    }
}


 */


/*        哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈我没疯
            部分正确  12/25 第一个测试点过了
 ——————————————————————————————————————————————————————————————————————
 明天再看看别人的答案吧
 */
package 刷题.pta乙题;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class 反转链表1025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        LinkedList<God> list = new LinkedList<>();
        int firstadress = Integer.valueOf(str[0]);
        int N = Integer.valueOf(str[1]);
        int K = Integer.valueOf(str[2]);
        for (int i = 0; i < N; i++) {
            God god = new God();
            str = br.readLine().split(" ");
            god.Address = Integer.valueOf(str[0]);
            god.Data = Integer.valueOf(str[1]);
            god.Next = Integer.valueOf(str[2]);
            list.addLast(god);
        }
        for(int i=0;i<N;i++)
        {
            God god=list.get(i);
            if(god.Address==firstadress)
            {
                list.addFirst(god);
                list.remove(i+1);
                break;
            }
        }

        for (int i = 0; i < N; i++) {

            for(int j=i+1;j<N;j++)
            {
                God god=list.get(j);
                if(list.get(i).Next==list.get(j).Address)
                {
                    list.add(i+1,god);
                    list.remove(j+1);
                }
            }

        }

        Reverse(list,K,firstadress);
        for (int i = 0; i < N; i++) {                                            //刚刚看了书，链表的get方法效率太低了，拿来查询还行，不要拿来遍历
            //System.out.println(list.get(i).toString());                         //要遍历链表可以用 增强for循环(foreach) 或 输出流forEach()
            if(list.get(i).Address==-1)
            {
                System.out.print("-1");
            }else  System.out.printf("%05d ",list.get(i).Address);

            System.out.printf("%d ",list.get(i).Data);
            if(list.get(i).Next==-1)
            {
                System.out.print("-1");
            }else  System.out.printf("%05d",list.get(i).Next);
            if(i!=N-1)
            System.out.printf("\n");
        }
    }
        static void Reverse(LinkedList < God > list,int K,int firstadress)
        {
           for(int i=0;i<list.size();i++)
           {   int index=0;
               if((i+1)%K==0)
               {
                   LinkedList<God> ll=new LinkedList<>();
                   God god=list.get(i);
                   if(index==0)
                   {
                       god.Next=0;
                   }else list.get(index-1).Next=god.Address;
                   ll.add(god);
                   for(int j=i-1;j>=index;j--)
                   {
                       god=list.get(j);
                       ll.getLast().Next=god.Address;
                       ll.add(god);
                       //ll.get(ll.size()-1).Next= god.Address;
                       if(j==index)
                       {
                           ll.getLast().Next=list.get(i+1).Address;
                       }
                   }
                  int n=0;
                   for(int k=index;k<=i;k++)
                   {
                       list.set(k,ll.get(n));
                       n++;
                   }
                   index=i+1;
               }


           }
        }
}
   class God {
        public int Address;
        public int Data;
        public int Next;

        public God() {
        }

      // @Override
      // public String toString() {
      //     return Address+" "+Data+" "+Next;
      // }
    }



