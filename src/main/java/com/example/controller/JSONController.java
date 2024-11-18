package com.example.controller;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
public class JSONController {
    String apiKey = "AIzaSyDiYoriL2BqPxdkCChUjV6Y1TeLGhsibns";
    String cxID = "233f0749f131242a6";

    public static String encodeValue(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public ResponseEntity<String> handleFormData(HttpSession session, @RequestBody String theData) throws IOException {
        System.out.println("incoming String: " + theData);
        String searchQuery = encodeValue(theData);
        System.out.println("searchQuery: " + searchQuery);

//        GET https://www.googleapis.com/customsearch/v1?key=INSERT_YOUR_API_KEY&cx=017576662512468239146:omuauf_lfve&q=lectures
        URL url = new URL("https://www.googleapis.com/customsearch/v1?key=" + apiKey + "&cx=" + cxID + "&q=" + searchQuery);
        String urlString = url.toString();
        Object parser = url.getContent();

        System.out.println("parser: "+parser);
        System.out.println("url: " + url);
        System.out.println("urlString" + urlString);

        HttpURLConnection con;
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        String googleResponse = null;

        if (responseCode == 200) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            System.out.println("response: "+ response);
            googleResponse = response.toString();
            System.out.println(googleResponse);
        } else {
            System.out.println("You done goofed son!");
        }
        return ResponseEntity.ok(googleResponse);
    }
}

