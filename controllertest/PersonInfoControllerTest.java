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

import com.safetynet.alerts.controller.PersonInfoController;
import com.safetynet.alerts.model.specific.PersonInfo;
import com.safetynet.alerts.service.PersonInfoService;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class PersonInfoControllerTest {

	@InjectMocks
    private PersonInfoController personInfoController;

    @Mock
    private PersonInfoService personInfoService;

    @SuppressWarnings("deprecation")
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testPersonInfo() throws IOException {
        // Créer des données de test
        String firstName = "John";
        String lastName = "Doe";
        List<PersonInfo> expectedPersonInfo = new ArrayList<>();
        expectedPersonInfo.add(new PersonInfo(lastName, lastName, lastName, 0, lastName, null, null));

        // Définir le comportement attendu du service
        when(personInfoService.getpersonInfo(firstName, lastName)).thenReturn(expectedPersonInfo);

        // Appeler la méthode de contrôleur à tester
        List<PersonInfo> actualPersonInfo = personInfoController.personInfo(firstName, lastName);

        // Vérifier les appels et les résultats
        verify(personInfoService, times(1)).getpersonInfo(firstName, lastName);
        assertEquals(expectedPersonInfo, actualPersonInfo);
    }

}

