package 花与鸟与爱之矢一一数据结构与算法.链表;

public class 单链表SingleLinkedListDemo {
    public static void main(String[] args) {

    }
}
//建立表对象
class SingleLinkedList{
    private HeroNode head = new HeroNode(0,"","");
    public void add(HeroNode heroNode)
    {
        HeroNode temp = head;
        while (true)
        {
            if(temp.next==null)
            {
                break;
            }
            temp=temp.next;
        }
        temp.next=heroNode;
    }
    //第二种添加，指定添加
    public void addByOrder(HeroNode heroNode)
    {
        HeroNode temp =head;
        boolean flag = false;
        while (true)
        {
            if (temp.next==null)
            {
                break;
            }
            if(temp.next.no>heroNode.no)
            {
                break;
            }else if(temp.next.no==heroNode.no)
            {
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag)
        {
            System.out.println("已经存在了，进不去，怎么想都进不去了");
        }else{
            heroNode.next=temp.next;
            temp.next=heroNode;          //画图理解   拉小弟的样子
        }
    }

    //修改节点信息
    public void update(HeroNode newheroNode)
    {
        if(head.next==null)
        {
            System.out.println("链表为空~");
            return;
        }
        HeroNode temp= head.next;
        boolean flag=false;
        while (true)
        {
            if(temp==null)
            {
                if(temp==null)
                {
                    break;
                }
                if(temp.no==newheroNode.no)
                {
                    flag=true;
                    break;
                }
                temp=temp.next;
            }
        }
        if(flag){
            temp.name= newheroNode.name;
            temp.nickname=newheroNode.nickname;
        }else {
            System.out.println("没用找到节点编号，节点被玩坏了，绝对不是idea的错哦");
        }

    }
    //删除节点
    public void del(int no)
    {
        HeroNode temp = head;
        boolean flag = false;
        while (true)
        {
            if(temp.next==null)
            {
                break;
            }
            if(temp.next.no==no)
            {
                flag = true;
                break;
            }
            temp=temp.next;
        }
        if(flag)
        {
            temp.next=temp.next.next;
        }else {
            System.out.println("要删的节点找不到哦~");
        }
    }


    public void list()
    {
        if(head.next==null)
        {
            System.out.println("空空的");
            return;
        }
        HeroNode temp=head.next;
        while (true)
        {
            if(temp==null)
            {
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }
}
//建立节点对象
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;  //名为next的HeroNode，是自己的同类
    //构造
    public HeroNode(int No,String Name,String Nickname)
    {
        this.no=No;
        this.name=Name;
        this.nickname=Nickname;
    }
    //便于显示方法，重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }



}
