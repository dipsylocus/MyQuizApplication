package com.dipankar.quizapp.controller;

import com.dipankar.quizapp.model.Question;
import com.dipankar.quizapp.model.QuestionWrapper;
import com.dipankar.quizapp.service.QuizService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling quiz-related HTTP requests.
 */
@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    /**
     * Handler method for creating a new quiz.
     * @param category The category of the quiz.
     * @param numQ The number of questions in the quiz.
     * @param title The title of the quiz.
     * @return ResponseEntity containing a status message.
     */
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        return quizService.createQuiz(category, numQ, title);
    }

    /**
     * Handler method for retrieving questions for a specific quiz.
     * @param id The ID of the quiz.
     * @return ResponseEntity containing a list of QuestionWrapper objects.
     */
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    /**
     * Handler method for submitting quiz responses and calculating the result.
     * @param id The ID of the quiz.
     * @param responses List of responses submitted by the user.
     * @return ResponseEntity containing the calculated result of the quiz.
     */
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }
}
