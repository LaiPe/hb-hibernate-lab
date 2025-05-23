package com.exemple;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String baseUrl = "http://app:8080/users";
        try {
            
            String allPersons  = RestClient.sendRequest(baseUrl, "GET", null);
            System.out.println("All persons: " + allPersons);
    
    
            // POST a new user
            User newUser = new User("John Doe", "johndoe@email.com");
            ObjectMapper objectMapper = new ObjectMapper();
            String newUserJson = objectMapper.writeValueAsString(newUser);
            String postResponse = RestClient.sendRequest(baseUrl, "POST", newUserJson);
            System.out.println("POST response: " + postResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
