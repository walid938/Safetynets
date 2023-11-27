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

import com.safetynet.alerts.controller.FloodStationsController;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.specific.Foyer;
import com.safetynet.alerts.model.specific.PersonMedicalRecord;
import com.safetynet.alerts.service.StationNumberService;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class FloodStationsControllerTest {

	@InjectMocks
    private FloodStationsController floodStationsController;

    @Mock
    private StationNumberService stationNumberService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testGetFoyer() {
        // Créer des données de test
        List<String> stations = new ArrayList<>();
        stations.add("1509 Culver St");
        stations.add("29 15th St");

        // Créer des foyers de test
        List<PersonMedicalRecord> medicalRecords1 = new ArrayList<>();
        List<PersonMedicalRecord> medicalRecords2 = new ArrayList<>();

        Foyer foyer1 = new Foyer("3", "1509 Culver St", medicalRecords1);
        Foyer foyer2 = new Foyer("2", "29 15th St", medicalRecords2);

        List<Foyer> expectedFoyers = new ArrayList<>();
        expectedFoyers.add(foyer1);
        expectedFoyers.add(foyer2);
        
        // Définir le comportement attendu du service
        when(stationNumberService.getFoyerListForStations(stations)).thenReturn(expectedFoyers);

        // Appeler la méthode de contrôleur à tester
        List<Foyer> actualFoyers = floodStationsController.getfoyer(stations);

        // Vérifier les appels et les résultats
        verify(stationNumberService, times(1)).getFoyerListForStations(stations);
        assertEquals(expectedFoyers, actualFoyers);
    }
   





	

}
