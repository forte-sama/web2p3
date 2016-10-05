package web2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * Created by forte on 04/10/16.
 */
@Controller
class DefaultController {

    @Autowired
    private MessageSource messageSource;

    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/")
    public String index(Model model, Locale locale) {
        model.addAttribute("tema",messageSource.getMessage("tema",null,locale));

        return "index";
    }
}

