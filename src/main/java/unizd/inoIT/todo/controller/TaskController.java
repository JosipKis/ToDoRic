package unizd.inoIT.todo.controller;

import org.springframework.beans.factory.annotation.Qualifier;
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

    public TaskController(TaskService taskService) {
        this.TASKS_SERVICE = taskService;
    }

    @GetMapping("/my-tasks")
    public String mojiZadatci(Model model, Authentication auth) {
        List<Task> tasks = TASKS_SERVICE.findAll();
        Task task = new Task();


        model.addAttribute("task", task);
        model.addAttribute("tasks", tasks);
        return "my-tasks";
    }

    @PostMapping("/tasks/save")
    public String saveTask(@ModelAttribute("task") Task task) {
        TASKS_SERVICE.save(task);
        return "redirect:/my-tasks";
    }
}