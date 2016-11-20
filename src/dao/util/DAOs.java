package dao.util;

import dao.ProfileDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Yasemin Alpay on 20.11.2016.
 */

public class DAOs {

    static ApplicationContext appContext;
    static{

        appContext = new ClassPathXmlApplicationContext("/resources/BeanLocations.xml");
    }

    public static ProfileDAO getProfileDao()
    {
        ProfileDAO profileDao = (ProfileDAO)appContext.getBean("ProfileDAO");
        return profileDao;
    }

}
