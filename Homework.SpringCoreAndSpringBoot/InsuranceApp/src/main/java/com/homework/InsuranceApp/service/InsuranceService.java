package com.homework.InsuranceApp.service;

import com.homework.InsuranceApp.model.CarInsurance;
import com.homework.InsuranceApp.model.HouseInsurance;
import com.homework.InsuranceApp.model.interfaces.Insurance;
import com.homework.InsuranceApp.repository.InsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;

    @PostConstruct
    private void postConstruct(){
        CarInsurance carInsurance1 = new CarInsurance("Dacia","2351",2004,180);
        CarInsurance carInsurance2 = new CarInsurance("BMW","7406",2009,230);

        HouseInsurance houseInsurance1 = new HouseInsurance("",1990,4);
        HouseInsurance houseInsurance2 = new HouseInsurance("",1992,5);

        insuranceRepository.save(carInsurance1);
        insuranceRepository.save(carInsurance2);
        insuranceRepository.save(houseInsurance1);
        insuranceRepository.save(houseInsurance2);
    }

    public List<Insurance> findAll(){return insuranceRepository.findAll();}

    public Insurance createInsurance(Insurance insurance){
        return insuranceRepository.save(insurance);
    }
    @Profile("dev")
    public double getInsurancePrice(int index){
        List<Insurance> insurances = insuranceRepository.findAll();
        if(insurances.isEmpty()){
            return 0.0f;
        }

        return insurances.get(index).getPrice();
    }

    @Profile("guest")
    public double getInsurancePrice(Insurance insurance){
        return insurance.getPrice();
    }

}
