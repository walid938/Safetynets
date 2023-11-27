package com.safetynet.alerts.controller;


import com.safetynet.alerts.service.PhoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneAlertController {
Logger logger = LoggerFactory.getLogger(PhoneAlertController.class);
    @Autowired
    PhoneService phoneService;

    @GetMapping("/phoneAlert")
    public List<String> getPhoneNumber(@RequestParam("firestation") Integer firestation) {
       logger.info("request list of phone which firstation number is " + firestation);
        List<String> phoneNumber = phoneService.getPhoneFirestation(firestation);
        logger.info("list of phone  is " + phoneNumber);
        return phoneNumber;
    }

}