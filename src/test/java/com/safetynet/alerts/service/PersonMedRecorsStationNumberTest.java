package com.safetynet.alerts.service;

import com.safetynet.alerts.data.JsonDataStructureExp;
import com.safetynet.alerts.model.specific.PersonMedRecordStationNumber;
import com.safetynet.alerts.utils.JsonDataStructure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PersonMedRecorsStationNumberTest {

    @Mock
    JsonDataStructureService jsonDataStructureService;

    @InjectMocks
    private PersonMedRecordService personMedRecordService;

    @InjectMocks
    private StationNumberService stationNumberService;

    static JsonDataStructure jsonDataStructureExp;

    @BeforeEach
    void init() {
        jsonDataStructureExp = JsonDataStructureExp.getJsonData();
    }

    @Test
    void fireTest50RueRivoli() {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);

        PersonMedRecordStationNumberService personMedRecordAndStationNumberService = new PersonMedRecordStationNumberService(personMedRecordService, stationNumberService);
         //on teste pour une personne habitant à 50RueRivoli que son num de sation =3
        PersonMedRecordStationNumber personMedRecordAndStationNumberExp = personMedRecordAndStationNumberService.createPersonMedRecordStationNumber("50 rue Rivoli");
        assertEquals("3", personMedRecordAndStationNumberExp.getStation());
    }

    @Test
    void fireTest10RueJeanClaudeMary() {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);

        PersonMedRecordStationNumberService personMedRecordAndStationNumberService = new PersonMedRecordStationNumberService(personMedRecordService, stationNumberService);
        //on teste pour une personne habitant à une adresse qui n'existe pas que son num de sation est null
        PersonMedRecordStationNumber personMedRecordAndStationNumberExp = personMedRecordAndStationNumberService.createPersonMedRecordStationNumber("10 Rue Jean Claude Mary");
        assertNull(personMedRecordAndStationNumberExp.getStation());
    }
    @Test
    void fireTest10RueVictorhugo() {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);

        PersonMedRecordStationNumberService personMedRecordAndStationNumberService = new PersonMedRecordStationNumberService(personMedRecordService, stationNumberService);
         // //on teste pour une personne habitant à 10RueVictorhugo que son num de sation =1
        PersonMedRecordStationNumber personMedRecordAndStationNumberExp1 = personMedRecordAndStationNumberService.createPersonMedRecordStationNumber("10 rue Victor hugo");
        assertEquals("1", personMedRecordAndStationNumberExp1.getStation());
    }
}