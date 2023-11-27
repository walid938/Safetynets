
package com.safetynet.alerts.utils;

import com.safetynet.alerts.model.*;

import java.util.List;

public class JsonDataStructure {

    private List<Person> persons;
    private List<Medicalrecord> medicalrecords;
    private List<Firestation> firestations;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Medicalrecord> getMedicalrecords() {
        return medicalrecords;
    }

    public void setMedicalrecords(List<Medicalrecord> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }

    public List<Firestation> getFirestations() {
        return firestations;
    }

    public void setFirestations(List<Firestation> firestations) {
        this.firestations = firestations;
    }
}