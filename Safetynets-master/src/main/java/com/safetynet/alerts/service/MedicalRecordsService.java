package com.safetynet.alerts.service;


import com.safetynet.alerts.model.Medicalrecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.utils.JsonDataStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordsService {
    @Autowired
    private JsonDataStructureService jsonDataStructureService;

    public List<Medicalrecord> listMedRecord() {
        JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();
        return jsonDataStructure.getMedicalrecords();
    }

    public void addMedicalRecord(Medicalrecord medicalrecord) {
        JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();
        jsonDataStructure.getMedicalrecords().add(medicalrecord);
    }

    public void updateMedicalRecord(Medicalrecord medicalrecord, String firstName, String lastName) {
        JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();
        for(int i=0; i< jsonDataStructure.getMedicalrecords().size(); i++){
            Medicalrecord m = jsonDataStructure.getMedicalrecords().get(i);
          
            if(m.getFirstName().equals(firstName)&&(m.getLastName().equals(lastName))){

                if (medicalrecord.getFirstName() == null) {
                    medicalrecord.setFirstName(firstName);
                } if (medicalrecord.getLastName() == null) {
                    medicalrecord.setLastName(lastName);
                }
                jsonDataStructure.getMedicalrecords().set(i,medicalrecord);
                return;
            }
        }
    }


    public void deleteMedicalRecord(String firstName, String lastName) {
        JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();
        jsonDataStructure.getMedicalrecords().removeIf(m->m.getFirstName().equals(firstName) && m.getLastName().equals(lastName));
    }
}