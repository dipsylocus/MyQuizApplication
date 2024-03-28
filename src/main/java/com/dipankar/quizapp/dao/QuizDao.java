package com.dipankar.quizapp.dao;

import com.dipankar.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for interacting with Quiz entities in the database.
 */
public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
