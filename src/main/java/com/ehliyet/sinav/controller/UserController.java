package com.ehliyet.sinav.controller;

import com.ehliyet.sinav.entity.User;
import com.ehliyet.sinav.service.ExamService;
import com.ehliyet.sinav.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ExamService examService;

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {
        String username = authentication.getName();
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        var examResults = examService.findByUser(user);
        var averageScore = examService.getAverageScoreByUser(user);

        model.addAttribute("user", user);
        model.addAttribute("examCount", examResults.size());
        model.addAttribute("averageScore", averageScore != null ? averageScore : 0.0);
        model.addAttribute("recentExams", examResults.stream().limit(5).toList());

        return "user/dashboard";
    }

    @GetMapping("/exams")
    public String listExams(Authentication authentication, Model model) {
        String username = authentication.getName();
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        model.addAttribute("results", examService.findByUser(user));
        return "user/exams";
    }

    @GetMapping("/exams/{id}")
    public String viewExam(@PathVariable Long id, Authentication authentication, Model model) {
        var result = examService.findById(id)
                .orElseThrow(() -> new RuntimeException("Sınav sonucu bulunamadı"));

        String username = authentication.getName();
        if (!result.getUser().getUsername().equals(username)) {
            return "redirect:/access-denied";
        }

        model.addAttribute("result", result);
        return "user/exam-detail";
    }

    @GetMapping("/profile")
    public String profile(Authentication authentication, Model model) {
        String username = authentication.getName();
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        model.addAttribute("user", user);
        return "user/profile";
    }
}
