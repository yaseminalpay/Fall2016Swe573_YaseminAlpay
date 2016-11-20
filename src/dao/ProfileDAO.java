package dao;

import model.Profile;

/**
 * Created by Yasemin Alpay on 13.11.2016.
 */
public interface ProfileDAO {

    void save(Profile profile);
    void delete(Profile profile);
    void update(Profile profile);
    Profile findByUserName(String userName);
}
