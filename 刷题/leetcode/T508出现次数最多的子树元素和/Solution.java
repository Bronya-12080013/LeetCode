package 刷题.leetcode.T508出现次数最多的子树元素和;

import java.util.*;

/*
1.
遍历hashmap的方法！！！
http://t.csdn.cn/9hyOG
本题出现了对hashmap键值对遍历的方法：

 HashMap<Integer,Integer> hashMap = new HashMap<>();
Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int key = entry.getKey();  //num
            int val = entry.getValue(); //count
            }

================================================
2.  ArrayList可以直接转为  Integer[] ,但不能直接变成int[]
只能用for变成int[]

   ArrayList<Integer> list = new ArrayList<Integer>();
   Integer[] arr = list.toArray(new Integer[list.size()]);
 */

//31.88% && 66.51%
/*
用excute递归，自下而上把数叠加，并记入hashmap 元素和——出现次数
对hashmap遍历 记入map  出现次数——相同key对应的元素 记录max
以max，在map中找结果
 */
class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left= new TreeNode(2);
        root.right= new TreeNode(-3);
        findFrequentTreeSum(root);
    }
    static public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        excute(root,hashMap);

        int max = Integer.MIN_VALUE;
        HashMap<Integer,ArrayList> map = new HashMap<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int key = entry.getKey();  //num
            int val = entry.getValue(); //count
            if(!map.containsKey(val))
            {
                ArrayList<Integer> list = new ArrayList();
                list.add(key);
                map.put(val,list);
            }else {
                ArrayList<Integer> list = map.get(val);
                list.add(key);
            }
            max = Math.max(max,val);
        }
        ArrayList<Integer> list = map.get(max);
        Integer[] arr = list.toArray(new Integer[list.size()]);
        int[] res = new int[arr.length];
        for (int i=0;i<arr.length;i++) res[i]=arr[i];
        return res;
    }

    static int excute(TreeNode node,HashMap<Integer,Integer> hashMap){
        if(node==null) return 0;
        node.val=node.val+excute(node.left,hashMap)+excute(node.right,hashMap); //记得加上自己的值
        hashMap.put(node.val,hashMap.getOrDefault(node.val,0)+1);
        return node.val;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }