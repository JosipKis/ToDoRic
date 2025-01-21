package unizd.inoIT.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unizd.inoIT.todo.model.Task;
import unizd.inoIT.todo.service.TaskService;
import unizd.inoIT.todo.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

        List<Task> tasks = TASKS_SERVICE.getOpenTasksByUserName(username);

        Task task = new Task();
        model.addAttribute("low", USER_SERVICE.getLowUrgency(username));
        model.addAttribute("medium", USER_SERVICE.getMidUrgency(username));
        model.addAttribute("high", USER_SERVICE.getHighUrgency(username));
        model.addAttribute("critical", USER_SERVICE.getCriticalUrgency(username));
        model.addAttribute("task", task);
        model.addAttribute("tasks", tasks);

        return "my-tasks";
    }

    @GetMapping("/my-tasks/completed")
    @ResponseBody
    public List<Task> getCompletedTasks(Authentication authentication) {
        String username = authentication.getName();
        return TASKS_SERVICE.getTasksByUserNameAndStatus(username, "solved");
    }



    @PostMapping("/tasks/save")
    public String saveTask(@ModelAttribute("task") Task task, Authentication authentication) {
        task.setUserName(authentication.getName());
        task.setStatus("open");
        TASKS_SERVICE.save(task);
        return "redirect:/my-tasks";
    }

    @PostMapping("/tasks/{taskId}/markAsSolved")
    public ResponseEntity<Void> markTaskAsSolved(@PathVariable Long taskId) {
        Optional<Task> task = TASKS_SERVICE.findById(taskId);
        if (task.isPresent()) {
            Task t = task.get();
            t.setStatus("solved");
            t.setCompletedDate(new Date());
            TASKS_SERVICE.save(t);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/tasks/{taskId}/delete")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        Optional<Task> task = TASKS_SERVICE.findById(taskId);
        if (task.isPresent()) {
            TASKS_SERVICE.deleteTask(task.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}