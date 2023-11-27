package com.safetynet.alerts.controllertest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
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

import com.safetynet.alerts.controller.ChildController;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.specific.Child;
import com.safetynet.alerts.model.specific.ChildFamily;
import com.safetynet.alerts.service.ChildService;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class ChildControllerTest {
	@InjectMocks
    private ChildController childController;

    @Mock
    private ChildService childService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    
    @Test
    public void testChildrenAndFamily() throws IOException {
        // Créer des données de test
        String address = "123 Main St";

        // Créer une liste d'enfants et une liste de membres de la famille
        List<Child> childrenList = new ArrayList<>();
        List<Person> familyMembersList = new ArrayList<>();

        // Ajouter des enfants et des membres de la famille à titre d'exemple
        childrenList.add(new Child("Child1", "Doe", 12)); // Exemple avec un enfant de 12 ans
        familyMembersList.add(new Person("John", "Doe", address, "123-456-7890"));
        // Créer un ChildFamily avec les listes d'enfants et de membres de la famille
        ChildFamily expectedChildFamily = new ChildFamily(childrenList, familyMembersList);

        // Définir le comportement attendu du service
        when(childService.getChildFamily(address)).thenReturn(expectedChildFamily);
     // Appeler la méthode de contrôleur à tester
        ChildFamily actualChildFamily = childController.childrenAndFamily(address);

        // Vérifier les appels et les résultats
        verify(childService, times(1)).getChildFamily(address);
        assertEquals(expectedChildFamily, actualChildFamily);
    }
	
}
