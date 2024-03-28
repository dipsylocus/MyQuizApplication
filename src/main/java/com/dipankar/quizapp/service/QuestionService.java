package com.dipankar.quizapp.service;

import com.dipankar.quizapp.model.Question;
import com.dipankar.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling business logic related to questions.
 */
@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    /**
     * Retrieves all questions from the database.
     * @return List of all questions.
     */
    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    /**
     * Retrieves questions by category from the database.
     * @param category The category of questions to retrieve.
     * @return List of questions belonging to the specified category.
     */
    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    /**
     * Adds a new question to the database.
     * @param question The question to add.
     * @return A status message indicating the success of the operation.
     */
    public String addQuestion(Question question) {
        questionDao.save(question);
        return "success";
    }

    /**
     * Updates an existing question in the database.
     * @param question The updated question.
     * @return A status message indicating the success of the operation.
     */
    public String putQuestion(Question question) {
        // Save the updated question
        questionDao.save(question);
        return "updated";
    }

    /**
     * Deletes a question from the database.
     * @param question The question to delete.
     * @return A status message indicating the success of the operation.
     */
    public String deleteQuestion(Question question) {
        questionDao.delete(question);
        return "deleted";
    }
}
