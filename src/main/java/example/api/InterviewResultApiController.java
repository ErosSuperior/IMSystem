package example.api;

import example.entities.InterviewResult;
import example.service.InterviewResultInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/interview-results")
public class InterviewResultApiController {

    @Autowired
    private InterviewResultInterface service;

    @GetMapping
    public List<InterviewResult> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<InterviewResult> getById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public InterviewResult create(@RequestBody InterviewResult interviewResult) {
        return service.save(interviewResult);
    }

    @PutMapping("/{id}")
    public InterviewResult update(@PathVariable int id, @RequestBody InterviewResult updatedResult) {
        updatedResult.setResult_id(id);
        return service.save(updatedResult);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);
    }
}
