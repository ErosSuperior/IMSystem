package example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import example.entities.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import example.service.UserInterface;


@Controller
public class LoginController {
    @Autowired
    private UserInterface userService;
    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(
            @RequestParam String email,
            @RequestParam String password,
            Model model,
            HttpSession session
    ) {
User usersaccount = userService.login(email, password);
        if (usersaccount != null) {
            session.setAttribute("useraccount", usersaccount);
            return "redirect:/home"; // or dashboard page
        } else {
            model.addAttribute("error", "Sai thông tin đăng nhập");
            return "login";
        }
    }
}
