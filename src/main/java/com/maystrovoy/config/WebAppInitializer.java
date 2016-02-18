//package com.maystrovoy.config;
//
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//
//public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        super.registerContextLoaderListener(servletContext);
//        registerDispatcherServlet(servletContext);
//    }
//
//    @Override
//    protected void registerDispatcherServlet(ServletContext servletContext) {
//        WebApplicationContext servletAppContext = createServletApplicationContext();
//        DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
//        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
//        System.out.println("Set dispatcher throw exception");
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[0];
//    }
//
//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class<?>[0];
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class<?>[0];
//    }
//}
