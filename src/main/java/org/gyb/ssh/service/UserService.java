package org.gyb.ssh.service;

import org.gyb.ssh.dao.UserDao;
import org.gyb.ssh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAll(){
        return userDao.listAll();
    }
}
