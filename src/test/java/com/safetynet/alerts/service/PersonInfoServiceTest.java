package com.safetynet.alerts.service;

import com.safetynet.alerts.data.JsonDataStructureExp;
import com.safetynet.alerts.model.specific.PersonInfo;
import com.safetynet.alerts.utils.JsonDataStructure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PersonInfoServiceTest {
@Mock
JsonDataStructureService jsonDataStructureService;

    @InjectMocks
    PersonInfoService  personInfoService;
    static JsonDataStructure jsonDataStructureExp;

    @BeforeEach
     void init() {
        jsonDataStructureExp = JsonDataStructureExp.getJsonData();
    }
    @Test
    void personInfoTestChrisMartin() {
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);
        
        List<PersonInfo> personInfo = personInfoService.getpersonInfo("Chris","Raul");
        
        assertEquals("10 rue liberté",personInfo.get(0).getAddress());
        assertFalse(personInfo.get(0).getAge() ==5);

    }
    
 
   /*
    @Test        
	void PersonInfoTest2List()
	{
		
		when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);
	 
		List<PersonInfo> personInfo =  personInfoService.getpersonInfo("Walid", "Seghdau");
		
	    assertEquals("14 rue Hoch",personInfo.get(0).getAddress() );
	    assertEquals("walid@gmail.com",personInfo.get(0).getEmail());
	    assertEquals("Nicolas",personInfo.get(1).getFirstName());
	    assertEquals("nicolas@gmail.com",personInfo.get(1).getEmail());
	}
    @Test
    void personInfoTestBobMarly() {
        //on teste si je donne le nom de Bob Marly, son age sera 61, et  présente d'allergie
        when(jsonDataStructureService.getJsonDataStructure()).thenReturn(jsonDataStructureExp);
        
        List<PersonInfo> y = personInfoService.getpersonInfo("Bob","Marly");
        
        assertEquals("Bob@gmail.com",y.get(0).getEmail());
        assertFalse(y.get(0).getAllergies().equals(Arrays.asList(new String[]{})));
        assertEquals(62, y.get(0).getAge());

    }
   */
}