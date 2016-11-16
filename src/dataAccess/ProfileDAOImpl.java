package dataAccess;

import model.Profile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import util.CustomHibernateDAOSupport;

import java.util.List;

/**
 * Created by Yasemin Alpay on 13.11.2016.
 */
@Repository("ProfileDAO")
public class ProfileDAOImpl extends CustomHibernateDAOSupport implements ProfileDAO {

    public void save(Profile profile){

        SessionFactory sessionFactory = getHibernateTemplate().getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        session.save(profile);
        txn.commit();
        session.flush();
        //getHibernateTemplate().save(profile);
         }

    public void update(Profile profile){
        getHibernateTemplate().update(profile);
    }

    public void delete(Profile profile){
        getHibernateTemplate().delete(profile);
    }

    public Profile findByUserName(String userName){
        List list = getHibernateTemplate().find("from profile where username=?",userName);
        return (Profile) list.get(0);
    }

}
