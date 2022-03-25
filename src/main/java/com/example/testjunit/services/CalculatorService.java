package com.example.testjunit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    @Autowired
    private OperationsService operationsService;

    public Double add(Double a, Double b) {
        operationsService.sendMessage(String.format("add %f + %f",a,b));
        return a+b;
    }

    public Double minus(Double a, Double b) {
        operationsService.sendMessage(String.format("minus %f + %f",a,b));
        return a - b;
    }

    public Double multiply(Double a, Double b) {
        operationsService.sendMessage(String.format("multiply %f + %f",a,b));
        return a * b;
    }

    public Double divide(Double a, Double b) {
        operationsService.sendMessage(String.format("divide %f + %f",a,b));
        if(b==0) {
            throw new ArithmeticException("invalid operation - divide by zero");
        }
        return (a / b);
    }

    public Double addOneOnValueAndDivideByTwo(Double a) {
        Double result = operationsService.addOneOnValue(a);
        return (result / 2);
    }
}
