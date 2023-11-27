package com.safetynet.alerts.controller;


import com.safetynet.alerts.model.specific.Foyer;
import com.safetynet.alerts.service.StationNumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class FloodStationsController {
Logger logger = LoggerFactory.getLogger(FloodStationsController.class);
    @Autowired
    StationNumberService stationNumberService;

    @GetMapping("/flood/stations")
    public List<Foyer> getfoyer(@RequestParam("stations") List<String> stations) {
        logger.info("request List of foyer in list of stations :" + stations);
        List<Foyer> foyer = stationNumberService.getFoyerListForStations(stations);
        logger.info("request List of foyer in list of stations :" + foyer);
        return foyer;
    }

}