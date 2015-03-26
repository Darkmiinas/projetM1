package com.supinforce.mewpipe.service;

import com.supinforce.mewpipe.dao.UserDao;
import com.supinforce.mewpipe.entity.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.File;

/**
 * Created by Pierre on 28/01/2015.
 */

@Stateless
public class UserService {
    @EJB
    private UserDao userDao;

    public void addUser(User user)
    {
        File file = new File(VideoService.VIDEOPATH+user.getUserName());
        if(!file.exists())
            file.mkdir();
        userDao.addEntity(user);

    }

    public User getUser(String pseudo, String password) {
        return userDao.getUserByCredentials(pseudo, password);
    }

}
