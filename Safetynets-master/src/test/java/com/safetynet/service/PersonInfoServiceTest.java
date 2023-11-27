package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Medicalrecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.specific.PersonInfo;
import com.safetynet.alerts.service.JsonDataStructureService;
import com.safetynet.alerts.service.PersonInfoService;
import com.safetynet.alerts.utils.JsonDataStructure;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonInfoServiceTest {

    @Mock
    private JsonDataStructureService jsonDataStructureService;

    @InjectMocks
    private PersonInfoService personInfoService;




    @Test
    void testGetpersonInfoPersonNotFound() {
        // Mocking the JsonDataStructure with an empty list of persons
        JsonDataStructure jsonDataStructure = new JsonDataStructure();
        jsonDataStructure.setPersons(Collections.emptyList());

        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructure);

        // Performing the test
        List<PersonInfo> result = personInfoService.getpersonInfo("John", "Doe");

        // Asserting the result
        assertEquals(0, result.size());
    }

    }


