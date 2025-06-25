package example.controller;

import example.entities.Candidate;
import example.service.CandidateInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import example.entities.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import example.service.UserInterface;

import java.util.ArrayList;


@Controller
public class LoginController {
    @Autowired
    private UserInterface userService;
    @Autowired
    private CandidateInterface candidateService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model,
            HttpSession session
    ) {
        Candidate candidateaccount = candidateService.login(username, password);
        User usersaccount = userService.login(username, password);
        if (usersaccount != null||candidateaccount !=null) {
            Object principal = (usersaccount != null) ? usersaccount : candidateaccount;
            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(principal, null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(auth);

            session.setAttribute("useraccount", usersaccount);
            session.setAttribute("candidateaccount", candidateaccount);// nếu bạn vẫn cần session riêng
            return "redirect:/home";
        }  else {
            model.addAttribute("error", "Sai thông tin đăng nhập");
            return "login";
        }
    }
}
