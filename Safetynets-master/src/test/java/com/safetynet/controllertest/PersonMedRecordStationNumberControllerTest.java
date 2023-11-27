package com.safetynet.alerts.controllertest;

import com.safetynet.alerts.controller.PersonMedRecordStationNumberController;
import com.safetynet.alerts.model.specific.PersonMedRecordStationNumber;
import com.safetynet.alerts.service.PersonMedRecordService;
import com.safetynet.alerts.service.PersonMedRecordStationNumberService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PersonMedRecordStationNumberControllerTest {

    @Mock
    private PersonMedRecordService personMedRecordService;

    @Mock
    private PersonMedRecordStationNumberService personMedRecordStationNumberService;

    @InjectMocks
    private PersonMedRecordStationNumberController personMedRecordStationNumberController;

    @Test
    public void testCreateFire() throws IOException {
        // Arrange
        String address = "123 Main St";
        PersonMedRecordStationNumber expectedPersonMedRecordStationNumber = new PersonMedRecordStationNumber(null, address);
        // Mocking the service method
        when(personMedRecordStationNumberService.createPersonMedRecordStationNumber(address)).thenReturn(expectedPersonMedRecordStationNumber);

        // Act
        PersonMedRecordStationNumber result = personMedRecordStationNumberController.createFire(address);

        // Assert
        assertEquals(expectedPersonMedRecordStationNumber, result);
        verify(personMedRecordStationNumberService, times(1)).createPersonMedRecordStationNumber(address);
    }
}

