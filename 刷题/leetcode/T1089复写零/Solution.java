package 刷题.leetcode.T1089复写零;

class Solution {
    public static void main(String[] args) {
        duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
    }
    static public void duplicateZeros(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i=0;i<arr.length;i++)
        {
            temp[i]=arr[i];
        }
        int count =0;
        for (int i =0;i<temp.length;i++)
        {
            arr[count]=temp[i];
            count++;
            if(count>=arr.length) break;
            if(temp[i]==0) {
                arr[count]=0;
                count++;
            }

            if (count>=arr.length) break;
        }
    }
}

/*
双指针
class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int top = 0;
        int i = -1;
        while (top < n) {
            i++;
            if (arr[i] != 0) {
                top++;
            } else {
                top += 2;
            }
        }
        int j = n - 1;
        if (top == n + 1) {
            arr[j] = 0;
            j--;
            i--;
        }
        while (j >= 0) {
            arr[j] = arr[i];
            j--;
            if (arr[i] == 0) {
                arr[j] = arr[i];
                j--;
            }
            i--;
        }
    }
}

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/duplicate-zeros/solution/fu-xie-ling-by-leetcode-solution-7ael/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */