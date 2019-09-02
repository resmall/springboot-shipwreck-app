package com.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
public class PersistenceConfiguration {
    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    @Primary
    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("spring.datasource.driver-class-name")));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));

        return dataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource.flyway")
    @FlywayDataSource
    public DataSource flywayDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("datasource.flyway.driver-class-name")));
        dataSource.setUrl(env.getProperty("datasource.flyway.url"));
        dataSource.setUsername(env.getProperty("datasource.flyway.username"));
        dataSource.setPassword(env.getProperty("datasource.flyway.password"));

        return dataSource;
    }
}
