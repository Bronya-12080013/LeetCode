package utils.降序排序;

public class 测试类 {
    public static void main(String[] args) {
        DescendingSort descendingSort = new DescendingSort();
        //Integer[] s={1,2,3,4,5};
        int[] b =new int[]{1,3,5,4,2};
        int[] a = descendingSort.descSort(b);
        for(int i =0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
    }
}
