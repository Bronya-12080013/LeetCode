
/*
获取时间的各个方法
 */
/*
抽象类
Calendar 在 Java 中是一个抽象类(Abstract Class)
https://blog.csdn.net/wei_zhi/article/details/52736350?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522163826477516780255251633%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=163826477516780255251633&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-1-52736350.first_rank_v2_pc_rank_v29&utm_term=%E6%8A%BD%E8%B1%A1%E7%B1%BBjava&spm=1018.2226.3001.4187
 */

package utils.时间;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Time {
    public static void main(String[] args) {
        //重要的日期格式化 牢记
        //注意: 月MM 和 时HH 要大写
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        //Calendar  getTime()  注意它的构造方法不同
        Calendar calendar = Calendar.getInstance();
        System.out.println(formatter.format(calendar.getTime()));
        /*
        Calendar 在 Java 中是一个抽象类(Abstract Class)，GregorianCalendar 是它的一个具体实现。
        Calendar是一个日历类
        首先, 从类名定义可以看出它实现了Serializable, Cloneable, Comparable接口。
        And, 实现了Comparable就意味着可以使用Arrays.sort的方法对多个Calendar对象进行排序。
        注意:
        月份从0开始算起 !!!
        星期天为一周的第一天
        时间推移使用add
        不能对日期进行格式化，可以转为Date类型后格式化。
         */

        //Date  getTime()
        Date date = new Date();
        System.out.println(formatter.format(date.getTime()));

        //System.currentTimeMillis()
        System.out.println(formatter.format(System.currentTimeMillis()));
        //也可以联系Date
        Date time = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(time));

        //注意下面三者的构造 参考上面的Calendar
        //注意: 月MM 和 时HH 要大写
        //注意: 格式化不能用SimpleDateFormat了

        //LocalDate 只能得日期
        LocalDate date02 = LocalDate.now(); // get the current date
        DateTimeFormatter formatter02 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println(date02.format(formatter02));

        //LocalTime 只能得时间
        LocalTime time01 = LocalTime.now();
        DateTimeFormatter formatter01 = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(time01.format(formatter01));

        //LocalDateTime  !!!!!!!!!!
        //LocalDateTime，也是Java中最常用的Date / Time类，代表前两个类的组合 - 即日期和时间的值
        LocalDateTime dateTime = LocalDateTime.now(); // get the current date and time
        DateTimeFormatter formatter03 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(dateTime.format(formatter03));
    }
}
