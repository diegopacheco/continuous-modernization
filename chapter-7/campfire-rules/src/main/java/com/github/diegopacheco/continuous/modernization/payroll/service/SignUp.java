package com.github.diegopacheco.continuous.modernization.payroll.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.diegopacheco.continuous.modernization.payroll.model.Customer;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// @Refactoring: Let's rename to CustomerRegisterClient
public class SignUp {

    // @Refactoring: Let's stop using Jackson, use Gson instead.
    private ObjectMapper objectMapper;

    // @Refactoring: Make sure we return at least a boolean, hard to test.
    public void signUp(Customer customer) {
        String json = null;
        try {
            // @Refactoring: Missing validations, what if user email is not present.
            json = objectMapper.writeValueAsString(customer);
        } catch (Exception e) {
            // @Refactoring: Let's use a logger here. it should goto centralized logger solution.
            throw new RuntimeException(e);
        }

        // @Refactoring: URI should be in a property file, we should not hardcode it.
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://internal.myorg.com:8080/register/customer"))
                .build();
        try {
            client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            // @Refactoring: Let's use a logger here. it should goto centralized logger solution.
            throw new RuntimeException(e);
        }
    }

}
