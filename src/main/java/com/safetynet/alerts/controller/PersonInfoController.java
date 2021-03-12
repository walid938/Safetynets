package com.safetynet.alerts.controller;


import com.safetynet.alerts.model.specific.PersonInfo;
import com.safetynet.alerts.service.PersonInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
public class PersonInfoController {
 Logger logger = LoggerFactory.getLogger(PersonInfoController.class);

    @Autowired
    PersonInfoService personInfoService;

    @GetMapping("/personInfo")
    public List<PersonInfo> personInfo(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws IOException {
        logger.info("request PersonInfo which his name is : " + firstName + lastName);
        List<PersonInfo> personInfo = personInfoService.getpersonInfo(firstName, lastName);
        logger.info("personInfo which his name is: " + firstName + lastName + "is" + personInfo);
        return personInfo;
    }
}