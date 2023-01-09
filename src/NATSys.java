import java.util.ArrayList;
import java.util.Scanner;

public class NATSys {
    public static ArrayList<TestSite> testSiteList = new ArrayList<>();
    public static ArrayList<Customer> customerList = new ArrayList<>();
    private ArrayList<NATest> testRecord = new ArrayList<>();

    public void updateTestResult(int index){
        TestResult testResult;
        System.out.print("""
                请输入检测结果:
                0. 阴性 (Negative);
                1. 阳性 (Positive);
                2. 检测中 (Testing).
                """);
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()) {
            case 0 -> {
                testResult = TestResult.Negative;
                for (Customer customer:
                testRecord.get(index).getCustomers()) {
                    customer.setHealthCode(HealthCode.Green);
                }
            }
            case 1 -> {
                testResult = TestResult.Positive;
                for (Customer customer:
                        testRecord.get(index).getCustomers()) {
                    customer.setHealthCode(HealthCode.Yellow);
                    if (testRecord.get(index).getCustomers().size() == 1) {
                        customer.setHealthCode(HealthCode.Red);
                    }
                }
            }
            default -> {testResult = TestResult.Testing;}
        }
        testRecord.get(index).setTestResult(testResult);
        System.out.println("更新成功.");
    }

    public void viewTestSiteList() {
        int index = 0;
        for (TestSite site:
             testSiteList) {
            System.out.println(index + ". ID: " + site.getSiteID() + ", 城市: " + site.getCity() +
                    ", 名称: " + site.getName());
            index += 1;
        }
    }

    public void viewTestSite(int index) {
        System.out.println(testSiteList.get(index));
    }

    public void addTestSite(TestSite s1) {
        testSiteList.add(s1);
    }
    public void addTestSite() {
        Scanner input = new Scanner(System.in);
        int confirm = -1;
        while (confirm != 1) {
            TestSite testSite = new TestSite();
            System.out.println("请核对信息");
            System.out.println(testSite);
            System.out.println("0. 返回; 1. 确认");
            confirm = input.nextInt();
            if (confirm == 1) {
                this.testSiteList.add(testSite);
                System.out.println("成功添加检测点.");
            }
        }
    }

    public void removeTestSite(TestSite s1) {
        testSiteList.remove(s1);
    }

    public void removeTestSite(int index) {
        testSiteList.remove(index);
    }

    public void viewTestRecords() {
        int index = 0;
        for (NATest site:
                this.testRecord) {
            System.out.println(index + ". " + site);
            index += 1;
        }
    }

    public void addTestRecord(NATest t1) {
        testRecord.add(t1);
    }

    public void removeTestRecord(NATest t1) {
        testRecord.remove(t1);
    }

    public void viewCustomerList() {
        int index = 0;
        for (Customer site:
                customerList) {
            System.out.println(index + ". ID: " + site.getId() + ", 姓名: " + site.getName() +
                    ", 健康码状态: " + site.getHealthCode());
            index += 1;
        }
    }

    public void addCustomer() {
        Customer c1 = new Customer();
        customerList.add(c1);
    }
    public void addCustomer(Customer c1) {
        customerList.add(c1);
    }

    public void removeCustomer(Customer c1) {
        customerList.remove(c1);
    }

    public ArrayList<TestSite> getTestSiteList() {
        return testSiteList;
    }

    public void setTestSiteList(ArrayList<TestSite> testSiteList) {
        this.testSiteList = testSiteList;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        NATSys.customerList = customerList;
    }

    public ArrayList<NATest> getTestRecord() {
        return testRecord;
    }

    public void setTestRecord(ArrayList<NATest> testRecord) {
        this.testRecord = testRecord;
    }
}
