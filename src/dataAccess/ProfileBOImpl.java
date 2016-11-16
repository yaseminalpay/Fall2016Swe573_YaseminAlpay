package dataAccess;

import model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Yasemin Alpay on 16.11.2016.
 */
@Service("ProfileBO")
public class ProfileBOImpl implements ProfileBO {


    @Autowired
    ProfileDAO profileDao;

    public void setProfileDao(ProfileDAO profileDao) {
        this.profileDao = profileDao;
    }

    @Override
    public void save(Profile profile) {
        profileDao.save(profile);
    }

    @Override
    public void delete(Profile profile) {
        profileDao.delete(profile);
    }

    @Override
    public void update(Profile profile) {
        profileDao.update(profile);
    }

    @Override
    public Profile findByUserName(String userName) {
        return profileDao.findByUserName(userName);
    }
}
