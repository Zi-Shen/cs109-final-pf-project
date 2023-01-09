import java.util.ArrayList;
import java.util.Scanner;

enum TestResult{Positive, Negative, Testing}
public class NATest {
    private ArrayList<Customer> customers = new ArrayList<>();
    private TestSite testSite;
    private String testTime;
    private TestResult testResult;

    public NATest(ArrayList<Customer> customers, TestSite testSite, String testTime) {
        this.customers = customers;
        this.testSite = testSite;
        this.testTime = testTime;
        this.testResult = TestResult.Testing;
    }
    public NATest() {
        Scanner input = new Scanner(System.in);
        System.out.print("""
                请选择操作:
                1. 创建新的核酸检测点;
                2. 从已有的检测点中选择.
                """);
        if (input.nextInt() == 2) {
            System.out.println();
            System.out.println("请输入要添加的核酸检测点序号");
            int index = 0;
            for (TestSite c1:
                    NATSys.testSiteList) {
                System.out.println(index + ". " + c1.getSiteID() + c1.getCity() + c1.getName());
                index += 1;
            }
            int index1 = input.nextInt();
            this.testSite = NATSys.testSiteList.get(index1);
        } else {
            this.testSite = new TestSite();
            NATSys.testSiteList.add(this.testSite);
        }
        System.out.println("请输入检测时间:");
        this.testTime = input.next();
        int opt = -1;
        while (opt != 0) {
            System.out.println("""
                    请选择操作:
                    1. 添加新受检人;
                    2. 从已注册受检人中添加;
                    0. 完成.
                    """);
            opt = input.nextInt();
            if (opt == 1) {
                Customer c1 = new Customer();
                this.customers.add(c1);
                NATSys.customerList.add(c1);
                System.out.println("成功添加受检人.");
            } else if (opt == 2){
                System.out.println("请输入要添加的受检人序号");
                int index = 0;
                for (Customer c1:
                     NATSys.customerList) {
                    System.out.println(index + ". " + c1.getName());
                    index += 1;
                }
                index = input.nextInt();
                this.customers.add(NATSys.customerList.get(index));
                System.out.println("成功添加受检人.");
            }
        }
        this.testResult = TestResult.Testing;
    }

    @Override
    public String toString() {
        StringBuilder customersName = new StringBuilder(new String());
        for (Customer cus:
             customers) {
            customersName.append(cus.getName()).append(", ");
        }
        return  "受检人: " + customersName +
                ", 检测点:  " + testSite.getName() +
                ", 检测时间: " + testTime +
                ", 检测结果: " + testResult;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public TestSite getTestSite() {
        return testSite;
    }

    public void setTestSite(TestSite testSite) {
        this.testSite = testSite;
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    public TestResult getTestResult() {
        return testResult;
    }

    public void setTestResult(TestResult testResult) {
        this.testResult = testResult;
    }
}
