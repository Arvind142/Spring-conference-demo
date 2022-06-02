package com.personal.conferencedemo.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Controller
public class PersistanceConfigurator {

    // few vars to be replaced at runtime

    @Value("${datasource.mysql.url}")
    private String url;
    @Value("${datasource.mysql.username}")
    private String username;
    @Value("${datasource.mysql.password}")
    private String password;
    @Value("${datasource.mysql.driverClassName}")
    private String driverClassName;

    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url(url).username(username).password(password).driverClassName(driverClassName);
        return builder.build();
    }
}
