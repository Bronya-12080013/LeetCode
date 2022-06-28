package 测试;

import com.sun.jndi.ldap.Connection;

import java.text.Collator;
import java.util.*;
import java.util.stream.Stream;

public class 排序 {
    public static void main(String[] args) {
        int [] nums={1,4,8,6,2,0,9,5,3,4};
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(8);
        arrayList.add(6);
        arrayList.add(2);
        arrayList.add(0);
        arrayList.add(9);
        arrayList.add(5);
        arrayList.add(3);
        arrayList.add(4);
        //排序:
        Collections.sort(arrayList);  //对List Set Map
        Arrays.sort(nums);            //对数组
     //   Arrays.sort(nums,0,3);
        for(int i =0;i< nums.length;i++)
            System.out.print(arrayList.get(i));
        System.out.println("");
        for(int i =0;i< nums.length;i++)
            System.out.print(nums[i]);
    }
}
