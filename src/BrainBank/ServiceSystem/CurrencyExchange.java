package BrainBank.ServiceSystem;

import BrainBank.Location.Bank;

public class CurrencyExchange implements OfflineService {

    private static float USDbuy = 4.07f;
    private static float USDsell = 4.27f;
    private static float EURbuy = 4.84f;
    private static float EURsell = 4.965f;
    private Bank bank;
    private String date;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public static float getUSDbuy() {
        return USDbuy;
    }

    public static void setUSDbuy(float USDbuy) {
        CurrencyExchange.USDbuy = USDbuy;
    }

    public static float getUSDsell() {
        return USDsell;
    }

    public static void setUSDsell(float USDsell) {
        CurrencyExchange.USDsell = USDsell;
    }

    public static float getEURbuy() {
        return EURbuy;
    }

    public static void setEURbuy(float EURbuy) {
        CurrencyExchange.EURbuy = EURbuy;
    }

    public static float getEURsell() {
        return EURsell;
    }

    public static void setEURsell(float EURsell) {
        CurrencyExchange.EURsell = EURsell;
    }

    public float RON_EUR(float val) {
        float res = val/EURsell;
        return res;
    }

    public float RON_USD(float val) {
        float res = val/USDsell;
        return res;
    }

    public float EUR_RON(float val) {
        float res = val*EURbuy;
        return res;
    }

    public float USD_RON(float val) {
        float res = val*USDbuy;
        return res;
    }

    public float USD_EUR(float val) {
        float res = USDbuy/EURbuy;
        return res;
    }

    public float EUR_USD(float val) {
        float res = EURbuy/USDbuy;
        return res;
    }

}
