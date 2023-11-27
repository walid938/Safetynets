package com.safetynet.alerts.controllertest;

import com.safetynet.alerts.controller.EmailController;
import com.safetynet.alerts.service.EmailService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EmailControllerTest {

    @Mock
    private EmailService emailService;

    @Mock
    private Logger logger;

    @InjectMocks
    private EmailController emailController;

    @Test
    public void testGetEmails() {
        // Arrange
        String city = "Culver";
        List<String> expectedEmails = Arrays.asList("email1@example.com", "email2@example.com");

        // Mocking behavior
        when(emailService.emails(city)).thenReturn(expectedEmails);

        // Act
        List<String> result = emailController.getemails(city);

        // Assert
        assertEquals(expectedEmails, result);
        verify(logger).info("request list emails living in city: " + city);
        verify(logger).info("list emails living in city: " + city + ": " + expectedEmails);
    }
}
