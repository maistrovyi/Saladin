package com.maystrovoy.controller;

import com.maystrovoy.model.PasswordChangingFormData;
import com.maystrovoy.service.PersonService;
import com.maystrovoy.validator.PasswordChangingDataValidator;
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
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller
public class PersonSettingsController extends AbstractLoginController {

    @Inject
    private PersonService personService;

    @Named("passwordChangingDataValidator")
    @Inject
    private PasswordChangingDataValidator passwordChangingDataValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(passwordChangingDataValidator);
    }

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    private ModelAndView showChfngePasswordForm() {
        final ModelAndView mov = new ModelAndView("settings");
        mov.addObject("passwordChangingFormData", new PasswordChangingFormData());
        return mov;
    }

    @RequestMapping(value = "/settings", method = RequestMethod.POST)
    public ModelAndView processChangePasswordForm(HttpServletRequest request, @ModelAttribute() @Valid final
    PasswordChangingFormData passwordChangingFormData,
                                                  BindingResult bindingResult) throws UnsupportedEncodingException,
            NoSuchAlgorithmException {
        final ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mav.setViewName("settings");
        } else {
            String login = getPersonLoginName(request);
            personService.changePersonPassword(login, passwordChangingFormData.getNewPassword());
            request.getSession().invalidate();
            mav.setViewName("redirect:/authentication");
        }
        return mav;
    }

}
