package controller;

import dao.util.DAOs;
import model.Login;
import model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Yasemin Alpay on 20.11.2016.
 */
@Controller
public class ProfileController {

    @RequestMapping(value = "/newProfile", method = RequestMethod.POST)
    public String submitLogin(@ModelAttribute("login") Login login,
                              ModelMap model) {


        model.addAttribute("user", login.getUserName());
        model.addAttribute("pass", login.getPassword());

        String user = login.getUserName();
        String pass = login.getPassword();

        /** insert **/
        Profile prof = new Profile(user, pass);
        DAOs.getProfileDao().save(prof);

        return "newProfile";
    }


}
