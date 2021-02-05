package com.safetynet.alerts.model.specific;

import java.util.List;

public class Foyer {

    private String station;
    private String address;
    private List<PersonMedicalRecord> personMedicalRecords;

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<PersonMedicalRecord> getPersonMedicalRecords() {
        return personMedicalRecords;
    }

    public void setPersonMedicalRecord(List<PersonMedicalRecord> personMedicalRecords) {
        this.personMedicalRecords = personMedicalRecords;
    }

    public Foyer(String station, String address, List<PersonMedicalRecord> personMedicalRecords) {
        this.station = station;
        this.address = address;
        this.personMedicalRecords = personMedicalRecords;
    }

    @Override
    public String toString() {
        return "Foyer{" +
                "station='" + station + '\'' +
                ", address='" + address + '\'' +
                ", personMedicalRecords=" + personMedicalRecords +
                '}';
    }
}