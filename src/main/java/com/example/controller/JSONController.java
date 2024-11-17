package com.example.controller;

import com.example.JuddProject.FormData;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import jakarta.servlet.http.HttpSession;
import org.apache.tomcat.util.json.JSONParser;
import org.jsoup.Jsoup;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JSONController {

    String apiKey = "AIzaSyDiYoriL2BqPxdkCChUjV6Y1TeLGhsibns";

    String cxID = "233f0749f131242a6";

    public static String encodeValue(String value) throws UnsupportedEncodingException {

        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    //@PostMapping("/search", method = RequestMethod.POST)
    //public ResponseEntity<String> handleFormData(HttpSession session, @RequestBody FormData theData) throws JsonProcessingException {
    //public ResponseEntity<String> handleFormData(HttpSession session, @RequestBody HashMap<String,String> whatJuddWant) {
    public ResponseEntity<String> handleFormData(HttpSession session, @RequestBody String theData) throws IOException {

        System.out.println(theData);
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
        //URLEncoder urlEncoder

        String searchQuery = encodeValue(theData);
        System.out.println(searchQuery);

        URL url = new URL("https://www.googleapis.com/customsearch/v1?key=" + apiKey + "&cx=" + cxID + "&q=" + searchQuery);

        String urlString = url.toString();
        Object parser = url.getContent();

        System.out.println(parser);

        System.out.println(url);
        System.out.println(urlString);

        HttpURLConnection con;
        con = (HttpURLConnection) url.openConnection();


        return ResponseEntity.ok(searchQuery);


        //This is an example of the URL format that needs to be done to perform a get request
        //GET https://www.googleapis.com/customsearch/v1?key=INSERT_YOUR_API_KEY&cx=017576662512468239146:omuauf_lfve&q=lectures


        //return ResponseEntity.ok("Form data received successfully!");
    }
}

