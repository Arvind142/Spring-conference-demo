package com.personal.conferencedemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    @Value("${app.version}")
    private String version;

    @Value("${app.endpoints.sessions}")
    private String sessionsEndpoint;

    @Value("${app.endpoints.speakers}")
    private String speakersEndpoint;

    @GetMapping
    @RequestMapping("/")
    public Map getVersion(){
        Map<String,Object> map = new HashMap();
        map.put("App Version: ",version);
        map.put("Speakers endPoint: ",speakersEndpoint);
        map.put("Sessions endPoint: ",sessionsEndpoint);
        return map;
    }
}
