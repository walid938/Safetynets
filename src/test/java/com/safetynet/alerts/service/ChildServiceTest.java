package com.safetynet.alerts.service;

import com.safetynet.alerts.data.JsonDataStructureExp;
import com.safetynet.alerts.model.specific.ChildFamily;
import com.safetynet.alerts.utils.JsonDataStructure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class ChildServiceTest {
    @Mock
    JsonDataStructureService jsonDataStructureService;

    @InjectMocks
    ChildService childService;
    static JsonDataStructure jsonDataStructureExp;

    @BeforeEach
    void init() {
        jsonDataStructureExp = JsonDataStructureExp.getJsonData();
    }

    @Test
    //Cette adresse contient un enfant et un autre membre de famille l'enfant s'appelle Nicolss et l'aute membre s'appelle Walid
    void getChildfamilyAdress14rueHoch() throws IOException {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn( jsonDataStructureExp);
        ChildFamily childfamily1 = childService.getChildFamily("14 rue Hoch");
        assertEquals(1,childfamily1.getChild().size());
        assertEquals(2,childfamily1.getFamily().size());
        assertEquals("Walid",childfamily1.getFamily().get(0).getFirstName());
        assertEquals("Nicolas",childfamily1.getChild().get(0).getFirstName());
    }

    @Test
    //Cette adresse ne contient pas d'enfant donc le resultat sera null
    void getChildfamilyAdress50rueRivoli()  throws IOException {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn( jsonDataStructureExp);
        ChildFamily childfamily2 = childService.getChildFamily("50 rue Rivoli");
        assertEquals(null,childfamily2);
    }

}