package com.safetynet.alerts.controller;


import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.specific.PersonStats;
import com.safetynet.alerts.service.FirestationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
public class FirestationController {

Logger logger = LoggerFactory.getLogger(FirestationController.class);
    @Autowired
    FirestationService firestationService;

    @GetMapping("/firestation")
    public PersonStats getPersonStats(@RequestParam("stationNumber") Integer stationNumber) throws IOException {
        logger.info("request personsWithStatistic in station number : " +  stationNumber);
        PersonStats personStats = firestationService.getPersonStats(stationNumber);
        logger.info(" personsWithStatistic in station number : " +  stationNumber + "is : " + personStats);
        return personStats;

    }


    @PostMapping("/firestation")
     public void addFairestation(@RequestBody Firestation firestation) {
        logger.info("adding new firestation " + firestation);
        firestationService.addFirestation(firestation);
    }

    @PutMapping("/firestation/{address}")
    public void updateFirestation(@RequestBody Firestation firestation, @PathVariable String address) {
        logger.info("updating firestation in address : " + address + "firestation become :"+ firestation);
        firestationService.updateFirestation(firestation, address);
    }

    @DeleteMapping("/firestation/{address}")
    public void deleteFirestation(@PathVariable String address) {
        logger.info("deleting  firestation in address : " + address);
        firestationService.deleteFirestation(address);
    }

}

