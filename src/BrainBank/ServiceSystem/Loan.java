package BrainBank.ServiceSystem;

public class Loan implements OnlineService{

    private String startingDate;
    private int instalments;
    private float monthlySum;


    public Loan(String startingDate, int instalments, float amount) {
        this.startingDate = startingDate;
        this.instalments = instalments;
        this.monthlySum = amount/instalments + 0.05f*amount;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public int getInstallments() {
        return instalments;
    }

    public void setInstallments(int instalments) {
        this.instalments = instalments;
    }

    public float getMonthlySum() {
        return monthlySum;
    }

    public void setMonthlySum(float monthlySum) {
        this.monthlySum = monthlySum;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "startingDate='" + startingDate + '\'' +
                ", instalments=" + instalments +
                ", monthlySum=" + monthlySum +
                '}';
    }
}
