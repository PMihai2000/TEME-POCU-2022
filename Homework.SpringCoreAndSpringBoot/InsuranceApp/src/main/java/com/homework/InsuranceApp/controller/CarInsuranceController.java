package com.homework.InsuranceApp.controller;


import com.homework.InsuranceApp.model.CarInsurance;
import com.homework.InsuranceApp.model.interfaces.Insurance;
import com.homework.InsuranceApp.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/insurances/cars")
@RequiredArgsConstructor
public class CarInsuranceController {
    private final InsuranceService insuranceService;

    @PostMapping("/create")
    public Insurance createCarInsurance(@Valid @RequestBody CarInsurance insurance){return insuranceService.createInsurance(insurance);}
    @GetMapping("/insurancePrice")
    public double getCarInsurancePrice(@Valid @RequestBody CarInsurance insurance){return insuranceService.getInsurancePrice(insurance);}
    @GetMapping("/insurancePrice/{id}")
    public double getCarInsurancePriceById(@PathVariable long id){
        return insuranceService.getInsurancePriceById(id);}
}
