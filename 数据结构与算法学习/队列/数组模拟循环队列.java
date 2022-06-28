package 花与鸟与爱之矢一一数据结构与算法.队列;

public class 数组模拟循环队列 {
    public static void main(String[] args) {
        //测试
    }
}

class CircleArray{
    private int maxSize;
    private int front;
    private int rear;  //默认为0了，正好
    int [] arr;
    public CircleArray(int arrMaxSize)
    {
        maxSize=arrMaxSize;
        arr=new int[maxSize];
    }
    public boolean isFull()
    {
        return (rear+1)%maxSize==front;
    }
    public boolean isEmpty()
    {
        return rear==front;
    }
    //添加方法（对比普通队列有了变化，主要是用超出的rear找出数组应放的位置）
    public void addQueue(int n)
    {
        if(isFull()){
            System.out.println("已经...满出来了");
            return;
        }
        arr[rear]=n;
        rear = (rear+1)%maxSize;  //用完了，后移 //这样是信任写法，每一次用完都把它处理好，下一个就不用先处理完再用了
    }
    public int getQueue()
    {
        if(isEmpty())
        {
            throw new RuntimeException("空空的（；´д｀）ゞ");
        }
        int value=arr[front];
        front=(front+1)%maxSize;
        return value;
    }
    //有效个数
    public int size()
    {
        return (rear+maxSize-front)%maxSize;
    }
    public void showQueue()
    {
        if(isEmpty())
        {
            System.out.println("空空的（；´д｀）ゞ");
            return;
        }
        for(int i=front;i<size();i++)
        {
            System.out.println("a["+i%maxSize+"]="+arr[i%maxSize]);   //妙啊，绕回来了
        }

    }
    public int headQueue()
    {
        if(isEmpty())
        {
            throw new RuntimeException("空空的（；´д｀）ゞ");
        }
        return arr[front];
    }
}
