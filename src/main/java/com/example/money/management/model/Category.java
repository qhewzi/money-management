package com.example.money.management.model;

import java.util.Objects;
//its actually 99/100 useless but i will leave it first since xiao heartpain to delete
public class Category {
    // private boolean breakfast;
    // private boolean lunch;
    // private boolean dinner;
    // private boolean snack;
    // private boolean drink;
    private boolean food = false;
    private boolean transportation = false;
    private boolean shopping = false;
    private boolean entertainment = false;
    private boolean groceries = false;
    private boolean housing = false;
    private boolean others = false;

    public Category(String categoryS) {
        if (categoryS.equals("Food")) {
            this.food = true;
        } else if (categoryS.equals("Transportation")) {
            this.transportation = true;
        } else if (categoryS.equals("Shopping")) {
            this.shopping = true;
        } else if (categoryS.equals("Entertainment")) {
            this.entertainment = true;
        } else if (categoryS.equals("Groceries")) {
            this.groceries = true;
        } else if (categoryS.equals("Housing")) {
            this.housing = true;
        } else {
            this.others = true;
        }
    }
    // public Category(boolean food, boolean transportation, boolean shopping, boolean entertainment, boolean groceries, boolean housing) {
    //     this.food = food;
    //     this.transportation = transportation;
    //     this.shopping = shopping;
    //     this.entertainment = entertainment;
    //     this.groceries = groceries;
    //     this.housing = housing;
    // }

    public boolean isFood() {
        return this.food;
    }

    public boolean getFood() {
        return this.food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isTransportation() {
        return this.transportation;
    }

    public boolean getTransportation() {
        return this.transportation;
    }

    public void setTransportation(boolean transportation) {
        this.transportation = transportation;
    }

    public boolean isShopping() {
        return this.shopping;
    }

    public boolean getShopping() {
        return this.shopping;
    }

    public void setShopping(boolean shopping) {
        this.shopping = shopping;
    }

    public boolean isEntertainment() {
        return this.entertainment;
    }

    public boolean getEntertainment() {
        return this.entertainment;
    }

    public void setEntertainment(boolean entertainment) {
        this.entertainment = entertainment;
    }

    public boolean isGroceries() {
        return this.groceries;
    }

    public boolean getGroceries() {
        return this.groceries;
    }

    public void setGroceries(boolean groceries) {
        this.groceries = groceries;
    }

    public boolean isHousing() {
        return this.housing;
    }

    public boolean getHousing() {
        return this.housing;
    }

    public void setHousing(boolean housing) {
        this.housing = housing;
    }


    public boolean isOthers() {
        return others;
    }

    public void setOthers(boolean others) {
        this.others = others;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Category)) {
            return false;
        }
        Category category = (Category) o;
        return food == category.food && transportation == category.transportation && shopping == category.shopping && entertainment == category.entertainment && groceries == category.groceries && housing == category.housing && others == category.others;
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, transportation, shopping, entertainment, groceries, housing);
    }

    @Override
    public String toString() {
        if (food) {
            return "Food";
        } else if (transportation) {
            return "Transportation";
        } else if (shopping) {
            return "Shopping";
        } else if (entertainment) {
            return "Entertainment";
        } else if (groceries) {
            return "Groceries";
        } else if (housing){
            return "Housing";
        } else {
            return "Others";
        }
    }
}
