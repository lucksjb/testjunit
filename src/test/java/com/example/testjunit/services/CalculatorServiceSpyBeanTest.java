package com.example.testjunit.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest
@DisplayName("This is a Calculadora test")
@TestInstance(Lifecycle.PER_CLASS)
public class CalculatorServiceSpyBeanTest {
    private Long count = 0L;

    @Autowired
    private AverageService averageService;

    @SpyBean
    private CalculatorService calculatorServiceSpyed;
    
    @Test
    @DisplayName("deve calcular a média de 2 numeros")
    public void deve_calcular_a_media_de_dois_numeros() {

        when(calculatorServiceSpyed.add(10,2)).thenReturn(12);

        Double result = averageService.avarage(10, 2);
        assertEquals(6, result);
    }

    @BeforeEach
    public void antes_de_cada_teste() {
        count++;
        System.out.println("executado antes de cada teste  "+count);
    }

    @BeforeAll 
    public void antes_de_todos_os_testes() {
        System.out.println("executado antes de iniciar os testes "+count);
    }
    
    @AfterAll 
    public void depois_de_todos_os_testes() {
        System.out.println("executado apos terminar os testes "+count);
    }
}
