package com.maystrovoy.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNoHandlerFoundException(NoHandlerFoundException exception) {
        ModelAndView mav = new ModelAndView("error_page");
        mav.addObject("header", "Oooooops 404");
        mav.addObject("message", "There are no mapping for: " + exception.getRequestURL());
        return mav;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception exception) {
        System.out.println("In handleException");
        ModelAndView mav = new ModelAndView("error_page");
        mav.addObject("header", "Unexpected exception");
        mav.addObject("message", "There error is: " + exception.getMessage());
        return mav;
    }
}
