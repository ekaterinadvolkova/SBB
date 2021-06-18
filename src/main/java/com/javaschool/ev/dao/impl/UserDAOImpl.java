package com.javaschool.ev.dao.impl;

import com.javaschool.ev.dao.api.UserDao;
import com.javaschool.ev.domain.Login;
import com.javaschool.ev.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDao {

//    @Autowired
//    DataSource datasource;

    private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

//    JdbcTemplate jdbcTemplate;

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    UserMapper userMapper;

    public int register(User user) {
        log.info("method register", user.toString());
        add(user);
        return 0;
    }

    public User validateUser(Login login) {

        String sql = "select * from myusers where username='" + login.getUsername() + "' and password='" + login.getPassword();
//                + "'";
//        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        List<User> users = allUsers();
//
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public User getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public boolean checkUser(String firstname, String lastname, LocalDate birthdate) {
        Session session = sessionFactory.getCurrentSession();
        Query query;

        query = session.createQuery("from User where firstname = :firstname, lastname = :lastname, birthdate = :birthdate");

        query.setParameter("firstName", firstname);

        query.setParameter("lastname", lastname);

        query.setParameter("birthdate", birthdate);

        return query.getResultList().isEmpty();
    }

    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

    @Override
    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    @Override
    public void edit(User user) {
        Session session = sessionFactory.getCurrentSession();

        User dbUser = getById(user.getId());

        dbUser.setId(user.getId());
        dbUser.setUsername(user.getUsername());
        dbUser.setPassword(user.getPassword());
        dbUser.setFirstname(user.getFirstname());
        dbUser.setLastname(user.getFirstname());
        dbUser.setBirthDate(user.getBirthdate());
        session.update(dbUser);
    }

}


