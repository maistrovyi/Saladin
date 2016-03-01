//package com.maystrovoy.controller;
//
//import com.maystrovoy.model.RegistrationFormData;
//import com.maystrovoy.service.PersonService;
//import com.maystrovoy.validator.RegistrationDataValidator;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.inject.Inject;
//import javax.validation.Valid;
//
//@Controller
//public class RegistrationController {
//
//    @Inject
//    private PersonService personService;
//
//    @Inject
//    private RegistrationDataValidator registrationDataValidator;
//
//    @InitBinder
//    private void initBinder(WebDataBinder binder) {
//        binder.setValidator(registrationDataValidator);
//    }
//
//    @RequestMapping(value = "/registration", method = RequestMethod.GET)
//    private ModelAndView showRegistrationForm() {
//        final ModelAndView mov = new ModelAndView("registration");
//        mov.addObject("registrationFormData", new RegistrationFormData());
//        return mov;
//    }
//
//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    private ModelAndView checkRegistrationForm(@ModelAttribute() @Valid final RegistrationFormData registrationFormData, BindingResult bindingResult) {
//        final ModelAndView mav = new ModelAndView();
//        if(bindingResult.hasErrors()){
//            mav.setViewName("registration");
//        }
//        else{
//            personService.registerPerson(registrationFormData.getPerson());
//            mav.setViewName("redirect:/authentication");
//        }
//        return mav;
//    }
//
//}
