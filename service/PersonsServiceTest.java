package com.safetynet.alerts.service;

import com.safetynet.alerts.data.JsonDataStructureExp;
import com.safetynet.alerts.model.Medicalrecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.utils.JsonDataStructure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PersonsServiceTest {
    @Mock
    JsonDataStructureService jsonDataStructureService;

    @InjectMocks
    PersonService personService;
    static JsonDataStructure jsonDataStructureExp;

    @BeforeEach
    void init() {
        jsonDataStructureExp = JsonDataStructureExp.getJsonData();
    }

    @Test
    void listPerson() {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);
        assertEquals(6, personService.listPerson().size());
    }

    @Test
    void addPersonVerifiyingSizeIs7() {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);
        Person person = new Person();
        person.setFirstName("bilal");
        person.setLastName("jacob");
        person.setAddress("14 Rue Hoch");
        person.setCity("paris");
        person.setEmail("bil@gmail.com");
        person.setPhone("454554");
        personService.addPerson(person);
        //si on ajoute une personne à la liste donc la taille de liste devient 7, son prénom James et pas Zack
        assertEquals(7, jsonDataStructureService.getJsonDataStructure().getPersons().size());
        assertEquals("bilal", jsonDataStructureService.getJsonDataStructure().getPersons().get(6).getFirstName());
        assertNotEquals("jacob", jsonDataStructureService.getJsonDataStructure().getPersons().get(6).getFirstName());
    }

    @Test
    void updatePersonModifiyingHerEmail() {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);

        Person updatePerson = new Person();
        updatePerson.setEmail("walids@gmail.com");
      //on modifie pour la personne walid l'adresse mail qui devient ;walids@gmail.com et on teste
        // que l'ancienne adresse n'est plus valable

        personService.updatePerson(updatePerson, "Walid", "Seghdau");
        assertEquals("walids@gmail.com", jsonDataStructureService.getJsonDataStructure().getPersons().get(0).getEmail());
        assertEquals("Walid", jsonDataStructureService.getJsonDataStructure().getPersons().get(0).getFirstName());
        assertNotEquals("walid@gmail.com", jsonDataStructureService.getJsonDataStructure().getMedicalrecords().get(0).getBirthdate());

    }

    @Test
    void deletePersonNamedChrisRaul() {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);
      //On compte le nombre de personnes ayant le nom Chris Raul (1),
      //on appelle la méthode de delete de cette personne puis on refait le compte et on vérifie qu'elle devient 0
        assertEquals(1,
                jsonDataStructureService.getJsonDataStructure()
                        .getMedicalrecords()
                        .stream()
                        .filter(person -> person.getFirstName().equals("Chris")
                                && person.getLastName().equals("Raul"))
                        .count()
        );
        personService.deletePerson("Chris", "Raul");

        assertEquals(0,
                jsonDataStructureService.getJsonDataStructure()
                        .getPersons()
                        .stream()
                        .filter(person -> person.getFirstName().equals("Chris")
                                && person.equals("Raul"))
                        .count()
        );
    }
}