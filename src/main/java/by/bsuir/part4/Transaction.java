package by.bsuir.part4;

import java.util.Date;


public class Transaction {

    private final String who;
    private final Date when;
    private final double amount;

    private  int hash;



    public Transaction(String who, Date when, double amount, int hash) {
        this.who = who;
        this.when = when;
        this.amount = amount;
        this.hash = hash;
    }

    private int customHashCode(){
        hash = 17;
        hash = 31 * hash + who.hashCode();
        hash = 31 * hash + when.hashCode();
        hash = 31 * hash + ((Double)amount).hashCode();
        return hash;
    }



}
