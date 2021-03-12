package com.safetynet.alerts.service;

import com.safetynet.alerts.data.JsonDataStructureExp;
import com.safetynet.alerts.utils.JsonDataStructure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest

class PhoneServiceTest {
    @Mock
    JsonDataStructureService jsonDataStructureService;

    @InjectMocks
    PhoneService phoneService;

    static JsonDataStructure jsonDataStructureExp;

    @BeforeAll
    static void init() {
        jsonDataStructureExp = JsonDataStructureExp.getJsonData();

    }
    @Test
    //pour la station 2 on obtient deux numéro du telephone dont le premier:"0202020"
    void getPhoneNumberTestFirestation2WichHad2Numbers() {
    	
    }
}