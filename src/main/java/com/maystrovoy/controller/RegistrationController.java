package com.maystrovoy.controller;

import com.maystrovoy.model.RegistrationFormData;
import com.maystrovoy.service.PersonService;
import com.maystrovoy.validator.RegistrationDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller
public class RegistrationController {

    private static final Logger LOGGER = LogManager.getLogger(RegistrationController.class);

    @Inject
    private PersonService personService;


    @Named("registrationDataValidator")
    @Inject
    private RegistrationDataValidator registrationDataValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(registrationDataValidator);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    private ModelAndView showRegistrationForm() {
        final ModelAndView mov = new ModelAndView("registration");
        mov.addObject("registrationFormData", new RegistrationFormData());
        return mov;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    private ModelAndView checkRegistrationForm(@ModelAttribute() @Valid final RegistrationFormData registrationFormData, BindingResult bindingResult) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        final ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            LOGGER.error("Error into register new person: " + registrationFormData.getPerson().getLoginName() + " " + bindingResult.getFieldError());
            mav.setViewName("registration");
        } else {
            personService.registerPerson(registrationFormData.getPerson());
            LOGGER.info("Successfully register new person: " + registrationFormData.getPerson().getLoginName());
            mav.setViewName("redirect:/authentication");
        }
        return mav;
    }

}
