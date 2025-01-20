package unizd.inoIT.todo.service;

import org.springframework.stereotype.Service;
import unizd.inoIT.todo.model.Task;
import unizd.inoIT.todo.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository TASK_REPOSITORY;

    public TaskService(TaskRepository taskRepository) {
        TASK_REPOSITORY = taskRepository;
    }

    public List<Task> findAll() {
        return TASK_REPOSITORY.findAll();
    }

    public Task save(Task task) {
        return TASK_REPOSITORY.save(task);
    }

    public List<Task> getTasksByUserName(String userName) {
        return TASK_REPOSITORY.findByUserName(userName);
    }
}