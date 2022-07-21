package com.homework.InsuranceApp.controller;

import com.homework.InsuranceApp.model.interfaces.Insurance;
import com.homework.InsuranceApp.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insurances")
@RequiredArgsConstructor
public class InsurancesController {
    private final InsuranceService insuranceService;

    @GetMapping("/details")
    public List<Insurance> getInsurances(){return insuranceService.findAll();}
    @GetMapping("/get/{id}")
    public Insurance getInsuranceById(@PathVariable("id") long id){
        return insuranceService.getInsuranceById(id);
    }
    @DeleteMapping("/remove/{id}")
    public Insurance removeInsuranceById(@PathVariable long id){
        return insuranceService.removeInsuranceById(id);
    }
}
