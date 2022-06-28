package 花与鸟与爱之矢一一数据结构与算法.队列;

public class 数组模拟队列 {
    public static void main(String[] args) {
        //测试
        ArrayQueue a =new ArrayQueue(3);
        a.addQueue(1);
        a.addQueue(2);
        a.addQueue(3);
        a.addQueue(4);
        a.showQueue();
    }
}

class ArrayQueue
{
    private int maxSize;
    private int front;
    private int rear;
    int [] arr;
    //建立队列构造器
    public ArrayQueue(int arrMaxSize)
    {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front=-1;
        rear=-1;
    }
    //判断为满
    public  boolean isFull()
    {
        return rear==maxSize-1;
    }
    public boolean isEmpty()
    {
        return rear==front;
    }
    public void addQueue(int n)
    {
        if(isFull())
        {
            System.out.println("已经...满出来了");
            return;
        }
        rear++;
        arr[rear]=n;
    }
    //取数据,这是模拟队列，只允许（默认）取头数据
    public int getQueue()
    {
        if(isEmpty())
        {
            throw new RuntimeException("空空的（；´д｀）ゞ");
        }
        front++;
        return arr[front];
    }
//显示队列，取过的也显示
    public void showQueue()
    {
        if(isEmpty())
        {
            System.out.println("空空的（；´д｀）ゞ");
            return;
        }
        for(int i=0;i<arr.length;i++)
        {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }

    }
    public int headQueue()
    {
        if(isEmpty())
        {
            throw new RuntimeException("空空的（；´д｀）ゞ");
        }
        return arr[front+1];
        }

    }

