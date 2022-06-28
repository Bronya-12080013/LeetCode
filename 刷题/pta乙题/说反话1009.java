/*
   20/20,一遍过，这题是20分之耻
 */

package 刷题.pta乙题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 说反话1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        for(int i=strings.length-1;i>=0;i--)
        {
            System.out.print(strings[i]);
            if(i!=0)
            {
                System.out.print(" ");
            }
        }
    }
}
