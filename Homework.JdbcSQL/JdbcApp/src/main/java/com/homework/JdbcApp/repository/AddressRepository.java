package com.homework.JdbcApp.repository;

import com.homework.JdbcApp.database.DbConnection;
import com.homework.JdbcApp.model.Address;
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
public class AddressRepository {
    public static Address getAddressByPersonId(long idPerson){
        Address address = null;

        String query = String.format("SELECT * FROM Address WHERE idPerson=%d",idPerson);
        Connection conn = DbConnection.getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet result = null;
            try {
                result = statement.executeQuery(query);
                if(result.next()) {
                    address = new Address(
                            result.getLong("idAddress"),
                            result.getString("country"),
                            result.getString("city"),
                            result.getString("street"),
                            result.getLong("idPerson")
                    );
                }
            } catch (SQLException e) {
                log.debug("GET."+e.getMessage());;
            }
        } catch (SQLException e) {
            log.debug("GET."+e.getMessage());;
        }
        return address;
    }
    public static List<String> getCities(){
        List<String> cities = new ArrayList<>();

        String query = "SELECT DISTINCT city FROM Address";
        Connection conn = DbConnection.getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet result = null;
            try {
                result = statement.executeQuery(query);
                while(result.next()){
                    cities.add(result.getString("city"));
                }
            } catch (SQLException e) {
                log.debug("GET."+e.getMessage());;
            }
        } catch (SQLException e) {
            log.debug("GET."+e.getMessage());;
        }
        return cities;
    }
    public static List<String> getStreets(){
        List<String> streets = new ArrayList<>();

        String query = "SELECT DISTINCT street FROM Address";
        Connection conn = DbConnection.getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet result = null;
            try {
                result = statement.executeQuery(query);
                while(result.next()){
                    streets.add(result.getString("street"));
                }
            } catch (SQLException e) {
                log.debug("GET."+e.getMessage());;
            }
        } catch (SQLException e) {
            log.debug("GET."+e.getMessage());;
        }
        return streets;
    }
    public static List<String> getCountries(){
        List<String> countries = new ArrayList<>();

        String query = "SELECT DISTINCT country FROM Address";
        Connection conn = DbConnection.getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet result = null;
            try {
                result = statement.executeQuery(query);
                while(result.next()){
                    countries.add(result.getString("country"));
                }
            } catch (SQLException e) {
                log.debug("GET."+e.getMessage());;
            }
        } catch (SQLException e) {
            log.debug("GET."+e.getMessage());;
        }
        return countries;
    }

    public static void saveAddress(Address address,long idPerson){
        String query = String.format("INSERT INTO Address(country,city,street,idPerson) " +
                "VALUES('%s','%s','%s','%d')",address.getCountry(),address.getCity(),address.getStreet(),idPerson);
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

    public static void updateAddress(Address address,long idPerson){
        String query = String.format("UPDATE Address SET country='%s',city='%s',street='%s' " +
                "WHERE idPerson=%d",address.getCountry(),address.getCity(),address.getStreet(),idPerson);
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
