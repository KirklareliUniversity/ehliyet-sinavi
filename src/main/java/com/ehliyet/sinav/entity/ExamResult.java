package com.ehliyet.sinav.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exam_results")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Integer totalQuestions = 50;

    @Column(nullable = false)
    private Integer correctAnswers = 0;

    @Column(nullable = false)
    private Integer wrongAnswers = 0;

    @Column(nullable = false)
    private Integer score = 0; // 0-100 arası puan

    @Column(nullable = false)
    private Boolean passed = false; // 70 puan ve üzeri geçer

    @Column(nullable = false)
    private Integer durationInSeconds = 0; // Sınav süresi (saniye)

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "exam_answers", joinColumns = @JoinColumn(name = "exam_result_id"))
    @Builder.Default
    private List<UserAnswer> userAnswers = new ArrayList<>();

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime examDate;

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserAnswer {
        private Long questionId;
        private String userAnswer;     // A, B, C, D
        private String correctAnswer;  // A, B, C, D
        private Boolean isCorrect;
    }

    public void calculateResults() {
        this.correctAnswers = (int) userAnswers.stream()
                .filter(UserAnswer::getIsCorrect)
                .count();
        
        this.wrongAnswers = totalQuestions - correctAnswers;
        this.score = (correctAnswers * 100) / totalQuestions;
        this.passed = score >= 70;
    }

    public double getSuccessRate() {
        return (correctAnswers * 100.0) / totalQuestions;
    }

    public String getFormattedDuration() {
        int minutes = durationInSeconds / 60;
        int seconds = durationInSeconds % 60;
        return String.format("%d:%02d", minutes, seconds);
    }
}
