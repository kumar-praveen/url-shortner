package com.example.url_shortner.controller;

import com.example.url_shortner.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("")
public class ApiController {
    @Autowired
    private ApiService service;

    @GetMapping("/short")
    public String getShortUrl(@RequestHeader("url") String url, @RequestHeader("client_id") Integer clientId){
        return service.getShortUrl(url, clientId);
    }

    @GetMapping("/long")
    public String getLongUrl(@RequestHeader("url") String url){
        return service.getLongUrl(url);
    }
}
