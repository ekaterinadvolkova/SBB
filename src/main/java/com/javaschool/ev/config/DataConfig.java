package com.javaschool.ev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Properties;

@PropertySource({"clathpath: db/db.properties"})
@Configuration
public class DataConfig {

    //hibernate properties
    @Bean
    public Properties hibernateProperties(){
        Properties hibernateProp = new Properties();

        //include all hibernate dialect
        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        return hibernateProp;
    }

}
