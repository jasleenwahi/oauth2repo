package com.knoldus.demooauth2client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@Controller
public class AuthController {

    private static final String CLIENT_ID = "1050588426667-an0aams9gtr17cabj5g258gi74c8r4je.apps.googleusercontent.com";
    private static final String REDIRECT_URI = "http://localhost:8082/login/oauth2/code/google";

    @GetMapping("/auth")
    public RedirectView authorize() throws UnsupportedEncodingException {
        System.out.println("hello");
        String encodedRedirectUri = URLEncoder.encode(REDIRECT_URI, StandardCharsets.UTF_8.toString());

        String authorizationUrl = "https://accounts.google.com/o/oauth2/auth" +
                "?response_type=code" +
                "&client_id=" + URLEncoder.encode(CLIENT_ID, StandardCharsets.UTF_8.toString()) +
                "&redirect_uri=" + encodedRedirectUri +
                "&scope=scope1+scope2"; // Specify the required scopes for your application

        return new RedirectView(authorizationUrl);
    }

    @GetMapping("/callback")
    public String callback(@RequestParam("code") String authorizationCode) {
        // Handle the authorization code obtained from the callback URL
        System.out.println("Authorization Code: " + authorizationCode);

        // Perform further processing or exchange the authorization code for an access token

        return "success"; // Return the appropriate view or redirect after processing
    }
}

