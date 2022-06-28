package 花与鸟与爱之矢一一数据结构与算法.稀疏数组SparseArray;

public class 稀疏数组的代码实现 {
    public static void main(String[] args) {
        int[][] chessArray =new int[11][11];
        chessArray[1][2]=1;
        chessArray[2][3]=2;
        System.out.println("原始数组");
        for(int[] row: chessArray)   //好厉害的增强for循环
        {
            for(int data : row)
            {
                System.out.print(data+" ");
            }
            System.out.print("\n");
        }

        System.out.println("转换为稀疏数组");
        int[][] sparseArray = trans(chessArray);
        for(int[] row : sparseArray)
        {
            for(int data : row)
            {
                System.out.print(data+" ");
            }
            System.out.print("\n");
        }

    }

    static int[][] trans(int[][] chessArray)
    {   int sum=0;
       for(int i=0;i<chessArray.length;i++)
       {
           for (int j=0;j<chessArray[i].length;j++)
           {
               if(chessArray[i][j]!=0)
               {
                   sum++;
               }
           }
       }
        int[][] sparseArray = new int[sum+1][3];
       sparseArray[0][0]=chessArray.length;
       sparseArray[0][1]=chessArray[0].length;
       sparseArray[0][2]=sum;
       int count=0;
        for(int i=0;i<chessArray.length;i++)
        {
            for (int j=0;j<chessArray[i].length;j++)
            {
                if(chessArray[i][j]!=0)
                {   count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=chessArray[i][j];
                }
            }
        }
        return sparseArray;
    }

}
