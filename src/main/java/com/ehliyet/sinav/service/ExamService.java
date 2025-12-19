package com.ehliyet.sinav.service;

import com.ehliyet.sinav.entity.ExamResult;
import com.ehliyet.sinav.entity.Question;
import com.ehliyet.sinav.entity.User;
import com.ehliyet.sinav.repository.ExamResultRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ExamService {

    private final ExamResultRepository examResultRepository;
    private final QuestionService questionService;

    public ExamResult submitExam(User user, List<Question> questions, Map<Long, String> userAnswers, int durationInSeconds) {
        log.info("Sınav teslim ediliyor - Kullanıcı: {}", user.getUsername());

        ExamResult examResult = ExamResult.builder()
                .user(user)
                .totalQuestions(questions.size())
                .durationInSeconds(durationInSeconds)
                .build();

        // Cevapları kontrol et
        for (Question question : questions) {
            String userAnswer = userAnswers.get(question.getId());
            String correctAnswer = question.getCorrectAnswer();
            boolean isCorrect = correctAnswer.equals(userAnswer);

            ExamResult.UserAnswer answer = ExamResult.UserAnswer.builder()
                    .questionId(question.getId())
                    .userAnswer(userAnswer != null ? userAnswer : "")
                    .correctAnswer(correctAnswer)
                    .isCorrect(isCorrect)
                    .build();

            examResult.getUserAnswers().add(answer);
        }

        examResult.calculateResults();
        
        log.info("Sınav sonucu - Doğru: {}, Yanlış: {}, Puan: {}, Durum: {}", 
                examResult.getCorrectAnswers(), 
                examResult.getWrongAnswers(), 
                examResult.getScore(),
                examResult.getPassed() ? "BAŞARILI" : "BAŞARISIZ");

        return examResultRepository.save(examResult);
    }

    public List<Question> generateExamQuestions(int questionCount) {
        long totalQuestions = questionService.getActiveQuestionCount();
        
        if (totalQuestions < questionCount) {
            throw new RuntimeException("Yeterli soru bulunamadı! Mevcut soru sayısı: " + totalQuestions);
        }

        return questionService.getRandomQuestionsForExam(questionCount);
    }

    public Optional<ExamResult> findById(Long id) {
        return examResultRepository.findById(id);
    }

    public List<ExamResult> findByUser(User user) {
        return examResultRepository.findByUserOrderByExamDateDesc(user);
    }

    public List<ExamResult> findAllResults() {
        return examResultRepository.findAll();
    }

    public List<ExamResult> findPassedExams() {
        return examResultRepository.findByPassedTrue();
    }

    public List<ExamResult> findFailedExams() {
        return examResultRepository.findByPassedFalse();
    }

    public List<ExamResult> findExamsByDateRange(LocalDateTime start, LocalDateTime end) {
        return examResultRepository.findByExamDateBetween(start, end);
    }

    public Double getAverageScore() {
        return examResultRepository.findAverageScore();
    }

    public Double getAverageScoreByUser(User user) {
        return examResultRepository.findAverageScoreByUser(user);
    }

    public long getTotalExamCount() {
        return examResultRepository.count();
    }

    public long getPassedExamCount() {
        return examResultRepository.countPassedExams();
    }

    public long getFailedExamCount() {
        return examResultRepository.countFailedExams();
    }

    public long getUserExamCount(User user) {
        return examResultRepository.countByUser(user);
    }

    public double getPassRate() {
        long total = getTotalExamCount();
        if (total == 0) return 0.0;
        return (getPassedExamCount() * 100.0) / total;
    }

    public void deleteExamResult(Long id) {
        log.info("Sınav sonucu siliniyor: ID {}", id);
        examResultRepository.deleteById(id);
    }
}
