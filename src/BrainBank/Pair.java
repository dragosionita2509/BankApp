package BrainBank;

import BrainBank.ClientSystem.IndividualClient;
import BrainBank.ServiceSystem.Loan;

public class Pair {

    private IndividualClient cl;
    private Loan l;

    public Pair(IndividualClient cl, Loan l) {
        this.cl = cl;
        this.l = l;
    }

    public IndividualClient getCl() {
        return cl;
    }

    public void setCl(IndividualClient cl) {
        this.cl = cl;
    }

    public Loan getL() {
        return l;
    }

    public void setL(Loan l) {
        this.l = l;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "cl=" + cl +
                ", l=" + l +
                '}';
    }
}
