import java.util.Scanner;

public class TestSite {

    private int siteID;
    private String city;
    private String name;
    private OpenTime openTime;
    public TestSite(int siteID, String city, String name, OpenTime openTime) {
        this.siteID = siteID;
        this.city = city;
        this.name = name;
        this.openTime = openTime;
    }

    public TestSite() {
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入核酸检测点信息(ID, 城市, 检测点名称):");
        int id = input.nextInt();
        String city = input.next();
        String name = input.next();
        System.out.println("创建开放时间...");
        OpenTime openTime = new OpenTime();
        System.out.println("创建核酸检测点...");
        this.siteID = id;
        this.city = city;
        this.name = name;
        this.openTime = openTime;
        System.out.println("成功创建核酸检测点.");
    }

    @Override
    public String toString() {
        return  "ID: " + this.siteID + "\n" +
                "城市: " + this.city + "\n" +
                "检测点名称: " + this.name + "\n" +
                "开放时间: " + openTime.toString();
    }

    public int getSiteID() {
        return siteID;
    }

    public void setSiteID(int siteID) {
        this.siteID = siteID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OpenTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(OpenTime openTime) {
        this.openTime = openTime;
    }
}
