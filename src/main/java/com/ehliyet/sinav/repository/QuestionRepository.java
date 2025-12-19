package com.ehliyet.sinav.repository;

import com.ehliyet.sinav.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    
    List<Question> findByActiveTrue();
    
    List<Question> findByCategory(Question.QuestionCategory category);
    
    List<Question> findByType(Question.QuestionType type);
    
    List<Question> findByActiveTrueAndCategory(Question.QuestionCategory category);
    
    List<Question> findByActiveTrueAndType(Question.QuestionType type);
    
    @Query(value = "SELECT * FROM questions WHERE active = true ORDER BY RAND() LIMIT :count", nativeQuery = true)
    List<Question> findRandomActiveQuestions(int count);
    
    long countByActiveTrue();
    
    long countByCategory(Question.QuestionCategory category);
}
