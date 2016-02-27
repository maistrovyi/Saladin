package com.maystrovoy.controller;

import org.springframework.stereotype.Controller;

@Controller
public class RegistrationController {

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
}
