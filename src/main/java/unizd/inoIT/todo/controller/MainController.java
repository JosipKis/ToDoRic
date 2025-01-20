package unizd.inoIT.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import unizd.inoIT.todo.model.User;

@Controller
public class MainController {

    /**
     * Maps the login page.
     *
     * @return the view name for the login page
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/my-tasks";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

}