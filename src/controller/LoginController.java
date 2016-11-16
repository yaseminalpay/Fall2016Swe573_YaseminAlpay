package controller;

import dataAccess.ProfileBO;
import dataAccess.ProfileDAOImpl;
import model.Profile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Login;
import org.springframework.web.bind.annotation.SessionAttribute;

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

        String user = login.getUserName();
        String pass = login.getPassword();

        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("/resources/BeanLocations.xml");

        ProfileBO profileBO = (ProfileBO) appContext.getBean("ProfileBO");

        /** insert **/
        Profile prof = new Profile(user, pass);
        profileBO.save(prof);

        return "newProfile";
    }

}
