package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping
    public Map<String ,String> testEndPoint(){
        HashMap<String ,String> hellon = new HashMap<String,String>();
        hellon.put("Name","mano");
        hellon.put("Age","20");
        hellon.put("Email","mano@gmail.com");
        hellon.put("Ooru","TN");
        hellon.put("Name","mano");
        return hellon;
        
    }
    

}