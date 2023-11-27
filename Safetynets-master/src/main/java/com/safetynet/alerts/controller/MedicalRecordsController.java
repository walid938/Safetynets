package com.safetynet.alerts.controller;


import com.safetynet.alerts.model.Medicalrecord;
import com.safetynet.alerts.service.MedicalRecordsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicalRecordsController {

    Logger logger = LoggerFactory.getLogger(MedicalRecordsController.class);
    @Autowired
    private MedicalRecordsService medicalRecordService;

    @GetMapping("/medicalRecords")

    public List<Medicalrecord> listMedRecord() {
        logger.info("request list of medicalRecord");
        List<Medicalrecord> medicalRecords =medicalRecordService.listMedRecord();
        logger.info("list of medicalRecord is " + medicalRecords);
        return medicalRecords;
    }

    @PostMapping("/medicalRecord")
    public void addMedicalRecord(@RequestBody Medicalrecord medicalrecord) {
        logger.info("adding new medicalrecord");
        medicalRecordService.addMedicalRecord(medicalrecord);
    }

    @PutMapping("/medicalRecord/{firstName}/{lastName}")
    public void updateMedicalRecord(@RequestBody Medicalrecord medicalrecord, @PathVariable String firstName, @PathVariable String lastName) {
        logger.info("updating medicalrecord which had name : " + firstName + lastName);
        medicalRecordService.updateMedicalRecord(medicalrecord, firstName, lastName);
    }

    @DeleteMapping("/medicalRecord/{firstName}/{lastName}")
    public void deleteMedicalRecord(@PathVariable String firstName, @PathVariable String lastName) {
        logger.info("deleting medicalrecord which had name : " + firstName + lastName);
        medicalRecordService.deleteMedicalRecord(firstName, lastName);
    }
}