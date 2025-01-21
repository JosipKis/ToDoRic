package unizd.inoIT.todo.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import unizd.inoIT.todo.model.User;
import unizd.inoIT.todo.service.UserService;

import java.util.Date;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/my-profile")
    public String myProfile() {
        return "my-profile";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        user.setPassword(encoder.encode(user.getPassword()));

        user.setDatumStvaranjaZadatka(new Date());
        user.setLowUrgency("#42ff6b");
        user.setMidUrgency("#f2ff42");
        user.setHighUrgency("#ffb630");
        user.setCriticalUrgency("#ff1e1e");
        userService.save(user);
        return "redirect:/login";
    }
}