package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Login;

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

    @RequestMapping(value = "/newProfile", method = RequestMethod.POST)
    public String submitLogin(@ModelAttribute("login") Login login,
                             ModelMap model) {
        model.addAttribute("user", login.getUserName());
        model.addAttribute("pass", login.getPassword());

        return "newProfile";
    }

}
