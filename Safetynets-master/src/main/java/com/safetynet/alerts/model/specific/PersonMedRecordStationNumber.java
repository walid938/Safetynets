package com.safetynet.alerts.model.specific;

import java.util.List;

public class PersonMedRecordStationNumber {

    private List<PersonMedicalRecord> personMedicalRecord;
    private String station;

    public PersonMedRecordStationNumber(List<PersonMedicalRecord> personMedicalRecord, String station) {
        this.personMedicalRecord = personMedicalRecord;
        this.station = station;
    }

    public List<PersonMedicalRecord> getPersonWithMedicalRecord() {
        return personMedicalRecord;
    }

    public void setPersonWithMedicalRecord(List<PersonMedicalRecord> personMedicalRecord) {
        this.personMedicalRecord = personMedicalRecord;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String i) {
        this.station = i;
    }

    @Override
    public String toString() {
        return "PersonMedRecordAndStationNumber {" +
                "personWithMedicalRecord=" + personMedicalRecord +
                ", station='" + station + '\'' +
                '}';
    }

	

	
	}
