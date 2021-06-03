package com.example.money.management.controller;

import javax.validation.Valid;

import com.example.money.management.model.Budget;
import com.example.money.management.model.Category;
import com.example.money.management.service.BudgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class BudgetController {
    @Autowired
    BudgetService service;

    @RequestMapping(value = "/list-budgets", method = RequestMethod.GET)
    public String showBudgets(ModelMap model) {
        String user = getLoggedInUserName(model);
        model.put("budgets", service.retrieveBudgets(user));
        return "list-budgets";
    }
    private String getLoggedInUserName(ModelMap model) {
        return (String) model.get("user");
    }

    //yea these two not working fine, the frontend was fine but the changes not reflected so whatever man
    //same code as spendingController yet different outcome idk how
    @RequestMapping(value = "/edit-budget", method = RequestMethod.GET)
    public String showEditBudgetPage(@RequestParam String user, @RequestParam String category, ModelMap model) {
        Budget budget = service.retrieveBudget(user, category);
        model.put("budget", budget);
        return "budget";
    }

    @RequestMapping(value = "/edit-budget", method = RequestMethod.POST)
    public String updateBudget(@Valid Budget budget, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "budget";
        }
        service.updateBudget(budget);
        return "redirect:/list-budgets";
    }
}
