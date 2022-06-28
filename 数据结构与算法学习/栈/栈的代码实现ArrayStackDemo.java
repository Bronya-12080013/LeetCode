package 花与鸟与爱之矢一一数据结构与算法.栈;
//数组模拟
public class 栈的代码实现ArrayStackDemo {
    public static void main(String[] args) {
        //测试
    }
}
class ArrayStack{
    private int MaxSize;
    private int [] stack;
    private int top=-1;
    public ArrayStack(int MaxSize)
    {
        this.MaxSize=MaxSize;
        stack=new int[MaxSize];
    }
    public boolean isFull(){
        return top==MaxSize-1;
    }
    public  boolean isEmpty(){
        return top==-1;
    }
    public void push(int value)
    {
        if(isFull())
        {
            System.out.println("已经...满了");
            return;
        }
        top++;
        stack[top]=value;   //先移动top再加
    }
    public int pop(){
        if(isEmpty())
        {
            throw new RuntimeException("里面什么都没有哦");
        }
        int value=stack[top];
        top--;
        return value;
    }
    public void list() {
        if(isEmpty()) {
            System.out.println("里面什么都没有哦");
            return;
        }
        //需要从栈顶开始显示数据
        for(int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
