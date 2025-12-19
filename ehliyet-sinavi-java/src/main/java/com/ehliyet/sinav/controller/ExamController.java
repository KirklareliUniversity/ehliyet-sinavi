package com.ehliyet.sinav.controller;

import com.ehliyet.sinav.entity.ExamResult;
import com.ehliyet.sinav.entity.Question;
import com.ehliyet.sinav.entity.User;
import com.ehliyet.sinav.service.ExamService;

import com.ehliyet.sinav.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/exam")
@RequiredArgsConstructor
@Slf4j
public class ExamController {

    private final ExamService examService;
    // private final QuestionService questionService;
    private final UserService userService;

    @GetMapping("/start")
    public String startExam(HttpSession session, RedirectAttributes redirectAttributes) {
        try {
            List<Question> questions = examService.generateExamQuestions(50);
            session.setAttribute("examQuestions", questions);
            session.setAttribute("examStartTime", System.currentTimeMillis());
            return "redirect:/exam/take";
        } catch (Exception e) {
            log.error("Sınav başlatılamadı: ", e);
            redirectAttributes.addFlashAttribute("error", "Sınav başlatılamadı: " + e.getMessage());
            return "redirect:/user/dashboard";
        }
    }

    @GetMapping("/take")
    public String takeExam(@RequestParam(defaultValue = "0") int question,
                          HttpSession session, Model model) {
        @SuppressWarnings("unchecked")
        List<Question> questions = (List<Question>) session.getAttribute("examQuestions");

        if (questions == null || questions.isEmpty()) {
            return "redirect:/exam/start";
        }

        if (question < 0 || question >= questions.size()) {
            question = 0;
        }

        @SuppressWarnings("unchecked")
        Map<Long, String> userAnswers = (Map<Long, String>) session.getAttribute("userAnswers");
        if (userAnswers == null) {
            userAnswers = new HashMap<>();
            session.setAttribute("userAnswers", userAnswers);
        }

        model.addAttribute("questions", questions);
        model.addAttribute("currentQuestion", questions.get(question));
        model.addAttribute("questionNumber", question);
        model.addAttribute("totalQuestions", questions.size());
        model.addAttribute("userAnswers", userAnswers);
        model.addAttribute("progress", ((question + 1) * 100) / questions.size());

        return "exam/take";
    }

    @PostMapping("/answer")
    public String submitAnswer(@RequestParam Long questionId,
                              @RequestParam String answer,
                              @RequestParam int currentQuestion,
                              HttpSession session) {
        @SuppressWarnings("unchecked")
        Map<Long, String> userAnswers = (Map<Long, String>) session.getAttribute("userAnswers");
        if (userAnswers == null) {
            userAnswers = new HashMap<>();
            session.setAttribute("userAnswers", userAnswers);
        }

        userAnswers.put(questionId, answer);

        @SuppressWarnings("unchecked")
        List<Question> questions = (List<Question>) session.getAttribute("examQuestions");
        int nextQuestion = currentQuestion + 1;

        if (nextQuestion < questions.size()) {
            return "redirect:/exam/take?question=" + nextQuestion;
        } else {
            return "redirect:/exam/submit";
        }
    }

    @GetMapping("/submit")
    public String submitExamPage(Model model, HttpSession session) {
        @SuppressWarnings("unchecked")
        List<Question> questions = (List<Question>) session.getAttribute("examQuestions");
        @SuppressWarnings("unchecked")
        Map<Long, String> userAnswers = (Map<Long, String>) session.getAttribute("userAnswers");

        if (questions == null || userAnswers == null) {
            return "redirect:/exam/start";
        }

        int answeredCount = userAnswers.size();
        int totalQuestions = questions.size();

        model.addAttribute("answeredCount", answeredCount);
        model.addAttribute("totalQuestions", totalQuestions);
        model.addAttribute("unansweredCount", totalQuestions - answeredCount);

        return "exam/submit-confirm";
    }

    @PostMapping("/submit")
    public String submitExam(Authentication authentication, HttpSession session,
                           RedirectAttributes redirectAttributes) {
        try {
            @SuppressWarnings("unchecked")
            List<Question> questions = (List<Question>) session.getAttribute("examQuestions");
            @SuppressWarnings("unchecked")
            Map<Long, String> userAnswers = (Map<Long, String>) session.getAttribute("userAnswers");
            Long startTime = (Long) session.getAttribute("examStartTime");

            if (questions == null || userAnswers == null) {
                redirectAttributes.addFlashAttribute("error", "Sınav oturumu bulunamadı!");
                return "redirect:/user/dashboard";
            }

            String username = authentication.getName();
            User user = userService.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

            int durationInSeconds = 0;
            if (startTime != null) {
                durationInSeconds = (int) ((System.currentTimeMillis() - startTime) / 1000);
            }

            ExamResult result = examService.submitExam(user, questions, userAnswers, durationInSeconds);

            // Session'ı temizle
            session.removeAttribute("examQuestions");
            session.removeAttribute("userAnswers");
            session.removeAttribute("examStartTime");

            redirectAttributes.addFlashAttribute("success", "Sınav başarıyla tamamlandı!");
            return "redirect:/exam/result/" + result.getId();

        } catch (Exception e) {
            log.error("Sınav teslim edilirken hata: ", e);
            redirectAttributes.addFlashAttribute("error", "Sınav teslim edilemedi!");
            return "redirect:/user/dashboard";
        }
    }

    @GetMapping("/result/{id}")
    public String viewResult(@PathVariable Long id, Authentication authentication, Model model) {
        var result = examService.findById(id)
                .orElseThrow(() -> new RuntimeException("Sınav sonucu bulunamadı"));

        String username = authentication.getName();
        User currentUser = userService.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        // Sadece kendi sonucunu veya admin görebilir
        if (!result.getUser().getId().equals(currentUser.getId()) && !currentUser.isAdmin()) {
            return "redirect:/access-denied";
        }

        model.addAttribute("result", result);
        return "exam/result";
    }
}
