package com.safetynet.alerts.data;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.Medicalrecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.utils.JsonDataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonDataStructureExp {

    public static JsonDataStructure getJsonData() {
//construction de 6 personnes
        Person p1 = new Person();
        p1.setFirstName("Walid");
        p1.setLastName("Seghdau");
        p1.setAddress("14 rue Hoch");
        p1.setEmail("walid@gmail.com");
        p1.setPhone("44545454");
        p1.setCity("Paris");
        p1.setZip("75000");

        Person p2= new Person();
        p2.setFirstName("Chris");
        p2.setLastName("Raul");
        p2.setAddress("10 rue liberté");
        p2.setEmail("chris@gmail.com");
        p2.setPhone("0202020");
        p2.setCity("Paris");
        p2.setZip("75000");

        Person p3 = new Person();
        p3.setFirstName("Amelie");
        p3.setLastName("Pascal");
        p3.setAddress("10 rue liberté");
        p3.setEmail("amelie@gmail.com");
        p3.setPhone("0142020");
        p3.setCity("Paris");
        p3.setZip("75000");

        Person p4 = new Person();
        p4.setFirstName("Guillaume");
        p4.setLastName("Raul");
        p4.setAddress("10 rue Victor hugo");
        p4.setEmail("guillaume@gmail.com");
        p4.setPhone("0202020");
        p4.setCity("Paris");
        p4.setZip("75000");

        Person p5 = new Person();
        p5.setFirstName("Nicolas");
        p5.setLastName("Seghdau");
        p5.setAddress("14 rue Hoch");
        p5.setEmail("nicolas@gmail.com");
        p5.setPhone("0202020");
        p5.setCity("Paris");
        p5.setZip("75000");

        Person p6 = new Person();
        p6.setFirstName("Bob");
        p6.setLastName("Marly");
        p6.setAddress("50 rue Rivoli");
        p6.setEmail("Bob@gmail.com");
        p6.setPhone("0202020");
        p6.setCity("Paris");
        p6.setZip("75000");

        //Construction de 4 firestations
        Firestation f1 = new Firestation();
        f1.setAddress("14 rue Hoch");
        f1.setStation("1");

        Firestation f2 = new Firestation();
        f2.setAddress("10 rue liberté");
        f2.setStation("2");

        Firestation f3 = new Firestation();
        f3.setAddress("50 rue Rivoli");
        f3.setStation("3");

        Firestation f4= new Firestation();
        f4.setAddress("10 rue Victor hugo");
        f4.setStation("1");

        //Construction de 6 medicalRecords liés aux personnes
        Medicalrecord m1 = new Medicalrecord();
        m1.setFirstName("Walid");
        m1.setLastName("Seghdau");
        m1.setBirthdate("09/10/1988");
        m1.setMedications(Arrays.asList(new String[]{"peni", "analgan"}));
        m1.setAllergies(Arrays.asList(new String[]{"pollen"}));

        Medicalrecord m2 = new Medicalrecord();
        m2.setFirstName("Chris");
        m2.setLastName("Raul");
        m2.setBirthdate("01/03/2018");
        m2.setMedications(Arrays.asList(new String[]{}));
        m2.setAllergies(Arrays.asList(new String[]{}));


        Medicalrecord m3 = new Medicalrecord();
        m3.setFirstName("Amelie");
        m3.setLastName("Pascal");
        m3.setBirthdate("11/10/1990");
        m3.setMedications(Arrays.asList(new String[]{"amalgame"}));
        m3.setAllergies(Arrays.asList(new String[]{"penicelline"}));

        Medicalrecord m4 = new Medicalrecord();
        m4.setFirstName("Guillaume");
        m4.setLastName("Raul");
        m4.setBirthdate("06/02/2005");
        m4.setMedications(Arrays.asList(new String[]{}));
        m4.setAllergies(Arrays.asList(new String[]{}));

        Medicalrecord m5 = new Medicalrecord();
        m5.setFirstName("Nicolas");
        m5.setLastName("Seghdau");
        m5.setBirthdate("02/10/2017");
        m5.setMedications(Arrays.asList(new String[]{"amoxi"}));
        m5.setAllergies(Arrays.asList(new String[]{"gluten"}));

        Medicalrecord m6 = new Medicalrecord();
        m6.setFirstName("Bob");
        m6.setLastName("Marly");
        m6.setBirthdate("10/10/1958");
        m6.setMedications(Arrays.asList(new String[]{"peni", "analgan"}));
        m6.setAllergies(Arrays.asList(new String[]{"pollen"}));

        List<Person> personsExp = new ArrayList<>();
        personsExp.add(p1);
        personsExp.add(p2);
        personsExp.add(p3);
        personsExp.add(p4);
        personsExp.add(p5);
        personsExp.add(p6);


        List<Firestation> firestationsExp = new ArrayList<>();
        firestationsExp.add(f1);
        firestationsExp.add(f2);
        firestationsExp.add(f3);
        firestationsExp.add(f4);

        List<Medicalrecord> medicalRecordExp = new ArrayList<>();
        medicalRecordExp.add(m1);
        medicalRecordExp.add(m2);
        medicalRecordExp.add(m3);
        medicalRecordExp.add(m4);
        medicalRecordExp.add(m5);
        medicalRecordExp.add(m6);

      //jsonDataStructureExp est l'objet json qui sera mocké et utilisé dans les tests
       JsonDataStructure jsonDataStructureExp = new JsonDataStructure();

        jsonDataStructureExp.setPersons(personsExp);
        jsonDataStructureExp.setFirestations(firestationsExp);
        jsonDataStructureExp.setMedicalrecords(medicalRecordExp);

        return jsonDataStructureExp;
    }
}