package com.maystrovoy.controller;

import com.maystrovoy.model.MenuType;
import com.maystrovoy.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MaterialController extends AbstractLoginDataController {

    @Autowired
    private MaterialService materialService;

    @RequestMapping(value = "simple_material", method = RequestMethod.GET)
    public String showCheckStockForm(HttpServletRequest request) {
        return getMenuTypeAccordingToRole(request);
    }

    @RequestMapping(value = "simple_material", method = RequestMethod.POST)
    public String processCheckStockForm(HttpServletRequest request) {
        String material = request.getParameter("material");
        String login = getPersonLoginName(request);
        materialService.processMaterial(material, login);
        return "redirect:/simple_material";
    }

    @Override
    protected MenuType getMenuTypeText() {
        return MenuType.MATERIAL;
    }
}
