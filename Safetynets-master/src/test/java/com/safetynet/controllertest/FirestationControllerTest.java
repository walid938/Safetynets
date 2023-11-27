package com.safetynet.alerts.controllertest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.safetynet.alerts.controller.FirestationController;
import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.specific.PersonStats;
import com.safetynet.alerts.service.FirestationService;

@SuppressWarnings("unused")
@ExtendWith(SpringExtension.class)
@SpringBootTest
class FirestationControllerTest {

	 @InjectMocks
	    private FirestationController firestationController;

	    @Mock
	    private FirestationService firestationService;

	    @Before
	    public void setup() {
	        MockitoAnnotations.initMocks(this);
	    }
	
	    @Test
	    public void testGetPersonStats() throws IOException {
	        // Créer des données de test
	        Integer stationNumber = 1;
	        PersonStats expectedPersonStats = new PersonStats(/* initialize with test data */);

	        // Définir le comportement attendu du service
	        when(firestationService.getPersonStats(stationNumber)).thenReturn(expectedPersonStats);

	        // Appeler la méthode de contrôleur à tester
	        PersonStats actualPersonStats = firestationController.getPersonStats(stationNumber);

	        // Vérifier les appels et les résultats
	        verify(firestationService, times(1)).getPersonStats(stationNumber);
	        assertEquals(expectedPersonStats, actualPersonStats);
	    }
	    
	    @Test
	    public void testAddFirestation() {
	        // Créer des données de test
	        Firestation firestation = new Firestation(/* initialize with test data */);

	        // Appeler la méthode de contrôleur à tester
	        firestationController.addFairestation(firestation);

	        // Vérifier les appels
	        verify(firestationService, times(1)).addFirestation(firestation);
	    }

	    @Test
	    public void testUpdateFirestation() {
	        // Créer des données de test
	        Firestation firestation = new Firestation(/* initialize with test data */);
	        String address = "123 Main St";

	        // Appeler la méthode de contrôleur à tester
	        firestationController.updateFirestation(firestation, address);

	        // Vérifier les appels
	        verify(firestationService, times(1)).updateFirestation(firestation, address);
	    }
	    
	    @Test
	    public void testDeleteFirestation() {
	        // Créer des données de test
	        String address = "123 Main St";

	        // Appeler la méthode de contrôleur à tester
	        firestationController.deleteFirestation(address);

	        // Vérifier les appels
	        verify(firestationService, times(1)).deleteFirestation(address);
	    }
}
