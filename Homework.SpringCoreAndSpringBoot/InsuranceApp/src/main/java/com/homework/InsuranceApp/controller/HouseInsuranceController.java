package com.homework.InsuranceApp.controller;

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

    @PostMapping
    public Insurance createHouseInsurance(@Valid @RequestBody HouseInsurance insurance){return insuranceService.createInsurance(insurance);}
    @GetMapping
    public double getHouseInsurancePrice(@Valid @RequestBody String index){
        return insuranceService.getInsurancePrice(Integer.parseInt(index));}
}
