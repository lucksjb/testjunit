package com.example.testjunit.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("This is a Calculadora test")
@EnableAutoConfiguration(exclude = {
    DataSourceAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class})
public class CalculatorServiceMockBeanTest {
    @MockBean
    private OperationsService operationsService;

    @Autowired
    private CalculatorService calculatorService;

    @Test
    @DisplayName("deve acrescentar um ao numero passado e dividir por dois")
    public void deve_acrescentar_um_ao_numero_passado_e_dividir_por_dois() {
        final Double value = 11d;
        doReturn(12d)
                .when(operationsService)
                .addOneOnValue(value);

        Double result = calculatorService.addOneOnValueAndDivideByTwo(value);
        assertEquals(6, result);
    }

    @Test
    @DisplayName("deve simular envio de mensagem no sqs ")
    public void deve_simular_envio_de_mensagem_no_sqs() {

        List<String> messagesSended = new ArrayList<>();
        doAnswer((answer) -> {
            messagesSended.add(answer.getArgument(0));
            return null;
        })
                .when(operationsService).sendMessage(any());

        calculatorService.add(10d, 5d);
        calculatorService.minus(10d, 5d);
        calculatorService.multiply(10d, 5d);
        calculatorService.divide(10d, 5d);

        messagesSended.forEach(p -> {
            System.out.println(p);
        });
        assertEquals(4, messagesSended.size());
        assertTrue(messagesSended.toString().contains("add"));
        assertTrue(messagesSended.toString().contains("minus"));
        assertTrue(messagesSended.toString().contains("multiply"));
        assertTrue(messagesSended.toString().contains("divide"));
    }

}
