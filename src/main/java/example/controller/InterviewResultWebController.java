package example.controller;

import example.entities.InterviewResult;
import example.service.InterviewResultInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/controller/interview-results")
public class InterviewResultWebController {
    @Autowired
    private InterviewResultInterface service;

    @GetMapping
    public String listInterviewResults(Model model) {
        List<InterviewResult> results = service.findAll();
        model.addAttribute("results", results);
        return "InterviewResult"; // Tên file: src/main/resources/templates/interview-results.html
    }
}

