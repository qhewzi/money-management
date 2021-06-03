package com.example.money.management.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import com.example.money.management.model.Spending;
import com.example.money.management.service.SpendingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class SpendingController {
    
    @Autowired
    SpendingService service;

    //dk why this is not working because the date supposedly will have a 
    //calendar popup to choose a date instead of typing the date manually
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
    }

    @RequestMapping(value = "/list-spendings", method = RequestMethod.GET)
    public String showSpendings(ModelMap model) {
        String name = getLoggedInUserName(model);
        model.put("spendings", service.retrieveSpendings(name));
        return "list-spendings";
    }

    private String getLoggedInUserName(ModelMap model) {
        return (String) model.get("user");
    }

    @RequestMapping(value = "/add-spending", method = RequestMethod.GET)
    public String showAddSpendingPage(ModelMap model) {
        model.addAttribute("spending", new Spending(0, getLoggedInUserName(model), "Default Desc", 0, new Date()));
        return "spending";
    }

    @RequestMapping(value = "/add-spending", method = RequestMethod.POST)
    public String addSpending(ModelMap model, @Valid Spending spending, BindingResult result) {
        if (result.hasErrors()) {
            return "spending";
        }
        service.addSpending(getLoggedInUserName(model), spending.getDesc(), spending.getAmount(), spending.getSpendingDate());
        return "redirect:/list-spendings";
    }

    @RequestMapping(value = "/delete-spending", method = RequestMethod.GET)
    public String deleteSpending(@RequestParam int id) {
        service.deleteSpending(id);
        return "redirect:/list-spendings";
    }

    @RequestMapping(value = "/update-spending", method = RequestMethod.GET)
    public String showUpdateSpendingPage(@RequestParam int id, ModelMap model) {
        Spending spending = service.retrieveSpending(id);
        model.put("spending", spending);
        return "spending";
    }

    @RequestMapping(value = "/update-spending", method = RequestMethod.POST)
    public String updateSpending(@Valid Spending spending, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "spending";
        }
        spending.setUser(getLoggedInUserName(model));
        service.updateSpending(spending);
        return "redirect:/list-spendings";
    }
}
