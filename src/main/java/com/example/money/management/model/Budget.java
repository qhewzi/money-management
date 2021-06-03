package com.example.money.management.model;

import java.util.Objects;

public class Budget {
    //may change this to String category coz this category class feels useless
    private Category category;
    private double amount;
    private String user;

    public Budget(String category, double amount, String user) {
        this.category = new Category(category);
        this.amount = amount;
        this.user = user;
    }

    public String getCategory() {
        return this.category.toString();
    }

    public void setCategory(String category) {
        this.category = new Category(category);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Budget)) {
            return false;
        }
        Budget budget = (Budget) o;
        return budget.getCategory().equals(this.category.toString()) && budget.getUser().equals(this.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, amount);
    }

    @Override
    public String toString() {
        return "{" +
            " category='" + getCategory() + "'" +
            ", amount='" + getAmount() + "'" +
            "}";
    }

}
