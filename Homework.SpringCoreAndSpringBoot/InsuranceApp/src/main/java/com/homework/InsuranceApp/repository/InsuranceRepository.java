package com.homework.InsuranceApp.repository;

import com.homework.InsuranceApp.exception.InsuranceNotFoundException;
import com.homework.InsuranceApp.model.interfaces.Insurance;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class InsuranceRepository {
    private final List<Insurance> insurances = new ArrayList<>();
    public List<Insurance> findAll(){return insurances;}
    public Insurance save(Insurance insurance){
        insurances.add(insurance);
        return insurance;
    }
    public Insurance get(long id){
        try {
            return insurances.stream()
                    .filter((i) -> i.getId() == id)
                    .findFirst()
                    .get();
        }catch(NoSuchElementException e){
            throw new InsuranceNotFoundException("There's no insurance with id "+id+".");
        }
    }
    public Insurance remove(long id){
        try {
            Insurance insuranceToBeRemoved = insurances.stream()
                    .filter((u) -> u.getId() == id)
                    .findFirst()
                    .get();

            insurances.remove(insuranceToBeRemoved);
            return insuranceToBeRemoved;

        }catch(NoSuchElementException e){
            throw new InsuranceNotFoundException("There's no insurance with id "+id+".");
        }
    }
}
