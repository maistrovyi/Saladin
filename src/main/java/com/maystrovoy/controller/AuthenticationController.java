package com.maystrovoy.controller;

import com.maystrovoy.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller
public class AuthenticationController {

    @Inject
    private PersonService personService;

    @RequestMapping(value = "/authentication", method = RequestMethod.GET)
    private String showAuthenticationForm() {
        return "authentication";
    }

    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
    private ModelAndView checkAuthenticationData(HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        ModelAndView mav = new ModelAndView("authentication");
        String authenticationError = personService.checkPersonAuthentication(request);
        if (authenticationError != null) {
            mav.addObject("authentication_error", authenticationError);
        } else {
            mav.setViewName("redirect:/home");
        }
        return mav;
    }

    @RequestMapping(value = "/signout", method = RequestMethod.GET)
    private String signOut(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/authentication";
    }
}
