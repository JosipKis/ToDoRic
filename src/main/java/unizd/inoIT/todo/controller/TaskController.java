package unizd.inoIT.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import unizd.inoIT.todo.model.Task;
import unizd.inoIT.todo.service.TaskService;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService TASKSERVICE;

    public TaskController(TaskService taskService) {
        TASKSERVICE = taskService;
    }

    @GetMapping("/my-tasks")
    public String mojiZadatci(Model model) {
        List<Task> tasks = TASKSERVICE.findAll();
        Task task = new Task();

        model.addAttribute("task", task);
        model.addAttribute("tasks", tasks);
        return "my-tasks";
    }

    @PostMapping("/tasks/save")
    public String saveTask(@ModelAttribute("task") Task task) {
        TASKSERVICE.save(task);
        return "redirect:/my-tasks";
    }
}