package com.example.controller;

import com.example.JuddProject.FormData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JSONController {

    @PostMapping("/search")
    public ResponseEntity<String> handleFormData(HttpSession session, @RequestBody FormData theData) throws JsonProcessingException {
    //public ResponseEntity<String> handleFormData(HttpSession session, @RequestBody HashMap<String,String> whatJuddWant) {

      /*  HashMap<String,String> json = new HashMap<>();
        HashMap mapper;
        JacksonJsonParser parser = new JacksonJsonParser();
        String payload = whatJuddWant.getParameters();
        mapper = (HashMap) parser.parseMap(payload);
        System.out.println(payload);
*/
        ObjectMapper objectMapper = new ObjectMapper();
        //FormData isThisWhatJuddWants = objectMapper.
        //FormData newData = objectMapper.readValue(theData,FormData.class);
        //String json = theData.getParameters();
        //System.out.println(newData);
        //System.out.println(json);
        //System.out.println(theData);
        //System.out.println("Parameters = " + theData.getParameters());
        //System.out.println(whatJuddWant);
        //System.out.println("Paramaters - " + whatJuddWant.getParameters());

        return ResponseEntity.ok("Form data received successfully!");
    }
}

