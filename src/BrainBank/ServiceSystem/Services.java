package BrainBank.ServiceSystem;

import BrainBank.AccountType.CurrentAccount;
import BrainBank.Files.WriterClass;

public class Services {

    public static void makeTransaction(CurrentAccount a, CurrentAccount b, float amount, String date) {
        a.makeTransaction(b,amount,date);
        WriterClass.getInstance().logsWriter("makeTransaction");
    }

    public static float currencyExchange(float amount,String firstCurr, String secondCurr) throws Exception {
        float returnValue = 0;
        if(firstCurr=="RON")
        {
            if(secondCurr=="EUR")
                returnValue = CurrencyExchange.RON_EUR(amount);
                else if(secondCurr=="USD")
                    returnValue =  CurrencyExchange.RON_USD(amount);
                else throw new Exception("Nu se poate(first:RON)");
        }
        else if(firstCurr=="USD")
        {
            if(secondCurr=="RON")
                returnValue = CurrencyExchange.USD_RON(amount);
            else if(secondCurr=="EUR")
                returnValue = CurrencyExchange.USD_EUR(amount);
            else throw new Exception("Nu se poate(first:USD)");
        }
        else if(firstCurr=="EUR")
        {
            if(secondCurr=="RON")
                returnValue = CurrencyExchange.EUR_RON(amount);
            else if(secondCurr=="USD")
                returnValue = CurrencyExchange.EUR_USD(amount);
            else throw new Exception("Nu se poate(first:EUR");
        }

        WriterClass.getInstance().logsWriter("currencyExchange");
        return returnValue;
    }

    public static Loan makeLoan(String startingDate,int installments,float monthlySum) {
        Loan loan = new Loan(startingDate,installments,monthlySum);
        WriterClass.getInstance().logsWriter("makeLoan");
        return loan;
    }

}
