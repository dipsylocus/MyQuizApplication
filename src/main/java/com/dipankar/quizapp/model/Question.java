package com.dipankar.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Entity class representing a question in the quiz application.
 */
@Data // Lombok annotation to automatically generate getters, setters, equals, hashCode, and toString methods
@Entity // Indicates that this class is a JPA entity
public class Question {
    @Id // Marks the field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategy for the primary key
    private Integer id; // Unique identifier for the question

    private String questionTitle; // The text of the question
    private String option1; // Option 1 for the question
    private String option2; // Option 2 for the question
    private String option3; // Option 3 for the question
    private String option4; // Option 4 for the question
    private String rightAnswer; // The correct answer for the question
    private String difficultyLevel; // The difficulty level of the question
    private String category; // The category to which the question belongs
}
