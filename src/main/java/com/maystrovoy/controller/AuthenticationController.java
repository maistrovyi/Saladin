package com.maystrovoy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController {

//    @Inject
//    private UserService userService;

    @RequestMapping(value = "/authentication", method = RequestMethod.GET)
    private String showAuthenticationForm() {
        return "authentication";
    }

//    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
//    private ModelAndView checkAuthenticationData(HttpServletRequest request) {
//        ModelAndView mav = new ModelAndView("authentication");
//        String authenticationError = userService.checkPersonAuthentication(request);
//        if(authenticationError != null){
//            mav.addObject("authentication_error", authenticationError);
//        } else{
//            mav.setViewName("redirect:/home");
//        }
//        return mav;
//    }
//
//    @RequestMapping(value = "/signout", method = RequestMethod.GET)
//    private String signOut(HttpSession httpSession) {
//        httpSession.invalidate();
//        return "authentication";
//    }
}
