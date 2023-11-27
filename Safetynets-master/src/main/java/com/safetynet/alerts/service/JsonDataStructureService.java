
package com.safetynet.alerts.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alerts.utils.JsonDataStructure;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class JsonDataStructureService {

    private final JsonDataStructure jsonDataStructure;


    public JsonDataStructureService() throws IOException {
        String fileName = "json/data.json";

        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        String content = new String(Files.readAllBytes(file.toPath()));

        ObjectMapper mapper = new ObjectMapper();
        jsonDataStructure = mapper.readValue(content, JsonDataStructure.class);
    }

    public JsonDataStructure getJsonDataStructure() {
        return jsonDataStructure;
    }
}