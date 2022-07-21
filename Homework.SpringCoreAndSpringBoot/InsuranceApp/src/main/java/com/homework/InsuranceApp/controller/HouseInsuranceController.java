package com.homework.InsuranceApp.controller;

import com.homework.InsuranceApp.model.CarInsurance;
import com.homework.InsuranceApp.model.HouseInsurance;
import com.homework.InsuranceApp.model.interfaces.Insurance;
import com.homework.InsuranceApp.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/insurances/houses")
@RequiredArgsConstructor
public class HouseInsuranceController {
    private final InsuranceService insuranceService;

    @PostMapping("/create")
    public Insurance createHouseInsurance(@Valid @RequestBody HouseInsurance insurance){return insuranceService.createInsurance(insurance);}

    @GetMapping("/insurancePrice")
    public double getHouseInsurancePrice(@Valid @RequestBody HouseInsurance insurance){return insuranceService.getInsurancePrice(insurance);}
    @GetMapping("/insurancePrice/{id}")
    public double getHouseInsurancePriceById(@PathVariable long id){
        return insuranceService.getInsurancePriceById(id);}
}
