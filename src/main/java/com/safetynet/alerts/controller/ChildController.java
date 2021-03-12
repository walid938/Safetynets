package com.safetynet.alerts.controller;
       



import com.safetynet.alerts.model.specific.ChildFamily;
import com.safetynet.alerts.service.ChildService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;



@RestController
public class ChildController {
 Logger logger = LoggerFactory.getLogger(ChildController.class);
    @Autowired
    ChildService childService;

    @GetMapping("/childAlert")
    public ChildFamily childrenAndFamily(@RequestParam("address") String address) throws IOException {
        logger.info("request list childen living in address: " + address);
        ChildFamily childrenAndFamily = childService.getChildFamily(address);
        logger.info("list childen living in address: " + address + ": " + childrenAndFamily);
        return childrenAndFamily;
    }

}
