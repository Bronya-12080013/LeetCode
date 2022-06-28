package 刷题.leetcode.剑指Offer35复杂链表的复制;
/*
这题好难
首先是题目的理解
然后是实现
看看大佬的吧
第一个是用哈希表
第二个实在太太太太太太太太太太太太太太太太太太强了
====================================================================


 */

import java.util.HashMap;

/*

错误示例1：

class RangeFreqQuery {
    public Node copyRandomList(Node head) {
        HashMap hashMap = new HashMap();
        Node temp;
        Node prev;
        for (int i = 1; head != null; i++) {
            hashMap.put(i, head);
            head = head.next;
            Node node = head;
            temp = (Node) hashMap.get(i);
            prev = temp;
            temp = node;
        }
        temp = (Node) hashMap.get(1);
        return temp;

    }
}


 */


/*
失败2：
package 刷题.leetcode.剑指Offer35.复杂链表的复制;
class RangeFreqQuery {
    public Node copyRandomList(Node head) {
        HashMap hashMapVal = new HashMap();
        HashMap hashMapnext=new HashMap();
        HashMap hashMapRandom=new HashMap();
        Node temp=head;
        Node prev=null;
        Node p=null;
        Node s=head;
        for (int i = 1; s!= null; i++) {
            hashMapVal.put(i, s.val);
            hashMapnext.put(i,s.next);
            hashMapRandom.put(i,s.random);
            s=s.next;
        }
        for(int i=1;i<=hashMapVal.size();i++)
        {
            Node node=new Node((int)hashMapVal.get(i));
            node.next=(Node) hashMapnext.get(i);
            node.random=(Node) hashMapnext.get(i);
            temp.next=node;
            prev=temp;
            if(i==1)
            {
                p=prev;
            }

            temp=temp.next;
        }
            return p;

    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


 */

/*
大佬代码一:
class RangeFreqQuery {
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
 */

/*
大佬代码二:
class RangeFreqQuery {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }
}

 */


//我的修改版

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
        {
            return null;
        }
        for(Node node=head;node!=null;node=node.next.next)
        {
            Node nodeNew = new Node(node.val);                          //！！！！注意这里不要写成  Node nodeNew = head;
                                                                        //因为这样会把head的next和random也搞过来 相当与把这个链表都搞过来了（题目不能这样直接交）（而且这样nodeNew会变成替身）
                                                                        //Node nodeNew = new Node(node.val);  这样的nodeNew只会变成一个节点，val同head，next和random都是null
            nodeNew.next=node.next;
            node.next=nodeNew;
        }
        for(Node node=head;node!=null;node=node.next.next)
        {
            Node nodeNew=node.next;                                                 //为什么这里可以用替身
            nodeNew.random=(node.random!=null)? node.random.next:null;
        }
        Node headNew = head.next;
        for (Node node=head;node!=null;node=node.next)
        {
            Node nodeNew =node.next;                                               //这里也是，有替身
            node.next=node.next.next;
            nodeNew.next=(nodeNew.next!=null)?nodeNew.next.next:null;
        }
        return headNew;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}