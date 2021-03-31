package BrainBank.Location;

public class Bank {

    private String title;
    private String address;
    private static int BankCount;

    public Bank(String title, String address) {
        BankCount++;
        this.title = title;
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static int getBankCount() {
        return BankCount;
    }

    public static void setBankCount(int bankCount) {
        BankCount = bankCount;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "title='" + title + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
