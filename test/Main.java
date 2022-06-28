package 测试;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner s = new Scanner(System.in);
        StringBuffer br =new StringBuffer();
        int n = s.nextInt();
        String s1 = in.readLine();
        String s2 = in.readLine();
        br.append(s2);
        br.append(s2);
        if(br.toString().contains(s1)){
            System.out.println("wow");
        }else System.out.println("TAT");

    }
}
