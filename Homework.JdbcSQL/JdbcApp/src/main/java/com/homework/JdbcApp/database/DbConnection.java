package com.homework.JdbcApp.database;


import com.homework.JdbcApp.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

@Configuration
public class DbConnection {
    private static ReentrantLock mutex = new ReentrantLock();

    private static String CONNECTION_STRING;
    @Value("${connection_string}")
    private void setConnectionString(String value){
        CONNECTION_STRING = value;
    }
    private static String USER;
    @Value("${user}")
    private void setConnectionUser(String value){
        USER = value;
    }
    private static String PASSWORD;
    @Value("${password}")
    private void setConnectionPassword(String value){
        PASSWORD = value;
    }

    public static void main(){
    }
    public static Connection getConnection(){
        try{
            try {
                mutex.lock();
                return DriverManager.getConnection(CONNECTION_STRING,USER,PASSWORD);
            }finally {
                mutex.unlock();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
