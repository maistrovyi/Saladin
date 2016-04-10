package com.maystrovoy.controller;

import com.maystrovoy.model.MenuType;
import com.maystrovoy.service.CheckStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CheckStockController extends AbstractLoginDataController {

    @Autowired
    private CheckStockService checkStockService;

    @RequestMapping(value = "check_stock", method = RequestMethod.GET)
    public String showCheckStockForm(HttpServletRequest request) {
        return getMenuTypeAccordingToRole(request);
    }

    @RequestMapping(value = "check_stock", method = RequestMethod.POST)
    public String processCheckStockForm(HttpServletRequest request) {
        String location = request.getParameter("location");
        String material = request.getParameter("material");
        String login = getPersonLoginName(request);
        checkStockService.processCheckStock(location, material, login);
        return "redirect:/check_stock";
    }

    @Override
    protected MenuType getMenuTypeText() {
        return MenuType.CHECK_STOCK;
    }
}
