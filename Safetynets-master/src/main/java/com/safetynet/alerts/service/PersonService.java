package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.utils.JsonDataStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private JsonDataStructureService jsonDataStructureService;

    public List<Person> listPerson() {
        JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();
        return jsonDataStructure.getPersons();
    }

    public void addPerson(Person person) {
        JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();
        jsonDataStructure.getPersons().add(person);
    }

    public void updatePerson(Person person, String firstName, String lastName) {
        JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();

        //pour une personne donné ayant le même nom et prénom que celui donné par l'utilisateur,
        // on remplace la nouvelle personne que celle ayant ces données
        for(int i=0; i< jsonDataStructure.getPersons().size(); i++){
            Person p = jsonDataStructure.getPersons().get(i);
            if(p.getFirstName().equals(firstName)&&(p.getLastName().equals(lastName))){

                if (person.getFirstName() == null) {
                    person.setFirstName(firstName);
                } if (person.getLastName() == null) {
                    person.setLastName(lastName);
                }
                jsonDataStructure.getPersons().set(i,person);
                return;
            }
        }
    }

    public void deletePerson(String firstName, String lastName) {
        JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();
        jsonDataStructure.getPersons().removeIf(p->p.getFirstName().equals(firstName) && p.getLastName().equals(lastName));
    }
}