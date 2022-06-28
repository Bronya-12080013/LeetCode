/*
这题的时间跨度太长了
====================================
啊啊啊啊啊啊啊，不知道错哪了
明明就差一步了
======================================
啊啊啊啊啊啊啊啊啊啊啊，不写了，总有用例会错
=======================================
 */

//大佬代码

package 刷题.leetcode.剑指Offer59II队列的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;
    public MaxQueue() {
        queue = new LinkedList<>();   //实现队列
        deque = new LinkedList<>();    //辅助取最大值
    }
    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    //重点，每添加一个都要把辅助deque里比它小的清理出去
    public void push_back(int value) {
        queue.offer(value);
        while(!deque.isEmpty() && deque.peekLast() < value)
            deque.pollLast();
        deque.offerLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        if(queue.peek().equals(deque.peekFirst()))
            deque.pollFirst();
        return queue.poll();
    }
}


/*
//我的代码，没过
package 刷题.leetcode.剑指Offer59II队列的最大值;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MaxQueue {
    public static void main(String[] args) {
                MaxQueue maxQueue = new MaxQueue();    //1
                maxQueue.max_value();
                maxQueue.pop_front();
                maxQueue.max_value();
                maxQueue.push_back(46);
                maxQueue.max_value();
                maxQueue.pop_front();
                maxQueue.max_value();
                maxQueue.pop_front();
                maxQueue.push_back(868);   //10
                maxQueue.pop_front();
                maxQueue.pop_front();
                maxQueue.pop_front();
                maxQueue.push_back(525);
                maxQueue.pop_front();
                maxQueue.max_value();
                maxQueue.pop_front();
                maxQueue.max_value();
                maxQueue.push_back(123);
                maxQueue.push_back(646); //20
                maxQueue.max_value();
                maxQueue.push_back(229);
                maxQueue.max_value();
                maxQueue.max_value();
                maxQueue.max_value();
                maxQueue.push_back(871);
                maxQueue.pop_front();
                maxQueue.max_value();
                maxQueue.push_back(285);
                maxQueue.max_value();         //30
                maxQueue.max_value();
                maxQueue.max_value();
                maxQueue.pop_front();
                maxQueue.push_back(45);
                maxQueue.push_back(140);
                maxQueue.push_back(837);
                maxQueue.push_back(545);
                maxQueue.pop_front();
                maxQueue.pop_front();
                maxQueue.max_value();         //40        //40
                maxQueue.pop_front();
                maxQueue.pop_front();
                maxQueue.max_value();                     //43
                maxQueue.push_back(561);
                maxQueue.push_back(237);
                maxQueue.pop_front();
                maxQueue.push_back(633);
                maxQueue.push_back(98);
                maxQueue.push_back(806);
                maxQueue.push_back(717);  //50
                maxQueue.pop_front();
                maxQueue.max_value();
                maxQueue.push_back(186);
                maxQueue.max_value();
                maxQueue.max_value();
                maxQueue.pop_front();
                maxQueue.max_value();
                maxQueue.max_value();
                maxQueue.max_value();
                maxQueue.push_back(268);    //60
                maxQueue.pop_front();
                maxQueue.push_back(29);
                maxQueue.pop_front();
                maxQueue.max_value();
                maxQueue.max_value();
                maxQueue.max_value();
                maxQueue.push_back(866);
                maxQueue.pop_front();
                maxQueue.push_back(239);
                maxQueue.push_back(3);      //70
                maxQueue.push_back(850);
                maxQueue.pop_front();
                maxQueue.max_value();
                maxQueue.pop_front();
                maxQueue.max_value();
                maxQueue.max_value();
                maxQueue.max_value();
                maxQueue.pop_front();
                maxQueue.push_back(310);
                maxQueue.pop_front();              //80
                maxQueue.push_back(674);
                maxQueue.push_back(770);
                maxQueue.pop_front();
                maxQueue.push_back(525);
                maxQueue.pop_front();
                maxQueue.push_back(425);
                maxQueue.pop_front();
                maxQueue.pop_front();
                maxQueue.push_back(720);
                maxQueue.pop_front();              //90
                maxQueue.pop_front();
                maxQueue.pop_front();
                maxQueue.push_back(373);
                maxQueue.push_back(411);
                maxQueue.max_value();              //95
                maxQueue.push_back(831);
                maxQueue.pop_front();
                maxQueue.push_back(765);
                maxQueue.push_back(701);
                maxQueue.pop_front();              //100

    }

    Deque deque;
    Deque dequeHelp=new ArrayDeque();
    int max=-1;
    public MaxQueue() {
        deque=new ArrayDeque();
    }

    public int max_value() {
            return max;
    }



 //  public void push_back(int value) {
 //     // if(dequeHelp.isEmpty()||(int)dequeHelp.peek()>=value) dequeHelp.push(value);
 //      if(dequeHelp.isEmpty()||(int)dequeHelp.getLast()>=value) dequeHelp.add(value);
 //      deque.add(value);

 //      if(value>max) {
 //          max=value;
 //          if(dequeHelp.size()!=0)

 //        while ((int)dequeHelp.peek()<value)
 //          {
 //              dequeHelp.poll();
 //              if(dequeHelp.isEmpty()) break;
 //          }
 //          dequeHelp.poll();
 //          dequeHelp.add(value);
 //      }
    }


      public void push_back(int value) {
       // if(dequeHelp.isEmpty()||(int)dequeHelp.peek()>=value) dequeHelp.push(value);
        if(dequeHelp.isEmpty()||(int)dequeHelp.getLast()>=value) dequeHelp.add(value);
        deque.add(value);
        if(max<value){
            max=value;
        }
        while(!dequeHelp.isEmpty() &&(int) dequeHelp.peekLast() < value)
            dequeHelp.pollLast();
        dequeHelp.offerLast(value);
        }



    public int pop_front() {
        if(deque.size()!=0){
            if(max==(int)deque.peek())
            {
                dequeHelp.poll();
                max=dequeHelp.size()!=0?(int)dequeHelp.poll():-1;
            }
        }
        if(deque.size()!=0) return (int)deque.poll();
        else return -1;
    }
}

 */



