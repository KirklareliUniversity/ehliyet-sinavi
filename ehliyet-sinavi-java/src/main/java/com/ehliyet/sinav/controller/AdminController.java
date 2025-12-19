package com.ehliyet.sinav.controller;

import com.ehliyet.sinav.entity.Question;
import com.ehliyet.sinav.entity.User;
import com.ehliyet.sinav.service.ExamService;
import com.ehliyet.sinav.service.QuestionService;
import com.ehliyet.sinav.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    private final UserService userService;
    private final QuestionService questionService;
    private final ExamService examService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalUsers", userService.getTotalUserCount());
        model.addAttribute("totalQuestions", questionService.getTotalQuestionCount());
        model.addAttribute("totalExams", examService.getTotalExamCount());
        model.addAttribute("passRate", examService.getPassRate());
        // Hibernate Lazy hatasını önlemek için DTO ile gönder
        var recentExams = examService.findAllResults().stream().limit(10)
            .map(exam -> new ExamDashboardDTO(
                exam.getId(),
                exam.getUser() != null ? (exam.getUser().getFirstName() + " " + exam.getUser().getLastName()) : "-",
                exam.getExamDate(),
                exam.getScore(),
                exam.getCorrectAnswers(),
                exam.getWrongAnswers(),
                exam.getPassed()
            )).toList();
        model.addAttribute("recentExams", recentExams);
        return "admin/dashboard";
    }

    // Dashboard için DTO
    public record ExamDashboardDTO(Long id, String fullName, java.time.LocalDateTime examDate, Integer score, Integer correctAnswers, Integer wrongAnswers, Boolean passed) {}

    // KULLANICI YÖNETİMİ
    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/users";
    }

    @GetMapping("/users/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/user-form";
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        try {
            userService.registerUser(user);
            redirectAttributes.addFlashAttribute("success", "Kullanıcı başarıyla eklendi!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/admin/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userService.findById(id)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
        model.addAttribute("user", user);
        return "admin/user-form";
    }

    @PostMapping("/users/edit/{id}")
    public String editUser(@PathVariable Long id, @ModelAttribute User user, 
                          RedirectAttributes redirectAttributes) {
        try {
            userService.updateUser(id, user);
            redirectAttributes.addFlashAttribute("success", "Kullanıcı başarıyla güncellendi!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/admin/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            userService.deleteUser(id);
            redirectAttributes.addFlashAttribute("success", "Kullanıcı başarıyla silindi!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Kullanıcı silinemedi!");
        }
        return "redirect:/admin/users";
    }

    // SORU YÖNETİMİ
    @GetMapping("/questions")
    public String listQuestions(Model model) {
        model.addAttribute("questions", questionService.findAll());
        return "admin/questions";
    }

    @GetMapping("/questions/add")
    public String addQuestionForm(Model model) {
        model.addAttribute("question", new Question());
        model.addAttribute("categories", Question.QuestionCategory.values());
        model.addAttribute("types", Question.QuestionType.values());
        return "admin/question-form";
    }

    @PostMapping("/questions/add")
    public String addQuestion(@ModelAttribute Question question,
                            @RequestParam(value = "mediaFile", required = false) MultipartFile mediaFile,
                            RedirectAttributes redirectAttributes) {
        try {
            if (mediaFile != null && !mediaFile.isEmpty()) {
                questionService.createQuestionWithMedia(question, mediaFile);
            } else {
                questionService.createQuestion(question);
            }
            redirectAttributes.addFlashAttribute("success", "Soru başarıyla eklendi!");
        } catch (Exception e) {
            log.error("Soru eklenirken hata: ", e);
            redirectAttributes.addFlashAttribute("error", "Soru eklenemedi: " + e.getMessage());
        }
        return "redirect:/admin/questions";
    }

    @GetMapping("/questions/edit/{id}")
    public String editQuestionForm(@PathVariable Long id, Model model) {
        Question question = questionService.findById(id)
                .orElseThrow(() -> new RuntimeException("Soru bulunamadı"));
        model.addAttribute("question", question);
        model.addAttribute("categories", Question.QuestionCategory.values());
        model.addAttribute("types", Question.QuestionType.values());
        return "admin/question-form";
    }

    @PostMapping("/questions/edit/{id}")
    public String editQuestion(@PathVariable Long id, 
                             @ModelAttribute Question question,
                             @RequestParam(value = "mediaFile", required = false) MultipartFile mediaFile,
                             RedirectAttributes redirectAttributes) {
        try {
            if (mediaFile != null && !mediaFile.isEmpty()) {
                questionService.updateQuestionWithMedia(id, question, mediaFile);
            } else {
                questionService.updateQuestion(id, question);
            }
            redirectAttributes.addFlashAttribute("success", "Soru başarıyla güncellendi!");
        } catch (Exception e) {
            log.error("Soru güncellenirken hata: ", e);
            redirectAttributes.addFlashAttribute("error", "Soru güncellenemedi: " + e.getMessage());
        }
        return "redirect:/admin/questions";
    }

    @GetMapping("/questions/delete/{id}")
    public String deleteQuestion(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            questionService.deleteQuestion(id);
            redirectAttributes.addFlashAttribute("success", "Soru başarıyla silindi!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Soru silinemedi!");
        }
        return "redirect:/admin/questions";
    }

    // SINAV SONUÇLARI
    @GetMapping("/exam-results")
    public String listExamResults(Model model) {
        model.addAttribute("results", examService.findAllResults());
        model.addAttribute("averageScore", examService.getAverageScore());
        model.addAttribute("passRate", examService.getPassRate());
        return "admin/exam-results";
    }

    @GetMapping("/exam-results/{id}")
    public String viewExamResult(@PathVariable Long id, Model model) {
        var result = examService.findById(id)
                .orElseThrow(() -> new RuntimeException("Sınav sonucu bulunamadı"));
        model.addAttribute("result", result);
        return "admin/exam-result-detail";
    }
}
