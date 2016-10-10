package web2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web2.models.Client;

import java.util.Locale;
import java.util.Optional;

@Controller
class DefaultController {

    @Autowired
    private MessageSource messageSource;

//    @PreAuthorize("hasAnyAuthority('ADMIN','USUARIO_NORMAL')")
    @RequestMapping("/")
    public String index(Model model, Locale locale) {
        model.addAttribute("tema",messageSource.getMessage("tema",null,locale));

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        return new ModelAndView("_login", "error", error);
    }

    @RequestMapping("/logout")
    public String getLogoutPage(Model model, Locale locale) {

        return "_logout";
    }

    @RequestMapping("/access_denied")
    public String accessDeniedPage(Model model, Locale locale) {

        return "_access_denied";
    }
}

