import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) {
        ArrayList<WeekDay> weekDays = new ArrayList<>();
        weekDays.add(WeekDay.Mon);
        weekDays.add(WeekDay.Tue);
        weekDays.add(WeekDay.Wen);
        weekDays.add(WeekDay.Thu);
        weekDays.add(WeekDay.Fri);
        TimePeriod period1 = new TimePeriod("8:00", "12:10");
        TimePeriod period2 = new TimePeriod("14:00", "21:50");
        ArrayList<TimePeriod> timePeriods = new ArrayList<>();
        timePeriods.add(period1);
        timePeriods.add(period2);
        OpenTime openTime = new OpenTime(weekDays, timePeriods);
        TestSite site1 = new TestSite(1000, "Shenzhen", "南方科技大学检测点", openTime);
        ArrayList<WeekDay> weekDays2 = new ArrayList<>();
        weekDays2.add(WeekDay.Mon);
        weekDays2.add(WeekDay.Wen);
        weekDays2.add(WeekDay.Fri);
        OpenTime openTime2 = new OpenTime(weekDays2, timePeriods);
        TestSite site2 = new TestSite(1001, "Shenzhen", "深圳大学检测点", openTime2);
        TestSite site3 = new TestSite(1003, "Beijing", "清华大学检测点", openTime2);
        System.out.println(site1);
        System.out.println(site2);
        System.out.println(site3);
        Customer c1 = new Customer("007", "王大山", 20);
        System.out.println(c1);
        ArrayList<Customer> cList = new ArrayList<>();
        cList.add(c1);
        cList.add(new Customer("011", "张三", 21));
        cList.add(new Customer("012", "李四", 23));
        cList.add(new Customer("013", "王五", 19));
        NATest naTest = new NATest(cList, site1, "2023年1月8日15:03:25");
        System.out.println(naTest);
    }
}