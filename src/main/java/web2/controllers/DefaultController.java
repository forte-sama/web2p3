package web2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;
import java.util.Optional;

@Controller
class DefaultController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/")
    public String index(Model model, Locale locale) {
        model.addAttribute("tema",messageSource.getMessage("tema",null,locale));

        return "index";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','OTRO')")
    @RequestMapping("/wepa")
    public String otraPagina(Model model, Locale locale) {
        model.addAttribute("tema","Otra pagina para ir probando Spring Security");

        return "wepa";
    }

    @PreAuthorize("hasAnyAuthority('OTRO')")
    @RequestMapping("/lala")
    public String otraPaginaz(Model model, Locale locale) {
        model.addAttribute("tema","SE LOGRO ENTRAR CON OTRO PERMISO DISTINTO A ADMIN");

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

