package com.ehliyet.sinav.service;

import com.ehliyet.sinav.entity.Question;
import com.ehliyet.sinav.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class QuestionService {

    private final QuestionRepository questionRepository;
    private static final String UPLOAD_DIR = "uploads/";

    public Question createQuestion(Question question) {
        log.info("Yeni soru oluşturuluyor");
        return questionRepository.save(question);
    }

    public Question createQuestionWithMedia(Question question, MultipartFile mediaFile) throws IOException {
        if (mediaFile != null && !mediaFile.isEmpty()) {
            String fileName = saveMediaFile(mediaFile);
            question.setMediaPath(fileName);
            question.setMediaType(mediaFile.getContentType());
            
            if (mediaFile.getContentType().startsWith("image/")) {
                question.setType(Question.QuestionType.IMAGE);
            } else if (mediaFile.getContentType().startsWith("video/")) {
                question.setType(Question.QuestionType.VIDEO);
            }
        }
        
        return createQuestion(question);
    }

    private String saveMediaFile(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString() + extension;
        
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        
        log.info("Medya dosyası kaydedildi: {}", fileName);
        return fileName;
    }

    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public List<Question> findActiveQuestions() {
        return questionRepository.findByActiveTrue();
    }

    public List<Question> findByCategory(Question.QuestionCategory category) {
        return questionRepository.findByActiveTrueAndCategory(category);
    }

    public List<Question> findByType(Question.QuestionType type) {
        return questionRepository.findByActiveTrueAndType(type);
    }

    public List<Question> getRandomQuestionsForExam(int count) {
        return questionRepository.findRandomActiveQuestions(count);
    }

    public Question updateQuestion(Long id, Question updatedQuestion) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Soru bulunamadı!"));

        question.setQuestionText(updatedQuestion.getQuestionText());
        question.setOptionA(updatedQuestion.getOptionA());
        question.setOptionB(updatedQuestion.getOptionB());
        question.setOptionC(updatedQuestion.getOptionC());
        question.setOptionD(updatedQuestion.getOptionD());
        question.setCorrectAnswer(updatedQuestion.getCorrectAnswer());
        question.setCategory(updatedQuestion.getCategory());
        question.setDifficulty(updatedQuestion.getDifficulty());
        question.setExplanation(updatedQuestion.getExplanation());

        return questionRepository.save(question);
    }

    public Question updateQuestionWithMedia(Long id, Question updatedQuestion, MultipartFile mediaFile) throws IOException {
        Question question = updateQuestion(id, updatedQuestion);
        
        if (mediaFile != null && !mediaFile.isEmpty()) {
            // Eski medya dosyasını sil
            if (question.getMediaPath() != null) {
                deleteMediaFile(question.getMediaPath());
            }
            
            // Yeni medya dosyasını kaydet
            String fileName = saveMediaFile(mediaFile);
            question.setMediaPath(fileName);
            question.setMediaType(mediaFile.getContentType());
            
            if (mediaFile.getContentType().startsWith("image/")) {
                question.setType(Question.QuestionType.IMAGE);
            } else if (mediaFile.getContentType().startsWith("video/")) {
                question.setType(Question.QuestionType.VIDEO);
            }
            
            questionRepository.save(question);
        }
        
        return question;
    }

    private void deleteMediaFile(String fileName) {
        try {
            Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName);
            Files.deleteIfExists(filePath);
            log.info("Medya dosyası silindi: {}", fileName);
        } catch (IOException e) {
            log.error("Medya dosyası silinirken hata oluştu: {}", fileName, e);
        }
    }

    public void deleteQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Soru bulunamadı!"));
        
        if (question.getMediaPath() != null) {
            deleteMediaFile(question.getMediaPath());
        }
        
        log.info("Soru siliniyor: ID {}", id);
        questionRepository.deleteById(id);
    }

    public void activateQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Soru bulunamadı!"));
        question.setActive(true);
        questionRepository.save(question);
    }

    public void deactivateQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Soru bulunamadı!"));
        question.setActive(false);
        questionRepository.save(question);
    }

    public long getTotalQuestionCount() {
        return questionRepository.count();
    }

    public long getActiveQuestionCount() {
        return questionRepository.countByActiveTrue();
    }

    public long getQuestionCountByCategory(Question.QuestionCategory category) {
        return questionRepository.countByCategory(category);
    }
}
