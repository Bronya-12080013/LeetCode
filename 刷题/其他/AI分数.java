/*
蓝桥杯题目 不难
分子用等比数列求和公式
分母都转成最大的那个 2^19
 */
package 刷题.其他;


import java.math.BigInteger;

public class AI分数 {
    public static void main(String[] args) {
        BigInteger two = BigInteger.valueOf(2);
        BigInteger molecule =two.pow(20).subtract(BigInteger.ONE); //分子
        BigInteger denominator = two.pow(19);//分母
        BigInteger gcd = molecule.gcd(denominator);//求最大公约数
        System.out.println(gcd);
        System.out.println(molecule.divide(gcd)+"/"+denominator.divide(gcd));
    }
}
