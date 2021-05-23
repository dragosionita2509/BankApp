package BrainBank.ClientSystem;

import BrainBank.CardSystem.Card;

import java.util.ArrayList;

public class IndividualClient extends UnregisteredClient {

    private String first_name;
    private String last_name;
    private ArrayList<Card> cardList;
    private int age;

    public IndividualClient(String CNP, String first_name, String last_name, int age) {
        super(CNP);
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        cardList = new ArrayList<Card>();
    }

    public IndividualClient() {
        super();
        cardList = new ArrayList<Card>();
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public ArrayList<Card> getCardList() {
        return cardList;
    }

    public void setCardList(ArrayList<Card> cardList) {
        this.cardList = cardList;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addCard(Card card) {
        cardList.add(card);
    }

    @Override
    public String toString() {
        return "IndividualClient{" +
                "CNP='" + CNP + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", \ncardList=" + cardList +
                '}';
    }
}
