package dao.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 * Created by Yasemin Alpay on 15.11.2016.
 */
public abstract class CustomHibernateDAOSupport extends HibernateDaoSupport {
    @Autowired
    public void sessionFactorySupport(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
}