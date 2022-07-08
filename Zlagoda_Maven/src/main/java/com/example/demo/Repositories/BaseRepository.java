package com.example.demo.Repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

public class BaseRepository {

    protected final JdbcTemplate jdbcTemplate;


    public BaseRepository(){
        this.jdbcTemplate = new JdbcTemplate(dataSource());
    }

    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5601/zlagoda");
        dataSource.setUsername("zlagoda_admin");
        dataSource.setPassword("password");
        return  dataSource;
    }

    public String Generate(int lenght, List<String> ids){
        boolean p = true;
        String id = "";
        Random random = new Random();
        while(p){
            byte[] array = new byte[lenght]; // length is bounded by 7
            id = "";
            for (int i = 0; i<lenght; i++)
                id+=String.valueOf(random.nextInt(10));

            p = false;
            for (String str: ids)
                if(id.equals(str))
                    p = true;
        }
        return id;
    }

}
