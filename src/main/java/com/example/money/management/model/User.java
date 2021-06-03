package com.example.money.management.model;

import java.util.Objects;

//will work on this class more after figuring out how to use mysql in springboot
public class User {
    private String username;
    private double cashAmount;
    private double netsAmount;
    private double totalBalance;

    public User() {
    }

    public User(String username, double cashAmount, double netsAmount, double totalBalance) {
        this.username = username;
        this.cashAmount = cashAmount;
        this.netsAmount = netsAmount;
        this.totalBalance = totalBalance;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getCashAmount() {
        return this.cashAmount;
    }

    public void setCashAmount(double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public double getNetsAmount() {
        return this.netsAmount;
    }

    public void setNetsAmount(double netsAmount) {
        this.netsAmount = netsAmount;
    }

    public double getTotalBalance() {
        return this.totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, cashAmount, netsAmount, totalBalance);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", cashAmount='" + getCashAmount() + "'" +
            ", netsAmount='" + getNetsAmount() + "'" +
            ", totalBalance='" + getTotalBalance() + "'" +
            "}";
    }


}
