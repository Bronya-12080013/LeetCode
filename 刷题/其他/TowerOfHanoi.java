package 刷题.其他;

public class TowerOfHanoi { //汉诺塔问题
    public static void main(String[] args) {
        hannuo(3,'A','B','C');
    }
    static void hannuo(int n,char A,char B,char C) //A有n个盘子，要放到C里，以B作为中介
    {
        if(n==1) System.out.println(A+"->"+C);
        else {
            hannuo(n-1,A,C,B);
            hannuo(1,A,B,C);
            hannuo(n-1,B,A,C);
        }
    }
}
