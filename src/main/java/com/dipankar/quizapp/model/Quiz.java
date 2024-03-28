package com.dipankar.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * Entity class representing a quiz in the quiz application.
 */
@Entity // Indicates that this class is a JPA entity
@Data // Lombok annotation to automatically generate getters, setters, equals, hashCode, and toString methods
public class Quiz {
    @Id // Marks the field as the primary key
    @GeneratedValue(strategy= GenerationType.IDENTITY) // Specifies the generation strategy for the primary key
    private Integer id; // Unique identifier for the quiz

    private String title; // The title of the quiz

    @ManyToMany // Establishes a many-to-many relationship with Question entities
    private List<Question> questions; // List of questions associated with the quiz
}
