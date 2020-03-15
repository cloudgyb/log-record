package org.gyb.ssh.dao;

import org.gyb.ssh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    private HibernateTemplate hibernateTemplate;

    @Autowired
    public UserDao(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public List<User> listAll(){
        return hibernateTemplate.loadAll(User.class);
    }
}
