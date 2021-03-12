package com.safetynet.alerts.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Medicalrecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.specific.Child;
import com.safetynet.alerts.model.specific.ChildFamily;
import com.safetynet.alerts.utils.JsonDataStructure;

import static java.time.temporal.ChronoUnit.YEARS;
@Service
public class ChildService {
	
	 @Autowired
	private JsonDataStructureService jsonDataStructureService ;
	
	/**
	 * @param address
	 * @return list of children name / first name / age / list of people living at the same address 
	 * @throws IOException
	 */
	
	public ChildFamily getChildFamily(String address) throws IOException
	{
		JsonDataStructure jsonDataStructure = jsonDataStructureService.getJsonDataStructure();
		
		
		List<Person> personAdd = new ArrayList<Person>();
		List<Child> childList = new ArrayList<Child>();
		
		for(Person p : jsonDataStructure.getPersons() ) {
			if(p.getAddress().equals(address)) {
				personAdd.add(new Person(p.getFirstName(), p.getLastName()));
				
				
			}
		}
		
		for (Medicalrecord medicalrecord : jsonDataStructure.getMedicalrecords())
			for(Person p : personAdd) {
				if(medicalrecord.getFirstName().equals(p.getFirstName())&& medicalrecord.getLastName().equals(p.getLastName())){
					String date = medicalrecord.getBirthdate();
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
					LocalDate dateTime = LocalDate.parse(date, formatter);
					
					int age = (int) YEARS.between(dateTime, LocalDate.now());
					if (age <= 18) {
						Child child = new Child(p.getFirstName(), p.getLastName(), age);
						childList.add(child);
					}
				}
			}
	
	
	if (childList.isEmpty()) {
		return null;
	}
	
	for (Child child : childList) {
		personAdd.remove(new Person(child.getFirstName(), child.getFirstName()));
	}
	
	return new ChildFamily(childList, personAdd);

	}
}