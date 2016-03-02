package com.maystrovoy.interceptor;

import com.maystrovoy.model.Person;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url= request.getRequestURI();
        if(!url.endsWith("authentication") && !url.endsWith("registration") && !url.endsWith("generalError")){
            Person person = (Person) request.getSession().getAttribute("person");
            if(person == null){
                response.sendRedirect("authentication");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(	HttpServletRequest request, HttpServletResponse response,
                               Object handler, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
    }
}
