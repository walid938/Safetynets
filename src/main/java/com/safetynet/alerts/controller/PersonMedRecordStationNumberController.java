package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.specific.PersonMedRecordStationNumber;
import com.safetynet.alerts.service.PersonMedRecordStationNumberService;
import com.safetynet.alerts.service.PersonMedRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class PersonMedRecordStationNumberController {
Logger logger = LoggerFactory.getLogger(PersonMedRecordStationNumberController.class);
    @Autowired
    PersonMedRecordService personMedRecordService;
    @Autowired
    PersonMedRecordStationNumberService personMedRecordStationNumberService;

    @GetMapping("/fire")
    public PersonMedRecordStationNumber createFire(@RequestParam("address") String address) throws IOException {
        logger.info("request fire:listPersonMedrecord living in address : " + address);
        PersonMedRecordStationNumber personMedRecordStationNumber = personMedRecordStationNumberService.createPersonMedRecordStationNumber(address);
        logger.info(" fire:listPersonMedrecord + intStation living in address : " + address + "is : " + personMedRecordStationNumber);
        return personMedRecordStationNumber;
    }
}