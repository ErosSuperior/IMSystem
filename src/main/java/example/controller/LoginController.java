package example.controller;

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
User usersaccount = userService.login(username, password);
        if (usersaccount != null) {
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    usersaccount, null, new ArrayList<>() // danh sách quyền (authority) để trống
            );
            SecurityContextHolder.getContext().setAuthentication(auth);

            session.setAttribute("useraccount", usersaccount); // nếu bạn vẫn cần session riêng
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Sai thông tin đăng nhập");
            return "login";
        }
    }
}
