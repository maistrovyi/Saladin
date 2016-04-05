package com.maystrovoy.controller;

import com.maystrovoy.service.MaterialDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class MaterialDocumentController extends AbstractLoginController {

    @Autowired
    private MaterialDocumentService materialDocumentService;

    @RequestMapping(value = "material_document", method = RequestMethod.GET)
    public String showCheckStockForm() {
        return "material_document";
    }

    @RequestMapping(value = "material_document", method = RequestMethod.POST)
    public String processCheckStockForm(HttpServletRequest request) {
        Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);
        String year = currentYear.toString();
        String document = request.getParameter("document");
        String login = getPersonLoginName(request);
        materialDocumentService.processMaterialDocument(year, document, login);
        return "redirect:/material_document";
    }

}
