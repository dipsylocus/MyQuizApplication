package com.dipankar.quizapp.model;

import lombok.Data;

/**
 * A wrapper class for representing simplified question details.
 * This class contains only question and options, excluding the answer.
 */
@Data // Lombok annotation to automatically generate getters, setters, equals, hashCode, and toString methods
public class QuestionWrapper {
    private Integer id; // Unique identifier for the question
    private String questionTitle; // The text of the question
    private String option1; // Option 1 for the question
    private String option2; // Option 2 for the question
    private String option3; // Option 3 for the question
    private String option4; // Option 4 for the question

    /**
     * Constructor for creating a QuestionWrapper object.
     * @param id The unique identifier for the question.
     * @param questionTitle The text of the question.
     * @param option1 Option 1 for the question.
     * @param option2 Option 2 for the question.
     * @param option3 Option 3 for the question.
     * @param option4 Option 4 for the question.
     */
    public QuestionWrapper(Integer id, String questionTitle, String option1, String option2, String option3, String option4) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
