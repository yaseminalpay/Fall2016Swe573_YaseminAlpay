package dao;

import dao.util.CustomHibernateDAOSupport;
import model.Profile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yasemin Alpay on 13.11.2016.
 */
@Service("ProfileDAO")
@Repository("ProfileDAO")
public class ProfileDAOImpl extends CustomHibernateDAOSupport implements ProfileDAO {

    @Autowired
    ProfileDAO profileDao;

    public void setProfileDao(ProfileDAO profileDao) {
        this.profileDao = profileDao;
    }


    public void save(Profile profile){

        SessionFactory sessionFactory = getHibernateTemplate().getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        session.save(profile);
        txn.commit();
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
