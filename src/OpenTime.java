import java.util.ArrayList;
import java.util.Scanner;

enum WeekDay{Mon, Tue, Wen, Thu, Fri, Sat, Sun;}
record TimePeriod(String startTime, String endTime) {
    @Override
    public String toString() {
        return startTime + "~" + endTime;
    }
}
public class OpenTime {
    private ArrayList<WeekDay> weekdays = new ArrayList<>();
    private ArrayList<TimePeriod> timePeriods = new ArrayList<>();

    public OpenTime(ArrayList<WeekDay> weekdays, ArrayList<TimePeriod> timePeriods) {
        this.weekdays = weekdays;
        this.timePeriods = timePeriods;
    }

    public OpenTime() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入开放周次(1~7分别代表周一至周日，输入0停止输入): ");
        int inputNum = -1;
        while (inputNum != 0) {
            inputNum = input.nextInt();
            if (inputNum == 1) {
                this.weekdays.add(WeekDay.Mon);
            } else if (inputNum == 2) {
                this.weekdays.add(WeekDay.Tue);
            } else if (inputNum == 3) {
                this.weekdays.add(WeekDay.Wen);
            } else if (inputNum == 4) {
                this.weekdays.add(WeekDay.Thu);
            } else if (inputNum == 5) {
                this.weekdays.add(WeekDay.Fri);
            } else if (inputNum == 6) {
                this.weekdays.add(WeekDay.Sat);
            } else if (inputNum == 7) {
                this.weekdays.add(WeekDay.Sun);
            }
        }
        inputNum = -1;
        while (inputNum != 2) {
            System.out.println("""
                    请输入选项: 
                    1. 添加时间段;
                    2. 完成.
                    """);
            inputNum = input.nextInt();
            if (inputNum == 1) {
                System.out.println("请输入起始时间:");
                String startTime = input.next();
                System.out.println("请输入终止时间:");
                String endTime = input.next();
                TimePeriod timePeriod = new TimePeriod(startTime, endTime);
                this.timePeriods.add(timePeriod);
                System.out.println("成功添加时间段.");
            }
        }
        System.out.println("开放时间创建成功.");
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(new String());
        for (WeekDay weekday : weekdays) {
            out.append(weekday.toString()).append(", ");
        }
        out.append("(");
        int counter = 0;
        for (TimePeriod timePeriod: timePeriods) {
            if (counter == timePeriods.size() - 1) {
                out.append(timePeriod.toString());
            } else {
                out.append(timePeriod.toString()).append(", ");
            }
            counter += 1;
        }
        out.append(")");
        return out.toString();
    }

    public ArrayList<WeekDay> getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(ArrayList<WeekDay> weekdays) {
        this.weekdays = weekdays;
    }

    public ArrayList<TimePeriod> getTimePeriods() {
        return timePeriods;
    }

    public void setTimePeriods(ArrayList<TimePeriod> timePeriods) {
        this.timePeriods = timePeriods;
    }
}
