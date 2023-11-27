package com.safetynet.alerts.service;

import com.safetynet.alerts.data.JsonDataStructureExp;
import com.safetynet.alerts.model.specific.Foyer;
import com.safetynet.alerts.utils.JsonDataStructure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest

class StationNumberServiceTest {
    @Mock
    JsonDataStructureService jsonDataStructureService;

    @InjectMocks
    StationNumberService stationNumberService;

    static JsonDataStructure jsonDataStructureExp;
    @BeforeEach
    void init() {
        jsonDataStructureExp = JsonDataStructureExp.getJsonData();
    }

    @Test
   
    void getStationByAddressTestStationIn10RueLibertéIs2 () {
            when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);
            String station = stationNumberService.getStationByAddress("10 rue liberté");
        assertEquals("2",jsonDataStructureService.getJsonDataStructure().getFirestations().get(1).getStation());
        assertNotEquals("5",jsonDataStructureService.getJsonDataStructure().getFirestations().get(3).getStation());
    }
    
    @Test
    //Si je donne une listes de 2 stations 1 et 2 j'attends avoir 3 foyers dont l'adresse du 1 er foyer:14 rue Hoch
    //et du 3 eme foyer est 10 rue liberté
    void getFoyerListForStationsInList1And2WhichHave3Foyers() {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);
        List<Foyer> foyers = stationNumberService.getFoyerListForStations(Arrays.asList("1", "2"));
        assertEquals(3,foyers.size());
        assertEquals("10 rue liberté",foyers.get(2).getAddress());
        assertEquals("14 rue Hoch",foyers.get(0).getAddress());
        assertEquals("1",foyers.get(0).getStation());
        assertNotEquals("10 Rue Jean Jacques Roussou",foyers.get(0).getAddress());
    }

   
}