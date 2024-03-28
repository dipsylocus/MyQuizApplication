package com.dipankar.quizapp.dao;

import com.dipankar.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for interacting with Question entities in the database.
 */
@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    /**
     * Method to find questions by category.
     * @param category The category of the questions to be retrieved.
     * @return A list of questions belonging to the specified category.
     */
    List<Question> findByCategory(String category);

    /**
     * Custom query to find random questions by category.
     * @param category The category of the questions to be retrieved.
     * @param numQ The number of random questions to be retrieved.
     * @return A list of random questions belonging to the specified category.
     */
    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
