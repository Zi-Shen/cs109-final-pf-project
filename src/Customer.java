import java.util.Scanner;

enum HealthCode{
    Green, Yellow, Red;
}
public class Customer {
    private String id;
    private String name;
    private int age;
    private HealthCode healthCode;

    public Customer(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        healthCode = HealthCode.Green;
    }

    public Customer() {
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入受检人信息 (ID, 姓名， 年龄):");
        this.id = input.next();
        this.name = input.next();
        this.age = input.nextInt();
        this.healthCode = HealthCode.Green;
        System.out.println("受检人注册成功.");
    }

    @Override
    public String toString() {
        return  "ID: " + id + '\n' +
                "姓名: " + name + '\n' +
                "年龄: " + age + '\n' +
                "健康码状态: " + healthCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public HealthCode getHealthCode() {
        return healthCode;
    }

    public void setHealthCode(HealthCode healthCode) {
        this.healthCode = healthCode;
    }
}
