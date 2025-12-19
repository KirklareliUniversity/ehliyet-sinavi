package com.ehliyet.sinav.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Soru metni boş olamaz")
    @Column(nullable = false, length = 1000)
    private String questionText;

    @NotBlank(message = "A şıkkı boş olamaz")
    @Column(nullable = false, length = 500)
    private String optionA;

    @NotBlank(message = "B şıkkı boş olamaz")
    @Column(nullable = false, length = 500)
    private String optionB;

    @NotBlank(message = "C şıkkı boş olamaz")
    @Column(nullable = false, length = 500)
    private String optionC;

    @NotBlank(message = "D şıkkı boş olamaz")
    @Column(nullable = false, length = 500)
    private String optionD;

    @NotNull(message = "Doğru cevap belirtilmelidir")
    @Column(nullable = false)
    private String correctAnswer; // A, B, C veya D

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private QuestionCategory category = QuestionCategory.TRAFIK_KURALLARI;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private QuestionType type = QuestionType.TEXT;

    // Görsel veya video dosya yolu (varsa)
    @Column(length = 500)
    private String mediaPath;

    @Column(length = 100)
    private String mediaType; // image/jpeg, video/mp4 vb.

    @Column(nullable = false)
    @Builder.Default
    private Boolean active = true;

    @Column(nullable = false)
    @Builder.Default
    private Integer difficulty = 1; // 1: Kolay, 2: Orta, 3: Zor

    @Column(length = 1000)
    private String explanation; // Sorunun açıklaması/çözümü

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public enum QuestionCategory {
        TRAFIK_KURALLARI("Trafik Kuralları"),
        TRAFIK_ISARETLERI("Trafik İşaretleri"),
        ILK_YARDIM("İlk Yardım"),
        MOTOR_VE_ARAC_TEKNIK("Motor ve Araç Tekniği"),
        CEVRESEL_KONULAR("Çevresel Konular");

        private final String displayName;

        QuestionCategory(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public enum QuestionType {
        TEXT("Sadece Metin"),
        IMAGE("Görselli"),
        VIDEO("Videolu");

        private final String displayName;

        QuestionType(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public boolean hasMedia() {
        return mediaPath != null && !mediaPath.isEmpty();
    }

    public boolean isImage() {
        return type == QuestionType.IMAGE;
    }

    public boolean isVideo() {
        return type == QuestionType.VIDEO;
    }
}
