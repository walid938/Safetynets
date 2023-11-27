package com.safetynet.alerts.service;


import com.safetynet.alerts.model.*;
import com.safetynet.alerts.utils.JsonDataStructure;
import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.Medicalrecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.specific.Foyer;
import com.safetynet.alerts.model.specific.PersonMedicalRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.time.temporal.ChronoUnit.YEARS;

@Service
public class StationNumberService {

    @Autowired
    private JsonDataStructureService jsonDataStructureService;

    /**
     *
     * @param address
     * @return une station correspondante
     */
    public String getStationByAddress(String address) {

        JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();
        String station = null;
        //à partir de l'adresse d'une personne p on cherche la même adresse dans le firestation qui contient le numéro de station associé
        for (Firestation f : jsonDataStructure.getFirestations()) {
            for (Person p : jsonDataStructure.getPersons()) {

                if (f.getAddress().equals(address) && (f.getAddress().equals(p.getAddress()))) {
                    station = f.getStation(); // pour eviter d'avoir le nombre de station répetée on fais le break
                    break;
                }
            }
        }
        return station;
    }

    /**
     *
     * @param stations (liste des stations)
     * @return liste des foyers:(station/adresse/liste personWithMedicalRecord)
     */
    public List<Foyer> getFoyerListForStations(List<String> stations) {

        JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();

        List<Firestation> StationsUtilisateur = new ArrayList<>();

        List<Foyer> foyers = new ArrayList<>();

     
        for (String id : stations) {
            for (Firestation firestation : jsonDataStructure.getFirestations()) {
                if (firestation.getStation().equals(id)) {
                    StationsUtilisateur.add(firestation);
                }
            }
        }

       
        for (Firestation firestation : StationsUtilisateur) {
            for (Medicalrecord m : jsonDataStructure.getMedicalrecords()) {
                for (Person person : jsonDataStructure.getPersons()) {
                    if (person.getFirstName().equals(m.getFirstName()) && person.getLastName().equals(m.getLastName())
                            && (person.getAddress()).equals(firestation.getAddress())) {

                        String date = m.getBirthdate();

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                        LocalDate dateTime = LocalDate.parse(date, formatter);

                        YEARS.between(dateTime, LocalDate.now());
                        int age = (int) YEARS.between(dateTime, LocalDate.now());

                        PersonMedicalRecord personWithMedicalRecord = new PersonMedicalRecord(person.getFirstName(),
                                person.getLastName(), person.getPhone(), age, m.getMedications(), m.getAllergies());
                        //si l'adresse du foyer correspond à celle de personWithMedicalRecord alors on ajoute cette personne
                        // au même foyer sinon on crée un nouveau foyer et on ajoute les personnes dedans
                        boolean dejaExistant = false;
                        for (Foyer foyer : foyers) {
                            if (foyer.getAddress().equals(person.getAddress())) {
                                foyer.getPersonMedicalRecords().add(personWithMedicalRecord);
                                dejaExistant = true;
                            }
                        }
                        if (dejaExistant != true) {
                            Foyer foyer = new Foyer(firestation.getStation(), firestation.getAddress(), new ArrayList<>());
                            foyer.getPersonMedicalRecords().add(personWithMedicalRecord);
                            foyers.add(foyer);
                        }
                    }
                }
            }
        }
        return foyers;
    }
}