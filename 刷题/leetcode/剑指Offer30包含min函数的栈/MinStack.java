//好耶，初版过了
/*
大意了，题目不是要求完全自己写一个栈
而是实现有min（）等方法的栈，而且时间复杂度有要求
用系统的栈Stack没有这些方法

所以我可以直接调用Stack的（反正系统检测也是看输入输出）

==================================================================
我用了改良版，太强了
速度从231ms变到18ms,就是内存低了（击败用户比例低了）（不过速度才是王道）
（但第二次执行时内存又高了！？ 是我的内存影响了吗）
 */

/*

初版：

package 刷题.leetcode.剑指Offer30包含min函数的栈;

import java.util.ArrayList;

class MinStack {
    int top=0;
    int tail=-1;
    ArrayList<Integer> stack =new ArrayList();
    public MinStack() {

    }

    public void push(int x) {
        stack.add(top,x);
        top++;
    }

    public void pop() {
        if(top!=0)
        {
            top--;
            stack.remove(top);
        }
    }

    public int top() {
        if(top!=0)
        {
            return stack.get(top-1);
        }
        else return -1;
    }

    public int min() {
        int min=stack.get(0);
        for (Integer s:stack) {
            if(min>s)
            {
                min=s;
            }
        }
        return min;
    }

}

 */


//改进版：
package 刷题.leetcode.剑指Offer30包含min函数的栈;

import java.util.Stack;

class MinStack {
   Stack<Integer> A,B;
    public MinStack() {
        //题目要求在这初始化
        A=new Stack<>();
        B=new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if(B.empty()||B.peek()>x)
        {
            B.add(x);
        }
    }

    public void pop() {
      if(A.pop().equals(B.peek()))  //注意，这里A.pop()已经执行了！！
      {
          B.pop();
      }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.pop();
    }

}