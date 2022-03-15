package com.example.testjunit.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
// import org.junit.Test; // TOMAR CUIDADO ESSE NAO PERMITE A INJEÇÃO DE DEPENDENCIAS 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("This is a Calculadora test")
@TestInstance(Lifecycle.PER_CLASS)
public class CalculatorServiceTest {
    private Long count = 0L;

    @Autowired
    private AverageService averageService;

    @Autowired
    private CalculatorService calculatorService;
    
    @Test
    @DisplayName("deve retornar o valor da soma se passados os valores de a e b ")
    public void deve_retornar_valor_da_soma_se_passado_valores_de_A_e_B() {
        int result = calculatorService.add(1,2);
        assertEquals(3, result);
    }

    @Test
    @DisplayName("deve retornar o valor da subtracao de A-B se passados os valores de a e b ")
    public void deve_retornar_valor_da_subtracao_se_passado_valores_de_A_e_B() {
        int result = calculatorService.minus(5,3);
        assertEquals(2, result);
    }

    @Test
    @DisplayName("deve retornar o valor da multiplicação de A x B se passados os valores de a e b ")
    public void deve_retornar_valor_da_multiplicacao_se_passado_valores_de_A_e_B() {
        int result = calculatorService.multiply(5,3);
        assertEquals(15, result);
    }

    @Test
    @DisplayName("deve retornar o valor da divisao de A / B se passados os valores de a e b e se B <> 0 ")
    public void deve_retornar_valor_da_divisao_se_passado_valores_de_A_e_B_e_se_B_diferente_de_zero() {
        Double result = calculatorService.divide(15,3);
        assertEquals(5D, result);
    }

    @Test
    @DisplayName("deve lançar a exceção  se passados os valores de a e b e se B <> 0 ")
    public void deve_lancar_a_excecao_se_B_igual_zero() {
        assertThrows(ArithmeticException.class, () -> {
           calculatorService.divide(15,0);
        });
    }


    @Test
    @DisplayName("deve calcular a média de 2 numeros")
    public void deve_calcular_a_media_de_dois_numeros() {
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
