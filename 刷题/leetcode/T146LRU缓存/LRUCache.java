/*
非常有意思的一题
长话短说 就是  哈希表 + 双向链表
要好好好好地理清它们的关系
两者独立又有关联
构造一个双向链表 也就是写一个可以双向的节点
class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }
把节点们相连就是链表，双向链表
这个节点有key 又有value
然后 又把key作为键 节点DLinkedNode为值 构造哈希表
注意注意注意注意 哈希是 映射 关系
节点们并不是拆开放入哈希的 ！！！ 节点们依然是上下串联着的 构成双向链表的 ！！！
哈希只是映射关系 节点们不分散
基于这种数据结构来实现本题 可以通过哈希映射来找到相应节点 节点们不分散 是上下连着的 我们就可以直接对着这个节点操作
所以要摆脱哈希的固有印象 认识到哈希是映射 可以快速查询 查询到的对象不是独立的 他们不是一定为了哈希才放进 而是它们在各个地方 为了好找 才有的哈希
说多了 总之 哈希不是箱子 是线
好好看看 好好理清它
=========================================================
另外 其实不需要手写本题 已有封装类了 不懂就算了
是 LinkedHashMap
本题答案 (用LinkedHashMap)
class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    public LRUCache(int capacity) {

        super(capacity, 0.75F, true); //super(参数)：调用父类中的某一个构造函数（应该为构造函数中的第一条语句）。
        //即搞这个 LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) 构造一个空的 LinkedHashMap实例，具有指定的初始容量，负载因子和订购模式。
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    //这个应该是它内部的要用 //见jdk
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
=================================================
官方代码 哈希表 + 双向链表 （手写）
public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

 */

package 刷题.leetcode.T146LRU缓存;

import java.util.HashMap;
import java.util.Map;

//模仿官方代码
public class LRUCache {

    class DLinkedNode {
        int key;
        int val;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){};  //别写成public DLinkedNode();  //无参构造
        public DLinkedNode(int k,int v){key=k;val=v;}       //有参构造
    }


    private HashMap<Integer,DLinkedNode> cache = new HashMap<>();
    private DLinkedNode head ;
    private DLinkedNode tail ;
    private int size,capacity; //我在这蒙了一会 //size从0开始 实时记录数据多少  而capacity是容量 当 if (size > capacity) 如果超出容量，删除双向链表的尾部节点
    //要注意 现在是写实现类 下面初始话的capacity是不能一直陪伴我们的 要搞个全局变量记录它

    //下面的写不写this有什么区别? 答: 又不是全部都是新new的 全局变量和局部变量相同(参数) 就用this区分 如  this.capacity=capacity;
    public LRUCache(int capacity) {
         head = new DLinkedNode();  //当然 这些也可以写成 this.XXX
        tail = new DLinkedNode();
        head.next=tail;
        tail.prev = head;
        this.size = 0;
        this.capacity=capacity;  //见上
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node==null) return -1;
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node==null)
        {
            DLinkedNode newNode = new DLinkedNode(key,value);
            cache.put(key,newNode);
            addToHead(newNode);  //这里不要写错成node了！！！  否则会在addToHead(DLinkedNode node)方法里报莫名奇妙的错误 我还以为是方法写错了
            size++;
            if(size>capacity)
            {
                DLinkedNode tail = removeTail(); //removeTail()已经执行了
                cache.remove(tail.key);           //又 cache.remove()
                size--;
            }
        }else {
            node.val=value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        node.prev=head;
    }

    //注意 DLinkedNode是个双端链表(节点)
    //这个方法主要是方便方法moveToHead()和 removeTail() 不把它抽出来也行的
    private void removeNode(DLinkedNode node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    //善于利用其他方法
    //不需要检索的 都是直接删的 毕竟这是链表啊！！！
    //至于存在与否 上面会用哈希表判断的
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        //DLinkedNode node = tail.prev;
        //tail.prev.prev.next=tail;
        //tail.prev=tail.prev.prev;
        //return node;

        //上面的也行 但要善于把通用的方法拿出来
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }
}
