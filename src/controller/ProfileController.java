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
    public String createProfile(@ModelAttribute("login") Profile profile,
                              ModelMap model) {
        return "newProfile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String saveProfile(@ModelAttribute("profile") Profile profile,
                              ModelMap model) {

        /** insert **/
        DAOs.getProfileDao().save(profile);

        return "profileSuccess";
    }


}
