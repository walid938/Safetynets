package com.safetynet.alerts.controllertest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.safetynet.alerts.controller.PhoneAlertController;
import com.safetynet.alerts.service.PhoneService;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class PhoneAlertControllerTest {
	 @InjectMocks
	    private PhoneAlertController phoneAlertController;

	    @Mock
	    private PhoneService phoneService;

	    @Before
	    public void setup() {
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    public void testGetPhoneNumber() {
	        // Créer des données de test
	        Integer firestation = 1;
	        List<String> expectedPhoneNumbers = new ArrayList<>();
	        expectedPhoneNumbers.add("841-874-6512");
	        expectedPhoneNumbers.add("841-874-6513");
	        expectedPhoneNumbers.add("841-874-8888");
	        expectedPhoneNumbers.add("841-874-9888");

	        // Définir le comportement attendu du service
	        when(phoneService.getPhoneFirestation(firestation)).thenReturn(expectedPhoneNumbers);

	        // Appeler la méthode de contrôleur à tester
	        List<String> actualPhoneNumbers = phoneAlertController.getPhoneNumber(firestation);

	        // Vérifier les appels et les résultats
	        verify(phoneService, times(1)).getPhoneFirestation(firestation);
	        assertEquals(expectedPhoneNumbers, actualPhoneNumbers);
	    }

}
