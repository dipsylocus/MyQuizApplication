package com.dipankar.quizapp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * A model class representing a response to a quiz question.
 */
@Data // Lombok annotation to automatically generate getters, setters, equals, hashCode, and toString methods
@RequiredArgsConstructor // Lombok annotation to generate a constructor with required arguments
public class Response {
    private Integer id; // Unique identifier for the response
    private String response; // The actual response given by the user

    /**
     * Constructor for creating a Response object with required arguments.
     * @param id The unique identifier for the response.
     * @param response The actual response given by the user.
     */
    public Response(Integer id, String response) {
        this.id = id;
        this.response = response;
    }
}
