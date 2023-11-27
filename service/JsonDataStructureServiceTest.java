package com.safetynet.alerts.service;

import com.safetynet.alerts.data.JsonDataStructureExp;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.utils.JsonDataStructure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JsonDataStructureServiceTest {

    @Mock
    JsonDataStructureService jsonDataStructureService;

    static JsonDataStructure jsonDataStructureExp;

    @BeforeEach
    void init() {
        jsonDataStructureExp = JsonDataStructureExp.getJsonData();
    }


    @Test
    void testPersonNameFromJsonDataStructurePersonsList() {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);
        
        assertEquals(4,jsonDataStructureService.getJsonDataStructure().getFirestations().size());
        assertEquals(6,jsonDataStructureService.getJsonDataStructure().getPersons().size());
       
        for(Person x : jsonDataStructureExp.getPersons()) {
           if(x.getFirstName().equals("Walid")){
               x.getAddress().equals("14 rue Hoch");
           }
       }
    }
}