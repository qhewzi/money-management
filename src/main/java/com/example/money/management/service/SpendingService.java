package com.example.money.management.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.example.money.management.model.Spending;

import org.springframework.stereotype.Service;


@Service
public class SpendingService {
    private static List<Spending> spendings = new ArrayList<Spending>();
    private static int spendingCount = 3;

    //will delete after figuring out how to use mysql here
    static {
        spendings.add(new Spending(1, "username", "Food", 20, new Date()));
        spendings.add(new Spending(2, "username", "Transportation", 30, new Date()));
        spendings.add(new Spending(3, "username", "Groceries", 60, new Date()));
    }

    public List<Spending> retrieveSpendings(String user) {
        List<Spending> filteredSpendings = new ArrayList<Spending>();
        for (Spending spending : spendings) {
            if (spending.getUser().equalsIgnoreCase(user)) {
                filteredSpendings.add(spending);
            }
        }
        return filteredSpendings;
    }
    
    public Spending retrieveSpending(int id) {
        for (Spending spending : spendings) {
            if (spending.getId()==id) {
                return spending;
            }
        }
        return null;
    }

    public void updateSpending(Spending spending){
        spendings.remove(spending);
        spendings.add(spending);
    }

    public void addSpending(String user, String desc, double amount, Date spendingDate) {
        spendings.add(new Spending(++spendingCount, user, desc, amount, spendingDate));
    }

    public void deleteSpending(int id) {
        Iterator<Spending> iterator = spendings.iterator();
        while (iterator.hasNext()) {
            Spending spending = iterator.next();
            if (spending.getId() == id) {
                iterator.remove();
            }
        }
    }
}
