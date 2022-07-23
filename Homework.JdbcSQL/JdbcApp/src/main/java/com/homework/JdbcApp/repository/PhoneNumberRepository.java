package com.homework.JdbcApp.repository;

import com.homework.JdbcApp.database.DbConnection;
import com.homework.JdbcApp.model.Address;
import com.homework.JdbcApp.model.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class PhoneNumberRepository {
    public static PhoneNumber getPhoneNumberByPersonId(long idPerson){
        PhoneNumber phoneNumber = null;

        String query = String.format("SELECT * FROM PhoneNumber WHERE idPerson=%d",idPerson);
        Connection conn = DbConnection.getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet result = null;
            try {
                result = statement.executeQuery(query);
                if(result.next()) {
                    phoneNumber = new PhoneNumber(
                            result.getLong("idPhoneNumber"),
                            result.getString("number"),
                            result.getString("serviceProvider"),
                            result.getLong("idPerson")
                    );
                }
            } catch (SQLException e) {
                log.debug("GET."+e.getMessage());;
            }
        } catch (SQLException e) {
            log.debug("GET."+e.getMessage());;
        }
        return phoneNumber;
    }
    public static List<String> getServiceProviders(){
        List<String> serviceProviders = new ArrayList<>();

        String query = "SELECT DISTINCT serviceProvider FROM PhoneNumber";
        Connection conn = DbConnection.getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet result = null;
            try {
                result = statement.executeQuery(query);
                while(result.next()){
                    serviceProviders.add(result.getString("serviceProvider"));
                }
            } catch (SQLException e) {
                log.debug("GET."+e.getMessage());;
            }
        } catch (SQLException e) {
            log.debug("GET."+e.getMessage());;
        }
        return serviceProviders;
    }

    public static void savePhoneNumber(PhoneNumber phoneNumber, long idPerson){
        String query = String.format("INSERT INTO PhoneNumber(number,serviceProvider,idPerson) " +
                "VALUES('%s','%s','%d')",phoneNumber.getNumber(),phoneNumber.getService_provider(),idPerson);
        Connection conn = DbConnection.getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            boolean result;
            try {
                result = statement.execute(query);
            } catch (SQLException e) {
                log.debug("POST."+e.getMessage());;
            }
        } catch (SQLException e) {
            log.debug("POST."+e.getMessage());;
        }
    }

    public static void updatePhoneNumber(PhoneNumber phoneNumber,long idPerson){
        String query = String.format("UPDATE PhoneNumber SET number='%s',serviceProvider='%s' " +
                "WHERE idPerson=%d",phoneNumber.getNumber(),phoneNumber.getService_provider(),idPerson);
        Connection conn = DbConnection.getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            int result;
            try {
                result = statement.executeUpdate(query);
            } catch (SQLException e) {
                log.debug("UPDATE."+e.getMessage());;
            }
        } catch (SQLException e) {
            log.debug("UPDATE."+e.getMessage());;
        }
    }
}
