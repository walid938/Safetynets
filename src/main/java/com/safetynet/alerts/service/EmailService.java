package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.utils.JsonDataStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JsonDataStructureService jsonDataStructureService;
    /**
     *
     * @param city
     * @return list of emails from people living in a given city 
     */
    public List<String> emails(String city) {

        JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();

        List<String> emails = new ArrayList<>();

        for (Person p : jsonDataStructure.getPersons()) {
            if (p.getCity().equals(city)) {
                emails.add(p.getEmail());
            }
        }
        return emails;
    }
}