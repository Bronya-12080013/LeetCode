package 刷题.leetcode.T138复制带随机指针的链表;

import java.util.*;


//回溯 + 哈希表  !!! 链表深复制（含支线）  ！！！hashMap<Node,Node> 妙用 由原节点领着前进
class Solution {
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);    //先是next一条路走到黑 然后才从后面连random的
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
/*
作者：LeetCode-Solution
        链接：https://leetcode.cn/problems/copy-list-with-random-pointer/solution/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-rblsf/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */
/*  我不行了
我无法给节点添加区别它们的唯一标志
class Solution {
    public Node copyRandomList(Node head) {
        ArrayList<Node> arrayList = new ArrayList();
        HashMap<Integer,Node> hashMap = new HashMap<>();
        int i=0;
        Node root = new Node(0);
        for (Node temp = head,r = root;temp!=null;temp=temp.next,r=r.next)
        {
            arrayList.add(new Node(temp.val));
            r.next = arrayList.get(i);
            hashMap.put(i,temp.random);
            i++;
        }
        for (int j=0;j<arrayList.size();j++)
        {
            Node node = arrayList.get(j);
            Node random = hashMap.get(j);
            if(random!=null) node.random=new Node(random.val);
            else node.random=null;
        }
        return root.next;
    }
}
 */

// Definition for a Node.
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