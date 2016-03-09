package com.maystrovoy.controller;

import com.maystrovoy.service.MaterialDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MaterialDocumentController {

    @Autowired
    private MaterialDocumentService materialDocumentService;

    @RequestMapping(value = "material_document", method = RequestMethod.GET)
    public String showCheckStockForm() {
        return "material_document";
    }

    @RequestMapping(value = "material_document", method = RequestMethod.POST)
    public String processCheckStockForm(HttpServletRequest request) {
        String year = request.getParameter("year");
        String document = request.getParameter("document");
        System.out.println(year + "_" + document);
        materialDocumentService.processMaterialDocument(year, document);
        return "redirect:/material_document";
    }

}
