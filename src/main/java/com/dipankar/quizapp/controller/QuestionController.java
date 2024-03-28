package com.dipankar.quizapp.controller;

import com.dipankar.quizapp.model.Question;
import com.dipankar.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This is the controller layer responsible for handling HTTP requests related to questions
@RestController // Annotation to mark this class as a RESTful controller
@RequestMapping("questions") // Base mapping for all endpoints in this controller
public class QuestionController {

    @Autowired
    QuestionService questionService; // Dependency injection of QuestionService

    // Handler method to get all questions
    @GetMapping("allQuestions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    // Handler method to get questions by category
    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    // Handler method to add a new question
    @PostMapping("add")
    public String addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    // Handler method to delete a question
    @DeleteMapping("delete")
    public String deleteQuestion(@RequestBody Question question) {
        return questionService.deleteQuestion(question);
    }

    // Handler method to update a question
    @PutMapping("put")
    public String putQuestion(@RequestBody Question question) {
        return questionService.putQuestion(question);
    }
}
