package unizd.inoIT.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import unizd.inoIT.todo.service.TaskService;

@Controller
public class TaskController {

    private final TaskService TASKSERVICE;

    public TaskController(TaskService taskService) {
        TASKSERVICE = taskService;
    }

    @GetMapping("/my-tasks")
    public String mojiZadatci(){
        return "my-tasks";
    }
}