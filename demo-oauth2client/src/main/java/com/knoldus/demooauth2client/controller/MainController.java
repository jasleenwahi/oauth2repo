package com.knoldus.demooauth2client.controller;


import com.knoldus.demooauth2client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;




    @GetMapping("/getUsers")
    public List<User> getAllUsers(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://localhost:8081/showusers", HttpMethod.GET, entity, List.class).getBody();
    }


}
