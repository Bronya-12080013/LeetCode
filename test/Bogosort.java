//猴子排序
package 测试;

public class Bogosort {

    public static void main(String[] args) {
        int count = 0;
            int[] arr = {5, 3, 4, 1, 2};
            while (!isOrdered(arr)) {
                shuffle(arr);
                count++;
            }
            System.out.println("排序次数" + count);
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }


    //判断是否有序方法
    public static boolean isOrdered(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    //随机排序方法
    public static void shuffle(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            int j = (int)(Math.random() * arr.length);
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}

