package com.safetynet.alerts.controllertest;

import com.safetynet.alerts.controller.MedicalRecordsController;
import com.safetynet.alerts.model.Medicalrecord;
import com.safetynet.alerts.service.MedicalRecordsService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MedicalRecordsControllerTest {

    @Mock
    private MedicalRecordsService medicalRecordsService;

    @InjectMocks
    private MedicalRecordsController medicalRecordsController;

    @Test
    public void testListMedRecord() {
        // Arrange
        List<Medicalrecord> expectedMedicalRecords = Arrays.asList(
                new Medicalrecord("John", "Doe", "01/01/1990", Arrays.asList("Medication1"), Arrays.asList("Allergy1")),
                new Medicalrecord("Jane", "Doe", "02/02/1995", Arrays.asList("Medication2"), Arrays.asList("Allergy2"))
        );
        when(medicalRecordsService.listMedRecord()).thenReturn(expectedMedicalRecords);

        // Act
        List<Medicalrecord> result = medicalRecordsController.listMedRecord();

        // Assert
        assertEquals(expectedMedicalRecords, result);
        verify(medicalRecordsService, times(1)).listMedRecord();
    }

    @Test
    public void testAddMedicalRecord() {
        // Arrange
        Medicalrecord medicalrecord = new Medicalrecord("John", "Doe", "01/01/1990", Arrays.asList("Medication1"), Arrays.asList("Allergy1"));

        // Act
        medicalRecordsController.addMedicalRecord(medicalrecord);

        // Assert
        verify(medicalRecordsService, times(1)).addMedicalRecord(medicalrecord);
    }

    @Test
    public void testUpdateMedicalRecord() {
        // Arrange
        Medicalrecord medicalrecord = new Medicalrecord("John", "Doe", "01/01/1990", Arrays.asList("Medication1"), Arrays.asList("Allergy1"));

        // Act
        medicalRecordsController.updateMedicalRecord(medicalrecord, "John", "Doe");

        // Assert
        verify(medicalRecordsService, times(1)).updateMedicalRecord(medicalrecord, "John", "Doe");
    }

    @Test
    public void testDeleteMedicalRecord() {
        // Act
        medicalRecordsController.deleteMedicalRecord("John", "Doe");

        // Assert
        verify(medicalRecordsService, times(1)).deleteMedicalRecord("John", "Doe");
    }
}
