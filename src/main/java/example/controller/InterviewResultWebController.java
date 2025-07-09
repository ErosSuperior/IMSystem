package example.controller;

import example.dto.InterviewResultDTO;
import example.entities.Interview;
import example.entities.InterviewResult;
import example.repository.InterviewRepo;
import example.service.InterviewResultInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class InterviewResultWebController {

    @Autowired
    private InterviewResultInterface interviewResultService;
    @Autowired
    private InterviewRepo interviewRepo;
    @GetMapping("/controller/interview-results")
    public String listInterviewResults(Model model) {
        List<InterviewResultDTO> resultDTOs = interviewResultService.findAll().stream()
                .map(InterviewResultDTO::new)
                .toList();
        model.addAttribute("results", resultDTOs);
        return "InterviewResult"; // Tên file: src/main/resources/templates/interview-results.html
    }



    @GetMapping("/interview-results/form")
    public String showAddForm() {
        return "AddInterviewResult"; // Tên file HTML (Thymeleaf view)
    }

    @PostMapping("/interview-results/add")
    public String addInterviewResult(@RequestParam("interview.interview_id") Integer interviewId,
                                     @RequestParam("score") Integer score,
                                     @RequestParam("feedback") String feedback,
                                     @RequestParam("result") String result,
                                     RedirectAttributes redirectAttributes) {

        Interview interview = interviewRepo.findById(interviewId).orElse(null);
        if (interview == null) {
            redirectAttributes.addFlashAttribute("error", "Interview ID không tồn tại!");
            return "redirect:/interview-results/form";
        }

        InterviewResult newResult = new InterviewResult();
        newResult.setInterview(interview);
        newResult.setScore(score);
        newResult.setFeedback(feedback);
        newResult.setResult(InterviewResult.Result.valueOf(result));

        interviewResultService.save(newResult);
        return "redirect:/interview-results/form";
    }
    // 1. Hiển thị form cập nhật
    @GetMapping("/interview-results/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        InterviewResult result = interviewResultService.findById(id).orElse(null);
        if (result == null) {
            return "redirect:/interview-results/form"; // hoặc trang báo lỗi
        }

        model.addAttribute("result", result);
        model.addAttribute("resultId", result.getResult_id());
        model.addAttribute("interviewId", result.getInterview().getInterview_id());
        return "UpdateInterviewResult"; // tên file HTML
    }

    // 2. Xử lý cập nhật
    @PostMapping("/interview-results/update")
    public String updateInterviewResult(@RequestParam("resultId") Integer resultId,
                                        @RequestParam("interviewId") Integer interviewId,
                                        @RequestParam("score") Integer score,
                                        @RequestParam("feedback") String feedback,
                                        @RequestParam("result") String resultValue,
                                        RedirectAttributes redirectAttributes) {

        Interview interview = interviewRepo.findById(interviewId).orElse(null);
        if (interview == null) {
            redirectAttributes.addFlashAttribute("error", "Interview ID không tồn tại!");
            return "redirect:/interview-results/form";
        }

        InterviewResult updated = new InterviewResult();
        updated.setResult_id(resultId);
        updated.setInterview(interview);
        updated.setScore(score);
        updated.setFeedback(feedback);
        updated.setResult(InterviewResult.Result.valueOf(resultValue));

        interviewResultService.save(updated);
        redirectAttributes.addFlashAttribute("success", "Cập nhật kết quả thành công!");
        return "redirect:/interview-results/edit/" + resultId;
    }
}

