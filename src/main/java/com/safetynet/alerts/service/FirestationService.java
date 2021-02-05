package com.safetynet.alerts.service;


import com.safetynet.alerts.model.*;
import com.safetynet.alerts.model.specific.PersonStats;
import com.safetynet.alerts.utils.JsonDataStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.time.temporal.ChronoUnit.YEARS;

@Service
public class FirestationService {

    @Autowired
    private JsonDataStructureService jsonDataStructureService;

    private Logger logger = Logger.getLogger(FirestationService.class.getName());

    public PersonStats getPersonStats(Integer stationNumber) throws IOException {

    	PersonStats toReturn = new PersonStats();

        List<Firestation> firestations = new ArrayList<>();

        JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();

   
        for (Firestation f : jsonDataStructure.getFirestations()) {
            if (f.getStation().equals(String.valueOf(stationNumber))) {
                firestations.add(f);
            }
        }
     
        for (Firestation firestation : firestations) {
            for (Person p : jsonDataStructure.getPersons()) {
                if (firestation.getAddress().equals(p.getAddress())) {
                  
                   Person personWithAddressAndPhone = new Person(p.getFirstName(),p.getLastName(),
                           p.getAddress(),p.getPhone());
                    toReturn.getPerson().add(personWithAddressAndPhone);
                     if (isPersonAdult(jsonDataStructure, p)) {
                        toReturn.setNumberAdult(toReturn.getNumberAdult() + 1);
                     } else {
                        toReturn.setNumberChild(toReturn.getNumberChild() + 1);
                     }
                }
            }
        }
        return toReturn;
    }

    /**
     *
     * @param jsonDataStructure
     * @param p
     * @return if the person is an adult> 18 years old
     */
    private boolean isPersonAdult(JsonDataStructure jsonDataStructure, Person p) {
        for (Medicalrecord x : jsonDataStructure.getMedicalrecords()) {
            if (x.getFirstName().equals(p.getFirstName()) && x.getLastName().equals(p.getLastName())) {
                String date = x.getBirthdate();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                LocalDate dateTime = LocalDate.parse(date, formatter);

                if (YEARS.between(dateTime, LocalDate.now()) > 18) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }


    public List<Firestation> listFirestations() {
        JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();
        return jsonDataStructure.getFirestations();
    }


    public void addFirestation(Firestation firestation) {
        JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();
        jsonDataStructure.getFirestations().add(firestation);
    }


    public void updateFirestation(Firestation firestation, String address) {
        JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();
        for (int i = 0; i < jsonDataStructure.getFirestations().size(); i++) {
            Firestation f = jsonDataStructure.getFirestations().get(i);
            if (f.getAddress().equals(address)) {
                if (firestation.getAddress() == null) {
                    firestation.setAddress(address);
                }
                jsonDataStructure.getFirestations().set(i, firestation);
                return;
            }
        }
    }

    public void deleteFirestation(String address) {
        JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();
        jsonDataStructure.getFirestations().removeIf(f -> f.getAddress().equals(address));
    }
}