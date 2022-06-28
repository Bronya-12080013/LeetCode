//初师告捷，过了
package 刷题.leetcode.剑指Offer09用两个栈实现队列;

import java.util.Stack;

public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1=new Stack();
        stack2=new Stack();
    }

    public void appendTail(int value) {
        while (!stack1.empty())
        {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.empty())
        {
            stack1.push(stack2.pop());
        }
    }

    public int deleteHead() {
        if(!stack1.empty())
        {
            return stack1.pop();
        }else return -1;
    }
}
