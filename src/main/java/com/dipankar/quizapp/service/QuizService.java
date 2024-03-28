package com.dipankar.quizapp.service;

import com.dipankar.quizapp.dao.QuestionDao;
import com.dipankar.quizapp.dao.QuizDao;
import com.dipankar.quizapp.model.Question;
import com.dipankar.quizapp.model.QuestionWrapper;
import com.dipankar.quizapp.model.Quiz;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class for handling business logic related to quizzes.
 */
@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    /**
     * Creates a new quiz with random questions from the specified category.
     * @param category The category of questions for the quiz.
     * @param numQ The number of questions in the quiz.
     * @param title The title of the quiz.
     * @return ResponseEntity containing a status message.
     */
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    /**
     * Retrieves questions for a specific quiz.
     * @param id The ID of the quiz.
     * @return ResponseEntity containing a list of QuestionWrapper objects.
     */
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> optionalQuiz = quizDao.findById(id);
        if (optionalQuiz.isPresent()) {
            List<Question> questionsFromDB = optionalQuiz.get().getQuestions();
            List<QuestionWrapper> questionsForUser = new ArrayList<>();
            for (Question q : questionsFromDB) {
                QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
                questionsForUser.add(qw);
            }
            return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Calculates the result of a quiz based on user responses.
     * @param id The ID of the quiz.
     * @param responses List of responses submitted by the user.
     * @return ResponseEntity containing the calculated result of the quiz.
     */
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Optional<Quiz> optionalQuiz = quizDao.findById(id);
        if (optionalQuiz.isPresent()) {
            Quiz quiz = optionalQuiz.get();
            List<Question> questions = quiz.getQuestions();
            int right = 0;
            int i = 0;
            for (Response response : responses) {
                if (response.getResponse().equals(questions.get(i).getRightAnswer()))
                    right++;
                i++;
            }
            return new ResponseEntity<>(right, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
