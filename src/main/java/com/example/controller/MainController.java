package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
public class MainController {

    @GetMapping("/")
    public String MainPage() {
        return "index.html";
    }

}






//@GetMapping("/MainPage")
//@GetMapping("/templates/MainPage.html")
//@ResponseBody
//@RequestMapping(value = "/", method = RequestMethod.GET)