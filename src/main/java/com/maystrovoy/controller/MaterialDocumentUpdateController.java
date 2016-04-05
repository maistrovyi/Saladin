package com.maystrovoy.controller;

import com.maystrovoy.service.MaterialDocumentUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class MaterialDocumentUpdateController extends AbstractLoginController {

    @Autowired
    private MaterialDocumentUpdateService materialDocumentUpdateService;

    @RequestMapping(value = "update_material_document", method = RequestMethod.GET)
    public String showCheckStockForm() {
        return "update_material_document";
    }

    @RequestMapping(value = "update_material_document", method = RequestMethod.POST)
    public String processCheckStockForm(HttpServletRequest request) {
        Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);
        String year = currentYear.toString();
        String document = request.getParameter("document");
        String login = getPersonLoginName(request);
        materialDocumentUpdateService.processMaterialDocumentUpdate(year, document, login);
        return "redirect:/update_material_document";
    }
}
