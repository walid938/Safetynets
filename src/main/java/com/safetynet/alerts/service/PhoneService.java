package com.safetynet.alerts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.utils.JsonDataStructure;


@Service
public class PhoneService {

		
		private JsonDataStructureService jsonDataStructureService;
		
		
public List<String> getPhoneFirestation(int station){
	List<Firestation> firestations = new ArrayList();
	
	List <String> phone = new ArrayList();
	
	 JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();
	 
	 
	 for (Firestation f : jsonDataStructure.getFirestations())
		 if (f.getStation().equals(station))
			 firestations.add(f);
	 {
		 
		 for(Firestation firestation : firestations)
			 for(Person p : jsonDataStructure.getPersons()) {
				 if(firestation.getAddress().equals(p.getAddress()));
				 phone.add(p.getPhone());
			 }
				 
		 
	 }
	return phone;
	
	
}
	
}
