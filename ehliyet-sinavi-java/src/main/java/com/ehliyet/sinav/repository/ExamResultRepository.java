package com.ehliyet.sinav.repository;

import com.ehliyet.sinav.entity.ExamResult;
import com.ehliyet.sinav.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExamResultRepository extends JpaRepository<ExamResult, Long> {

    // Tek bir ExamResult'ı user ile eager fetch
    @Query("SELECT e FROM ExamResult e JOIN FETCH e.user WHERE e.id = :id")
    ExamResult findByIdWithUser(Long id);

        // User'ı eager fetch ile getir
        @Query("SELECT e FROM ExamResult e JOIN FETCH e.user ORDER BY e.examDate DESC")
        List<ExamResult> findAllWithUser();
    
    List<ExamResult> findByUser(User user);
    
    List<ExamResult> findByUserOrderByExamDateDesc(User user);
    
    List<ExamResult> findByPassedTrue();
    
    List<ExamResult> findByPassedFalse();
    
    List<ExamResult> findByExamDateBetween(LocalDateTime start, LocalDateTime end);
    
    @Query("SELECT AVG(e.score) FROM ExamResult e")
    Double findAverageScore();
    
    @Query("SELECT AVG(e.score) FROM ExamResult e WHERE e.user = :user")
    Double findAverageScoreByUser(User user);
    
    @Query("SELECT COUNT(e) FROM ExamResult e WHERE e.passed = true")
    Long countPassedExams();
    
    @Query("SELECT COUNT(e) FROM ExamResult e WHERE e.passed = false")
    Long countFailedExams();
    
    long countByUser(User user);
}
