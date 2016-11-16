package dataAccess;

import model.Profile;

/**
 * Created by Yasemin Alpay on 16.11.2016.
 */
public interface ProfileBO {
    void save(Profile profile);
    void delete(Profile profile);
    void update(Profile profile);
    Profile findByUserName(String userName);
}
