package com.example.testjunit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AverageService {
 
    @Autowired
    private CalculatorService calculatorService;

    public Double avarage(Double a, Double b) {
        Double result = calculatorService.add(a, b);
        Double divResult = calculatorService.divide(result,2d);
        return divResult;

    }
}
