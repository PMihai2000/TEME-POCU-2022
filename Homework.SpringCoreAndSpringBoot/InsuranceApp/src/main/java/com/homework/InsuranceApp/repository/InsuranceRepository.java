package com.homework.InsuranceApp.repository;

import com.homework.InsuranceApp.model.User;
import com.homework.InsuranceApp.model.interfaces.Insurance;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InsuranceRepository {
    private List<Insurance> insurances = new ArrayList<>();
    public List<Insurance> findAll(){return insurances;}
    public Insurance save(Insurance insurance){
        insurances.add(insurance);
        return insurance;
    }
}
