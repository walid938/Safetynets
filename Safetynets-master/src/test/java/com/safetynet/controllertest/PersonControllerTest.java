package com.safetynet.alerts.controllertest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.safetynet.alerts.controller.PersonController;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.service.PersonService;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class PersonControllerTest {

	  @InjectMocks
	    private PersonController personController;

	    @Mock
	    private PersonService personService;

	    @SuppressWarnings("deprecation")
		@Before
	    public void setup() {
	        MockitoAnnotations.initMocks(this);
	    }
	    
	    @Test
	    public void testListPerson() {
	        // Créer des données de test
	        List<Person> expectedPersons = new ArrayList<>();
	        // Ajouter des personnes à la liste

	        // Définir le comportement attendu du service
	        when(personService.listPerson()).thenReturn(expectedPersons);

	        // Appeler la méthode de contrôleur à tester
	        List<Person> actualPersons = personController.listPerson();

	        // Vérifier les appels et les résultats
	        verify(personService, times(1)).listPerson();
	        assertEquals(expectedPersons, actualPersons);
	    }
	    
	    @Test
	    public void testAddPerson() {
	        // Créer une personne de test
	        Person person = new Person(/* initialize with test data */);

	        // Appeler la méthode de contrôleur à tester
	        personController.addPerson(person);

	        // Vérifier les appels
	        verify(personService, times(1)).addPerson(person);
	    }
	    

	    @Test
	    public void testUpdatePerson() {
	        // Créer une personne de test
	        Person person = new Person(/* initialize with test data */);
	        String firstName = "John";
	        String lastName = "Doe";

	        // Appeler la méthode de contrôleur à tester
	        personController.updatePerson(person, firstName, lastName);

	        // Vérifier les appels
	        verify(personService, times(1)).updatePerson(person, firstName, lastName);
	    }
	    
	    @Test
	    public void testDeletePerson() {
	        // Définir les noms de la personne à supprimer
	        String firstName = "John";
	        String lastName = "Doe";

	        // Appeler la méthode de contrôleur à tester
	        personController.deletePerson(firstName, lastName);

	        // Vérifier les appels
	        verify(personService, times(1)).deletePerson(firstName, lastName);
	    }


}
