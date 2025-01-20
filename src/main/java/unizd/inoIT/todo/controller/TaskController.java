package unizd.inoIT.todo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import unizd.inoIT.todo.model.Task;
import unizd.inoIT.todo.service.TaskService;
import unizd.inoIT.todo.service.UserService;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService TASKS_SERVICE;
    private final UserService USER_SERVICE;

    public TaskController(TaskService taskService, UserService userService) {
        this.TASKS_SERVICE = taskService;
        this.USER_SERVICE = userService;
    }

    @GetMapping("/my-tasks")
    public String mojiZadatci(Model model, Authentication authentication) {
        String username = authentication.getName();
        List<Task> tasks = TASKS_SERVICE.getTasksByUserName(username);
        Task task = new Task();

        System.out.println(USER_SERVICE.getLowUrgency(username));
        System.out.println(USER_SERVICE.getHighUrgency(username));

        model.addAttribute("low", USER_SERVICE.getLowUrgency(username));
        model.addAttribute("medium", USER_SERVICE.getMidUrgency(username));
        model.addAttribute("high", USER_SERVICE.getHighUrgency(username));
        model.addAttribute("critical", USER_SERVICE.getCriticalUrgency(username));
        model.addAttribute("task", task);
        model.addAttribute("tasks", tasks);
        return "my-tasks";
    }

    @PostMapping("/tasks/save")
    public String saveTask(@ModelAttribute("task") Task task, Authentication authentication) {
        task.setUserName(authentication.getName());
        TASKS_SERVICE.save(task);
        return "redirect:/my-tasks";
    }
}