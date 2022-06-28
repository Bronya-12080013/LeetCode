package 花与鸟与爱之矢一一数据结构与算法.链表;

public class 单向环形链表 {
    public static void main(String[] args) {

    }
}

//环形单向链表
class CircleSingleLinkedList{
    private Boy first =new Boy(-1); //first节点，没有编号，先设-1，后面会改
    public void addBoy(int nums){  //方法 //nums是节点数
        if(nums<1){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy=null; //辅助指针（变量）
        for(int i=1;i<=nums;i++)
        {
            Boy boy = new Boy(i);
            if(i==1)
            {
                first=boy;
                first.setNext(first); //重点，即使只有一个，也要闭环，不要想着把所有节点都引进来后再让最后一个闭环
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }
    //遍历
    public void showBoy(){
        if(first==null){
            System.out.println("链表为空");
            return;
        }
        Boy curboy=first;
        while (true){
            System.out.println("编号为："+curboy.getNo());
            if(curboy.getNext()==first) //已经遍历完了
            {
                break;
            }
            curboy=curboy.getNext();
        }
    }
//下面这个方法是实现约瑟夫问题，可看笔记或百度
    public void countBoy(int startNo,int countNum,int nums){
        if(first==null||startNo<1||startNo>nums)
        {
            System.out.println("参数输入有误");
            return;
        }
        Boy helper =first; //辅助指针，让它到最后一个，即first的后面(从first遍历一圈过去)//可见笔记
        while (true)
        {
            if(helper.getNext()==first){ //已经到最后一个了
                break;
            }
            helper=helper.getNext();
        }
        for(int j=0;j<startNo-1;j++)
        {
            first=first.getNext();
            helper=helper.getNext();
        }
        while (true){
            if (helper == first) {
                break;     //集合上面的for：圈中只有一个节点
            }
            for(int j=0;j<countNum-1;j++) //见题目
            {
                first=first.getNext();
                helper= helper.getNext();
            }
            System.out.println(first.getNo()+"号出圈");
            first=first.getNext();
            helper.setNext(first); //妙阿
        }
        System.out.println("最后生存者是"+first.getNo()+"号");

    }
}

//节点类
class Boy{
    private int no;
    private Boy next;
    public Boy(int no)   //构造方法
    {
        this.no=no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
