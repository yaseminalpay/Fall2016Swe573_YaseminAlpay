package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Yasemin Alpay on 23.10.2016.
 */
@Controller
public class LoginController {

    @RequestMapping( value = "/" , method = RequestMethod.GET)
    public String hello(ModelMap model){
        model.addAttribute("message", "Hello World!");

        return "home";
    }





}
