package com.safetynet.alerts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.utils.JsonDataStructure;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PhoneServiceTest {

    @Mock
    private JsonDataStructureService jsonDataStructureService;

    @InjectMocks
    private PhoneService phoneService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPhoneFirestation() {
        // Mocking the JsonDataStructure
        JsonDataStructure jsonDataStructure = new JsonDataStructure();
        jsonDataStructure.setPersons(Arrays.asList(
                new Person("John", "Doe", "address1", "john.doe@example.com", "123456789"),
                new Person("Jane", "Doe", "address2", "jane.doe@example.com", "987654321")
        ));
        jsonDataStructure.setFirestations(Arrays.asList(
                new Firestation("address1", "1"),
                new Firestation("address2", "1")
        ));

        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructure);

        // Performing the test
        List<String> result = phoneService.getPhoneFirestation(1);

        // Asserting the result
        List<String> expected = Arrays.asList("123456789", "987654321");
        assertEquals(expected, result);
    }
}
