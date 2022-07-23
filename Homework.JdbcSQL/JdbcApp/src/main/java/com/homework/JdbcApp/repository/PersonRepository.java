package com.homework.JdbcApp.repository;

import com.homework.JdbcApp.database.DbConnection;
import com.homework.JdbcApp.model.Address;
import com.homework.JdbcApp.model.Person;
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
public class PersonRepository {
    public static Person getPersonById(long idPerson){
        Person person = null;

        String query = String.format("SELECT * FROM Person WHERE idPerson=%d",idPerson);
        Connection conn = DbConnection.getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet result = null;
            try {
                result = statement.executeQuery(query);
                if(result.next()) {
                    person = new Person(
                            result.getLong("idPerson"),
                            result.getString("name"),
                            result.getDate("birthday"),
                            result.getString("birthplace"));
                }
            } catch (SQLException e) {
                log.debug("GET."+e.getMessage());;
            }
        } catch (SQLException e) {
            log.debug("GET."+e.getMessage());;
        }
        return person;
    }
    public static List<Person> getPersonsBornBefore1990(){
        List<Person> persons = new ArrayList<>();

        String query = "SELECT * FROM Person WHERE YEAR(birthday)<1990";
        Connection conn = DbConnection.getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet result = null;
            try {
                result = statement.executeQuery(query);
                while(result.next()){
                    persons.add(new Person(
                            result.getLong("idPerson"),
                            result.getString("name"),
                            result.getDate("birthday"),
                            result.getString("birthplace")));
                }
            } catch (SQLException e) {
                log.debug("GET."+e.getMessage());;
            }
        } catch (SQLException e) {
            log.debug("GET."+e.getMessage());;
        }
        return persons;
    }

    public static List<Person> getPersonsWhoLiveInTheCityTheyWereBorn(){
        List<Person> persons = new ArrayList<>();

        String query = "SELECT * FROM Person " +
                "INNER JOIN Address ON Person.idPerson=Address.idPerson " +
                "WHERE Person.birthplace=Address.city";
        Connection conn = DbConnection.getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet result = null;
            try {
                result = statement.executeQuery(query);
                while(result.next()){
                    persons.add(new Person(
                            result.getLong("idPerson"),
                            result.getString("name"),
                            result.getDate("birthday"),
                            result.getString("birthplace")));
                }
            } catch (SQLException e) {
                log.debug("GET."+e.getMessage());;
            }
        } catch (SQLException e) {
            log.debug("GET."+e.getMessage());;
        }
        return persons;
    }

    public static List<Person> getPersonsWhoLiveInTheSameCity(String city){
        List<Person> persons = new ArrayList<>();

        String query = String.format("SELECT * FROM Person " +
                "INNER JOIN Address ON Person.idPerson=Address.idPerson " +
                "WHERE Address.city='%s'",city);
        Connection conn = DbConnection.getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet result = null;
            try {
                result = statement.executeQuery(query);
                while(result.next()){
                    persons.add(new Person(
                            result.getLong("idPerson"),
                            result.getString("name"),
                            result.getDate("birthday"),
                            result.getString("birthplace")));
                }
            } catch (SQLException e) {
                log.debug("GET."+e.getMessage());;
            }
        } catch (SQLException e) {
            log.debug("GET."+e.getMessage());;
        }
        return persons;
    }
    public static List<Person> getPersonsWhoLiveInTheSameCountry(String country){
        List<Person> persons = new ArrayList<>();

        String query = String.format("SELECT * FROM Person " +
                "INNER JOIN Address ON Person.idPerson=Address.idPerson " +
                "WHERE Address.country='%s'",country);
        Connection conn = DbConnection.getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet result = null;
            try {
                result = statement.executeQuery(query);
                while(result.next()){
                    persons.add(new Person(
                            result.getLong("idPerson"),
                            result.getString("name"),
                            result.getDate("birthday"),
                            result.getString("birthplace")));
                }
            } catch (SQLException e) {
                log.debug("GET."+e.getMessage());;
            }
        } catch (SQLException e) {
            log.debug("GET."+e.getMessage());;
        }
        return persons;
    }

    public static List<Person> getPersonsWhoLiveInTheSameStreet(String street){
        List<Person> persons = new ArrayList<>();

        String query = String.format("SELECT * FROM Person " +
                "INNER JOIN Address ON Person.idPerson=Address.idPerson " +
                "WHERE Address.street='%s'",street);
        Connection conn = DbConnection.getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet result = null;
            try {
                result = statement.executeQuery(query);
                while(result.next()){
                    persons.add(new Person(
                            result.getLong("idPerson"),
                            result.getString("name"),
                            result.getDate("birthday"),
                            result.getString("birthplace")));
                }
            } catch (SQLException e) {
                log.debug("GET."+e.getMessage());;
            }
        } catch (SQLException e) {
            log.debug("GET."+e.getMessage());;
        }
        return persons;
    }

    public static List<Person> getPersonsWhoUseTheSameServiceProvider(String serviceProvider){
        List<Person> persons = new ArrayList<>();

        String query = String.format("SELECT * FROM Person " +
                "INNER JOIN PhoneNumber ON Person.idPerson=PhoneNumber.idPerson " +
                "WHERE PhoneNumber.serviceProvider='%s'",serviceProvider);
        Connection conn = DbConnection.getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet result = null;
            try {
                result = statement.executeQuery(query);
                while(result.next()){
                    persons.add(new Person(
                            result.getLong("idPerson"),
                            result.getString("name"),
                            result.getDate("birthday"),
                            result.getString("birthplace")));
                }
            } catch (SQLException e) {
                log.debug("GET."+e.getMessage());;
            }
        } catch (SQLException e) {
            log.debug("GET."+e.getMessage());;
        }
        return persons;
    }


}
