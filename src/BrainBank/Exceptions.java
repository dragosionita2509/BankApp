package BrainBank;

import BrainBank.AccountType.Account;
import BrainBank.AccountType.CurrentAccount;
import BrainBank.AccountType.SavingsAccount;
import BrainBank.ClientSystem.IndividualClient;
import BrainBank.ClientSystem.UnregisteredClient;
import BrainBank.ServiceSystem.Deposit;
import BrainBank.ServiceSystem.Loan;
import BrainBank.ServiceSystem.Transaction;
import BrainBank.ServiceSystem.Withdrawal;

public class Exceptions {

    public boolean checkCurrAccount (CurrentAccount Acc) {
                if(Acc.getIBAN().length()!=24) return false;
                else if(Acc.getBalance()<0) return false;
                else if(Acc.getCurrency()!="USD" && Acc.getCurrency()!="EUR" && Acc.getCurrency()!="RON") return false;
                else return true;
    }

    public boolean checkSavingsAccount(SavingsAccount Acc) {
        if(Acc.getBalance()<0) return false;
        else if(Acc.getCurrency()!="USD" && Acc.getCurrency()!="EUR" && Acc.getCurrency()!="RON") return false;
        else if(Acc.getIBAN().length()!=24) return false;
        else if(Acc.getInterestRate()<0) return false;
        else if(Acc.getWithdrawLimit()<0) return false;
        else return true;
    }

    public boolean checkIndividualClient(IndividualClient Cl) {
                if(Cl.getAge()<18) return false;
                else if(Cl.getCNP().length()!=13) return false;
                else if(Cl.getFirst_name().length()<1) return false;
                else if(Cl.getLast_name().length()<1) return false;
                else return true;
    }

    public boolean checkUnregisteredClient(UnregisteredClient Cl) {
        if(Cl.getCNP().length()!=13) return false;
        else return true;
    }

    public boolean CheckDeposit(Deposit dep) {
        if(dep.getBank()==null) return false;
        else return true;
    }

    public boolean checkLoan(Loan loan) {
        if(loan.getStartingDate()==null) return false;
        else if(loan.getMonthlySum()<=0) return false;
        else if(loan.getStartingDate()==null) return false;
        else return true;
    }

    public boolean checkWithdrawal(Withdrawal w) {
        if(w.getamount()<=5) return false;
        else if(w.getDate()==null) return false;
        else return true;
    }

}
