package com.safetynet.alerts.service;


import com.safetynet.alerts.model.specific.PersonMedRecordStationNumber;
import com.safetynet.alerts.model.specific.PersonMedicalRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonMedRecordStationNumberService {

    private PersonMedRecordService personMedRecordService;
    private StationNumberService stationNumberService;

    @Autowired
    public PersonMedRecordStationNumberService(PersonMedRecordService personMedRecordService, StationNumberService stationNumberService) {
        this.personMedRecordService = personMedRecordService;
        this.stationNumberService = stationNumberService;
    }
    /**
     * 
     * @param address
     * @return  station number as well as the list of people
      * / with their medical info 
     * 
     */

    public PersonMedRecordStationNumber createPersonMedRecordStationNumber(String address) {

        List<PersonMedicalRecord> total = personMedRecordService.getpersonMedRecord(address);

        String stats = stationNumberService.getStationByAddress(address);

        return new PersonMedRecordStationNumber(total, stats);
    }
}