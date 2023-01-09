import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Run run = new Run();
    }
    public Run() {
        NATSys sys = new NATSys();
        while (true) {
            int opt = selectOperation();
            if (opt == 1) {
                sys.viewTestSiteList();
                int siteOpt = -1;
                while (siteOpt != 0) {
                    siteOpt = selectSiteOpt();
                    switch (siteOpt) {
                        case 1 -> {
                            System.out.println("请输入要查询的核酸检测点序号:");
                            sys.viewTestSite(getInputNum());
                            System.out.println("查询完成.");
                        }
                        case 2 -> sys.addTestSite();
                        case 3 -> {
                            System.out.println("请输入要删除的核酸检测点序号:");
                            sys.removeTestSite(getInputNum());
                            System.out.println("成功删除.");
                        }
                    }
                }
            } else if (opt == 2) {
                int recordOpt = -1;
                while (recordOpt != 0) {
                    recordOpt = selectRecordOpt();
                    switch (recordOpt) {
                        case 1 -> { sys.viewTestRecords();}
                        case 2 -> {
                            NATest newTest = new NATest();
                            sys.addTestRecord(newTest);
                        }
                        case 3 -> {
                            System.out.println("请输入要更新的记录序号:");
                            int index = getInputNum();
                            sys.updateTestResult(index);
                        }
                        case 4 -> {
                            System.out.println("请输入要删除的记录序号:");
                            int index = getInputNum();
                            sys.removeTestRecord(sys.getTestRecord().get(index));
                            System.out.println("删除成功.");
                        }
                    }
                }
            } else if (opt == 3) {
                int customerOpt = -1;
                while (customerOpt != 0) {
                    customerOpt = selectCustomerOpt();
                    switch (customerOpt) {
                        case 1 -> {sys.viewCustomerList();}
                        case 2 -> {sys.addCustomer();}
                        case 3 -> {
                            System.out.println("请输入要注销的受检人序号:");
                            sys.removeCustomer(sys.getCustomerList().get(getInputNum()));
                        }
                    }
                }
            }
        }
    }

    private int selectCustomerOpt() {
        System.out.print("""
                请选择操作:
                1. 查看已注册受检人列表;
                2. 添加新的受检人;
                3. 注销受检人;
                0. 返回
                """);
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    private int selectSiteOpt() {
        System.out.print("""
                请选择操作:
                1. 查看核酸检测点;
                2. 添加新的核酸检测点;
                3. 删除核酸检测点;
                0. 返回
                """);
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private int selectRecordOpt() {
        System.out.print("""
                请选择操作:
                1. 查看检测记录;
                2. 添加新的检测记录;
                3. 更新检测结果;
                4. 删除检测记录;
                0. 返回
                """);
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    private int selectOperation() {
        System.out.print("""
                    请输入序号以选择操作:
                    1. 核酸检测点管理;
                    2. 核酸检测记录管理;
                    3. 受检人管理;
                    0. 退出系统.
                    """);
        int userInput = getInputNum();
        if (userInput == 0) {
            System.exit(0);
        }
        return userInput;
    }

    private String getInputStr() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    private int getInputNum() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
