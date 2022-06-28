package 测试;

import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 集合流的聚合操作 {
    public static void main(String[] args) {
        String[] names={
                "a","b","c","d","e"
        };
        int[] values={1,2,3,4,5,6,7};
        Stream.of(names).forEach(e->System.out.print(e+" "));
        System.out.println();
        IntStream.of(values).skip(3).forEach(e->System.out.print(e+" "));
    }
}
