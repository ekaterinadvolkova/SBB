package com.javaschool.ev.config;

import com.javaschool.ev.dao.api.UserDao;
import com.javaschool.ev.dao.impl.UserDAOImpl;
import com.javaschool.ev.service.api.UserService;
import com.javaschool.ev.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.javaschool.ev")
public class AppConfig {
    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public UserDao userDao() {
        return new UserDAOImpl();
    }

}
