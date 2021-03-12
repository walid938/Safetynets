package com.safetynet.alerts.service;

import com.safetynet.alerts.data.JsonDataStructureExp;
import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.Medicalrecord;
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

class MedicalRecordServiceTest {
    @Mock
    JsonDataStructureService jsonDataStructureService;

    @InjectMocks
    MedicalRecordsService medicalRecordsService;
    static JsonDataStructure jsonDataStructureExp;

    @BeforeEach
    void init() {
        jsonDataStructureExp = JsonDataStructureExp.getJsonData();
    }

    @Test
    void listMedRecord() {
     when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);

        assertEquals(6,medicalRecordsService.listMedRecord().size());

    }

    @Test
    void addMedicalRecord() {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName("Lina");
        medicalrecord.setLastName("Bouch");
        medicalrecord.setBirthdate("06/02/2006");
        medicalrecord.setMedications(Arrays.asList(new String[]{}));
        medicalrecord.setAllergies(Arrays.asList(new String[]{}));
         //j'ajoute un medical record don la taille de la liste augmente de 6 à 7 ayant comme prénom Lina et pas Cross
        assertEquals(6, jsonDataStructureService.getJsonDataStructure().getMedicalrecords().size());
        medicalRecordsService.addMedicalRecord(medicalrecord);
        assertEquals(7, jsonDataStructureService.getJsonDataStructure().getMedicalrecords().size());
        assertEquals("Lina", medicalrecord.getFirstName());
        assertFalse(medicalrecord.getFirstName()== "Cross");
    }

    @Test
    void updateMedicalRecord() {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);

        Medicalrecord UpdateMedicRecord  = new Medicalrecord();
        UpdateMedicRecord.setBirthdate("04/04/2019");
       //pour la personne Walid Seghdau on modifie la date de naissance et on modifie que l'ancienne date est fausse
        medicalRecordsService.updateMedicalRecord(UpdateMedicRecord,"Walid","Seghdau");
        assertEquals( "04/04/2019",jsonDataStructureService.getJsonDataStructure().getMedicalrecords().get(0).getBirthdate());
        assertEquals( "Walid",jsonDataStructureService.getJsonDataStructure().getMedicalrecords().get(0).getFirstName());
        assertNotEquals("09/10/1988", jsonDataStructureService.getJsonDataStructure().getMedicalrecords().get(0).getBirthdate());

    }



    @Test
    void deleteMedicalRecord() {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);
        // on compte le nombre de personne au nom Cris Raul avant et apres le delete (1 puis devient 0)
        assertEquals(1,
                jsonDataStructureService.getJsonDataStructure()
                        .getPersons()
                        .stream()
                        .filter(medicalrecord -> medicalrecord.getFirstName().equals("Chris")
                                && medicalrecord.getLastName().equals("Raul"))
                        .count()
        );
        medicalRecordsService.deleteMedicalRecord("Chris","Raul");

        assertEquals(0,
                jsonDataStructureService.getJsonDataStructure()
                        .getMedicalrecords()
                        .stream()
                        .filter(medicalrecord-> medicalrecord.getFirstName().equals("Chris")
                                && medicalrecord.getLastName().equals("Raul"))
                        .count()
        );
    }
}