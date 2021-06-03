package com.example.money.management.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.money.management.model.Budget;
// import com.example.money.management.model.Category;

import org.springframework.stereotype.Service;

@Service
public class BudgetService {
    private static List<Budget> budgets = new ArrayList<Budget>();

    //will delete after figuring out how to use mysql here
    static {
        budgets.add(new Budget("Food", 300.00, "username"));
        budgets.add(new Budget("Transportation", 100.00, "username"));
        budgets.add(new Budget("Shopping", 200.00, "username"));
        budgets.add(new Budget("Entertainment", 200.00, "username"));
        budgets.add(new Budget("Groceries", 100.00, "username"));
        budgets.add(new Budget("Housing", 500.00, "username"));
        budgets.add(new Budget("Others", 200.00, "username"));

    }

    public List<Budget> retrieveBudgets(String user) {
        List<Budget> filteredBudgets = new ArrayList<Budget>();
        for (Budget budget : budgets) {
            if (budget.getUser().equals(user)) {
                filteredBudgets.add(budget);
            }
        }
        return filteredBudgets;
    }

    public Budget retrieveBudget (String user, String category) {
        for (Budget budget : budgets) {
            if (budget.getUser().equals(user) && budget.getCategory().equals(category)) {
                return budget;
            }
        }
        return null;
    }

    public void addBudget(String category, double amount, String user) {
        budgets.add(new Budget(category, amount, user));
    }

    // public void updateBudget(String category, double amount, String user) {
    //     Budget budget = retrieveBudget(user, category);
    //     if (budget != null) {
    //         budgets.remove(budget);
    //     }
    //     Budget newBudget = new Budget(new Category(category), amount, user);
    //     budgets.add(newBudget);
    // }

    // public void updateBudget(String category, double amount, String user) {
    //     Budget budget = retrieveBudget(user, category);
    //     if (budget != null) {
    //         budgets.remove(budget);
    //     }
    //     Budget newBudget = new Budget(category, amount, user);
    //     if (newBudget == null) {
    //         budgets.add(new Budget("testing", 300, "username"));
    //     } else {
    //         budgets.add(newBudget);
    //     }

    // }

    //somehow the update is not working for budget even though the code is the same
    //dk how to debug this alr whatever
    public void updateBudget(Budget budget) {
        budgets.remove(budget);
        budgets.add(budget);
    }

    public void deleteBudget(String user, String category) {
        Iterator<Budget> iterator = budgets.iterator();
        while (iterator.hasNext()) {
            Budget budget = iterator.next();
            if (budget.getUser().equals(user) && budget.getCategory().equals(category)) {
                iterator.remove();
            }
        }
    }

}
