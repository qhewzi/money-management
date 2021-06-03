package com.example.money.management.model;

import java.util.Date;
//want to change it to spending + income but dk how to name it so i leave it first
//once i change the naming may create one more private char type to differentiate them
public class Spending {
	private int id;
	private String user;
    private String desc;
        //TODO!!!
    //change to category after figuring out how
    //or maybe not if im deleting the category class
    private double amount;
    private Date spendingDate;

    public Spending(int id, String user, String desc, double amount, Date spendingDate) {
        this.id = id;
        this.user = user;
        this.desc = desc;
        this.amount = amount;
        this.spendingDate = spendingDate;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getSpendingDate() {
        return spendingDate;
    }

    public void setSpendingDate(Date spendingDate) {
        this.spendingDate = spendingDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Spending other = (Spending) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "Spending [id=%s, user=%s, desc=%s, amount=%f, spendingDate=%s]", id,
                user, desc, amount, spendingDate);
    }

}
