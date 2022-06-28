package 花与鸟与爱之矢一一数据结构与算法.链表;

public class 双向链表DoubleStructures {
    public static void main(String[] args) {

    }
}

//创建双向链表
class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0,"","");
   //返回头节点
    public HeroNode2 getHead(){
        return head;
    }

    //遍历
    public void list()
    {
        if(head.next==null)
        {
            System.out.println("空空的");
            return;
        }
        HeroNode2 temp=head.next;
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
    //(在最后)添加
    public void add(HeroNode2 heroNode)
    {
        HeroNode2 temp = head;
        while (true)
        {
            if(temp.next==null)
            {
                break;
            }
            temp=temp.next;
        }
        temp.next=heroNode;
        heroNode.pre=temp;
    }
    //修改
    public void update(HeroNode2 newheroNode)
    {
        if(head.next==null)
        {
            System.out.println("链表为空~");
            return;
        }
        HeroNode2 temp= head.next;
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
        if(head.next==null)
        {
            System.out.println("链表为空，无法删除！");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true)
        {
            if(temp==null)
            {
                break;
            }
            if(temp.no==no)
            {
                flag = true;
                break;
            }
            temp=temp.next;
        }
        if(flag)
        {
            temp.pre.next=temp.next;
            if(temp.next!=null)
            {
                temp.next.pre=temp.pre;
            }
        }else {
            System.out.println("要删的节点找不到哦~");
        }
    }

}

class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no,String name,String nickname)
    {
        this.no=no;
        this.name=name;
        this.nickname=nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}
