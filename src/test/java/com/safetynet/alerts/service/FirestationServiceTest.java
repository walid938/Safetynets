package com.safetynet.alerts.service;

import com.safetynet.alerts.data.JsonDataStructureExp;
import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.specific.PersonStats;
import com.safetynet.alerts.utils.JsonDataStructure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FirestationServiceTest {
    @Mock
    JsonDataStructureService jsonDataStructureService;

    @InjectMocks
    FirestationService firestationService;
    static JsonDataStructure jsonDataStructureExp;

    @BeforeEach
    void init() {
        jsonDataStructureExp = JsonDataStructureExp.getJsonData();
    }


    @Test
    void addFirestationsAdd1firestationAndChecksizeIsIncreasing() {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);

        Firestation firestation = new Firestation();
        firestation.setStation("100");
        firestation.setAddress("New York");
    
        assertEquals(4, jsonDataStructureService.getJsonDataStructure().getFirestations().size());
        firestationService.addFirestation(firestation);
        assertEquals(5, jsonDataStructureService.getJsonDataStructure().getFirestations().size());
    }
    
    @Test
    void getPersonsWithStatisticsTestStation1Assert1Adult2Child() throws IOException {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);
        //on teste pour la station 1 qU'on a un adulte et deux enfant
        PersonStats  personstats = firestationService.getPersonStats(1);
        assertEquals(1, personstats.getNumberAdult());
        assertEquals(2, personstats.getNumberChild());
    }

    @Test
    void getPersonsWithStatisticsTestStationTestStationNotExisting4() throws IOException {
        //on teste pour la station 4 qui n'existe pas qu'on n'a ni enfants ni adultes
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);
        PersonStats personstats = firestationService.getPersonStats(4);
        assertEquals(0, personstats.getNumberAdult());
        assertEquals(0, personstats.getNumberChild());
        assertFalse (personstats.getPerson().size() == 3);
    }
    
    

    @Test
    void updateFirestation() {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);

        Firestation updatedFirestation = new Firestation();
        updatedFirestation.setStation("2");

        firestationService.updateFirestation(
                updatedFirestation, "14 rue Hoch"
        );
     
        assertEquals("2", jsonDataStructureService.getJsonDataStructure().getFirestations().get(0).getStation());
        assertEquals("14 rue Hoch", jsonDataStructureService.getJsonDataStructure().getFirestations().get(0).getAddress());

        assertNotEquals(1, jsonDataStructureService.getJsonDataStructure().getFirestations().get(0).getStation());
    }

    @Test
    void deleteFirestation() {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);
       
        assertEquals(1,
                jsonDataStructureService.getJsonDataStructure()
                        .getFirestations()
                        .stream()
                        .filter(firestation -> firestation.getAddress().equals("14 rue Hoch"))
                        .count()
        );
        firestationService.deleteFirestation("14 rue Hoch");

        assertEquals(0,
                jsonDataStructureService.getJsonDataStructure()
                        .getFirestations()
                        .stream()
                        .filter(firestation -> firestation.getAddress().equals("14 rue Hoch"))
                        .count()
        );
    }

    @Test
    void deleteFirestationWithWrongAddress() {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);
        // si je supprime une adresse que j 'ai pas je vérifie que le nombre initiale reste le même
        int initialSize = jsonDataStructureService.getJsonDataStructure().getFirestations().size();

        firestationService.deleteFirestation("Cité Safia 2");

        assertEquals(initialSize,
                jsonDataStructureService.getJsonDataStructure()
                        .getFirestations()
                        .size()
        );
    }
}