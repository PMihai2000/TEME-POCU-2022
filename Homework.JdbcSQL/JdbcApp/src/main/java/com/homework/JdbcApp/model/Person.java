package com.homework.JdbcApp.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Date;
@Data
public class Person {
    @Id
    private long id;
    @NotNull
    private String name;
    @NotNull
    private Date birthday;
    @NotNull
    private String birthplace;


    public Person(long id, String name, Date birthday, String birthplace) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.birthplace = birthplace;

    }

    @Override
    public String toString() {
        return "Person{" +
                " name='" + name + '\'' +
                ", birthday=" + birthday +
                ", birthplace='" + birthplace +
                '}';
    }
}
