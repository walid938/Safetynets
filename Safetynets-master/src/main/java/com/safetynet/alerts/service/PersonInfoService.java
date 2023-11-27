package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Medicalrecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.specific.PersonInfo;
import com.safetynet.alerts.utils.JsonDataStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import static java.time.temporal.ChronoUnit.YEARS;



@Service
public class PersonInfoService {
    @Autowired
    private JsonDataStructureService jsonDataStructureService;

    /**
     * @param firstName
     * @param lastName
     * @return personInfo Nom/prenom/age/adresse/ medications/allergies from the given FirstName and LastName
     */
    public List<PersonInfo> getpersonInfo(String firstName, String lastName) {

        JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();

        List<PersonInfo> personInfos = new ArrayList<>();

        List<Person> persons = new ArrayList<>();

        for (Person p : jsonDataStructure.getPersons()) {
            if (p.getLastName().equals(lastName) && p.getFirstName().equals(firstName)) {
                persons.add(new Person(p.getFirstName(), p.getLastName(), p.getAddress(), p.getEmail(), p.getPhone()));
            }
        }

        for (Person person : persons) {
            for (Medicalrecord m : jsonDataStructure.getMedicalrecords()) {
                if (person.getFirstName().equals(m.getFirstName()) && person.getLastName().equals(m.getLastName())
                        && (person.getLastName().equals(lastName))) {

                    String date = m.getBirthdate();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                    LocalDate dateTime = LocalDate.parse(date, formatter);

                    int age = (int) YEARS.between(dateTime, LocalDate.now());

                    PersonInfo personInfo = new PersonInfo(person.getFirstName(), person.getLastName(),
                            person.getAddress(), age, person.getEmail(), m.getMedications(), m.getAllergies());

                    personInfos.add(personInfo);
                }
            }
        }

        return personInfos;
    }
}

	


