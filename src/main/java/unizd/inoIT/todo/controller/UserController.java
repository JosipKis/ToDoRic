package unizd.inoIT.todo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import unizd.inoIT.todo.model.User;
import unizd.inoIT.todo.service.UserService;

import java.security.Principal;
import java.util.Date;
import java.util.Optional;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/my-profile")
    public String myProfile(Model model, Authentication authentication) {
        Optional<User> user = userService.findByUsername(authentication.getName());
        System.out.println(user.toString());
        model.addAttribute("user", user);
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

    @PostMapping("/my-profile/update-password")
    public String updatePasswordSubmit(
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword,
            @RequestParam("repeatPassword") String repeatPassword,
            Principal principal) {

        User user = userService.findByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(oldPassword, user.getPassword())) {
            throw new IllegalArgumentException("Old password is incorrect!");
        }

        if (!newPassword.equals(repeatPassword)) {
            throw new IllegalArgumentException("Passwords do not match!");
        }

        user.setPassword(encoder.encode(newPassword));
        userService.save(user);

        return "redirect:/my-profile";
    }


}