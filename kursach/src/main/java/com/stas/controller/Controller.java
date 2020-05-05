package com.stas.controller;

import com.stas.CRUD;
import com.stas.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private CRUD crud;

    @RequestMapping("/")
    public String openLoginPage() {
        return "authorization";
    }

    @RequestMapping("/accounts")
    public String openUsersPage(Model model) {
        List<Account> listAccounts = crud.getAllAccounts();
        model.addAttribute("listAccounts", listAccounts);
        return "accounts";
    }

    @RequestMapping("/new")
    public String openNewAccountPage(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "newAccount";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView openEditAccountPage(@PathVariable(name = "id") int id) {
        ModelAndView modAndV = new ModelAndView("editAccount");
        Account acc = crud.getAccount(id);
        modAndV.addObject("account", acc);
        return modAndV;
    }

    @RequestMapping("/creditDet/{id}")
    public ModelAndView openCreditAddPage(@PathVariable(name = "id") int id) {
        ModelAndView modAndV = new ModelAndView("creditDetail");
        Account acc = crud.getAccount(id);
        modAndV.addObject("account", acc);
        return modAndV;
    }

    @RequestMapping("/depositDet/{id}")
    public ModelAndView openDepositAddPage(@PathVariable(name = "id") int id) {
        ModelAndView modAndV = new ModelAndView("depositDetail");
        Account acc = crud.getAccount(id);
        modAndV.addObject("account", acc);
        return modAndV;
    }

    @RequestMapping("/detail/{id}")
    public ModelAndView openDetailPage(@PathVariable(name = "id") int id) {
        ModelAndView modAndV = new ModelAndView("detailAccount");
        Account acc = crud.getAccount(id);
        modAndV.addObject("account", acc);
        return modAndV;

    }

    @RequestMapping("/addCredit/{id}")
    public ModelAndView openAddCreditPage(@PathVariable(name = "id") int id) {
        ModelAndView modAndV = new ModelAndView("addCredit");
        Account acc = crud.getAccount(id);
        modAndV.addObject("account", acc);
        // List<Account> accountsCredits = crud.accountsCredits();
        return modAndV;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAccount(@ModelAttribute("account") Account acc) {
        crud.addAccount(acc);
        return "redirect:/accounts";
    }

    @RequestMapping(value = "/saveDetail", method = RequestMethod.POST)
    public String saveCreditDetails(@ModelAttribute("account") Account acc) {
        crud.addAccount(acc);
        return "redirect:/detail/" + acc.getId();
    }

    @RequestMapping(value = "/back", method = RequestMethod.POST)
    public String BackToAccount(@ModelAttribute("account") Account acc) {
        return "redirect:/accounts";
    }

    @RequestMapping("/delete/{id}")
    public String deleteAccount(@PathVariable(name = "id") int id) {
        crud.deleteAccount(id);
        return "redirect:/accounts";
    }

    @RequestMapping(value = "/payCredit/{id}", method = RequestMethod.POST)
    public String PayCredit(@PathVariable(name = "id") int id) {
        Account acc = crud.getAccount(id);
        acc.setValue(acc.getValue() - ((acc.getCreditvalue() * (acc.getCreditpercent() / 100)) + acc.getCreditvalue()));
        acc.setCreditdate("0000-00-00");
        acc.setCreditname("No bank");
        acc.setCreditpercent(0);
        acc.setCreditvalue(0);
        crud.addAccount(acc);
        return "redirect:/detail/" + acc.getId();
    }

    @RequestMapping(value = "/payDeposit/{id}", method = RequestMethod.POST)
    public String PayDeposit(@PathVariable(name = "id") int id) {
        Account acc = crud.getAccount(id);
        acc.setValue(acc.getValue() + ((acc.getDepositvalue() * (acc.getDepositpercent() / 100)) + acc.getDepositvalue()));
        acc.setDepositdate("0000-00-00");
        acc.setDepositname("No bank");
        acc.setDepositpercent(0);
        acc.setDepositvalue(0);
        crud.addAccount(acc);
        return "redirect:/detail/" + acc.getId();
    }

}
